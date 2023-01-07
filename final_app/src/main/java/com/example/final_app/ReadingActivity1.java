package com.example.final_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadingActivity1 extends Fragment {
    public static String TAG = "reading1";
    private GridView gv;

    //定义并初始化保存图片id的数组
    public static int[] imageID = {R.drawable.wx_book1, R.drawable.wx_book2, R.drawable.wx_book3, R.drawable.wx_book4,
            R.drawable.wx_book5, R.drawable.wx_book6, R.drawable.wx_book7, R.drawable.wx_book8, R.drawable.wx_book9,
            R.drawable.wx_book10, R.drawable.wx_book11, R.drawable.wx_book12};
    //定义并初始化保存名字的字符数组
    String[] title1 = new String[]{"活着", "悲惨世界", "红楼梦", "追风筝的人", "记忆记忆",
            "回归故里", "云边有个小卖部", "飘", "风声", "月亮与六便士", "嫌疑人X的献身", "骆驼祥子",};
    String[] title2 = new String[]{"评分9.4", "评分9.9", "评分:9.6", "评分:8.9", "评分:8.8",
            "评分:9.0", "评分:7.6", "评分:9.3", "评分:9.0", "评分:8.8", "评分:8.9", "评分:8.4",};

    SimpleAdapter adapter;
    GridView gridView1;
    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        // 加载自己的layout布局
        View view = inflater.inflate(R.layout.activity_reading1, null);
        //创建一个list集合
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        //通过for循环将图片id和文字放到Map中，并添加到list列表中
        for (int i = 0; i < imageID.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();//实例化Map对象
            map.put("image", imageID[i]);
            map.put("name1", title1[i]);
            map.put("name2", title2[i]);
            listItems.add(map);
        }
        //创建SimpleAdapter
        adapter = new SimpleAdapter(getActivity(), listItems, R.layout.main_book, new String[]{"name1", "name2", "image"}, new int[]{R.id.book_title1, R.id.book_title2, R.id.book_image});
        gridView1=(GridView)view.findViewById(R.id.gridView1);
        gridView1.setAdapter(adapter);//将适配器与listview关联
        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Book_detailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        /*
        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), Book_detailsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle = new Bundle();
                bundle.putInt("position", i);
                intent.putExtras(bundle);
                startActivity(intent);

                //获取选择项的值
                /*Map<String,Object> map=(Map<String,Object>)adapterView.getItemAtPosition(i);
                Toast.makeText(ReadingActivity.this,map.get("name").toString(),Toast.LENGTH_SHORT).show();*/
            //}

       // });
        return view;
    }
}

