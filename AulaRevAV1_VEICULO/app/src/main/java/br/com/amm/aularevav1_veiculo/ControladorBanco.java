package br.com.amm.aularevav1_veiculo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ControladorBanco extends SQLiteOpenHelper {
    private static final int VERSAO = 1;
    private static final String BANCO = "CARROS";
    private static final String TABELA = "TB_MOTORISTA";
    private static final String CREATE_TABELA = "CREATE TABLE "+TABELA+
                                                "(MOTORISTA TEXT," +
                                                " MARCA     TEXT," +
                                                " MULTAS    INTEGER," +
                                                " PRECO     REAL);";

    public ControladorBanco(Context context) {
        super(context, BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABELA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void inserirMotorista(Motorista m){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("MOTORISTA",m.getNomeMotorista());
        registro.put("MARCA",m.getMarcaCarro());
        registro.put("MULTAS",m.getNrMultas());
        registro.put("PRECO",m.getPrecoCarro());
        db.insert(TABELA,null,registro);
    }
    public void carregarLista(ArrayList<Motorista> lista){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor;
        String[] colunas = new String[4];
        colunas[0] = "MOTORISTA"; colunas[1] = "MARCA";  colunas[2] = "MULTAS"; colunas[3] = "PRECO";
        cursor = db.query(TABELA,colunas,null,null,null,null,null);
        boolean proximo = false;
        if(cursor != null){
            proximo = cursor.moveToFirst();
        }else{
            System.out.println("Erro de leitura, sem registros");
        }
        while (proximo){
            String nome  = cursor.getString(0);
            String marca = cursor.getString(1);
            int    nr    = cursor.getInt(2);
            double preco = cursor.getDouble(3);
            Motorista m = new Motorista(nome,marca,nr,preco);
            lista.add(m);
            proximo = cursor.moveToNext();
        }
    }
}
