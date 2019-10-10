package com.kgm.segconstr.ManejoBD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;


public class BDImplementacio extends SQLiteOpenHelper {

    public static final String BD_NOMBRE_DEL_ARCHIVO = "mensahero.db";
    public static final int BD_VERSION = 1;

    public BDImplementacio(@Nullable Context context) {
        super(context, BD_NOMBRE_DEL_ARCHIVO, null, BD_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(BDDefinicion.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        bd.execSQL(BDDefinicion.SQL_DELETE);
        onCreate(bd);
    }
}
