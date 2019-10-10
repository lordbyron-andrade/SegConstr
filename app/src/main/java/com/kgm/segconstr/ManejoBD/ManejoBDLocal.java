package com.kgm.segconstr.ManejoBD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ManejoBDLocal {

    private Context mbdContext;
    public SQLiteDatabase mbdBD;
    private SQLiteOpenHelper mbdHelper;

    public ManejoBDLocal(Context mbdContext) {
        this.mbdContext = mbdContext;
        mbdHelper = new BDImplementacio(mbdContext);
        mbdBD = mbdHelper.getWritableDatabase();
    }

    public void open(){
        mbdBD = mbdHelper.getWritableDatabase();
    }

    public void close(){
        mbdHelper.close();
    }


}
