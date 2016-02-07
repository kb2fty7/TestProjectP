package com.testtask.kb2fty7.testprojectpsyh.view.fragments;


import android.graphics.Bitmap;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.testtask.kb2fty7.testprojectpsyh.map.IMapPresenter;
import com.testtask.kb2fty7.testprojectpsyh.map.IMapView;
import com.testtask.kb2fty7.testprojectpsyh.map.MapPresenter;
import com.testtask.kb2fty7.testprojectpsyh.model.Person;

import java.util.List;

public class MapPointFragment extends com.google.android.gms.maps.MapFragment implements OnMapReadyCallback, IMapView {
    private IMapPresenter mMapPresenter;
    private GoogleMap mGoogleMap;

    public MapPointFragment() {
        // Required empty public constructor
    }

    public static MapPointFragment newInstance() {
        MapPointFragment fragment = new MapPointFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMapPresenter = new MapPresenter(this);
        getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        mMapPresenter.getPoints();
    }

    @Override
    public void initPoints(List<Person> list) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Person person : list) {
            LatLng point = stringToLatLng(person.getLocation());
            Marker marker = mGoogleMap.addMarker(new MarkerOptions().position(point));
            builder.include(point);
            loadMarkerIcon(marker, person.getPhoto());
        }
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(builder.build(),20);
        mGoogleMap.animateCamera(cameraUpdate);
    }

    private void loadMarkerIcon(final Marker marker, String url) {
        Glide.with(this).load(url)
                .asBitmap().fitCenter().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                Bitmap scaleBitmap = Bitmap.createScaledBitmap(bitmap,100,100,false);
                BitmapDescriptor icon = BitmapDescriptorFactory.fromBitmap(scaleBitmap);
                marker.setIcon(icon);
            }
        });
    }

    private LatLng stringToLatLng(String coordinates) {
        String[] point = coordinates.split(",");
        LatLng latLng = new LatLng(Double.parseDouble(point[0]), Double.parseDouble(point[1]));
        return latLng;
    }


}
