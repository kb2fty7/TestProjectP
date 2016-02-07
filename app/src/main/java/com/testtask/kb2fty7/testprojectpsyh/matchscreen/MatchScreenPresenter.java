package com.testtask.kb2fty7.testprojectpsyh.matchscreen;

import com.testtask.kb2fty7.testprojectpsyh.matchscreen.asynk.IMatchScreenInteractor;
import com.testtask.kb2fty7.testprojectpsyh.matchscreen.asynk.IMatchScreenInteractorListener;
import com.testtask.kb2fty7.testprojectpsyh.matchscreen.asynk.MatchScreenInteractor;

/**
 * Created by Yurii on 2/7/2016.
 */
public class MatchScreenPresenter implements IMatchScreenPresenter,IMatchScreenInteractorListener {
    private IMatchScreenView mMatchScreenView;
    private IMatchScreenInteractor mMatchScreenInteractor;

    public MatchScreenPresenter(IMatchScreenView matchScreenView){
        mMatchScreenView = matchScreenView;
        mMatchScreenInteractor = new MatchScreenInteractor();

    }

    @Override
    public void success(String link) {
        mMatchScreenView.initView(link);
    }

    @Override
    public void getData(long id) {
        mMatchScreenInteractor.getImageLink(id,this);
    }
}
