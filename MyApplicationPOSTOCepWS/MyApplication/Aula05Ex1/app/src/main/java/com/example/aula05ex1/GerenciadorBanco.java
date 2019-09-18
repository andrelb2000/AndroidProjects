package com.example.aula05ex1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class GerenciadorBanco extends SQLiteOpenHelper {

    public GerenciadorBanco(Context context) {
        super(context,"ESTADODB",null, 1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
       String sql = "CREATE TABLE TB_ESTADO(NOME TEXT," +
                                          " POPULACAO INTEGER)";
       db.execSQL(sql);
    }
    public void inserir(EstadoModelo estado){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("NOME",estado.getNomeEstado());
        registro.put("POPULACAO",estado.getPopulacaoEstado());
        db.insert("TB_ESTADO",null,registro);
    }
    public void carregar(ArrayList lista){
        lista.clear();
        SQLiteDatabase db = getReadableDatabase();
        String colunas[] = new String[2];
        colunas[0] = "NOME";
        colunas[1] = "POPULACAO";
        Cursor cursor =  db.query("TB_ESTADO",colunas,null,null,null,null,null);
        boolean proximo;
        if(cursor == null){
            return;
        }else{
            proximo = cursor.moveToFirst();
            while (proximo){
                String nome = cursor.getString(0);
                int    pop  = cursor.getInt(1);
                EstadoModelo em = new EstadoModelo(nome,pop);
                lista.add(em);
                proximo = cursor.moveToNext();
            }
        }
    }
}
