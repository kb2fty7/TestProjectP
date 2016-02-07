package com.testtask.kb2fty7.testprojectpsyh.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.testtask.kb2fty7.testprojectpsyh.R;
import com.testtask.kb2fty7.testprojectpsyh.homescreen.IHomePresenter;
import com.testtask.kb2fty7.testprojectpsyh.homescreen.IHomeView;
import com.testtask.kb2fty7.testprojectpsyh.homescreen.HomePresenter;
import com.testtask.kb2fty7.testprojectpsyh.view.fragments.MapPointFragment;
import com.testtask.kb2fty7.testprojectpsyh.view.fragments.PersonsListFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements IHomeView {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.container)
    ViewPager mViewPager;
    @Bind(R.id.tabs)
    TabLayout mTabLayout;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private IHomePresenter mPersonsDataPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mPersonsDataPresenter = new HomePresenter(this);
        mPersonsDataPresenter.init();


    }


    @Override
    public void initData() {
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }



    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return PersonsListFragment.newInstance();
            } else {
                return MapPointFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
            }
            return null;
        }
    }
}
