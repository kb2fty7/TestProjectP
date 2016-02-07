package com.testtask.kb2fty7.testprojectpsyh.personslist;

import android.app.NotificationManager;
import android.content.Context;
import android.media.audiofx.EnvironmentalReverb;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;

import com.testtask.kb2fty7.testprojectpsyh.R;
import com.testtask.kb2fty7.testprojectpsyh.TestApplication;
import com.testtask.kb2fty7.testprojectpsyh.model.Person;
import com.testtask.kb2fty7.testprojectpsyh.personslist.async.IPersonListInteractor;
import com.testtask.kb2fty7.testprojectpsyh.personslist.async.IPersonListListener;
import com.testtask.kb2fty7.testprojectpsyh.personslist.async.PersonalListInteractor;

import java.util.List;

/**
 * Created by Yurii on 2/5/2016.
 */
public class PersonalListPresenter implements IPersonListPresenter, IPersonListListener {
    private IPersonListView mPersonListView;
    private IPersonListInteractor mPersonListInteractor;

    public  PersonalListPresenter(IPersonListView personListView){
        mPersonListView = personListView;
        mPersonListInteractor = new PersonalListInteractor();
    }
    @Override
    public void init() {
        mPersonListInteractor.getData(this);
        mPersonListInteractor.subscribe(this);
    }

    @Override
    public void noItems() {
        mPersonListView.showGenerate();
    }

    @Override
    public void setLike(long id) {
        mPersonListInteractor.setUserChoice(id, true, this);
    }

    @Override
    public void setDislike(long id) {
        mPersonListInteractor.setUserChoice(id, false,this);
    }

    @Override
    public void destroy() {
        mPersonListInteractor.unscribe();
    }

    @Override
    public void data(List<Person> list) {
        mPersonListView.init(list);
    }

    @Override
    public void matchAction(long id) {
        mPersonListView.showMatch(id);
    }

    @Override
    public void update(Person person) {
        mPersonListView.update(person);
    }

    @Override
    public void matchNotification(Person person) {
        showNotification("congratulation", "match",false);

    }

    private void showNotification(String title, String content, boolean onlyView) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(TestApplication.getAppContext()).setContentTitle(title).setContentText(content).setSmallIcon(R.drawable.heart);
        if (!onlyView){
            mBuilder.setVibrate(new long[]{1000,1000}).setSound(Settings.System.DEFAULT_NOTIFICATION_URI);

        }
        NotificationManager notificationManager = (NotificationManager) TestApplication.getAppContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, mBuilder.build());
    }

    @Override
    public void removedNotification(Person person) {
        showNotification("Removed", "removed",true);
    }
}
