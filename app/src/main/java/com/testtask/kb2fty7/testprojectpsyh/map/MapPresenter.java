package com.testtask.kb2fty7.testprojectpsyh.map;

import com.testtask.kb2fty7.testprojectpsyh.map.sync.IMapInteractor;
import com.testtask.kb2fty7.testprojectpsyh.map.sync.MapInteractor;

/**
 * Created by Yurii on 2/7/2016.
 */
public class MapPresenter implements IMapPresenter{
    private IMapView mMapView;
    private IMapInteractor mMapInteractor;

    public MapPresenter(IMapView mapView){
        mMapView = mapView;
        mMapInteractor = new MapInteractor();
    }

    @Override
    public void getPoints() {
       mMapView.initPoints(mMapInteractor.getPoints());
    }
}
