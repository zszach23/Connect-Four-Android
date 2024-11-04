package com.example.connectfour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BoardFragment extends Fragment
{
    private final String GAME_STATE = "gameState";
    private ConnectFourGame mGame;
    private GridLayout mGrid;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);

        // Create grid layout for the game board
        View view = inflater.inflate(R.layout.fragment_board, container, false);
        mGrid = view.findViewById(R.id.grid);

        // Set callbacks for all buttons in the grid
        for (int i = 0; i < mGrid.getChildCount(); i++)
        {
            Button button = (Button) mGrid.getChildAt(i);
            button.setOnClickListener(this::onButtonClick);
        }

        return view;
    }

    public void onButtonClick(View view)
    {
        // TODO: Implement button click logic
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState)
    {
        // Save the game state when the fragment is destroyed
        super.onSaveInstanceState(outState);
        outState.putString(GAME_STATE, mGame.getState());
    }
}
