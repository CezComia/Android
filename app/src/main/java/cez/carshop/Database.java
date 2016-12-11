package cez.carshop;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

/**
 * Created by anirudh on 10/12/16.
 */

public class Database {

    private SQLiteDatabase database;
    public static final String TABLE_NAME  = "cars";
    public static final String CARID = "carid";
    public static final String MODEL = "model";
    public static final String CURRENT_OWNER = "owner";
    public static final String PRICE = "price";
    private static final String NEW_TABLE = "CREATE TABLE IF NOT EXISTS %s (%s VARCHAR, %s VARCHAR, %s VARCHAR, %s VARCHAR);";

    public Database(Context context, String database_name)
    {
        database = context.openOrCreateDatabase(database_name,Context.MODE_PRIVATE,null);
        database.execSQL(String.format(NEW_TABLE,TABLE_NAME,CARID,MODEL,CURRENT_OWNER,PRICE));
    }

    public Cursor getResult(String query)
    {
        return database.rawQuery(query,null);
    }

    public void execute(String query)
    {
        database.execSQL(query);
    }


}
