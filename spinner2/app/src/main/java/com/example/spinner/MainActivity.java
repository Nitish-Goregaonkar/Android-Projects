package com.example.spinner;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerSemester;
    TextView textViewSubjects;

    String[] semesters = {"Select Semester", "5th Sem", "6th Sem"};

    String[] sem5Subjects = {
            "JavaScript",
            "Advanced Java",
            "Operating System",
            "Computer Networks and Security",
            "Engineering Drawing (ED)"
    };

    String[] sem6Subjects = {
            "Python",
            "Mobile Application Development",
            "Human-Computer Interaction (HCI)",
            "Cloud Computing",
            "Project"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerSemester = findViewById(R.id.spinnerSemester);
        textViewSubjects = findViewById(R.id.textViewSubjects);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, semesters);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSemester.setAdapter(adapter);

        spinnerSemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    showSubjects(sem5Subjects);
                } else if (position == 2) {
                    showSubjects(sem6Subjects);
                } else {
                    textViewSubjects.setText(""); // Clear text if "Select Semester"
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textViewSubjects.setText("");
            }
        });
    }

    private void showSubjects(String[] subjects) {
        StringBuilder sb = new StringBuilder();
        for (String subject : subjects) {
            sb.append("• ").append(subject).append("\n");
        }
        textViewSubjects.setText(sb.toString());
    }
}
