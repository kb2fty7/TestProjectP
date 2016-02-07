package com.testtask.kb2fty7.testprojectpsyh.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.testtask.kb2fty7.testprojectpsyh.R;
import com.testtask.kb2fty7.testprojectpsyh.matchscreen.IMatchScreenPresenter;
import com.testtask.kb2fty7.testprojectpsyh.matchscreen.IMatchScreenView;
import com.testtask.kb2fty7.testprojectpsyh.matchscreen.MatchScreenPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MatchActivity extends AppCompatActivity implements IMatchScreenView {
    public static final String KEY_PERSON_ID = "person_id_key";
    private IMatchScreenPresenter mMatchScreenPresenter;
    @Bind(R.id.personImageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        ButterKnife.bind(this);

        mMatchScreenPresenter = new MatchScreenPresenter(this);
        mMatchScreenPresenter.getData(getPersonId());

    }

    @Override
    public void initView(String link) {
        Glide.with(this).load(link).into(imageView);
    }

    @OnClick(R.id.okButton)
    void onClickOkButton(View view){
        finish();
    }

    private long getPersonId() {
        long personId = getIntent().getLongExtra(KEY_PERSON_ID,0);
        return personId;
    }
}
