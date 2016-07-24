package com.example.test_bmob;

import cn.bmob.v3.Bmob;
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
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("unused")
public class MainActivity extends Activity {
	private EditText etUsername;
	private EditText etPwd;
	private EditText etPwdAga;
	private Button btnLogin;
	private Button btnRegist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initListeners();
	}

	private void initListeners() {
		btnLogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,
						LoginActivity.class));
				finish();
			}
		});
		btnRegist.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// ע��
				BmobUser user = new BmobUser();
				String name = etUsername.getText().toString().trim();
				String pwd = etPwd.getText().toString().trim();
				String pwdage = etPwdAga.getText().toString().trim();
				// �ǿ���֤
				if (name.equals("")) {
					etUsername.setError("�˺Ų���Ϊ��");
					return;
				}
				if (pwd.equals("")) {
					etUsername.setError("���벻��Ϊ��");
					return;
				}
				if (pwdage.equals("")) {
					etUsername.setError("�ظ����벻��Ϊ��");
					return;
				}
				user.setUsername(name);
				user.setPassword(pwdage);
				user.signUp(new SaveListener<BmobUser>() {

					@Override
					public void done(BmobUser arg0, BmobException arg1) {
						// TODO Auto-generated method stub
						if (arg1 == null) {
							// ע��ɹ�
							Toast.makeText(MainActivity.this, "ע��ɹ�",
									Toast.LENGTH_SHORT).show();
							
						} else {
							Toast.makeText(MainActivity.this,
									"ע��ʧ��" + arg1.getMessage(),
									Toast.LENGTH_SHORT).show();

						}
					}

				});

			}
		});

	}

	private void initView() {
		etUsername = (EditText) findViewById(R.id.et_username);
		etPwd = (EditText) findViewById(R.id.et_pwd);
		etPwdAga = (EditText) findViewById(R.id.et_pwd_aga);
		btnLogin = (Button) findViewById(R.id.btn_login);
		btnRegist = (Button) findViewById(R.id.btn_regist);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
