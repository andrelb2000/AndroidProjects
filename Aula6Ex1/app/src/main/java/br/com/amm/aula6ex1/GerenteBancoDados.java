package br.com.amm.aula6ex1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GerenteBancoDados extends SQLiteOpenHelper {
    //Versao do Banco importante ao longo do tempo
    private static final int VERSAO_BANCO = 1;
    // Nome do Banco de dados
    public static final String NOME_BANCO = "EMPRESA";
    //Nome das Tabelas
    public static final String TABELA1_NOME = "TABELAFUNC";
    // Statement de criaçao de uma das tabelas
    private static final String TABELA1_CREATE =
            "CREATE TABLE " + TABELA1_NOME + " ("+
                    "NOME    TEXT, " +
                    "SALARIO REAL);";
    public GerenteBancoDados(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABELA1_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){}
}
