package com.test.aroutetest;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @ProjectName: ArouteTest
 * @Package: com.test.aroutetest
 * @ClassName: MyApplication
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/6/30 11:50
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/6/30 11:50
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MyApplication extends Application {
    public static boolean isLogin = false;

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(
                this
        );

//        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
//                Log.e("MyApplication",t.getName()+":::"+e.getMessage());
//            }
//        });
    }
}
