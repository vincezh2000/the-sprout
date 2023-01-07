package com.example.final_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hot_film extends Fragment {
    public static String TAG = "hot_film";
    int[] imageID=new int[]{R.mipmap.img1_11,R.mipmap.img1_21,R.mipmap.img1_31,R.mipmap.img1_41,R.mipmap.img1_51,R.mipmap.img1_61,R.mipmap.img1_71,R.mipmap.img1_81,R.mipmap.img1_91,R.mipmap.img1_101};
    //定义并初始化保存名字的字符数组
    String[] title=new String[]{"送你一朵小红花","心灵奇旅","温暖的抱抱","拆弹专家2","沐浴之王","崖上的波妞","除暴","神奇女侠1984","紧急救援","明天你是否依然爱我"};
    String[] director=new String[]{"导演：韩延","导演：彼特·道格特、凯普·鲍尔斯","导演：常远","导演：邱礼涛","导演：易小星","导演：宫崎骏","导演：派蒂·杰金斯","导演：刘浩良","导演：林超贤","导演：周楠"};
    //onCreateView 初始化Fragment的布局。加载布局和findViewById的操作通常在此函数内完成
    SimpleAdapter adapter;
    ListView listviewf1;
    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 加载自己的layout布局
        View view = inflater.inflate(R.layout.activity_hot_film, null);
        //创建一个list集合
        List<Map<String,Object>> listItems =new ArrayList<Map<String,Object>>();
        //通过for循环将图片id和文字放到Map中，并添加到list列表中
        for(int i=0;i<imageID.length;i++)
        {
            Map<String,Object> map=new HashMap<String, Object>();//实例化Map对象
            map.put("name",title[i]);
            map.put("image",imageID[i]);
            map.put("director",director[i]);
            listItems.add(map);
        }
        //创建SimpleAdapter
        adapter = new SimpleAdapter(getActivity(), listItems, R.layout.listview, new String[]{"name", "image","director"}, new int[]{R.id.name, R.id.image,R.id.director});
        listviewf1=(ListView)view.findViewById(R.id.listviewf1);
        listviewf1.setAdapter(adapter);
        listviewf1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),MovieDetail.class);
                Bundle bundle=new Bundle();
                bundle.putInt("position",position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return view;

    }

}