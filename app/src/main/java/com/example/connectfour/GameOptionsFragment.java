package com.example.connectfour;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class GameOptionsFragment extends Fragment {

    public static final String DIFFICULTY_MODE = "DIFFICULTY_MODE";
//    public static final String EASY_MODE = "EASY";
//    public static final String MEDIUM_MODE = "MEDIUM";
//    public static final String HARD_MODE = "HARD";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);

        // Inflate the layout for the fragment
        View view = inflater.inflate(R.layout.fragment_game_options, container, false);

        // Load the selected difficulty mode from SharedPreferences
        SharedPreferences sharedPrefs = requireActivity().getPreferences(Context.MODE_PRIVATE);

        // Set the selected radio button based on the saved difficulty mode
        int savedDifficultyLevel = sharedPrefs.getInt(DIFFICULTY_MODE, R.id.MediumRadioButton);
        int radioId = R.id.MediumRadioButton;

        // Set the selected radio button based on the saved difficulty mode
        if (savedDifficultyLevel == R.id.EasyRadioButton)
        {
            radioId = R.id.EasyRadioButton;
        }
        else if (savedDifficultyLevel == R.id.MediumRadioButton)
        {
            radioId = R.id.MediumRadioButton;
        }
        else if (savedDifficultyLevel == R.id.HardRadioButton)
        {
            radioId = R.id.HardRadioButton;
        }

        // Set radio button as checked
        RadioButton radio = view.findViewById(radioId);
        radio.setChecked(true);

        // Set callback methods for when the radio buttons are clicked
        RadioGroup radioGroup = view.findViewById(R.id.DifficultyRadioGroup);
        for (int i = 0; i < radioGroup.getChildCount(); i++)
        {
            radio = (RadioButton) radioGroup.getChildAt(i);
            radio.setOnClickListener(this::onDifficultySelected);
        }

        return view;
    }

    // Callback method for when a radio button is clicked
    public void onDifficultySelected(View view)
    {
        int difficultyId = view.getId();

        // Save the selected difficulty mode to SharedPreferences
        SharedPreferences sharedPrefs = requireActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt(DIFFICULTY_MODE, difficultyId);
        editor.apply();

//        String difficultyName;
//
//        // Determine the selected difficulty mode based on the radio button ID
//        if (difficultyId == R.id.EasyRadioButton)
//        {
//            difficultyName = EASY_MODE;
//        }
//        else if (difficultyId == R.id.MediumRadioButton)
//        {
//            difficultyName = MEDIUM_MODE;
//        }
//        else if (difficultyId == R.id.HardRadioButton)
//        {
//            difficultyName = HARD_MODE;
//        }
//        // Default to Medium mode if no radio button is selected
//        else
//        {
//            difficultyName = MEDIUM_MODE;
//        }
//
//        // Return the selected difficulty mode to the calling activity
//        Intent intent = new Intent();
//        intent.putExtra(DIFFICULTY_MODE, difficultyName);
//        setResult(RESULT_OK, intent);
//        finish();
    }
}
