package com.example.int20hsg2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;

public class device_is_not_found2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_is_not_found2);

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
