package com.thanglastudio.doggydeals;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register extends Fragment {
    EditText et_name, et_breed, et_height, et_weight, et_age;
    Button register;
    ImageView profile;
    View v;
    private static final int SELECT_PICTURE = 1;
    PetDBHelper helper;
    String selectedImagePath;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tab_register, container, false);

        ButterKnife.bind(getActivity());

        profile = (ImageView) v.findViewById(R.id.picture);
        register = (Button) v.findViewById(R.id.button_register);
        et_name = (EditText) v.findViewById(R.id.et_name);
        et_breed = (EditText) v.findViewById(R.id.et_breed);
        et_height = (EditText) v.findViewById(R.id.et_height);
        et_weight = (EditText) v.findViewById(R.id.et_weight);
        et_age = (EditText) v.findViewById(R.id.et_age);

        profile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method
                openPhotoChooser();

            }
        });
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


                String TabOfFragmentB = ((DashBoard) getActivity()).getTabFragmentNext();

            /*    MyGallery fragmentGallery = (MyGallery) getActivity()
                        .getSupportFragmentManager()
                        .findFragmentByTag(TabOfFragmentB);

                fragmentGallery.updateText("hello");*/

            }

        });


        return v;


    }

    private void register() {



       /* helper = new PetDBHelper(getActivity());
        long res = helper.insertData(et_name.getText().toString(),
                et_breed.getText().toString(), et_height.getText()
                        .toString(), et_weight.getText().toString(),
                et_age.getText().toString(), selectedImagePath);

       // sendData(et_name.getText() + "");

        if (res != -1) {

            Toast.makeText(getActivity(), "Data Inserted",
                    Toast.LENGTH_LONG).show();


            clearText();

        } else
            Toast.makeText(getActivity(), "Data Not Inserted",
                    Toast.LENGTH_LONG).show();
        clearText();*/


    }


    public void openPhotoChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(intent, "Select Picture"),
                SELECT_PICTURE);


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




}