package com.buildmlearn.quiztemplate;

import android.util.Log;


public class ApplicationModel {
	
	
	private String mAppName;
	private String mAuthorName;
	
	
	public String getmAppName() {
		return mAppName;
	}
	public void setmAppName(String mAppName) {
		Log.e("setting app name as", ""+mAppName);
		this.mAppName = mAppName;
	}
	public String getmAuthorName() {
		return mAuthorName;
	}
	public void setmAuthorName(String mAuthorName) {
		this.mAuthorName = mAuthorName;
	}
	
	

}
