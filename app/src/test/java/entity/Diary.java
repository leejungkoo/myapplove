package entity;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Diary extends RealmObject { //RealmObject를 extends하여 Relam에 붙여줄수 있는형태가 되게해준다.
    @PrimaryKey
    int id;
    String contents;
    Date writeAt;

    public Diary() {
    }

    public Diary(int id, String contents) {
        this.id = id;
        this.contents = contents;
    }

    public Diary(int id, String contents, Date writeAt) {
        this.id = id;
        this.contents = contents;
        this.writeAt = writeAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getWriteAt() {
        return writeAt;
    }

    public void setWriteAt(Date writeAt) {
        this.writeAt = writeAt;
    }
}