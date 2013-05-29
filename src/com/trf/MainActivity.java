package com.trf;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private Button onCreateButton;
	private Button updateButton;
	private Button queryButton;
	private Button insertButton;
	private Button deleteButton;
	private TextView mTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		onCreateButton = (Button)findViewById(R.id.onCreate);
		updateButton = (Button)findViewById(R.id.update);
		insertButton = (Button)findViewById(R.id.insert);
		queryButton = (Button)findViewById(R.id.query);
		deleteButton = (Button)findViewById(R.id.delete);
		mTextView = (TextView)findViewById(R.id.text1);
		
		onCreateButton.setOnClickListener(new onCreateListener());
		updateButton.setOnClickListener(new updateListener());
		insertButton.setOnClickListener(new insertListener());
		queryButton.setOnClickListener(new queryListener());
		deleteButton.setOnClickListener(new deleteListener());
	}
	class onCreateListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			SQLite dbHelper = new SQLite(getBaseContext());
		}
		
	}
	class insertListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			SQLite dbHelper = new SQLite(getBaseContext());
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("admin_name", "admin");
			values.put("admin_passwd", "admin1");
			db.insert(SQLite.TABLE_NAME, null, values);
		}
		
	}
	class deleteListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			SQLite dbHelper = new SQLite(getBaseContext());
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			db.delete(SQLite.TABLE_NAME, "admin_id = ? ", new String[]{"4"});
		}
		
	}
	
	class updateListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			SQLite dbHelper = new SQLite(getBaseContext());
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("admin_passwd", "assd");
			db.update(SQLite.TABLE_NAME, values, "admin_id = ? ", new String[]{"11"});
		}
		
	}
	class queryListener implements OnClickListener{

		private final String abc = null;

		@SuppressLint("NewApi")
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			SQLite dbHelper = new SQLite(getBaseContext());
			SQLiteDatabase db = dbHelper.getReadableDatabase();
			Cursor cursor = db.query(true, SQLite.TABLE_NAME, null, " admin_id = ?", new String[]{"11"}, null, null, null, null, null);
			Log.i(abc, cursor + "");
			cursor.moveToFirst();
			String name = cursor.getString(cursor.getColumnIndex("admin_name")).toString();
			mTextView.setText(name);
		}
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
