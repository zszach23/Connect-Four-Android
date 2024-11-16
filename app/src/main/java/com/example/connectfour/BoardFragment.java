package com.example.connectfour;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
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

        // Initialize the game if it hasn't been initialized yet
        if (mGame == null)
        {
            mGame = new ConnectFourGame();
        }

        // Restore the game state if it was saved
        if (savedInstanceState == null)
        {
            startGame();
        }
        else
        {
            mGame.setState(GAME_STATE);
            setDisc();
        }

        return view;
    }

    public void onButtonClick(View view)
    {
        int buttonIndex = mGrid.indexOfChild(view);
        int row = buttonIndex / ConnectFourGame.COLS;
        int col = buttonIndex % ConnectFourGame.COLS;

        mGame.selectDisc(row, col);
        setDisc();

        if (mGame.isGameOver())
        {
            // Instantiate Toast
            Toast toast = Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT);
            toast.show();

            mGame.newGame();
            setDisc();
        }
    }

    public void startGame()
    {
        mGame.newGame();
        setDisc();
    }

    public void setDisc()
    {
        for (int buttonIndex = 0; buttonIndex < mGrid.getChildCount(); buttonIndex++)
        {
            Button gridButton = (Button) mGrid.getChildAt(buttonIndex);

            int row = buttonIndex / ConnectFourGame.COLS;
            int col = buttonIndex % ConnectFourGame.COLS;

            Drawable whiteDisc = ContextCompat.getDrawable(getActivity(), R.drawable.circle_white);
            Drawable redDisc = ContextCompat.getDrawable(getActivity(), R.drawable.circle_red);
            Drawable blueDisc = ContextCompat.getDrawable(getActivity(), R.drawable.circle_blue);

            whiteDisc = DrawableCompat.wrap(whiteDisc);
            redDisc = DrawableCompat.wrap(redDisc);
            blueDisc = DrawableCompat.wrap(blueDisc);

            int value = mGame.getDisc(row, col);

            if (value == ConnectFourGame.RED)
            {
                gridButton.setBackground(redDisc);
            }
            else if (value == ConnectFourGame.BLUE)
            {
                gridButton.setBackground(blueDisc);
            }
            else if (value == ConnectFourGame.EMPTY)
            {
                gridButton.setBackground(whiteDisc);
            }
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState)
    {
        // Save the game state when the fragment is destroyed
        super.onSaveInstanceState(outState);
        outState.putString(GAME_STATE, mGame.getState());
    }
}
