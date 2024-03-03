package com.example.int20hsg2;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class device_is_not_found2 extends AppCompatActivity {
    private Button btnBack1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_is_not_found2);
        btnBack1=findViewById(R.id.btnBack1);

        btnBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View animation) {
                // Перехід на екран MainActivity
                Intent intent1 = new Intent(device_is_not_found2.this, MainActivity.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        Button sendRequestButton = findViewById(R.id.sendRequestButton);
        sendRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Відкриття вспливаючого вікна
                openPopupWindow();
            }
        });
    }

    private void openPopupWindow() {
        // Створюємо LayoutInflater для вспливаючого вікна
        LayoutInflater inflater = getLayoutInflater();
        View popupView = inflater.inflate(R.layout.popup_window, null);

        // Створюємо інстанцію PopupWindow
        final PopupWindow popupWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        // Оголошуємо кнопку "Повернутися на головну"
        Button backToMainButton = popupView.findViewById(R.id.backToMainButton);
        backToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Закриваємо вспливаюче вікно
                popupWindow.dismiss();
                // Відкриваємо головну активність
                openMainActivity();
            }
        });

        // Відображаємо вспливаюче вікно
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
    }

    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Закриваємо поточну активність
    }
}
