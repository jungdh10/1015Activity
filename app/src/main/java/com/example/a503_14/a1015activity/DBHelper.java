package com.example.a503_14.a1015activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    //생성자
    public DBHelper(Context context){
        //첫 번째는 Context, 두 번째는 저장될 파일명, 세번째는 Cursor를 직접 만든 경우 지정, 네 번째는 버전
        super(context, "database.sqlite3", null, 1);
    }

    //데이터베이스를 처음 사용하려고 할 때 한 번 호출되는 메소드
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table tb_data(_id integer primary key autoincrement,category text,location text)";
        db.execSQL(sql);

        db.execSQL("insert into tb_data(category, location) values('서울특별시', '강남구')");
        db.execSQL("insert into tb_data(category, location) values('서울특별시', '서초구')");
        db.execSQL("insert into tb_data(category, location) values('서울특별시', '양천구')");
        db.execSQL("insert into tb_data(category, location) values('서울특별시', '종로구')");
        db.execSQL("insert into tb_data(category, location) values('전라남도', '목포시')");
        db.execSQL("insert into tb_data(category, location) values('전라남도', '신안군')");
        db.execSQL("insert into tb_data(category, location) values('경기도', '포천시')");
        db.execSQL("insert into tb_data(category, location) values('경기도', '일산시')");
        db.execSQL("insert into tb_data(category, location) values('경기도', '성남시')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //테이블을 삭제하고 다시 생성
        db.execSQL("drop table tb_data");
        onCreate(db);
    }
}
