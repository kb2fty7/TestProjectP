package com.testtask.kb2fty7.testprojectpsyh.map.sync;

import com.orm.SugarRecord;
import com.testtask.kb2fty7.testprojectpsyh.model.Person;

import java.util.List;

/**
 * Created by Yurii on 2/7/2016.
 */
public class MapInteractor implements IMapInteractor {
    @Override
    public List<Person> getPoints() {
        return SugarRecord.listAll(Person.class);
    }

}
