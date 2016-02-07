package com.testtask.kb2fty7.testprojectpsyh.splashscreen.async;

import com.orm.SugarRecord;
import com.testtask.kb2fty7.testprojectpsyh.TestApplication;
import com.testtask.kb2fty7.testprojectpsyh.model.Person;

import org.testpackage.test_sdk.android.testlib.API;

/**
 * Created by Yurii on 2/3/2016.
 */
public class AsyncSplashScreenInteractor implements IAsyncSplashScreenInteractor {
    private ISplashScreenListener mListener;

    @Override
    public void initData(ISplashScreenListener listener) {
        mListener = listener;
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (SugarRecord.findWithQuery(Person.class, "SELECT * FROM PERSON WHERE USER_STATUS IS NULL AND STATUS <> ? ", "removed").size()>0){
                    mListener.availableData();
                } else {
                    mListener.unavailableData();
                }
            }
        }).run();
    }
}
