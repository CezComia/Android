package cez.carshop;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCar extends AppCompatActivity {

    private EditText editCarID;
    private EditText editCarName;
    private EditText editCarModel;
    private EditText editCarPrice;
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        Intent i = getIntent();
        editCarID = ((EditText)findViewById(R.id.editCarID));
        editCarName = ((EditText)findViewById(R.id.editCarName));
        editCarModel = ((EditText)findViewById(R.id.editCarModel));
        editCarPrice = ((EditText)findViewById(R.id.editCarPrice));
        database = new Database(AddCar.this,Database.TABLE_NAME);
        if(i.getStringExtra("CarId") != null)
        {
            editCarID.setText(i.getStringExtra("CarId"));
        }
    }

    public void addCar(View view) {

        if(editCarID.getText().toString().isEmpty() || editCarName.getText().toString().isEmpty() ||
                editCarModel.getText().toString().isEmpty() || editCarPrice.getText().toString().isEmpty())
        {
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setCancelable(false)
                    .setTitle("No empty fields allowed")
                    .setMessage("You have left a field empty! it is not allowed! Please enter all the fields and continue")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create();
            dialog.show();
        }
        else
        {
            String query = String.format("INSERT INTO %s ('%s','%s','%s','%s') VALUES ('%s','%s','%s','%s');", Database.TABLE_NAME,Database.CARID,Database.MODEL,Database.CURRENT_OWNER,Database.PRICE, editCarID.getText().toString(), editCarModel.getText().toString(),editCarName.getText().toString(),editCarPrice.getText().toString());
            database.execute(query);
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setCancelable(false)
                    .setTitle("Car Added")
                    .setMessage("Car ID: " + editCarID.getText().toString() + " has been added! Would you like to view car?")
                    .setPositiveButton("Yes, View Car", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(AddCar.this,ViewCar.class);
                            i.putExtra("CarId", editCarID.getText().toString());
                            startActivity(i);
                        }
                    })
                    .setNegativeButton("No, Take me Home", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(AddCar.this,MainActivity.class);
                            startActivity(i);
                        }
                    }).create();
            dialog.show();

            Toast.makeText(this,"Car successfully added!",Toast.LENGTH_LONG).show();
        }
    }

    public void cancel(View view)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Are you sure you want to cancel adding?");
        if(!editCarID.getText().toString().isEmpty() || !editCarName.getText().toString().isEmpty() ||
                !editCarModel.getText().toString().isEmpty() || !editCarPrice.getText().toString().isEmpty())
        {
            builder.append("All the progress you made will be cancelled and you will be taken back to home?");
        }
        else
        {
            builder.append(" You will be taken back if you accept!");
        }

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("Confirm")
                .setMessage(builder.toString())
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(AddCar.this,MainActivity.class));
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AddCar.this, "You can continue adding the car! You can press OK when finished.", Toast.LENGTH_SHORT).show();
                    }
                }).create();
        dialog.show();
    }


}
