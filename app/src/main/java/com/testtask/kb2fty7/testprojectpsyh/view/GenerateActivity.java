package com.testtask.kb2fty7.testprojectpsyh.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.testtask.kb2fty7.testprojectpsyh.R;
import com.testtask.kb2fty7.testprojectpsyh.generate.GeneratePresenter;
import com.testtask.kb2fty7.testprojectpsyh.generate.IGeneratePresenter;
import com.testtask.kb2fty7.testprojectpsyh.generate.IGenerateView;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class GenerateActivity extends AppCompatActivity implements IGenerateView {
    private IGeneratePresenter mGeneratePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);
        ButterKnife.bind(this);
        mGeneratePresenter = new GeneratePresenter(this);
    }


    @OnClick(R.id.generateButton)
    void onClickGenerate(View view){
        mGeneratePresenter.startGenerate();
    }
    @Override
    public void startHomeScreen() {
        Intent homeIntent = new Intent(this, HomeActivity.class);
        startActivity(homeIntent);
        finish();
    }
}
