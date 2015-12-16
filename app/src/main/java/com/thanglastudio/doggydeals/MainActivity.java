package com.thanglastudio.doggydeals;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.MediaColumns;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    EditText et_name, et_breed, et_height, et_weight, et_age;
    TextView path;
    Button register, show,menu;
    ImageView profile;
    SQLiteDatabase db;
    private static final int SELECT_PICTURE = 1;

    String selectedImagePath;
    // ADDED
    String filemanagerstring;

    int column_index;

    String imagePath;

    PetDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profile = (ImageView) findViewById(R.id.picture);
        register = (Button) findViewById(R.id.button_register);
        show = (Button) findViewById(R.id.button_view);
        menu = (Button) findViewById(R.id.button_dashboard);
        et_name = (EditText) findViewById(R.id.et_name);
        et_breed = (EditText) findViewById(R.id.et_breed);
        et_height = (EditText) findViewById(R.id.et_height);
        et_weight = (EditText) findViewById(R.id.et_weight);
        et_age = (EditText) findViewById(R.id.et_age);
        path = (TextView) findViewById(R.id.path);

        profile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(
                        Intent.createChooser(intent, "Select Picture"),
                        SELECT_PICTURE);

            }
        });

        menu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent i= new Intent(MainActivity.this,DashBoard.class);
                startActivity(i);

            }
        });

        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                helper = new PetDBHelper(MainActivity.this);
                long res = helper.insertData(et_name.getText().toString(),
                        et_breed.getText().toString(), et_height.getText()
                                .toString(), et_weight.getText().toString(),
                        et_age.getText().toString(), selectedImagePath);

                if (res != -1) {

                    Toast.makeText(MainActivity.this, "Data Inserted",
                            Toast.LENGTH_LONG).show();
                    clearText();

                } else
                    Toast.makeText(MainActivity.this, "Data Not Inserted",
                            Toast.LENGTH_LONG).show();
                clearText();

            }

        });

        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Cursor res = helper.showData();

                if (res.getCount() == 0) {
                    showMessage("Error", "No data found");
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {

                    buffer.append("Id:" + res.getString(0) + "\n" + "Name:"
                            + res.getString(1) + "\n" + "Breed:"
                            + res.getString(2) + "\n"+"Height:"
                            + res.getString(3) + "\n"+"Weight:"
                            + res.getString(4) + "\n"+"Age:"
                            + res.getString(5) + "\n\n");

                    showMessage("data", buffer.toString());

                }

            }
        });

    }

    protected void clearText() {
        // TODO Auto-generated method stub
        et_age.setText("");
        et_breed.setText("");
        et_height.setText("");
        et_weight.setText("");
        et_name.setText("");
        profile.setImageResource(R.drawable.photo);

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();

                // OI FILE Manager
                filemanagerstring = selectedImageUri.getPath();

                // MEDIA GALLERY
                selectedImagePath = getPath(selectedImageUri);

                path.setText(selectedImagePath);

                profile.setImageURI(selectedImageUri);

                // img1.setImageBitmap(bm);

            }

        }

    }

    // UPDATED!
    public String getPath(Uri uri) {
        String[] projection = { MediaColumns.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        column_index = cursor.getColumnIndexOrThrow(MediaColumns.DATA);
        cursor.moveToFirst();
        imagePath = cursor.getString(column_index);

        return cursor.getString(column_index);
    }

    public void showMessage(String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

}
