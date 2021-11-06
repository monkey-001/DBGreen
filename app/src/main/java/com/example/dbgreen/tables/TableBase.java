package com.example.dbgreen.tables;

import android.content.ContentValues;

import com.green.DBGreen.annotations.Column;
import com.green.DBGreen.interfaces.DBTableFormat;

/**
 * Created by LEE on 2021-09-09
 */
public class TableBase extends DBTableFormat {
    @Column(primaryKey = true, autoincrement = true, notNull = true, unique = true)
    private int _id;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    @Override
    public ContentValues formatContentValues() {
        return new ContentValues();
    }
}
