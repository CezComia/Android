package cez.carshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddCar extends AppCompatActivity {
    private static int carID;
    private String carName;
    private String carModel;
    private float carPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
    }

}
