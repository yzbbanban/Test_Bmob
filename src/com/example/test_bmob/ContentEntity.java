package com.example.test_bmob;

import cn.bmob.v3.BmobObject;

public class ContentEntity extends BmobObject {
	private String title;
	private String content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ContentEntity [title=" + title + ", content=" + content + "]";
	}

}
