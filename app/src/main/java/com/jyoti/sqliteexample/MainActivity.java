package com.jyoti.sqliteexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created By : Jyoti on 18 Dec 2018 (Thrusday)
 * Functionality : This class join the multiple tables with sqlite browser
 * Nevigation :
 */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity ";

    private RecyclerView recycler_view;
    private RecyclerView.Adapter adapter;

    private ArrayList<RecyclerViewDataProvider> arrayList = new ArrayList<RecyclerViewDataProvider>();

    private static final String TABLE_EMPLOYEE = "Employee";
    private static final String KEY_ID = "empid";
    private static final String KEY_DEPT_ID = "deptid";

    private static final String TABLE_DEPARTMENT = "department";
    private static final String KEY_DID = "deptid";
    private DatabaseHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler_view = findViewById(R.id.recycler_view);
        try {
            DatabaseHelper.getInstance(this).createDataBase();
            myDbHelper = DatabaseHelper.getInstance(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String join = "SELECT * FROM " + TABLE_EMPLOYEE + " e " + "  INNER JOIN " + TABLE_DEPARTMENT + " d "
                + " ON " + " e." + KEY_DEPT_ID + " = d." + KEY_DID;
        Log.d(TAG, "onCreate: query :: " + join);

        Cursor cursor = myDbHelper.getDataUsingCustomQuery(join, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                RecyclerViewDataProvider recyclerViewDataProvider = new RecyclerViewDataProvider();
                recyclerViewDataProvider.setDeptName(cursor.getString(cursor.getColumnIndex("deptname")));
                recyclerViewDataProvider.setDeptsal(cursor.getString(cursor.getColumnIndex("deptsal")));
                recyclerViewDataProvider.setEmpName(cursor.getString(cursor.getColumnIndex("empname")));
                recyclerViewDataProvider.setEmpsalary(cursor.getString(cursor.getColumnIndex("empsalary")));

                arrayList.add(recyclerViewDataProvider);

                Log.d(TAG, "onCreate: empid :: " + cursor.getString(cursor.getColumnIndex("empid")));
                Log.d(TAG, "onCreate: empName :: " + cursor.getString(cursor.getColumnIndex("empname")));
                Log.d(TAG, "onCreate: empsalary :: " + cursor.getString(cursor.getColumnIndex("empsalary")));
                Log.d(TAG, "onCreate: deptid :: " + cursor.getString(cursor.getColumnIndex("deptid")));
                Log.d(TAG, "onCreate: deptName :: " + cursor.getString(cursor.getColumnIndex("deptname")));
                Log.d(TAG, "onCreate: deptsal :: " + cursor.getString(cursor.getColumnIndex("deptsal")));

                cursor.moveToNext();
            }//for loop close
            cursor.close();
            recycler_view.setLayoutManager(new LinearLayoutManager(this));
            adapter = new RecyclerViewDataAdapter(this, arrayList);
            recycler_view.setAdapter(adapter);

        }//if statement close


    }//end of onCreate()

}//end of MianActivity
