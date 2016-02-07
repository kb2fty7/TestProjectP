package com.testtask.kb2fty7.testprojectpsyh.generate;

import com.testtask.kb2fty7.testprojectpsyh.generate.async.GenerateInteractor;
import com.testtask.kb2fty7.testprojectpsyh.generate.async.IGenerateInteractor;
import com.testtask.kb2fty7.testprojectpsyh.generate.async.IGenerateListener;

/**
 * Created by Yurii on 2/3/2016.
 */
public class GeneratePresenter implements IGeneratePresenter, IGenerateListener {
    private IGenerateView mGenerateView;
    private IGenerateInteractor mGenerateInteractor;

    public GeneratePresenter(IGenerateView generateView) {
        mGenerateView = generateView;
        mGenerateInteractor = new GenerateInteractor();
    }

    @Override
    public void startGenerate() {
        mGenerateInteractor.generate(this);
    }

    @Override
    public void success() {
        mGenerateView.startHomeScreen();
    }
}
