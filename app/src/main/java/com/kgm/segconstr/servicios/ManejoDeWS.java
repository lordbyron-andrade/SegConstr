package com.kgm.segconstr.servicios;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ManejoDeWS {


    public static List<Organizacion> Orgas;

    public static void bajarOrganizaciones(){

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
            }

            @Override
            public void onFailure(Call<List<Organizacion>> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }



}
