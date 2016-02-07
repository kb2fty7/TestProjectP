package com.testtask.kb2fty7.testprojectpsyh.personslist.async;

import android.util.Log;

import com.google.gson.Gson;
import com.orm.SugarRecord;
import com.testtask.kb2fty7.testprojectpsyh.model.Person;

import org.testpackage.test_sdk.android.testlib.API;
import org.testpackage.test_sdk.android.testlib.services.UpdateService;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by Yurii on 2/5/2016.
 */
public class PersonalListInteractor implements IPersonListInteractor {
    @Override
    public void getData(IPersonListListener listener) {
        listener.data(SugarRecord.findWithQuery(Person.class, "SELECT * FROM PERSON WHERE USER_STATUS IS NULL AND STATUS <> ? ", "removed"));
    }

    @Override
    public void setUserChoice(long id, boolean isLike,IPersonListListener listener) {
        Person person = SugarRecord.findById(Person.class, id);
        person.setUserStatus(isLike ? 1 : 0);
        SugarRecord.save(person);
        if (person.getStatus().equals("like")&&isLike){
            listener.matchAction(id);
        }
    }

    @Override
    public void subscribe(final IPersonListListener listener) {
        API.INSTANCE.subscribeUpdates(new UpdateService.UpdateServiceListener() {
            @Override
            public void onChanges(String person) {
                Log.d("TESTTEST",person);
                Observable.just(person).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).map(new Func1<String, Person>() {
                    @Override
                    public Person call(String s) {
                        Gson gson = new Gson();
                        return gson.fromJson(s, Person.class);
                    }
                }).doOnNext(new Action1<Person>() {
                    @Override
                    public void call(Person person) {
                        Person olderPersomRecord = SugarRecord.findById(Person.class, person.getId());
                        person.setUserStatus(olderPersomRecord.getUserStatus());
                        SugarRecord.save(person);
                        listener.update(person);
                        if (person.getStatus().equals("like") && new Integer(1).equals(person.getUserStatus())) {
                            listener.matchNotification(person);
                        }
                        if (person.getStatus().equals("removed")) {
                            listener.removedNotification(person);
                        }
                    }
                }).subscribe(new Action1<Person>() {
                    @Override
                    public void call(Person person) {
                        listener.update(person);
                    }
                });
            }
        });
    }

    @Override
    public void unscribe() {
API.INSTANCE.unSubscribeUpdates();
    }

}
