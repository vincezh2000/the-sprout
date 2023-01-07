package com.example.final_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MusicActivity extends FragmentActivity {
    //导航栏相关控件
    private FrameLayout content;
    private Button btn_liuxing, btn_jingdian,btn_oumei,btn_rihan;
    private FragmentManager fm;//用于管理Activity中的FragmentManager
    private FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        Intent intent=getIntent();//从主界面跳转到音乐界面
        content=(FrameLayout)findViewById(R.id.content);

        btn_liuxing=(Button)findViewById(R.id.music_liuxing);
        btn_jingdian=(Button)findViewById(R.id.music_jingdian);
        btn_oumei=(Button)findViewById(R.id.music_oumei);
        btn_rihan=(Button)findViewById(R.id.music_rihan);

        btn_liuxing.setOnClickListener(viewClickListener);
        btn_jingdian.setOnClickListener(viewClickListener);
        btn_oumei.setOnClickListener(viewClickListener);
        btn_rihan.setOnClickListener(viewClickListener);

        //获取FragmentManager
        fm = getSupportFragmentManager();
        ft=fm.beginTransaction();
        ft.replace(R.id.content,new MusicliuxingActivity());//默认情况下Fragment1
        ft.commit();
    }

    //导航栏的点击事件
    private View.OnClickListener viewClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            ft=fm.beginTransaction();
            switch (v.getId()) {
                case R.id.music_liuxing:
                    ft.replace(R.id.content,new MusicliuxingActivity());;//切换到“电影”Fragment
                    break;
                case R.id.music_jingdian:
                    ft.replace(R.id.content,new MusicjingdianActivity());;//切换到“阅读”Fragment
                    break;
                case R.id.music_rihan:
                    ft.replace(R.id.content,new MusicrihanActivity());;//切换到“音乐”Fragment
                    break;
                case R.id.music_oumei:
                    ft.replace(R.id.content,new MusicoumeiActivity());;
                default:
                    break;
            }
            ft.commit();
        }
    };
}
