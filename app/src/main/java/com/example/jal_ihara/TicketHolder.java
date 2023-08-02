package com.example.jal_ihara;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TicketHolder extends RecyclerView.ViewHolder {
    ImageView gambarticket;
    TextView namaticket,deskripsiticket,tanggalticket;

    public TicketHolder(@NonNull View itemView) {
        super(itemView);
        gambarticket = itemView.findViewById(R.id.gambar);
        namaticket = itemView.findViewById(R.id.titleTextView);
        deskripsiticket = itemView.findViewById(R.id.descriptionTextView);
        tanggalticket = itemView.findViewById(R.id.tanggal);
    }
}
