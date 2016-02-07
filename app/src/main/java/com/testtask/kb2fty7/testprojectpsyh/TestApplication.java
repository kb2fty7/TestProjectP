package com.testtask.kb2fty7.testprojectpsyh;

import android.app.Application;
import android.content.Context;

import com.orm.SugarContext;

import org.testpackage.test_sdk.android.testlib.API;

/**
 * Created by Yurii on 2/3/2016.
 */
public class TestApplication extends Application{
    private static Context instanceOfContext;

    @Override
    public void onCreate() {
        super.onCreate();
        instanceOfContext = getApplicationContext();
        SugarContext.init(getApplicationContext());
        API.INSTANCE.init(getApplicationContext());
    }

    public static final Context getAppContext(){
        return instanceOfContext;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
