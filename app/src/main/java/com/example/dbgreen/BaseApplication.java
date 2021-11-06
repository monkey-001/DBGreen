package com.example.dbgreen;

import android.app.Application;
import android.content.Context;

import com.green.DBGreen.manager.DBManager;

/**
 * Created by LEE on 2021-10-26
 */
public class BaseApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        DBManager.getInstance().init(this);
        DBManager.getInstance().initConfigXML(R.xml.db_config);
    }
}
