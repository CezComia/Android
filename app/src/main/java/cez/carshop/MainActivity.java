package cez.carshop;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    public void viewCarDetails(View view) {
        Button btnView = (Button)findViewById(R.id.btnViewCarDetails);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                enter car ID then show car details
                 */
            }
        });
    }

    public void sellCar(View view) {
        Button btnSell = (Button)findViewById(R.id.btnSellCar);
        btnSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                enter car ID then show dialog box
                ("Are you sure you want to sell this car?")
                 */
            }
        });

    }



}
