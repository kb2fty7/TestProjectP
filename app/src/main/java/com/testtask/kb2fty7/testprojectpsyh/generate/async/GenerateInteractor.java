package com.testtask.kb2fty7.testprojectpsyh.generate.async;

import android.util.Log;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.orm.SugarRecord;
import com.testtask.kb2fty7.testprojectpsyh.model.Person;

import org.testpackage.test_sdk.android.testlib.API;
import org.testpackage.test_sdk.android.testlib.interfaces.PersonsExtendedCallback;
import org.testpackage.test_sdk.android.testlib.interfaces.SuccessCallback;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yurii on 2/3/2016.
 */
public class GenerateInteractor implements IGenerateInteractor {
    private int page = 0;
    private IGenerateListener listener;

    @Override
    public void generate(final IGenerateListener listener) {
        this.listener = listener;
        API.INSTANCE.refreshPersons(new SuccessCallback() {
            @Override
            public void onSuccess() {
                loadData();
            }
        });

    }

    private void loadData(){
        API.INSTANCE.getPersons(page, new PersonsExtendedCallback() {
            @Override
            public void onResult(final String persons) {
                {
                    Gson gson = new Gson();
                    Type listType = new TypeToken<ArrayList<Person>>() {
                    }.getType();
                    List<Person> personList = gson.fromJson(persons, listType);
                    if (personList == null||personList.size()==0) {
                        listener.success();
                        return;
                    }
                    for (Person person : personList) {
                        SugarRecord.save(person);
                    }
                    page++;
                    loadData();
                }


            }

            @Override
            public void onFail(String reason) {
                listener.success();
            }
        });


    }
}
