package cez.carshop;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                                    .setMessage("I see that you did enter a car ID, It is required for you to view the car.\nWould you like to provide it now??")
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
