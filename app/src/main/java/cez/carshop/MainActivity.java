package cez.carshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = (Button)findViewById(R.id.btnAddCar);
        Button btnView = (Button)findViewById(R.id.btnViewCarDetails);
        Button btnSell = (Button)findViewById(R.id.btnSellCar);
    }
}
