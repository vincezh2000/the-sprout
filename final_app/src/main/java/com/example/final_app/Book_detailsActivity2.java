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

public class Book_detailsActivity2 extends AppCompatActivity {
    String[] title1=new String[]{"撒野","挪威的森林","火星救援","解忧杂货铺",
            "破云","天龙八部","神雕侠侣","来自新世界","天气之子","何以笙箫默","步步惊心","庆余年"};
    String[] title2=new String[]{"评分8.7","评分8.9","评分:9.4","评分:8.7","评分:9.3",
            "评分:9.5","评分:7.6","评分:8.3","评分:8.0","评分:8.9","评分:9.2","评分:8.5",};


    int[] imageID = new int[]{R.drawable.lx_book1,R.drawable.lx_book2,R.drawable.lx_book3,R.drawable.lx_book4,
            R.drawable.lx_book5,R.drawable.lx_book6,R.drawable.lx_book7,R.drawable.lx_book8,R.drawable.lx_book9,
            R.drawable.lx_book10,R.drawable.lx_book11,R.drawable.lx_book12};
    ImageView img;
    RatingBar rb1;
    ImageButton btn1;
    TextView book_name;
    TextView book_name2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book2_details);
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
                Toast.makeText(Book_detailsActivity2.this,"你的评价为"+Float.toString(v)+"星",Toast.LENGTH_SHORT).show();
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