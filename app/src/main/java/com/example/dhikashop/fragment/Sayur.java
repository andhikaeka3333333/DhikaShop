package com.example.dhikashop.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dhikashop.GroceryModel;
import com.example.dhikashop.PreviewProduct;
import com.example.dhikashop.R;
import com.example.dhikashop.adapter.DagingAdapter;
import com.example.dhikashop.adapter.SayurAdapter;

import java.util.ArrayList;
import java.util.List;

public class Sayur extends Fragment implements SayurAdapter.ItemClickListener{

    List<GroceryModel> items;
    RecyclerView recyclerView;
    SayurAdapter adapter;

    public Sayur() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daging, container, false);

        items = new ArrayList<GroceryModel>();

        // Add items to the list

        items.add(new GroceryModel(R.drawable.bayam,"Bayam", "Rp 3.000"));
        items.add(new GroceryModel(R.drawable.kol,"Kol", "Rp 6.000"));
        items.add(new GroceryModel(R.drawable.selada,"Selada", "Rp 5.000"));
        items.add(new GroceryModel(R.drawable.sawi,"Sawi", "Rp 3.000"));
        items.add(new GroceryModel(R.drawable.wortel,"Wortel", "Rp 8.000"));

        // Find the RecyclerView in the fragment's layout
        recyclerView = view.findViewById(R.id.rvDaging);

        // Set up the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new SayurAdapter(items, requireContext());
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), PreviewProduct.class);
        intent.putExtra("nama", adapter.getItem(position).getName());
        startActivity(intent);
        Toast.makeText(getActivity(), "You clicked " + adapter.getItem(position).getName() + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}