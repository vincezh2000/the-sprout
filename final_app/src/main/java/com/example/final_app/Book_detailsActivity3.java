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

public class Book_detailsActivity3 extends AppCompatActivity {
    String[] title1=new String[]{"边城","围城","亲密关系","傲慢与偏见",
            "简爱","爱的艺术","小王子","杀死一只知更鸟","哈利 波特","窗边的小豆豆","生活,是很好玩的","料理图鉴"};
    String[] title2=new String[]{"评分9.3","评分9.2","评分:8.5","评分:8.9","评分:9.0",
            "评分:8.5","评分:9.1","评分:8.3","评分:9.0","评分:8.9","评分:8.2","评分:8.5",};

     int[] imageID =new int[] {R.drawable.sh_book1,R.drawable.sh_book2,R.drawable.sh_book3,R.drawable.sh_book4,
            R.drawable.sh_book5,R.drawable.sh_book6,R.drawable.sh_book7,R.drawable.sh_book8,R.drawable.sh_book9,
            R.drawable.sh_book10,R.drawable.sh_book11,R.drawable.sh_book12};
    ImageView img;
    RatingBar rb1;
    ImageButton btn1;
    TextView book_name;
    TextView book_name2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book3_details);
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
                Toast.makeText(Book_detailsActivity3.this,"你的评价为"+Float.toString(v)+"星",Toast.LENGTH_SHORT).show();
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