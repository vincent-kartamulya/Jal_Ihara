package com.example.jal_ihara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.appcompat.widget.Toolbar;
import android.widget.PopupMenu;
public class TicketActivity extends AppCompatActivity {
    private boolean isMenuVisible = false;
    private View slidingMenu;
    private TextView menuItem1;
    private TextView menuItem2;
    private TextView menuItem3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.rvData);
        List<Item> items = new ArrayList<>();
        items.add(new Item("Wayang", "Rp.50000", R.drawable.wayang, "28\nOct"));
        items.add(new Item("Men with a Mission", "Rp.50000", R.drawable.konser, "4\nJuli"));
        items.add(new Item("Opera del Monte", "Rp.50000", R.drawable.opera, "30\nAgustus"));
        items.add(new Item("Theatrical le Luminaire", "Rp.50000", R.drawable.teater, "1\nJanuari"));
        items.add(new Item("Wayang Manusia", "Rp.50000", R.drawable.wayang_orang, "8\nJanuari"));



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TicketAdapter(getApplicationContext(),items));


        // Set a custom title for the Toolbar (hide the app name)
        getSupportActionBar().setTitle("");

        // Set up the burger menu click listener
        ImageView burgerMenu = findViewById(R.id.burgerMenu);

        burgerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the dropdown menu
                showPopupMenu(v);
            }
        });
    }

        private void showPopupMenu(View v) {
            PopupMenu popupMenu = new PopupMenu(this, v);
            popupMenu.inflate(R.menu.dropdown_menu);

            // Set up menu item click listener
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.menu_home:
                            // Handle menu item 1 click
                            return true;
                    case R.id.menu_view_tickets:
                        // Handle menu item 2 click
                        Intent intent = new Intent(TicketActivity.this, TicketActivity.class);
                        startActivity(intent);
                    // Add more menu items as needed
                    case R.id.menu_about_us:
                        // Handle menu item 2 click
                        Intent intent = new Intent(TicketActivity.this, HomeActivity.class);
                        startActivity(intent);
                        case R.id.menu_logout:
                            // Handle menu item 2 click
                            Intent intent = new Intent(TicketActivity.this, LoginActivity.class);
                            startActivity(intent);
                        default:
                            return false;
                    }
                }
            });

            // Show the popup menu
            popupMenu.show();
        }



}