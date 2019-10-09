package com.kgm.segconstr.servicios;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WSOrganizacion {
    @GET("Organizaciones")
    Call<List<Organizacion>> getOrgs();
}
