package com.example.int20hsg2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerDeviceType, spinnerManufacturer, spinnerModel;
    private Button btnNext, btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerDeviceType = findViewById(R.id.spinnerDeviceType);
        spinnerManufacturer = findViewById(R.id.spinnerManufacturer);
        spinnerModel = findViewById(R.id.spinnerModel);
        btnNext = findViewById(R.id.btnNext);
        btnSearch = findViewById(R.id.btnsearch);

        // Наповнюємо спіннери даними
        populateDeviceTypeSpinner();
        populateManufacturerSpinner();
        populateModelSpinner();

        // Обробка натискання на кнопку "Далі"
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Показати загрузочний екран
                showLoadingScreen();

                // Симулюємо завантаження даних з бази даних
                loadDataFromDatabase();
            }
        });

        // Обробка натискання на кнопку "Пошук"
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Перехід на екран DeviceIsNotFound2
                Intent intent = new Intent(MainActivity.this, device_is_not_found2.class);
                startActivity(intent);
            }
        });
    }

    private void populateDeviceTypeSpinner() {
        // Додаємо дані для спіннера типу пристрою
        List<String> deviceTypes = new ArrayList<>();
        deviceTypes.add("Смартфон");
        deviceTypes.add("Планшет");
        deviceTypes.add("Ноутбук");
        // Додаємо адаптер до спіннера
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, deviceTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDeviceType.setAdapter(adapter);
    }

    private void populateManufacturerSpinner() {
        // Додаємо дані для спіннера виробника
        List<String> manufacturers = new ArrayList<>();
        manufacturers.add("Samsung");
        manufacturers.add("Apple");
        manufacturers.add("HP");
        // Додаємо адаптер до спіннера
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, manufacturers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerManufacturer.setAdapter(adapter);
    }

    private void populateModelSpinner() {
        // Додаємо дані для спіннера моделі
        List<String> models = new ArrayList<>();
        models.add("Galaxy S20");
        models.add("iPhone 12");
        models.add("Pavilion x360");
        // Додаємо адаптер до спіннера
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, models);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerModel.setAdapter(adapter);
    }

    private void showLoadingScreen() {
        // Показати загрузочний екран
        setContentView(R.layout.loading_screen);
    }

    private void loadDataFromDatabase() {
        // Симулюємо завантаження даних з бази даних
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Здійснення звернення до бази даних
                // Після завершення завантаження даних, переходимо на наступний екран
                navigateToNextScreen();
            }
        }, 3000); // Затримка на 3 секунди для симуляції завантаження даних
    }

    private void navigateToNextScreen() {
        // Перехід на наступний екран після завантаження даних
        Intent intent = new Intent(MainActivity.this, NextActivity.class);
        startActivity(intent);
        finish(); // Закриваємо поточну активність, щоб користувач не міг повернутися назад
    }
}
