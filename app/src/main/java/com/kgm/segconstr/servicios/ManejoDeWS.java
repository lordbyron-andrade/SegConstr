package com.kgm.segconstr.servicios;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kgm.segconstr.MainActivity;
import com.kgm.segconstr.ManejoBD.BDDefinicion;
import com.kgm.segconstr.ManejoBD.ManejoBDLocal;

import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ManejoDeWS {


    public static List<Organizacion> Orgas;

    public static void bajarOrganizaciones(final Context cx){

        Gson gson = new GsonBuilder().create();
        Retrofit r = new Retrofit.Builder()
                .baseUrl("http://201.151.105.188:8000/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        WSOrganizacion c = r.create(WSOrganizacion.class);

        Call<List<Organizacion>> call = c.getOrgs();

        call.enqueue(new Callback<List<Organizacion>>() {
            @Override
            public void onResponse(Call<List<Organizacion>> call, Response<List<Organizacion>> response) {
                Orgas = response.body();
                String comando_sql;
                //Toast.makeText(cx, "Exito", Toast.LENGTH_SHORT).show();
                ManejoBDLocal mbdLocal = new ManejoBDLocal(cx);
                mbdLocal.open();
                mbdLocal.mbdBD.execSQL("delete from organizaciones_00");

                for(Organizacion Ox : Orgas){
                    comando_sql = "INSERT INTO " + BDDefinicion.TABLE_ORGS;
                    comando_sql += " (" + BDDefinicion.COLUMN_ID_ID
                                 + "," + BDDefinicion.COLUMN_ID_INT + "," + BDDefinicion.COLUMN_ID_LONG
                                 + "," + BDDefinicion.COLUMN_ID_UUID + "," + BDDefinicion.COLUMN_TEXTO + ")"
                                 + " VALUES (" + "'" + UUID.randomUUID().toString() + "',"
                                 + Ox.id_int + "," + Ox.id_long + ",'" + Ox.id_uuid.toString() + "','"
                                 + Ox.texto + "');";
                    //Toast.makeText(cx, comando_sql, Toast.LENGTH_SHORT).show();
                    mbdLocal.mbdBD.execSQL(comando_sql);
                }

                mbdLocal.close();

            }

            @Override
            public void onFailure(Call<List<Organizacion>> call, Throwable t) {
                Log.d("Error",t.getMessage());

            }
        });


    }



}
