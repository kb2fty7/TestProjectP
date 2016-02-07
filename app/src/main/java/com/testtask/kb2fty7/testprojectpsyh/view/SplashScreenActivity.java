package com.testtask.kb2fty7.testprojectpsyh.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.testtask.kb2fty7.testprojectpsyh.R;
import com.testtask.kb2fty7.testprojectpsyh.splashscreen.ISplashScreenPresenter;
import com.testtask.kb2fty7.testprojectpsyh.splashscreen.ISplashScreenView;
import com.testtask.kb2fty7.testprojectpsyh.splashscreen.SplashScreenPresenter;

public class SplashScreenActivity extends AppCompatActivity implements ISplashScreenView {

    private ISplashScreenPresenter mSplashScreenPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mSplashScreenPresenter = new SplashScreenPresenter(this);
        if (savedInstanceState == null){
            mSplashScreenPresenter.initData();
        }
    }

    @Override
    public void navigateToHomeScreen() {
        Intent homeIntent = new Intent(this,HomeActivity.class);
        startActivity(homeIntent);
        finish();
    }

    @Override
    public void navigationToGenerateScreen() {
        Intent homeIntent = new Intent(this,GenerateActivity.class);
        startActivity(homeIntent);
        finish();
    }
}
