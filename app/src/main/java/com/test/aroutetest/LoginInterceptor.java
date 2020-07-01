package com.test.aroutetest;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * @ProjectName: ArouteTest
 * @Package: com.test.aroutetest
 * @ClassName: LoginIntercepter
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/6/30 11:55
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/6/30 11:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Interceptor(priority = 1, name = "LoginInterceptor")
public class LoginInterceptor implements IInterceptor {

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.e("LoginInterceptor", postcard.toString());
        if(postcard.getExtra() == 100 && !MyApplication.isLogin){
            callback.onInterrupt(new Exception("需要登录"));
        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        Log.e("LoginInterceptor", "拦截器初始化");
    }
}
