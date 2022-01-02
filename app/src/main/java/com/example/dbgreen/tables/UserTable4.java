package com.example.dbgreen.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;

import com.green.DBGreen.annotations.Column;
import com.green.DBGreen.annotations.TableName;
import com.green.DBGreen.interfaces.DBTableFormat;

/**
 * Created by LEE on 2021-09-08
 */
@TableName(name = "user4")
public class UserTable4 extends TableBase {
    @Column(notNull = true, defaultValue = "张三")
    private String userName;

    @Column(notNull = true, unique = true)
    private String userID;

    @Column
    private byte[] photo;

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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public ContentValues formatContentValues() {
        ContentValues contentValues = new ContentValues();
        if (!TextUtils.isEmpty(userName)) {
            contentValues.put("userName", userName);
        }
        if (!TextUtils.isEmpty(userID)) {
            contentValues.put("userID", userID);
        }
        contentValues.put("photo", photo);
        return contentValues;
    }

    @Override
    public <T extends DBTableFormat> void cursorToMode(Cursor query, T t) {
        UserTable4 userTable1 = (UserTable4) t;
        userTable1.setUserName(query.getString(query.getColumnIndexOrThrow("userName")));
        userTable1.setUserID(query.getString(query.getColumnIndexOrThrow("userID")));
        userTable1.setPhoto(query.getBlob(query.getColumnIndexOrThrow("photo")));
    }
}
