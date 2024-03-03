package com.example.int20hsg2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class Main {
    @RequiresApi(api = Build.VERSION_CODES.P)
    public static void main(String[] args) {
        // Отримання пристроїв з бази даних
        List<DeviceData> devices = retrieveDevicesFromDatabase();

        // Виведення інформації про пристрої
        for (DeviceData device : devices) {
            System.out.println(device);
        }
    }

    // Статичний метод для отримання пристроїв з бази даних
    @RequiresApi(api = Build.VERSION_CODES.P)
    public static List<DeviceData> retrieveDevicesFromDatabase() {
        List<DeviceData> devices = new ArrayList<>();

        // Отримання посилання на базу даних
        SQLiteDatabase db = DeviceDatabaseHelper.getInstance().getReadableDatabase();

        // Запит до бази даних для отримання пристроїв
        Cursor cursor = db.query("devices", null, null, null, null, null, null);

        // Отримання індексів стовпців
        int idIndex = cursor.getColumnIndex("id");
        int typeIndex = cursor.getColumnIndex("type");
        int brandIndex = cursor.getColumnIndex("brand");
        int modelIndex = cursor.getColumnIndex("model");
        int videoIndex = cursor.getColumnIndex("video");
        int wifiIndex = cursor.getColumnIndex("wifi");
        int twoGHzIndex = cursor.getColumnIndex("twoGHz");
        int fiveGHzIndex = cursor.getColumnIndex("fiveGHz");
        int securityProtocolIndex = cursor.getColumnIndex("security_protocol");
        int privacyShutterIndex = cursor.getColumnIndex("privacy_shutter");
        int encryptionIndex = cursor.getColumnIndex("encryption");
        int secureIndex = cursor.getColumnIndex("secure");
        int infoLinkIndex = cursor.getColumnIndex("info_link");
        int commentsIndex = cursor.getColumnIndex("comments");

        // Перевірка, чи є дані в результатах запиту
        if (cursor.moveToFirst()) {
            do {
                // Отримання даних про пристрій з результата запиту
                int id = cursor.getInt(idIndex);
                String type = cursor.getString(typeIndex);
                String brand = cursor.getString(brandIndex);
                String model = cursor.getString(modelIndex);
                boolean video = cursor.getInt(videoIndex) == 1;
                boolean wifi = cursor.getInt(wifiIndex) == 1;
                boolean twoGHz = cursor.getInt(twoGHzIndex) == 1;
                boolean fiveGHz = cursor.getInt(fiveGHzIndex) == 1;
                String securityProtocol = cursor.getString(securityProtocolIndex);
                boolean privacyShutter = cursor.getInt(privacyShutterIndex) == 1;
                String encryption = cursor.getString(encryptionIndex);
                boolean secure = cursor.getInt(secureIndex) == 1;
                String infoLink = cursor.getString(infoLinkIndex);
                String comments = cursor.getString(commentsIndex);

                // Створення об'єкта пристрою і додавання його до списку
                devices.add(new DeviceData(id, type, brand, model, video, wifi, twoGHz, fiveGHz, securityProtocol, privacyShutter, encryption, secure, infoLink, comments));
            } while (cursor.moveToNext());
        }

        // Закриття курсора і бази даних
        cursor.close();
        db.close();

        return devices;
    }
}
