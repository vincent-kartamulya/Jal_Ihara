package com.example.jal_ihara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class TicketActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        RecyclerView recyclerView = findViewById(R.id.rvData);
        List<Item> items = new ArrayList<>();
        items.add(new Item("Wayang", "Rp.50000", R.drawable.wayang, "28\nOct"));
        items.add(new Item("Men with a Mission", "Rp.50000", R.drawable.konser, "4\nJuli"));
        items.add(new Item("Opera del Monte", "Rp.50000", R.drawable.opera, "30\nAgustus"));
        items.add(new Item("Theatrical le Luminaire", "Rp.50000", R.drawable.teater, "1\nJanuari"));
        items.add(new Item("Wayang Manusia", "Rp.50000", R.drawable.wayang_orang, "8\nJanuari"));



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TicketAdapter(getApplicationContext(),items));

        EditText editText = findViewById(R.id.editText);
        String userInput = editText.getText().toString();
    }
}