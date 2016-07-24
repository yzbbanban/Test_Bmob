package com.example.test_bmob;

import cn.bmob.v3.Bmob;
import android.app.Application;

public class MyApplication extends Application {
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Bmob.initialize(this, "3f9a4de05f39f0aa2bbb25ec24bcca2b");
	}
}
