package com.testtask.kb2fty7.testprojectpsyh.personslist;

/**
 * Created by Yurii on 2/5/2016.
 */
public interface IPersonListPresenter {
    void init();
    void noItems();
    void setLike(long id);
    void setDislike(long id);
    void destroy();
}
