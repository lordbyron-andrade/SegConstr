package com.kgm.segconstr;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kgm.segconstr.ManejoBD.BDDefinicion;
import com.kgm.segconstr.ManejoBD.ManejoBDLocal;
import com.kgm.segconstr.servicios.ManejoDeWS;
import com.kgm.segconstr.servicios.Organizacion;
import com.kgm.segconstr.servicios.WSOrganizacion;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    public static List<Organizacion> Orgas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }








    public void manejoLogin(View view) {

        //Intent i = new Intent(this, TomaFoto.class);
        //startActivity(i);
        ManejoBDLocal mbdLocal = new ManejoBDLocal(this);
        mbdLocal.open();
        Cursor c = mbdLocal.mbdBD.rawQuery("select * from " + BDDefinicion.TABLE_ORGS + ";", null);
        mbdLocal.close();

    }

    public void manejoDownload(View view) {
        //Toast m = Toast.makeText(this,"Test",Toast.LENGTH_SHORT);
        //m.show();
        ManejoDeWS.bajarOrganizaciones(this);

    }
}
