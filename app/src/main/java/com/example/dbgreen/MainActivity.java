package com.example.dbgreen;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.example.dbgreen.tables.UserTable1;
import com.green.DBGreen.manager.DBManager;

import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private boolean threadEnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_test).setOnClickListener((view)->{
            new Thread(() -> {
                threadEnd = false;
                for (int i = 0; i < 1000; i++) {
                    UserTable1 userTable1 = new UserTable1();
                    userTable1.setUserID(UUID.randomUUID().toString());
                    Uri uri = DBManager.getInstance().insert(Uri.parse("content://"
                            + DBManager.getInstance().getAuthority()).buildUpon().appendPath("user1").build(), userTable1);
                    if (uri != null) {
                        Log.d(TAG, uri.toString());
                    }
                }
                threadEnd = true;
            }).start();
            new Thread(() -> {
                while (!threadEnd) {
                    List<UserTable1> query4 = DBManager.getInstance().query(Uri.parse("content://"
                                    + DBManager.getInstance().getAuthority() + "/" + "user1"),
                            null, null, null, null, UserTable1.class);
                    if (query4 != null) {
                        Log.d(TAG, query4.toString());
                    }
                }
            }).start();
            new Thread(() -> {
                while (!threadEnd) {
                    int delete = DBManager.getInstance().delete(Uri.parse("content://"
                                    + DBManager.getInstance().getAuthority() + "/" + "user1"),
                            "userName=?", new String[]{"张三"});
                    Log.d(TAG, "delete status : " + delete);
                }
            }).start();
        });
    }
}