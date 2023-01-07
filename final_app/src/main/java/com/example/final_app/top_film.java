package com.example.final_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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

public class top_film extends Fragment {
    public static String TAG = "top_film";
    int[] imageID=new int[]{R.mipmap.img2_11,R.mipmap.img2_21,R.mipmap.img2_31,R.mipmap.img2_41,R.mipmap.img2_51,R.mipmap.img2_61,R.mipmap.img2_71,R.mipmap.img2_81,R.mipmap.img2_91,R.mipmap.img2_101};
    //定义并初始化保存名字的字符数组
    String[] title=new String[]{"肖申克的救赎","霸王别姬","阿甘正传","这个杀手不太冷","泰坦尼克号","美丽人生","千与千寻","辛德勒的名单","盗梦空间","忠犬八公的故事"};
    String[] director=new String[]{"导演：弗兰克·德拉邦特","导演：陈凯歌","导演：罗伯特·泽米吉斯","导演：吕克·贝松","导演：詹姆斯·卡梅隆","导演：罗伯托·贝尼尼","导演：宫崎骏","导演：史蒂文·斯皮尔伯格","导演：克里斯托弗·诺兰","导演：拉斯·霍尔斯道姆"};
    //onCreateView 初始化Fragment的布局。加载布局和findViewById的操作通常在此函数内完成
    SimpleAdapter adapter;
    ListView listviewf2;
    //onCreateView 初始化Fragment的布局。加载布局和findViewById的操作通常在此函数内完成
    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 加载自己的layout布局
        View view = inflater.inflate(R.layout.activity_top_film, null);
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
        listviewf2=(ListView)view.findViewById(R.id.listviewf2);
        listviewf2.setAdapter(adapter);
        listviewf2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),TopMovieDetail.class);
                Bundle bundle=new Bundle();
                bundle.putInt("position",position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return view;
    }
}