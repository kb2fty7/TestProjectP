package com.testtask.kb2fty7.testprojectpsyh.matchscreen.asynk;

import com.orm.SugarRecord;
import com.testtask.kb2fty7.testprojectpsyh.model.Person;

/**
 * Created by Yurii on 2/7/2016.
 */
public class MatchScreenInteractor implements IMatchScreenInteractor {

    @Override
    public void getImageLink(long id, IMatchScreenInteractorListener listener) {
        Person person = SugarRecord.findById(Person.class, id);
        listener.success(person.getPhoto());
    }
}
