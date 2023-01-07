package com.example.final_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Book_detailsActivity extends AppCompatActivity {

    String[] title1 = new String[]{"活着", "悲惨世界", "红楼梦", "追风筝的人", "记忆记忆",
            "回归故里", "云边有个小卖部", "飘", "风声", "月亮与六便士", "嫌疑人X的献身", "骆驼祥子",};
    String[] title2 = new String[]{"评分9.4", "评分9.9", "评分:9.6", "评分:8.9", "评分:8.8",
            "评分:9.0", "评分:7.6", "评分:9.3", "评分:9.0", "评分:8.8", "评分:8.9", "评分:8.4",};
    int[] imageID=new int[]{R.drawable.wx_book1,R.drawable.wx_book2,R.drawable.wx_book3,R.drawable.wx_book4,
            R.drawable.wx_book5,R.drawable.wx_book6,R.drawable.wx_book7,R.drawable.wx_book8,R.drawable.wx_book9,
            R.drawable.wx_book10,R.drawable.wx_book11,R.drawable.wx_book12};
    ImageView img;
    RatingBar rb1;
    ImageButton btn1;
    TextView book_name;
    TextView book_name2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        img=(ImageView)findViewById(R.id.book1);
        rb1=(RatingBar)findViewById(R.id.rb1);
        btn1=(ImageButton)findViewById(R.id.btn1);
        img.setImageResource(imageID[bundle.getInt("position")]);
        book_name=(TextView)findViewById(R.id.book1_text);
        book_name2=(TextView)findViewById(R.id.book1_text3);
        book_name.setText(title1[bundle.getInt("position")]);
        book_name2.setText(title2[bundle.getInt("position")]);
        rb1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(Book_detailsActivity.this,"你的评价为"+Float.toString(v)+"星",Toast.LENGTH_SHORT).show();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}