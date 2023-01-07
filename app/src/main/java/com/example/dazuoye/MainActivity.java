package com.example.dazuoye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    //导航栏相关控件
    ImageButton btn_film, btn_reading, btn_music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}