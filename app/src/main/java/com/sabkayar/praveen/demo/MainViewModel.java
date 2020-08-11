package com.sabkayar.praveen.demo;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

class MainViewModel extends AndroidViewModel {
    private Context mAppContext;
    public MainViewModel(@NonNull Application application) {
        super(application);
        mAppContext=application.getApplicationContext();
    }
}
