package com.example.myapplove;

// Realm 초기화(한 번만 초기화합니다)

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
//Realm.init(context); realm 초기화 해야되는데 왜 오류가 뜰까

// RealmObject를 상속받아서 model 클래스 정의
public class db_myapp2 extends RealmObject {
    private String name;
    private int age;

    // ... Generated getters and setters ...
}

public class Person extends RealmObject {
    @PrimaryKey
    private long id;
    private String name;
    private RealmList<db_myapp2> dogs; // List 정의

    // ... Generated getters and setters ...
}

    // this 스레드에 대한 Realm 인스턴스 생성
    Realm realm = Realm.getDefaultInstance();

    // 일반 Java 객체와 같이 사용합니다
    db_myapp2 dog = new db_myapp2();
    db_myapp2.setName("Rex");
    db_myapp2.setAge(1);

// 2세 미만의 모든 Dog를 쿼리합니다.
final RealmResults<db_myapp2> puppies = realm.where(db_myapp2.class).lessThan("age", 2).findAll();
        puppies.size(); // => 아직 Realm에 Dog가 추가되지 않았으므로 0입니다.

// 트랜잭션에서 데이터 insert
        realm.beginTransaction();
final Dog managedDog = realm.copyToRealm(dog); // 미리 만들어진 객체를 사용
        Person person = realm.createObject(Person.class); // 객체를 직접 생성
        person.getDogs().add(managedDog);
        realm.commitTransaction();

// 데이터가 변경되면 Listener에 알림
        puppies.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<Dog>>() {
@Override
public void onChange(RealmResults<Dog> results, OrderedCollectionChangeSet changeSet) {
        // 쿼리 결과는 실시간으로 업데이트됩니다.
        changeSet.getInsertions(); // => [0] is added.
        }
        });

// 백그라운드에서 비동기로 데이터 update
        realm.executeTransactionAsync(new Realm.Transaction() {
@Override
public void execute(Realm bgRealm) {
        Dog dog = bgRealm.where(Dog.class).equalTo("age", 1).findFirst();
        dog.setAge(3);
        }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // 원본 쿼리와 Realm 객체는 자동으로 업데이트 됩니다.
                puppies.size(); // => 2세 미만의 Dog가 없으므로 0입니다.
                managedDog.getAge();   // => 나이가 업데이트 됐으므로 3입니다.
            }
        });
