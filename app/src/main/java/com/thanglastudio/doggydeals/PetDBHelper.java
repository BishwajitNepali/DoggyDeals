package com.thanglastudio.doggydeals;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class PetDBHelper extends SQLiteOpenHelper{
	
	
	private static final String DB_NAME="DOGDEALS";
	private static final String DB_TABLE_NAME="Register";
	private static final String FIELD_PATH="path";
	private static final String FIELD_NAME="name";
	private static final String FIELD_BREED="breed";
	private static final String FIELD_HEIGHT="height";
	private static final String FIELD_WEIGHT="weight";
	private static final String FIELD_AGE="age";
	SQLiteDatabase db;
	
	private static final String CREATE_DATABASE_TABLE="create table "+DB_TABLE_NAME+"( id integer primary key autoincrement,name text not null,breed text,height float,weight float,age float,path text)";
	
	

	public PetDBHelper(Context context ) {
		super(context, DB_NAME, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		db.execSQL(CREATE_DATABASE_TABLE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE_NAME);
		onCreate(db);
		
	}

	public long insertData(String name, String breed, String height,
			String weight, String age,String path) {
		// TODO Auto-generated method stub
		db=this.getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put(FIELD_NAME, name);
		values.put(FIELD_BREED, breed);
		values.put(FIELD_HEIGHT, height);
		values.put(FIELD_WEIGHT, weight);
		values.put(FIELD_AGE, age);
		long res= db.insert(DB_TABLE_NAME, null, values);
		
		
		return res;
		
		
		
	}
	
	public Cursor showData(){
		
		db=this.getWritableDatabase();
		Cursor res=db.rawQuery("select *from "+DB_TABLE_NAME, null);
		return res;
		
	}

}
