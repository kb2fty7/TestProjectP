package com.testtask.kb2fty7.testprojectpsyh.splashscreen;

import com.testtask.kb2fty7.testprojectpsyh.splashscreen.async.AsyncSplashScreenInteractor;
import com.testtask.kb2fty7.testprojectpsyh.splashscreen.async.ISplashScreenListener;

/**
 * Created by Yurii on 2/3/2016.
 */
public class SplashScreenPresenter implements ISplashScreenPresenter, ISplashScreenListener{
    private ISplashScreenView mSplashScreenView;
    private AsyncSplashScreenInteractor mAsyncSplashScreenInteractor;

    public SplashScreenPresenter(ISplashScreenView splashScreenView){
        mSplashScreenView =splashScreenView;
        mAsyncSplashScreenInteractor = new AsyncSplashScreenInteractor();
    }

    @Override
    public void initData() {
        mAsyncSplashScreenInteractor.initData(this);
    }

    @Override
    public void availableData() {
        mSplashScreenView.navigateToHomeScreen();
    }

    @Override
    public void unavailableData() {
        mSplashScreenView.navigationToGenerateScreen();
    }
}
