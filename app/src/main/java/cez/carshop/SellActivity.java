package cez.carshop;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    public void sell(final View view)
    {

        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.prompt, null);

        final EditText input = (EditText) promptsView
                .findViewById(R.id.txtEnterCarID);
        ((EditText) promptsView
                .findViewById(R.id.txtEnterCarID)).setHint("Please Enter new Owner name");
        ((EditText) promptsView.findViewById(R.id.txtEnterCarID)).setInputType(InputType.TYPE_CLASS_TEXT);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setCancelable(false)
                .setView(promptsView)
                .setTitle("Please Enter the Information")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(input.getText().toString().isEmpty())
                        {
                            AlertDialog confirm = new AlertDialog.Builder(SellActivity.this)
                                    .setCancelable(false)
                                    .setTitle("Please Enter the Information")
                                    .setMessage("New owner information is required!\n\nWould you like to enter it?")
                                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            sell(view);
                                        }
                                    })
                                    .setNegativeButton("NO",null).create();
                            confirm.show();
                        }
                        else
                        {
                            database.updateOwner(carid,input.getText().toString());
                            Toast.makeText(SellActivity.this, "Modified Owner", Toast.LENGTH_SHORT).show();
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

    public void goBack(View view)
    {
        startActivity(new Intent(SellActivity.this,MainActivity.class));
    }

}
