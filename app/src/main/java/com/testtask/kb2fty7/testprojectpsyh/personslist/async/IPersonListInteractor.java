package com.testtask.kb2fty7.testprojectpsyh.personslist.async;

/**
 * Created by Yurii on 2/5/2016.
 */
public interface IPersonListInteractor {
    void getData(IPersonListListener listener);
    void setUserChoice(long id, boolean isLike, IPersonListListener listener);
    void subscribe(IPersonListListener listener);
    void unscribe();
}
