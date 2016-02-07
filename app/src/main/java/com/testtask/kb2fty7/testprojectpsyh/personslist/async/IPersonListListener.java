package com.testtask.kb2fty7.testprojectpsyh.personslist.async;

import com.testtask.kb2fty7.testprojectpsyh.model.Person;

import java.util.List;

/**
 * Created by Yurii on 2/5/2016.
 */
public interface IPersonListListener {
    void data(List<Person> list);
    void matchAction(long id);
    void update(Person person);
    void matchNotification(Person person);
    void removedNotification(Person person);
}
