package com.example.int20hsg2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DeviceDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "devices.db";
    private static final int DATABASE_VERSION = 5; // Змінено версію бази даних
    private static DeviceDatabaseHelper instance;
    private final Context mContext;

    // Оголошення SQL-запиту для створення таблиці
    private static final String CREATE_TABLE_DEVICES = "CREATE TABLE devices (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "device_type TEXT," +
            "device_brand TEXT," +
            "device_model TEXT," +
            "video INTEGER," +
            "wifi INTEGER," +
            "twoGHz INTEGER," + // Додано стовпець twoGHz
            "fiveGHz INTEGER," +
            "security_protocol TEXT," +
            "privacy_shutter INTEGER," +
            "encryption TEXT," +
            "device_is_secure INTEGER," +
            "device_info_link TEXT," +
            "comments TEXT)";



    private DeviceDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    public static synchronized DeviceDatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DeviceDatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    public static synchronized DeviceDatabaseHelper getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Context not provided. Call getInstance(Context) instead.");
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Виконання SQL-запиту для створення таблиці в базі даних
        db.execSQL(CREATE_TABLE_DEVICES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE devices ADD COLUMN Device_type TEXT");
        }
        if (oldVersion < 3) {
            db.execSQL("ALTER TABLE devices ADD COLUMN Device_brand TEXT");
        }
        if (oldVersion < 4) {
            db.execSQL("ALTER TABLE devices ADD COLUMN Device_model TEXT");
        }
        // Додайте інші необхідні оновлення для більш високих версій, якщо потрібно
    }
}
