package com.example.dbgreen.tables;

import android.database.Cursor;

import com.green.DBGreen.annotations.Column;
import com.green.DBGreen.annotations.TableName;
import com.green.DBGreen.interfaces.DBTableFormat;

/**
 * Created by LEE on 2021-09-08
 */
public class UserTable2 extends TableBase {
    @TableName
    private String tableName = "user2";

    @Column(notNull = true, defaultValue = "李四")
    private String userName;

    @Column(notNull = true, unique = true)
    private String userID;

    @Column(notNull = true, defaultValue = "18", version = 2, check = "(age > 17)")
    private int age;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public <T extends DBTableFormat> void cursorToMode(Cursor cursor, T t) {
        UserTable2 userTable2 = (UserTable2) t;
        userTable2.setUserID(cursor.getString(cursor.getColumnIndexOrThrow("userID")));
        userTable2.setUserName(cursor.getString(cursor.getColumnIndexOrThrow("userName")));
        userTable2.set_id(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
        int index = cursor.getColumnIndex("age");
        if (index != -1) {
            userTable2.setAge(cursor.getInt(index));
        }
    }
}
