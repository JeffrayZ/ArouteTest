package com.test.aroutetest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_userinfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/test/UserInfoActivity")
                        .navigation(MainActivity.this, new NavCallback() {
                            @Override
                            public void onArrival(Postcard postcard) {
                                Log.e("MainActivity", "onArrival");
                            }

                            @Override
                            public void onFound(Postcard postcard) {
                                super.onFound(postcard);
                                Log.e("MainActivity", "onFound");
                            }

                            @Override
                            public void onLost(Postcard postcard) {
                                super.onLost(postcard);
                                Log.e("MainActivity", "onLost");
                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                super.onInterrupt(postcard);
                                Log.e("MainActivity", "onInterrupt");
                                ARouter.getInstance().build("/test/LoginActivity")
                                        .with(postcard.getExtras())
                                        .withString("loginPath",null)
                                        .navigation();
                            }
                        });
            }
        });

    }
}