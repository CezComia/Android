package cez.carshop;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SellActivity extends AppCompatActivity {

    private Database database;
    private String carid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        Intent i = getIntent();
        carid = i.getStringExtra("CarId");
        database = new Database(SellActivity.this,Database.TABLE_NAME);
        Cursor cursor = database.getResult(String.format("SELECT * FROM %s where %s='%s'",Database.TABLE_NAME,Database.CARID,i.getStringExtra("CarId")));
        cursor.moveToFirst();
        ((TextView)findViewById(R.id.valCarID)).setText("       " + cursor.getString(0));
        ((TextView)findViewById(R.id.valCarModel)).setText("       " + cursor.getString(1));
        ((TextView)findViewById(R.id.valCarOwner)).setText("       " + cursor.getString(2));
        ((TextView)findViewById(R.id.valCarPrice)).setText("       " + cursor.getString(3));
    }

    public void sell(View view)
    {
        String query = String.format("UPDATE TABLE %s SET %s='%s' WHERE %s='%s'", Database.TABLE_NAME,Database.CURRENT_OWNER, "NEW USER" , Database.CARID, carid );
        database.execute(query);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("Ownership changed!")
                .setMessage("The car's new owner is " + "NEW USER")
                .setPositiveButton("OK", null).create();
        dialog.show();
    }

    public void goBack(View view)
    {
        startActivity(new Intent(SellActivity.this,MainActivity.class));
    }

}
