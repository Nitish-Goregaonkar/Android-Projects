package com.example.database_exp_10;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3;
    Button bt1, bt2, bt3;
    String uid, uname, upass;
    SQLiteDatabase db;
    SQLiteOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        helper = new DataBase(this);
    }

    public void InsertData(View view) {
        uid = et1.getText().toString();
        uname = et2.getText().toString();
        upass = et3.getText().toString();

        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataBase.COL_1, uid);
        values.put(DataBase.COL_2, uname);
        values.put(DataBase.COL_3, upass);

        // Change to 'long' because insert returns a long
        long res = db.insert(DataBase.TABLE_NAME, null, values);

        if (res == -1) {
            Toast.makeText(this, "Insertion failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Insertion successful", Toast.LENGTH_SHORT).show();
        }
    }

    public void DeleteData(View view) {
        uid = et1.getText().toString();

        db = helper.getWritableDatabase();
        // Change to 'int' because delete returns an int
        int res = db.delete(DataBase.TABLE_NAME, DataBase.COL_1 + "=?", new String[]{uid});

        if (res == 0) {  // Check for 0 rows deleted
            Toast.makeText(this, "Deletion failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Deletion successful", Toast.LENGTH_SHORT).show();
        }
    }

    public void UpdateData(View view) {
        uid = et1.getText().toString();
        uname = et2.getText().toString();
        upass = et3.getText().toString();

        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataBase.COL_1, uid);
        values.put(DataBase.COL_2, uname);
        values.put(DataBase.COL_3, upass);

        // Change to 'int' because update returns an int
        int res = db.update(DataBase.TABLE_NAME, values, DataBase.COL_1 + "=?", new String[]{uid});

        if (res == 0) {  // Check for 0 rows updated
            Toast.makeText(this, "Updation failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Updation successful", Toast.LENGTH_SHORT).show();
        }
    }
}
