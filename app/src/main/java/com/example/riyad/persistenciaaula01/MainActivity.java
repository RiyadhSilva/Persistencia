package com.example.riyad.persistenciaaula01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PostDB postDB = new PostDB(this);

        Post post = new Post();
        post.setTexto("Testando.... Eu sou o maaaascara");
        post.setLikes(1);
        post.setData(new Date());

        postDB.save(post);
    }


}
