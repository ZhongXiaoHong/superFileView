package com.silang.superfileview;

/**
 * Created by 12457 on 2017/8/2.
 */

import android.app.Application;
import android.os.Build;
import com.tencent.smtt.sdk.QbSdk;

/**
 * Created by ljh
 * on 2016/12/22.
 */
public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        //增加这句话
        QbSdk.initX5Environment(this,null);
        ExceptionHandler.getInstance().initConfig(this);
    }


}
