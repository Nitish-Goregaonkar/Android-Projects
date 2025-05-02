package com.example.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Log.d("message", "onCreate is called");
            return insets;
        });
    }
    public void onStart()
    {
        super.onStart();
        Log.d("message", "onStart is called");
    }
    public void onResume()
    {
        super.onResume();
        Log.d("message", "onResume is called");
    }
    public void onPause()
    {
        super.onPause();
        Log.d("message", "onPause is called");
    }
    public void onStop()
    {
        super.onStop();
        Log.d("message", "onStop is called");
    }
    public void onRestart() {
        super.onRestart();
        Log.d("message", "onRestart is called");
    }
    public void onDestroy() {
        super.onDestroy();
        Log.d("message", "onDestroy is called");

    }
}