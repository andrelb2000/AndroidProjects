package br.com.amm.aula6ex1sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by andre on 03/04/2018.
 */

public class GerenteBanco extends SQLiteOpenHelper {
    public static final String NOME_TABELA = "TAB_PRODUTO";
    private static final String CREATE_TABELA = "CREATE TABLE "+
                                                NOME_TABELA +
                                                "(NOME  TEXT, "+
                                                 "PRECO REAL);";
    public GerenteBanco(Context context) {
        super(context, "PRODUTODB2", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABELA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
