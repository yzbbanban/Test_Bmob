package com.example.test_bmob;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private EditText etLoginUsername;
	private EditText etLoginPwd;
	private Button btnLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initView();
		initListeners();
	}

	private void initListeners() {
		btnLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String name = etLoginUsername.getText().toString().trim();
				String pwd = etLoginPwd.getText().toString();
				BmobUser user = new BmobUser();
				user.setUsername(name);
				user.setPassword(pwd);
				user.login(new SaveListener<BmobUser>() {

					@Override
					public void done(BmobUser arg0, BmobException arg1) {
						if (arg1 == null) {

							Toast.makeText(LoginActivity.this, "µÇÂ½³É¹¦",
									Toast.LENGTH_SHORT).show();
							startActivity(new Intent(LoginActivity.this,
									DataActivity.class));
						} else {
							Toast.makeText(LoginActivity.this,
									"µÇÂ½Ê§°Ü" + arg1.getMessage(),
									Toast.LENGTH_SHORT).show();

						}

					}
				});
			}
		});

	}

	private void initView() {
		etLoginUsername = (EditText) findViewById(R.id.et_login_username);
		etLoginPwd = (EditText) findViewById(R.id.et_login_pwd);
		btnLogin = (Button) findViewById(R.id.btn_login_login);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
