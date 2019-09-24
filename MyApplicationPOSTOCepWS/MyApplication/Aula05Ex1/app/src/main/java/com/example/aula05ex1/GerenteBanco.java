package com.example.aula05ex1;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GerenteBanco extends SQLiteOpenHelper {
    public GerenteBanco(Context context) {
        super(context,"MEUBANCO",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
     //Codigo para criar as tabelas
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     // Codigo em caso de atualizacao futura
    }
}
