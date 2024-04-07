package com.example.dhikashop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dhikashop.GroceryModel;
import com.example.dhikashop.R;

import java.util.List;

public class DagingAdapter extends RecyclerView.Adapter<DagingAdapter.ViewHolder> {

    private Context context;
    private List<GroceryModel> listData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public DagingAdapter(List<GroceryModel> listData, Context context) {
        this.listData = listData;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DagingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_view_daging,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DagingAdapter.ViewHolder holder, int position) {
        GroceryModel items = this.listData.get(position);
        holder.tvNamaMakanan.setText(items.getName());
        holder.tvHarga.setText(items.getPrice());
        holder.ivGambarMakanan.setImageResource(items.getImage());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvNamaMakanan, tvHarga;
        ImageView ivGambarMakanan;
        Button btnBeli;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaMakanan = itemView.findViewById(R.id.tvNamaMakanan);
            tvHarga = itemView.findViewById(R.id.tvHarga);
            ivGambarMakanan = itemView.findViewById(R.id.ivImageMakanan);
            btnBeli = itemView.findViewById(R.id.btnBeli);

            btnBeli.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) {
                if (view.getId() == R.id.btnBeli) {
                    mClickListener.onItemClick(view, getAdapterPosition());
                }
            }
        }
    }

    public GroceryModel getItem(int id) {
        return listData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}


