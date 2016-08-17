package com.example.riyad.persistenciaaula01;

import android.content.ContentValues;
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

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long save(Post post){
        long id = post.getId();
        SQLiteDatabase db = getWritableDatabase();
        try{
            ContentValues values = new ContentValues();
            values.put("texto", post.getTexto());
            values.put("likes", post.getLikes());
            values.put("data", post.getData().getTime());
            if( id != 0){
                String _id = String.valueOf(post.getId());
                String[] whereArgs = new String[]{_id};
                int count = db.update("post", values," _id=?", whereArgs);
                Log.i(TAG, "Atualizou post");
                return count;
            } else {
                id = db.insert("post", "", values);
                Log.d(TAG, "Inseriu post");
                return id;
            }
        }catch (Exception e){
            Log.d(TAG, "Erro: " + e.getMessage());
            return 0;
        } finally {
            db.close();
        }
    }


}
