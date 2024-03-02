package com.example.int20hsg2;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.int20hsg2.R;
//asd
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Знаходимо кнопку searchButton за її ідентифікатором
        ImageButton searchButton = findViewById(R.id.searchButton);

        // Додаємо обробник натискання для кнопки searchButton
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Відкриваємо нову активність DeviceNotFoundActivity
                Intent intent = new Intent(MainActivity.this, DeviceIsNotFound.class);
                startActivity(intent);
            }
        });
    }
}
