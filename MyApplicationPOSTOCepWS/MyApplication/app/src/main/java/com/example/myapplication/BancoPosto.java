package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BancoPosto extends SQLiteOpenHelper {
    static final private int VERSAO = 1;
    static final private String BANCO = "POSTODB";
    private String TABELA = "POSTO_TB";
    private String CREATE_TABELA = "CREATE TABLE " + TABELA + "(" +
                                            "NOME TEXT," +
                                            "CEP  TEXT," +
                                            "RUA  TEXT" +
                                        ")";

    public BancoPosto(Context context) {
        super(context, BANCO, null, VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABELA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void inserePosto(Posto p){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("NOME",p.getNomePosto());
        registro.put("CEP",p.getCepPosto());
        registro.put("RUA",p.getRuaPosto());
        db.insert(TABELA,null,registro);
    }
    public void carregaListaPosto(ArrayList<Posto> lista){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor;
        String[] coluna = new String[3];
        coluna[0] = "NOME" ; coluna[1] = "CEP"; coluna[2] = "RUA";
        cursor = db.query(TABELA,coluna,null,null,null,null,null);
        boolean proximo = false;
        if (cursor != null){
            proximo = cursor.moveToFirst();
        }else{
            System.out.println("Nenhum registro.....");
        }
        while (proximo){
            String nome = cursor.getString(0);
            String cep  = cursor.getString(1);
            String rua  = cursor.getString(2);
            Posto posto = new Posto(nome,cep,rua);
            lista.add(posto);
            proximo = cursor.moveToNext();
        }
    }
    public void apagarPosto(Posto p){
        SQLiteDatabase db = getWritableDatabase();
        String where = "NOME = ?";
        String[] parametros = new String[1];
        parametros[0] = p.getNomePosto();
        db.delete(TABELA,where,parametros);
    }
    public void alteraPosto(Posto p){
        SQLiteDatabase db = getWritableDatabase();
        /// "Roubado" da funcao de INSERIR
        ContentValues registro = new ContentValues();
        registro.put("NOME",p.getNomePosto());
        registro.put("CEP",p.getCepPosto());
        registro.put("RUA",p.getRuaPosto());
        /// "Roubado" da funcao de APAGAR
        String where = "NOME = ?";
        String[] parametros = new String[1];
        parametros[0] = p.getNomePosto();

        db.update(TABELA,registro,where,parametros);
    }

}
