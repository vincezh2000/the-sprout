package com.example.final_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MusicjingdianActivity extends Fragment {
    public View view;
    public String[] name={"光辉岁月——Beyond","海阔天空——Beyond","真的爱你——Beyond","我只在乎你——邓丽君","月亮代表我的心——邓丽君","甜蜜蜜——邓丽君","忘情水——刘德华"};
    public static int[] icons={R.drawable.music1, R.drawable.music2, R.drawable.music3, R.drawable.music4,
            R.drawable.music5, R.drawable.music6, R.drawable.music7, R.drawable.music8, R.drawable.music9,
            R.drawable.music10, R.drawable.music11, R.drawable.music12, R.drawable.music13, R.drawable.music14,
            R.drawable.music15, R.drawable.music16, R.drawable.music17, R.drawable.music18, R.drawable.music19,
            R.drawable.music20, R.drawable.music21, R.drawable.music22, R.drawable.music23, R.drawable.music24,
            R.drawable.music25, R.drawable.music26, R.drawable.music27, R.drawable.music28};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 加载自己的layout布局
        view = inflater.inflate(R.layout.music_jingdian, null);
        ListView listView=view.findViewById(R.id.lv);

        MyBaseAdapter adapter=new MyBaseAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int positions;
                Intent intent=new Intent(MusicjingdianActivity.this.getContext(), MusicDetailActivity.class);//创建Intent对象，启动check
                //将数据存入Intent对象
                intent.putExtra("name",name[position]);
                positions=position+9;
                intent.putExtra("position",String.valueOf(positions));
                startActivity(intent);
            }
        });




        return view;
    }

    class MyBaseAdapter extends BaseAdapter {
        @Override
        public int getCount(){return  name.length;}
        @Override
        public Object getItem(int i){return name[i];}
        @Override
        public long getItemId(int i){return i;}

        @Override
        public View getView(int i ,View convertView, ViewGroup parent) {
            View view=View.inflate(MusicjingdianActivity.this.getContext(), R.layout.item_layout,null);
            TextView tv_name=view.findViewById(R.id.item_name);
            ImageView iv=view.findViewById(R.id.iv);

            tv_name.setText(name[i]);
            iv.setImageResource(icons[i+9]);
            return view;
        }
    }
}
