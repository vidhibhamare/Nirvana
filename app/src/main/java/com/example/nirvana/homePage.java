package com.example.nirvana;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.example.nirvana.ui.home.HomeFragment;
import com.example.nirvana.ui.premade_playlist.PremadeplylistActivity;
import com.example.nirvana.ui.profile.ProfileFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nirvana.databinding.ActivityHomepageBinding;
import android.os.Bundle;
import android.widget.TextView;

public class homePage extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomepageBinding binding;
    Bundle extras;
    public String username;
    public String mood = "Indifferent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomepageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        extras = getIntent().getExtras();
        username = extras.getString("username");
        mood = extras.getString("mood");
//        HomeFragment homeFragment = new HomeFragment();
//        Bundle args = new Bundle();
//        args.putString("mood", mood); // Pass the mood
//        homeFragment.setArguments(args);




        if ("spiritual".equalsIgnoreCase(mood)) {
            PremadeplylistActivity premadePlaylistFragment = new PremadeplylistActivity();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_home_page, premadePlaylistFragment)
                    .addToBackStack(null)
                    .commit();
        }


        setSupportActionBar(binding.appBarHomePage.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        View headerView = navigationView.getHeaderView(0);

        TextView textViewUsername = headerView.findViewById(R.id.user_text_view);
        textViewUsername.setText(username);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_search, R.id.nav_playlist, R.id.nav_record, R.id.nav_timer, R.id.nav_update_profile)
                .setOpenableLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_page);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_page);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}