package com.issamelasri.moneymanager.ui;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.issamelasri.moneymanager.ui.pojo.PostModel;

public class MyDataBase extends SQLiteOpenHelper {
    public static final String DB_NAME = "inputs";
    public static final int DB_VERSION = 1;
    public static final String TB_DB_NAME = "inputsUsers";
    public static final String TB_DB_ID = "id";
    public static final String TB_DB_DATE = "date";
    public static final String TB_DB_AMOUNT = "amount";
    public static final String TB_DB_TYPE = "type";


    public MyDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TB_DB_NAME + " (" + TB_DB_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TB_DB_DATE + " TEXT, " + TB_DB_AMOUNT + " REAL, " + TB_DB_TYPE + " TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_DB_NAME);

    }

    public boolean insertInputs(PostModel postModel) {
        SQLiteDatabase dp = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TB_DB_DATE, postModel.getDate());
        values.put(TB_DB_AMOUNT, postModel.getAmount());
        values.put(TB_DB_TYPE, postModel.getType());
        long result = dp.insert(TB_DB_NAME, null, values);
        return result != -1;
    }
    /*<editor-fold desc="Description">
    public boolean updateInputs(PostModel postModel){
        SQLiteDatabase dp = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TB_DB_DATE, postModel.getDate());
        values.put(TB_DB_AMOUNT,postModel.getAmount());
        values.put(TB_DB_TYPE,postModel.getType());
    //    String [] =
      //  long result = dp.update(TB_DB_NAME,values,"type=?",);
    //    if (result==-1)
            return false;
        else return true;
    }
    </editor-fold> */
}
