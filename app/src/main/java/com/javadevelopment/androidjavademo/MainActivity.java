package com.javadevelopment.androidjavademo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int counter = 0;
    private int step = 1;

    private TextView counterTextView;
    private Button increaseCounterBtn;
    private Button resetCounterBtn;
    private EditText counterStepEditText;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        counterTextView = findViewById(R.id.counter_text_view);
        increaseCounterBtn = findViewById(R.id.increase_counter_btn);
        resetCounterBtn = findViewById(R.id.reset_counter_btn);
        counterStepEditText = findViewById(R.id.counter_step_edit_text);
        submitBtn = findViewById(R.id.submit_btn);

        increaseCounterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter += step;

                counterTextView.setText("" + counter);
            }
        });

        resetCounterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                step = 1;

                counterTextView.setText("" + counter);
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String newStep = counterStepEditText.getText().toString();
                    step = Integer.parseInt(newStep);

                    counterStepEditText.setText("");

                    Toast.makeText(
                            MainActivity.this,
                            "Change step successfully.",
                            Toast.LENGTH_SHORT
                    ).show();
                } catch (NumberFormatException e) {
                    counterStepEditText.setText("");

                    Toast.makeText(
                            MainActivity.this,
                            "You must enter a valid step.",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }
}
