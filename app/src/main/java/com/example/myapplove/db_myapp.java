package com.example.myapplove;


import android.app.Application;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import kotlin.reflect.KProperty;


public class db_myapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}


// Realm 초기화(한 번만 초기화합니다)

//Realm.init(context); realm 초기화 해야되는데 왜 오류가 뜰까
