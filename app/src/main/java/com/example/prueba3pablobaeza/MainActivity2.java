package com.example.prueba3pablobaeza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button Volverrr;
    TextView tv_blanco, tv_boric, tv_nulo, tv_kast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Volverrr = (Button) findViewById(R.id.button3);
        tv_blanco = (TextView) findViewById(R.id.textView3);
        tv_boric = (TextView) findViewById(R.id.textView12);
        tv_kast = (TextView) findViewById(R.id.textView9);
        tv_nulo = (TextView) findViewById(R.id.textView5);

        Integer TotalBlancos =0, TotalBoric=0, TotalKast=0, TotalNulos=0;
        SQLiteDatabase db;
        Dbhelper conn = new Dbhelper(getApplicationContext());
        db = conn.getReadableDatabase();
        Cursor C=db.query("Voto",null,null,null,null,null,null);
        if(C!=null)
        {
            if(C.moveToFirst())
            {
                do{
                    if(C.getString(1).equals("Blanco"))
                    {
                        TotalBlancos++;
                    }

                    if(C.getString(2).equals("Nulo"))
                    {
                        TotalNulos++;
                    }
                    if(C.getString(3).equals("Gabriel Boric"))
                    {
                        TotalBoric++;
                    }
                    if(C.getString(4).equals("Jose Antonio Kast"))
                    {
                        TotalKast++;
                    }
                }
                while(C.moveToNext());
            }
        }
        tv_boric.setText(""+TotalBoric);
        tv_blanco.setText(""+TotalBlancos);
        tv_kast.setText(""+TotalKast);
        tv_nulo.setText(""+TotalNulos);

        Volverrr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(I);
            }
        });

    }
}