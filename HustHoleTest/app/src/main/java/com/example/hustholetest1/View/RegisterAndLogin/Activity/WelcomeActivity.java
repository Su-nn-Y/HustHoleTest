package com.example.hustholetest1.View.RegisterAndLogin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hustholetest1.R;
import com.example.hustholetest1.View.HomePage.Activity.HomePageActivity;
import com.githang.statusbar.StatusBarCompat;


public class WelcomeActivity extends AppCompatActivity {
    private Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_welcome);
        StatusBarCompat.setStatusBarColor(this,getResources().getColor(R.color.GrayScale_100) , true);
        button1=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);

        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        }
    public void onClick(View v){
        Intent intent;
        switch (v.getId()) {
            case R.id.button://注册
                intent=new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.button2://直接进主界面逛逛
                //登录成功进入主界面
                intent=new Intent(WelcomeActivity.this, HomePageActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);;
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
