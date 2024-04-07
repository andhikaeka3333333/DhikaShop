package com.example.dhikashop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PreviewProduct extends AppCompatActivity {

    ImageView ivGambarProduk, ivArrowBack;
    TextView tvNamaProduk, tvHarga;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_product);

        ivGambarProduk = findViewById(R.id.ivGambarProduk);
        ivArrowBack = findViewById(R.id.ivArrowBack);
        tvNamaProduk = findViewById(R.id.tvNamaProduk);
        tvHarga = findViewById(R.id.tvHarga);

        ivArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");


        switch (nama) {
            case "Dada Ayam":
                tvNamaProduk.setText("Dada Ayam");
                tvHarga.setText("Rp 36.000");
                ivGambarProduk.setImageResource(R.drawable.dadaayam);
                break;
            case "Wagyu A5":
                tvNamaProduk.setText("Wagyu A5");
                tvHarga.setText("Rp 3.000.000");
                ivGambarProduk.setImageResource(R.drawable.wagyua5);
                break;
            case "Slice Beef":
                tvNamaProduk.setText("Slice Beef");
                tvHarga.setText("Rp 120.000");
                ivGambarProduk.setImageResource(R.drawable.slicebeef);
                break;
            case "Daging Tuna":
                tvNamaProduk.setText("Daging Tuna");
                tvHarga.setText("Rp 70.000");
                ivGambarProduk.setImageResource(R.drawable.tuna);
                break;
            case "Daging Salmon":
                tvNamaProduk.setText("Daging Salmon");
                tvHarga.setText("Rp 90.000");
                ivGambarProduk.setImageResource(R.drawable.salmon);
                break;

                //sayur

            case "Bayam":
                tvNamaProduk.setText("Bayam");
                tvHarga.setText("Rp 3.000");
                ivGambarProduk.setImageResource(R.drawable.bayam);
                break;
            case "Kol":
                tvNamaProduk.setText("Kol");
                tvHarga.setText("Rp 6.000");
                ivGambarProduk.setImageResource(R.drawable.kol);
                break;
            case "Selada":
                tvNamaProduk.setText("Selada");
                tvHarga.setText("Rp 5.000");
                ivGambarProduk.setImageResource(R.drawable.selada);
                break;
            case "Sawi":
                tvNamaProduk.setText("Sawi");
                tvHarga.setText("Rp 3.000");
                ivGambarProduk.setImageResource(R.drawable.sawi);
                break;
            case "Wortel":
                tvNamaProduk.setText("Wortel");
                tvHarga.setText("Rp 8.000");
                ivGambarProduk.setImageResource(R.drawable.wortel);
                break;


        }
    }
}