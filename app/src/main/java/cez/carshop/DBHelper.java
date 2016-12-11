package cez.carshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private final String TABLE_NAME = "carshop";
    private final String CAR_ID = "car_id";
    private final String CAR_MAKE = "car_make";
    private final String CAR_MODEL = "car_model";
    private final String CAR_YEAR = "car_year";
    private final String CAR_OWNER = "car_owner";
    private final String CAR_PRICE = "car_price";
    private Context context;
    public DBHelper(Context context, String DATABASE_NAME) {
        super(context, DATABASE_NAME, null,1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME + " (" +
                CAR_ID + " TEXT PRIMARY KEY, " +
                CAR_MAKE + " TEXT NOT NULL, " +
                CAR_MODEL + " TEXT NOT NULL, " +
                CAR_YEAR + " TEXT NOT NULL, " +
                CAR_OWNER + " TEXT NOT NULL, " +
                CAR_PRICE + " TEXT NOT NULL);" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long createInsert(String carID, String make, String model, String year, String owner, String price)
    {
        ContentValues cv = new ContentValues();
        cv.put(CAR_ID, carID);
        cv.put(CAR_MAKE, make);
        cv.put(CAR_MODEL, model);
        cv.put(CAR_YEAR, year);
        cv.put(CAR_OWNER, owner);
        cv.put(CAR_PRICE, price);
        return 1L;
    }
}
