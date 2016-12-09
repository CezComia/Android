package cez.carshop;

import android.database.sqlite.SQLiteDatabase;

public class Shop {
    // class where database magic happens. get database from activity
    private SQLiteDatabase database;

    public Shop(SQLiteDatabase database)
    {
        this.database = database;
    }


}
