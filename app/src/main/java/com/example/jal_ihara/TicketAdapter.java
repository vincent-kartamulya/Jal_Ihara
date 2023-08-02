package com.example.jal_ihara;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketHolder> {

    Context  context;
    List<Item> items;

    public TicketAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public TicketHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TicketHolder(LayoutInflater.from(context).inflate(R.layout.activity_ticketlist,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TicketHolder holder, int position) {
        holder.namaticket.setText(items.get(position).getNamaticket());
        holder.deskripsiticket.setText(items.get(position).getDeskripsiticket());
        holder.gambarticket.setImageResource(items.get(position).getGambarticket());
        holder.tanggalticket.setText(items.get(position).getTanggalticket());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
