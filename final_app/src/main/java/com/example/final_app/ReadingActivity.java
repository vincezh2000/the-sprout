package com.example.final_app;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ReadingActivity extends FragmentActivity {
    //导航栏相关控件
    Button book_wenxue,book_liuxing,book_shenghuo;
    FragmentManager ffragmentManager;//用于管理Activity中的FragmentManager
    Fragment fcurFragment;// 记录当前显示的Fragment
    ReadingActivity1 ffirstFragment = null;//文学Fragment
    ReadingActivity2 fsecondFragment = null;//流行Fragment
    ReadingActivity3 fthirdFragment = null;//生活Fragment
    public static String curTag = "";// 当前导航标签

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        Intent intent=getIntent();
        finitView();
        curTag = "";
        tofFirstFragment();
    }
    private void finitView() {
        book_wenxue= (Button) findViewById(R.id.book_wenxue);
        book_liuxing= (Button) findViewById(R.id.book_liuxing);
        book_shenghuo=(Button)findViewById(R.id.book_shenghuo);

        book_wenxue.setOnClickListener(viewClickListener);
        book_liuxing.setOnClickListener(viewClickListener);
        book_shenghuo.setOnClickListener(viewClickListener);

        //获取FragmentManager
        ffragmentManager = getSupportFragmentManager();
    }

    //导航栏的点击事件
    private View.OnClickListener viewClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.book_wenxue:
                    tofFirstFragment();//切换到“文学”Fragment
                    break;
                case R.id.book_liuxing:
                    tofSecondFragment();//切换到“流行”Fragment
                    break;
                case R.id.book_shenghuo:
                    tofThirdFragment();//切换到“生活”Fragment
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
            if (ReadingActivity1.TAG.equals(tag)){
                ffirstFragment = new ReadingActivity1();
                fragment = ffirstFragment;
            }
            if (ReadingActivity2.TAG.equals(tag)) {
                fsecondFragment = new ReadingActivity2();
                fragment = fsecondFragment;
            }
            if(ReadingActivity3.TAG.equals(tag)){
                fthirdFragment = new ReadingActivity3();
                fragment = fthirdFragment;
            }
            //向activity中指定的位置（第一个参数），添加一个Fragment（第二个参数），这个Fragment对应的tag指定为（第三个参数）
            transation.add(R.id.reading_frame_layout, fragment, tag);
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
        if (!curTag.equals(ReadingActivity1.TAG)) {
            //显示指定的Fragment
            showTabData(ReadingActivity1.TAG);
        }
    }

    /**
     * 切换到 热映 界面
     * */
    public void tofSecondFragment() {
        if (!curTag.equals(ReadingActivity2.TAG)) {
            //显示指定的Fragment
            showTabData(ReadingActivity2.TAG);

        }
    }
    public void tofThirdFragment() {
        if (!curTag.equals(ReadingActivity3.TAG)) {
            //显示指定的Fragment
            showTabData(ReadingActivity3.TAG);

        }
    }
}