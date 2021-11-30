package com.example.prueba3pablobaeza;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button RULTADOS,VOTACIONES;
    RadioButton nulo,boric,kast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RULTADOS = (Button) findViewById(R.id.button);
        VOTACIONES = (Button) findViewById(R.id.button2);
        nulo = (RadioButton) findViewById(R.id.radioButton);
        boric = (RadioButton) findViewById(R.id.radioButton2);
        kast = (RadioButton) findViewById(R.id.radioButton3);


        VOTACIONES.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db;
                Dbhelper conn = new Dbhelper(getApplicationContext());
                db=conn.getWritableDatabase();
                ContentValues CV = new ContentValues();

                if(nulo.isChecked()==false || boric.isChecked()==false || kast.isChecked()==false){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("ALERTA!! Su voto esta en blanco, Desea continuar?")
                            .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    SQLiteDatabase db;
                                    Dbhelper conn = new Dbhelper(getApplicationContext());
                                    db = conn.getReadableDatabase();
                                    db.insert("Voto",null,CV);
                                    Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                                    startActivity(I);
                                }
                            })
                            .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            });
                    builder.create();
                    builder.show();


                }

                if(nulo.isChecked()){
                    CV.put("VotoNulo",nulo.getText().toString());
                    db.insert("Voto",null,CV);
                    Toast.makeText(getApplicationContext(),"Se ha guardado su voto",Toast.LENGTH_SHORT).show();
                    Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                    startActivity(I);
                }

                if(boric.isChecked()){
                    CV.put("VotoBoric",boric.getText().toString());
                    db.insert("Voto",null,CV);
                    Toast.makeText(getApplicationContext(),"Se ha guardado su voto",Toast.LENGTH_SHORT).show();
                    Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                    startActivity(I);
                }

                if(kast.isChecked()){
                    CV.put("VotoKast",kast.getText().toString());
                    db.insert("Voto",null,CV);
                    Toast.makeText(getApplicationContext(),"Se ha guardado su voto",Toast.LENGTH_SHORT).show();
                    Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                    startActivity(I);
                }
            }
        });

        RULTADOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(I);

            }
        });

    }
}