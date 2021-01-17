package com.example.sharedexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_save;
    String shared = "file";

    //현재 상태 저장: 스위치 끄고 켜는데 유용 ex)설정에 on/off, 아이디 기억 but, 임시저장으로 앱 삭제 시 사라짐
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText)findViewById(R.id.et_save);
        //불러오기
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("ko", "");
        et_save.setText(value);


    }

    //
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //저장
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value = et_save.getText().toString();
        editor.putString("ko", value);
        editor.commit();
    }
}