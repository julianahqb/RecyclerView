package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

    private List<Item> items = new ArrayList<>();
    private Context context;

    public ItemAdapter(Context context) {
        this.context = context;
        for(int i=0; i<100; i++){
            Item item = new Item(i+1, "Item " + (i + 1));
            this.items.add(item);
        }
    }

    @NonNull
    @Override
    public ItemAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context)
                .inflate(android.R.layout.simple_list_item_2,
                        parent, false);
        ItemHolder holder = new ItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemHolder holder, int position) {
        Item item = items.get(position);
        holder.txtId.setText(String.valueOf(item.getId()));
        holder.txtNome.setText(item.getNome());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtId;
        public TextView txtNome;

        public ItemHolder(View itemView) {
            super(itemView);
            this.txtId = itemView.findViewById(android.R.id.text1);
            this.txtNome = itemView.findViewById(android.R.id.text2);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int pos = getAdapterPosition();
            Item item = items.get(pos);

            Toast.makeText(context,
                    "Item: " + item.getId(), Toast.LENGTH_SHORT).show();

        }

    }
}