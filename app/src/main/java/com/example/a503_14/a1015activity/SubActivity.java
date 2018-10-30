package com.example.a503_14.a1015activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class SubActivity extends AppCompatActivity {
    TextView subLabel;
    Button moveMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        subLabel=(TextView)findViewById(R.id.subLabel);
        moveMain=(Button)findViewById(R.id.moveMain);

        //메인에서 전달해 준 데이터 읽기
        final Intent intent=getIntent();
        //String data=intent.getStringExtra("data");
        //subLabel.setText(data);
        HashMap<String, Object> map=(HashMap<String, Object>)intent.getSerializableExtra("data");
        subLabel.setText(map.toString());


        moveMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //상위 Activity에게 전달할 데이터 생성
                Intent intent=new Intent();
                intent.putExtra("subdata", "하위 Activity에서 넘겨주는 데이터");
                //응답 코드 생성 한 후 데이터 전달
                setResult(100, intent);
                finish();
            }
        });


        Log.e("SubActivity", "Sub의 onCreate");

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("SubActivity", "Sub의 onResume");

    }

}
