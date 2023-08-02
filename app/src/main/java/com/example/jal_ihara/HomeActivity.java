package com.example.jal_ihara;

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

public class HomeActivity extends AppCompatActivity {
    private boolean isMenuVisible = false;
    private View slidingMenu;
    private TextView menuItem1;
    private TextView menuItem2;
    private TextView menuItem3;
    private ViewPager viewPager;
    private int[] imageIds = {R.drawable.banner1, R.drawable.banner3, R.drawable.banner4, R.drawable.banner5};
    private int currentPage = 0;
    String username;
    private TextView welcomeMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set a custom title for the Toolbar (hide the app name)
        getSupportActionBar().setTitle("");

        // Set up the burger menu click listener
        ImageView burgerMenu = findViewById(R.id.burgerMenu);
        welcomeMsg = findViewById(R.id.welcome_msg);

        burgerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the dropdown menu
                showPopupMenu(v);
            }
        });

//        Intent fromLogin = getIntent();
//        viewUsername.setText(fromLogin.getStringExtra("username"));
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        username = sharedPreferences.getString("username", "");

        // Set the initial welcome message
        welcomeMsg.setText("Welcome, " + username);

        viewPager = findViewById(R.id.viewPager);
        CarouselAdapter adapter = new CarouselAdapter(this, imageIds);
        viewPager.setAdapter(adapter);

        // Auto-scroll the ViewPager
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            public void run() {
                if (currentPage == imageIds.length) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 0, 1000);
    }


    // Show the dropdown menu
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
//                        Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
//                        startActivity(intent);
                        return false;
//                    // Add more menu items as needed
                    case R.id.menu_about_us:
                        // Handle menu item 2 click
                        Intent intent = new Intent(HomeActivity.this, AboutContactActivity.class);
                        startActivity(intent);
                    case R.id.menu_logout:
                        // Handle menu item 2 click
                        Intent intent2 = new Intent(HomeActivity.this, LoginActivity.class);
                        startActivity(intent2);
                    default:
                        return false;
                }
            }
        });

        // Show the popup menu
        popupMenu.show();
    }

}

