package com.testtask.kb2fty7.testprojectpsyh.view.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.testtask.kb2fty7.testprojectpsyh.R;
import com.testtask.kb2fty7.testprojectpsyh.model.Person;
import com.testtask.kb2fty7.testprojectpsyh.personslist.IPersonListPresenter;
import com.testtask.kb2fty7.testprojectpsyh.personslist.IPersonListView;
import com.testtask.kb2fty7.testprojectpsyh.personslist.PersonalListPresenter;
import com.testtask.kb2fty7.testprojectpsyh.view.GenerateActivity;
import com.testtask.kb2fty7.testprojectpsyh.view.MatchActivity;
import com.testtask.kb2fty7.testprojectpsyh.view.adapters.RecyclerPersonListAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PersonsListFragment extends Fragment implements IPersonListView, RecyclerPersonListAdapter.IPersonListAdapterListener {
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private RecyclerPersonListAdapter recyclerPersonListAdapter;
    private IPersonListPresenter mPersonListPresenter;

    public PersonsListFragment() {
        // Required empty public constructor
    }


    public static PersonsListFragment newInstance() {
        PersonsListFragment fragment = new PersonsListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_persons_list, container, false);
        ButterKnife.bind(this, view);

        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mPersonListPresenter = new PersonalListPresenter(this);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPersonListPresenter.init();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void init(List<Person> list) {
        recyclerPersonListAdapter = new RecyclerPersonListAdapter(list,this, getActivity());
        mRecyclerView.setAdapter(recyclerPersonListAdapter);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void showMatch(long id) {
        Intent intent = new Intent(getActivity(), MatchActivity.class);
        intent.putExtra(MatchActivity.KEY_PERSON_ID,id);
        getActivity().startActivity(intent);
    }

    @Override
    public void showGenerate() {
        Intent intent = new Intent(getActivity(), GenerateActivity.class);
        getActivity().startActivity(intent);
    }

    @Override
    public void onClickLike(long id) {
        mPersonListPresenter.setLike(id);
        checkList();
    }

    @Override
    public void onClickDislike(long id) {
        mPersonListPresenter.setDislike(id);
        checkList();
    }

    private void checkList(){
        if (mRecyclerView.getAdapter().getItemCount()==0){
            mPersonListPresenter.noItems();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        mPersonListPresenter.destroy();
    }
}
