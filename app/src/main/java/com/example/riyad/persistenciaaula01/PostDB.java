package com.example.riyad.persistenciaaula01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by riyad on 17/08/2016.
 */
public class PostDB extends SQLiteOpenHelper {
    //Nome do banco
    public static final String NOME_BANCO = "rede_social.sqlite";
    public static final String TAG = "SQL_TEP";
    private static final int VERSAO_BANCO = 1;

    public PostDB(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    public void onCreate(SQLiteDatabase db){
        Log.d(TAG, "Criando a Tabela carro...");
        db.execSQL(" create table if not exists post (" +
        "_id integer primary key autoincrement, " +
        " texto text, likes integer, data data);");
        Log.d(TAG, "Tabela carro criada com sucesso.");
    }


}
