package br.com.amm.aula6ex1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class InsereActivity extends AppCompatActivity {
    private GerenteBancoDados gerenteBanco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insere);
        gerenteBanco = new GerenteBancoDados(getApplicationContext());
    }
    public long insere(Funcionario funcionario) throws Exception{
        SQLiteDatabase db = gerenteBanco.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("NOME", funcionario.getNomeFuncionario());
            registro.put("SALARIO",funcionario.getSalarioFuncionario());
        return db.insert(GerenteBancoDados.TABELA1_NOME,null,registro);
    }

    public ArrayList<Funcionario> selectAll() throws Exception{
        SQLiteDatabase db = gerenteBanco.getReadableDatabase();
        Cursor cursor = null;
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        String[] colunas = new String[2];
        colunas[0] = "NOME";
        colunas[1] = "SALARIO";
        cursor = db.query(GerenteBancoDados.TABELA1_NOME,
                          colunas,null,null,null,null,null);
        while(cursor != null){
            String nome = cursor.getString(0);
            double salario = cursor.getDouble(1);
            Funcionario f  = new Funcionario(nome,salario);
            lista.add(f);
            cursor.moveToNext();
        }
        return lista;
    }
}
