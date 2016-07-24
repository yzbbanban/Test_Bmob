package com.example.test_bmob;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DataActivity extends Activity {
	private EditText etDataDiary;
	private EditText etDataTitle;
	private Button btnSubmit;
	private Button btnGet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data);
		initView();
		initListeners();
	}

	private void initListeners() {
		btnSubmit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String title = etDataTitle.getText().toString();
				String content = etDataDiary.getText().toString();
				ContentEntity contentEntity = new ContentEntity();
				contentEntity.setTitle(title);
				contentEntity.setContent(content);
				contentEntity.save(new SaveListener<String>() {

					@Override
					public void done(String arg0, BmobException arg1) {
						if (arg1 == null) {
							Toast.makeText(getApplicationContext(), "保存成功",
									Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(getApplicationContext(),
									"保存失败" + arg1.getMessage(),
									Toast.LENGTH_SHORT).show();

						}

					}
				});
			}
		});

		btnGet.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				BmobQuery<ContentEntity> query = new BmobQuery<ContentEntity>();
				query.setLimit(50);
				query.findObjects(new FindListener<ContentEntity>() {

					@Override
					public void done(List<ContentEntity> arg0,
							BmobException arg1) {
						if (arg1 == null) {
							Log.i("supergirl", arg0.toString());

						} else {

							Log.i("supergirl", arg1.getMessage());
						}
					}
				});
			}
		});

	}

	private void initView() {
		etDataDiary = (EditText) findViewById(R.id.et_data_diary);
		etDataTitle = (EditText) findViewById(R.id.et_data_title);
		btnSubmit = (Button) findViewById(R.id.btn_data_submit);
		btnGet = (Button) findViewById(R.id.btn_data_get);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
