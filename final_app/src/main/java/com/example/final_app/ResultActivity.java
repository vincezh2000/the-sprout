package com.example.final_app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ImageView image1=(ImageView)findViewById(R.id.image);
        TextView tv1=(TextView)findViewById(R.id.tv1);
        Intent intent=getIntent();
        tv1.setText(intent.getStringExtra("name"));
        String photo=intent.getStringExtra("photo");
        byte[] decode = Base64.decode(photo.getBytes(), Base64.DEFAULT);
        Bitmap bitmap1 = BitmapFactory.decodeByteArray(decode, 0, decode.length);
        image1.setImageBitmap(bitmap1);

    }
}
