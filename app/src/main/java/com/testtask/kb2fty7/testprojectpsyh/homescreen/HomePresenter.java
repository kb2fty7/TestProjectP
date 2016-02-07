package com.testtask.kb2fty7.testprojectpsyh.homescreen;

/**
 * Created by Yurii on 2/5/2016.
 */
public class HomePresenter implements IHomePresenter {
    private IHomeView mPersonsView;

    public HomePresenter(IHomeView personsView) {
        mPersonsView = personsView;
    }

    @Override
    public void init() {
        mPersonsView.initData();
    }

    @Override
    public void destroy() {

    }

}
