package com.example.final_app;



import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity {
    EditText nameEdit,passwordEdit;
    Button registerBtn,queryBtn,selectImageButton;
    ImageView image;
    Handler handler;
    String baseURL="",headPicture="",name="",password="",headPicture1;
    String result="";
    //导航栏相关控件
    ImageButton btn_film, btn_reading, btn_music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_film = (ImageButton) findViewById(R.id.btn_film);
        btn_music = (ImageButton) findViewById(R.id.btn_music);
        btn_reading = (ImageButton) findViewById(R.id.btn_reading);
        btn_film.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, FilmActivity.class);
                startActivity(intent1);
            }
        });
        btn_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, MusicActivity.class);
                startActivity(intent2);
            }
        });
        btn_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, ReadingActivity.class);
                startActivity(intent3);
            }
        });

        //baseURL="http://192.168.71.104:8080/myRegister/";
        nameEdit = (EditText) findViewById(R.id.name);
        passwordEdit = (EditText) findViewById(R.id.password);     //获取用于输入密码的编辑框组件
        registerBtn= (Button) findViewById(R.id.register);
        queryBtn=(Button) findViewById(R.id.query);
        image=(ImageView)findViewById(R.id.image);
        selectImageButton=(Button)findViewById(R.id.tv3);//选择头像按钮
        selectImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent=new Intent(MainActivity.this,HeadActivity.class);
                startActivityForResult(intent, 0x11);//启动intent对应的Activity
            }
        });

        //新建了一个test_db的数据库
        DatabaseHelper databaseHelper = new DatabaseHelper(this,"test_db",null,1);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

    }

}


