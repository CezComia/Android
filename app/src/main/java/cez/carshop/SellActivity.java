package cez.carshop;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SellActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        int carID = Integer.parseInt(getIntent().getStringExtra("CarId"));
        SQLiteDatabase database = openOrCreateDatabase("cars", MODE_PRIVATE, null);
    }

}
