package com.testtask.kb2fty7.testprojectpsyh.personslist;

import com.testtask.kb2fty7.testprojectpsyh.model.Person;

import java.util.List;

/**
 * Created by Yurii on 2/5/2016.
 */
public interface IPersonListView {
    void init(List<Person> list);
    void update(Person person);
    void showMatch(long id);
    void showGenerate();
}
