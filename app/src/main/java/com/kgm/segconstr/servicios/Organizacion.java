package com.kgm.segconstr.servicios;

import java.util.UUID;

public class Organizacion {
    public int id_int;
    public long id_long;
    public UUID id_uuid;
    public String texto;


    public int getId_int() {
        return id_int;
    }

    public void setId_int(int id_int) {
        this.id_int = id_int;
    }

    public long getId_long() {
        return id_long;
    }

    public void setId_long(long id_long) {
        this.id_long = id_long;
    }

    public UUID getId_uuid() {
        return id_uuid;
    }

    public void setId_uuid(UUID id_uuid) {
        this.id_uuid = id_uuid;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }



}
