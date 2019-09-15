package com.kgm.segconstr;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE;

public class TomaFoto extends AppCompatActivity {


    public static final int REQUERIR_TOMA_DE_FOTO = 0;
    public static final int REQUERIR_TOMA_DE_VIDEO = 1;
    public static final int REQUERIR_SELECCION_DE_FOTO = 0;
    public static final int REQUERIR_SELECCION_DE_VIDEO = 1;

    private Uri mArchivo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toma_foto);

    }

    public void manejoTomaFoto(View view) {
        //Toast.makeText(this,"Hola Mundo",Toast.LENGTH_SHORT).show();
        mArchivo = getUriArchivo(MEDIA_TYPE_IMAGE);

        if(mArchivo == null){
            Toast.makeText(this,
                    "Hubo un problema con el almacenamiento externo",
                    Toast.LENGTH_LONG);
        }
        else{
            Intent t = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            t.putExtra(MediaStore.EXTRA_OUTPUT, mArchivo);
            startActivityForResult(t, REQUERIR_TOMA_DE_FOTO);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode == REQUERIR_TOMA_DE_FOTO){

            }
        }
    }

    private Uri getUriArchivo(int mediaTypeImage) {
        //Checar si hay almacenamiento externo
        if(existeAlmacenamientoDisponible()){

            // 1. Obtener el directorio del almacenamiento externo
            File mediaStorageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

            // 2.- Crear un nombre unico de archivo
            String nombreArchivo = "";
            String extensionArchivo = ".jpg";
            String idUUid = UUID.randomUUID().toString() + new SimpleDateFormat("HHmmss").format(new Date());
            nombreArchivo = "IMG_" + idUUid;

            //3.- Crear el archivo
            File manejadorArchivo;

            try{
                manejadorArchivo = File.createTempFile(nombreArchivo, extensionArchivo, mediaStorageDir);
                Log.i("DebugFoto:","File:"+Uri.fromFile(manejadorArchivo));
                // 4 Regresar archivo
                return Uri.fromFile(manejadorArchivo);
            }catch (IOException e){

            }

            return null;
        }

        return null;

    }

    private boolean existeAlmacenamientoDisponible(){
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            return  true;
        }
        else{
            return false;
        }

    }

}
