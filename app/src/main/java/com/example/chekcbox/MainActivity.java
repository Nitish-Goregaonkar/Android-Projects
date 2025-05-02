package com.example.chekcbox;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1, cb2, cb3;
    Button btn;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure your XML file is named activity_main.xml

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        btn = findViewById(R.id.btn);
        tv1 = findViewById(R.id.tv1);
    }

    public void click(View view) {
        StringBuilder result = new StringBuilder("Selected Fruits:\n");

        if (cb1.isChecked()) result.append("Apple\n");
        if (cb2.isChecked()) result.append("Mango\n");
        if (cb3.isChecked()) result.append("Banana\n");

        // You can show it using TextView or Toast
        // Option 1: Show in TextView
        tv1.setText(result.toString());

        // Option 2: Show as Toast
        // Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show();
    }
}
