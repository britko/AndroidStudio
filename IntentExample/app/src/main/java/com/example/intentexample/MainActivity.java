package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bt_move;
    private EditText et_test;
    private String str;
    ImageView test_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //activity_main.xml을 화면에 표시하라는 의미

        et_test = findViewById(R.id.et_test);

        bt_move = findViewById(R.id.bt_move);
        bt_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = et_test.getText().toString(); //텍스트를 가져와서 String형으로 변환해라
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("str", str);
                startActivity(intent);  //액티비티 이동 구문
            }
        });

        test_img = (ImageView)findViewById(R.id.test_img);
        test_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "고영국입니다요", Toast.LENGTH_SHORT).show();
            }
        });

    }
}