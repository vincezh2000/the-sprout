package com.example.final_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FilmActivity extends FragmentActivity {
    //导航栏相关控件
    Button film_rmtj,film_ysbf;
    FragmentManager ffragmentManager;//用于管理Activity中的FragmentManager
    Fragment fcurFragment;// 记录当前显示的Fragment
    top_film ffirstFragment = null;//top Fragment
    hot_film fsecondFragment = null;//播放Fragment
    public static String curTag = "";// 当前导航标签
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);
        Intent intent=getIntent();
        finitView();
        curTag = "";
        tofFirstFragment();
    }
    private void finitView() {
        film_rmtj= (Button) findViewById(R.id.film_rmtj);
        film_ysbf= (Button) findViewById(R.id.film_ysbf);

        film_rmtj.setOnClickListener(viewClickListener);
        film_ysbf.setOnClickListener(viewClickListener);

        //获取FragmentManager
        ffragmentManager = getSupportFragmentManager();
    }

    //导航栏的点击事件
    private View.OnClickListener viewClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.film_rmtj:
                    tofFirstFragment();//切换到“热门”Fragment
                    break;
                case R.id.film_ysbf:
                    tofSecondFragment();//切换到“播放”Fragment
                    break;
                default:
                    break;
            }
        }
    };
    // 显示tab标签对应的数据
    private void showTabData(String tag) {
        curTag = tag;
        //在fragmentManager中，通过指定的tag，找到对应的Fragment
        Fragment fragment = ffragmentManager.findFragmentByTag(tag);
        //开始一个事务
        FragmentTransaction transation = ffragmentManager.beginTransaction();

        //如果没有找到 对应的Fragment，就创建一个
        if (fragment == null) {
            if (top_film.TAG.equals(tag)) {
                ffirstFragment = new top_film();
                fragment = ffirstFragment;
            }else {
                fsecondFragment= new hot_film();
                fragment = fsecondFragment;
            }
            //向activity中指定的位置（第一个参数），添加一个Fragment（第二个参数），这个Fragment对应的tag指定为（第三个参数）
            transation.add(R.id.film_frame_layout, fragment, tag);
        }

        if (fcurFragment != null) {
            //隐藏当前的Fragment
            transation.hide(fcurFragment);
        }
        //显示指定的Fragment
        transation.show(fragment);
        //提交一个事务
        transation.commitAllowingStateLoss();
        //记录当前显示的Fragment
        fcurFragment = fragment;
    }

    /**
     * 切换到 top 界面
     * */
    private void tofFirstFragment() {
        if (!curTag.equals(top_film.TAG)) {
            //显示指定的Fragment
            showTabData(top_film.TAG);
        }
    }

    /**
     * 切换到 热映 界面
     * */
    public void tofSecondFragment() {
        if (!curTag.equals(hot_film.TAG)) {
            //显示指定的Fragment
            showTabData(hot_film.TAG);

        }
    }
}