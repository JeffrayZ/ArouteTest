package com.test.aroutetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/test/LoginActivity")
public class LoginActivity extends AppCompatActivity {

//    @Autowired(name = "")
//    public String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApplication.isLogin = true;
                ARouter.getInstance().build(getIntent().getStringExtra("loginPath")).with(getIntent().getExtras()).navigation();
            }
        });
    }
}