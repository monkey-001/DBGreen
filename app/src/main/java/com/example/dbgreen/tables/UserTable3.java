package com.example.dbgreen.tables;

import android.os.Parcel;
import android.os.ParcelUuid;

import com.green.DBGreen.annotations.Column;
import com.green.DBGreen.annotations.TableName;

import java.util.Date;
import java.util.UUID;

/**
 * Created by LEE on 2021-09-08
 */
@TableName(version = 3, name = "user3")
public class UserTable3 extends TableBase{
    @Column(notNull = true, defaultValue = "王五")
    private String userName;

    @Column(notNull = true, unique = true)
    private String userID = getRandomID();

    @Column(notNull = true, defaultValue = "18", version = 2, check = "(age > 17)")
    private int age;

    @Column(notNull = true, version = 3)
    private Date date = new Date();

    @Column(version = 4)
    private boolean goodStudent;

    public String getRandomID() {
        ParcelUuid fromParcel = ParcelUuid.CREATOR.createFromParcel(Parcel.obtain());
        UUID uuid = fromParcel.getUuid();
        return uuid.toString();
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isGoodStudent() {
        return goodStudent;
    }

    public void setGoodStudent(boolean goodStudent) {
        this.goodStudent = goodStudent;
    }
}
