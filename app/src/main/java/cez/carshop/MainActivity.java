package cez.carshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    public void addCar(View view)
    {
        startActivity(new Intent(this,AddCar.class));
    }

}
