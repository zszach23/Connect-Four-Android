package com.example.connectfour;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout for the activity
        setContentView(R.layout.activity_main);

        // Set up the BottomNavigationView and NavController
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        // Set up the toolbar (fixes onSetTitle error on startup)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up the action bar with the NavController
        if (navHostFragment != null)
        {
            NavController navController = navHostFragment.getNavController();
            AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.BoardFragment, R.id.GameOptionsFragment).build();

            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
            NavigationUI.setupWithNavController(bottomNavigationView, navController);
        }

//        // Get references to the buttons
//        Button connectFourButton = findViewById(R.id.ConnectFourButton);
//        Button optionsButton = findViewById(R.id.OptionsButton);
//
//        // Set callback methods for when the buttons are clicked
//        connectFourButton.setOnClickListener(this::onConnectFourButtonClick);
//        optionsButton.setOnClickListener(this::onOptionsButtonClick);
    }

//    // Callback method for when the Connect Four button is clicked
//    // Starts the Board activity
//    protected void onConnectFourButtonClick(View view) {
//        Intent intent = new Intent(MainActivity.this, BoardFragment.class);
//        startActivity(intent);
//    }
//
//    // Callback method for when the Options button is clicked
//    // Starts the GameOptions activity
//    protected void onOptionsButtonClick(View view) {
//        Intent intent = new Intent(MainActivity.this, GameOptionsFragment.class);
//        OptionsResultLauncher.launch(intent);
//    }
//
//    // ActivityResultLauncher for the GameOptions activity
//    // Receives the difficulty mode from the activity and displays it in a Toast
//    ActivityResultLauncher<Intent> OptionsResultLauncher = registerForActivityResult(
//            new ActivityResultContracts.StartActivityForResult(),
//            result -> {
//                if (result.getResultCode() == RESULT_OK) {
//                    Intent data = result.getData();
//                    if (data != null) {
//                        String difficultyMode = data.getStringExtra(GameOptionsFragment.DIFFICULTY_MODE);
//                        Toast.makeText(MainActivity.this, "Difficulty Mode: " + difficultyMode, Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//    );
}