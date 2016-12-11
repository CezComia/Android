package cez.carshop;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = new Database(MainActivity.this,Database.TABLE_NAME);
    }

    public void addCar(View view)
    {
        startActivity(new Intent(this,AddCar.class));
    }

    public void director(final View view)
    {
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.prompt, null);

        final EditText input = (EditText) promptsView
                .findViewById(R.id.txtEnterCarID);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setCancelable(false)
                .setView(promptsView)
                .setTitle("Please Enter the Information")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(input.getText().toString().isEmpty())
                        {
                            AlertDialog confirm = new AlertDialog.Builder(MainActivity.this)
                                    .setCancelable(false)
                                    .setTitle("Empty Car ID Provided!")
                                    .setMessage("I see that you did enter a car ID, It is required for you to view the car.\n\nWould you like to provide it now??")
                                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            director(view);
                                        }
                                    })
                                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    })
                                    .create();
                            confirm.show();
                        }
                        else
                        {

                            // check if the car even exists

                            Cursor cursor = database.getResult(String.format("SELECT * FROM %s where %s='%s'",Database.TABLE_NAME,Database.CARID,input.getText().toString()));
                            if(cursor.getCount() == 1)
                            {
                                // found a car id
                                Intent i;
                                switch (view.getId())
                                {
                                    case R.id.btnSellCar:
                                        i = new Intent(MainActivity.this,SellActivity.class);
                                        break;
                                    case R.id.btnViewCarDetails:
                                        i = new Intent(MainActivity.this,ViewCar.class);
                                        break;
                                    default:
                                        i = new Intent(MainActivity.this,AddCar.class);
                                        break;
                                }
                                i.putExtra("CarId", input.getText().toString());
                                startActivity(i);
                            }
                            else
                            {
                                AlertDialog confirm = new AlertDialog.Builder(MainActivity.this)
                                        .setCancelable(false)
                                        .setTitle("Car not found")
                                        .setMessage("Car not found with that ID.\n\nWould you like to add it first??")
                                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent i = new Intent(MainActivity.this,AddCar.class);
                                                i.putExtra("CarId", input.getText().toString());
                                                startActivity(i);
                                            }
                                        })
                                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                            }
                                        })
                                        .create();
                                confirm.show();
                            }

                        }
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create();
        dialog.show();
    }


}
