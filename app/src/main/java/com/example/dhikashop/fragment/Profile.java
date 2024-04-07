package com.example.dhikashop.fragment;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dhikashop.EditProfile;
import com.example.dhikashop.R;


public class Profile extends Fragment {
    Button buttonEdit;
    TextView tvNama;
    static final int EDIT_NAME_REQUEST = 1;

    public Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        buttonEdit = view.findViewById(R.id.btnEdit);
        tvNama = view.findViewById(R.id.tvNama);

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditProfile.class);
                startActivityForResult(intent, EDIT_NAME_REQUEST);
            }
        });




        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDIT_NAME_REQUEST) {
            if (resultCode == RESULT_OK) {
                String newName = data.getStringExtra("newName");
                tvNama.setText(newName);
            }
        }
    }
}