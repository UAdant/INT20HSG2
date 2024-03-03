package com.example.int20hsg2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner typeSpinner, brandSpinner, modelSpinner;
    private List<String> deviceTypes, deviceBrands, deviceModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        typeSpinner = findViewById(R.id.type_spinner);
        brandSpinner = findViewById(R.id.brand_spinner);
        modelSpinner = findViewById(R.id.model_spinner);

        deviceTypes = new ArrayList<>();
        deviceBrands = new ArrayList<>();
         deviceModels = new ArrayList<>();

        // Додавання даних до бази даних
        addDataToDatabase();

        // Отримання даних з бази даних
        retrieveDeviceDataFromDatabase();

        // Створення адаптерів для випадаючих списків
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, deviceTypes);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

        ArrayAdapter<String> brandAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, deviceBrands);
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brandSpinner.setAdapter(brandAdapter);

        ArrayAdapter<String> modelAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, deviceModels);
        modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modelSpinner.setAdapter(modelAdapter);
    }

    private void addDataToDatabase() {
        SQLiteDatabase db = DeviceDatabaseHelper.getInstance(this).getWritableDatabase();

        // Дані для вставки
        String[][] data = {
                {"1", "babymonitor", "BOTSLAB", "Camc221", "TRUE", "TRUE", "TRUE", "TRUE", "WEP", "TRUE", "N/A", "YES", "https://global.botslab.com/products/botslab-indoor-cam-2-pro", "No reported issues"},
                {"2", "babymonitor", "‎Owlet", "Cam 1", "TRUE", "TRUE", "TRUE", "FALSE", "TLS", "FALSE", "AES_128bit", "NO", "https://owletcare.com/products/cam", "Lots of articles about camera being hacked e.g. https://www.reddit.com/r/beyondthebump/comments/13ln4n6/mans_voice_over_owlet_camera/"},
                {"3", "babymonitor", "VTech", "DM111", "FALSE", "FALSE", "FALSE", "FALSE", "N/A", "N/A", "N/A", "N/A", "https://www.amazon.com/VTech-Rechargeable-Guaranteed-Transmissions-Cystal-Clear/dp/B00JEV5UI8?th=1", "Not enough information"}
        };

        // SQL-запит для вставки даних
        String insertQuery = "INSERT INTO devices (ID, Device_type, Device_brand, Device_model, Video, WiFi, twoGHz, fiveGHz, Security_Protocol, Privacy_Shutter, Encryption, Device_is_secure, Device_info_link, Comments) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        // Виконати запит для кожного рядка даних
        for (String[] row : data) {
            db.execSQL(insertQuery, row);
        }
        //gh
        db.close();
    }

    private void retrieveDeviceDataFromDatabase() {
        // Отримання посилання на базу даних
        SQLiteDatabase db = DeviceDatabaseHelper.getInstance(this).getReadableDatabase();

        // Виконання запиту для отримання всіх рядків з таблиці devices
        Cursor cursor = db.query("devices", null, null, null, null, null, null);

        // Індекси стовпців
        int typeIndex = cursor.getColumnIndex("Device_type");
        int brandIndex = cursor.getColumnIndex("Device_brand");
        int modelIndex = cursor.getColumnIndex("Device_model");

        // Додавання унікальних значень до списків
        if (cursor.moveToFirst()) {
            do {
                String type = cursor.getString(typeIndex);
                String brand = cursor.getString(brandIndex);
                String model = cursor.getString(modelIndex);

                if (!deviceTypes.contains(type)) {
                    deviceTypes.add(type);
                }
                if (!deviceBrands.contains(brand)) {
                    deviceBrands.add(brand);
                }
                if (!deviceModels.contains(model)) {
                    deviceModels.add(model);
                }
            } while (cursor.moveToNext());
        }

        // Закриття курсора і бази даних
        cursor.close();
        db.close();
    }
}
