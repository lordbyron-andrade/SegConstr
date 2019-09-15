package com.kgm.segconstr;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TomaFoto extends AppCompatActivity {


    public static final int REQUERIR_TOMA_DE_FOTO = 0;
    public static final int REQUERIR_TOMA_DE_VIDEO = 1;
    public static final int REQUERIR_SELECCION_DE_FOTO = 0;
    public static final int REQUERIR_SELECCION_DE_VIDEO = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toma_foto);

    }

    public void manejoTomaFoto(View view) {
        //Toast.makeText(this,"Hola Mundo",Toast.LENGTH_SHORT).show();
        Intent t = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(t, REQUERIR_TOMA_DE_FOTO);

    }
}
