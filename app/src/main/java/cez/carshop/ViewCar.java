package cez.carshop;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ViewCar extends AppCompatActivity {

    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_car);
        Intent i = getIntent();
        database = new Database(ViewCar.this,Database.TABLE_NAME);
        Cursor cursor = database.getResult(String.format("SELECT * FROM %s where %s='%s'",Database.TABLE_NAME,Database.CARID,i.getStringExtra("CarId")));
        cursor.moveToFirst();
        ((TextView)findViewById(R.id.valCarID)).setText("       " + cursor.getString(0));
        ((TextView)findViewById(R.id.valCarModel)).setText("       " + cursor.getString(1));
        ((TextView)findViewById(R.id.valCarOwner)).setText("       " + cursor.getString(2));
        ((TextView)findViewById(R.id.valCarPrice)).setText("       " + cursor.getString(3));
    }


}
