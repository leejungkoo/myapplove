package domain;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyDiaryApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("MyDiary.realm") //생성할 realm파일 이름 지정
                .schemaVersion(0)
                .build();

        //Realm에 셋팅한 정보 값을 지정
        Realm.setDefaultConfiguration(config);
    }


}