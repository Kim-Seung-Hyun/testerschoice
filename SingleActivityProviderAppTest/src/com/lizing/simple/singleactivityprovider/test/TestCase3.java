package com.lizing.simple.singleactivityprovider.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;

import com.lizing.simple.singleactivityprovider.SingleActivityProviderAppActivity;

public class TestCase3 extends ActivityInstrumentationTestCase2<SingleActivityProviderAppActivity> {

	EditText text;
	Button addButton;
	Button delButton;
	
	public TestCase3(){
		super(SingleActivityProviderAppActivity.class);
	}
	
	public void testPreConditions(){
		Activity a = getActivity();
		assertNotNull(a);
		text = (EditText) a.findViewById(com.lizing.simple.singleactivityprovider.R.id.editText1);
		assertNotNull(text);
		addButton = (Button) a.findViewById(com.lizing.simple.singleactivityprovider.R.id.btn_add);
		assertNotNull(addButton);
		delButton = (Button) a.findViewById(com.lizing.simple.singleactivityprovider.R.id.btn_del_all);
		assertNotNull(delButton);
	}
	
	public void testAdd(){
		Activity a = super.getActivity();
		try {
			runTestOnUiThread(new Runnable() {
				
				//@Override
				public void run() {
					// TODO Auto-generated method stub
					text.requestFocus();
				}
			});
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.sendKeys(KeyEvent.KEYCODE_T);
		this.sendKeys(KeyEvent.KEYCODE_E);
		this.sendKeys(KeyEvent.KEYCODE_S);
		this.sendKeys(KeyEvent.KEYCODE_T);
		this.sendKeys(KeyEvent.KEYCODE_2);
		this.sendKeys(KeyEvent.KEYCODE_DPAD_DOWN);
		this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
	}
}