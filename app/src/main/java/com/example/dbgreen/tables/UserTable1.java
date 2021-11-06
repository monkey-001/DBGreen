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
public class UserTable1 extends TableBase {
    @TableName
    private String tableName = "user1";

    @Column(notNull = true, defaultValue = "张三")
    private String userName;

    @Column(notNull = true, unique = true)
    private String userID;

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

    @Override
    public ContentValues formatContentValues() {
        ContentValues contentValues = super.formatContentValues();
        if (!TextUtils.isEmpty(userName)) {
            contentValues.put("userName", userName);
        }
        contentValues.put("userID", userID);
        return contentValues;
    }

    @Override
    public <T extends DBTableFormat> void cursorToMode(Cursor query, T t) {
        UserTable1 userTable1 = (UserTable1) t;
        userTable1.setUserName(query.getString(query.getColumnIndexOrThrow("userName")));
        userTable1.setUserID(query.getString(query.getColumnIndexOrThrow("userID")));
    }
}
