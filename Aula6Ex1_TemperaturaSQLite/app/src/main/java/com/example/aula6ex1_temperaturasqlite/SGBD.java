package com.example.aula6ex1_temperaturasqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SGBD extends SQLiteOpenHelper {
    private final static int VERSION = 1;
    private final static String NOMEBANCO    = "TEMP2";
    private final static String TABELA       = "TEMPER2";
    private final static String CREATE_STMT  = "CREATE TABLE " +
                         TABELA +
                         "(NOMESENSOR TEXT, " +
                          "CODSENSOR  INTEGER, " +
                          "TEMPSENSOR REAL);";

    public SGBD(Context context) {
        super(context, NOMEBANCO, null, VERSION);


    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Onde vamos criar as tabelas do banco
        db.execSQL(CREATE_STMT);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Quando queremos alterar bancos ja existentes
    }
    public void insereSensor(Sensor s){
        //1 - Obter Banco para Escrita
        SQLiteDatabase db = getWritableDatabase();
            ContentValues registro = new ContentValues();
            // Colocar valores no registro
                registro.put("NOMESENSOR",s.getNomeSensor());
                registro.put("CODSENSOR",s.getCodSensor());
                registro.put("TEMPSENSOR",s.getTempSensor());
            db.insert(TABELA,null,registro);
        db.close();
    }
    public ArrayList<Sensor> recuperaSensores(ArrayList<Sensor> lista){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor;
        String[] colunas = new String[3];
        colunas[0] = "NOMESENSOR";  colunas[1] = "CODSENSOR";  colunas[2] = "TEMPSENSOR";
        cursor = db.query(TABELA,colunas,null,null,null,null,null);
        boolean proximo = false;
        if(cursor==null){
            System.out.print("Erro de banco");
        }else{
            proximo = cursor.moveToFirst();
        }
        while(proximo){
            String nome = cursor.getString(0);
            int    cod  = cursor.getInt(1);
            double temp = cursor.getDouble(2);
            Sensor s = new Sensor(nome,cod,temp);
            lista.add(s);
            proximo = cursor.moveToNext();
        }
        db.close();
        return lista;
    }
    public ArrayList<Sensor> recuperaSensores(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Sensor> lista = new ArrayList<Sensor>();
        Cursor cursor;
        String[] colunas = new String[3];
        colunas[0] = "NOMESENSOR";
        colunas[1] = "CODSENSOR";
        colunas[2] = "TEMPSENSOR";
        cursor = db.query(TABELA,colunas,null,null,null,null,null);
        boolean proximo = false;
        if(cursor==null){
            System.out.print("Erro de banco");
        }else{
            proximo = cursor.moveToFirst();
        }
        while(proximo){
            String nome = cursor.getString(0);
            int    cod  = cursor.getInt(1);
            double temp = cursor.getDouble(2);
            Sensor s = new Sensor(nome,cod,temp);
            lista.add(s);
            proximo = cursor.moveToNext();
        }
        db.close();
        return lista;
    }
}
