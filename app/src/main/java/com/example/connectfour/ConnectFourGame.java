package com.example.connectfour;

public class ConnectFourGame
{
    private int[][] board;
    private final int ROWS = 7;
    private final int COLS = 6;

    public ConnectFourGame()
    {
        board = new int[ROWS][COLS];
    }

    // Initialize the game board with empty cells
    public void newGame()
    {
        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                board[i][j] = 0;
            }
        }
    }

    // Get the current state of the game board as a string
    public String getState()
    {
        StringBuilder state = new StringBuilder();

        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                state.append(board[i][j]);
            }
        }

        return state.toString();
    }
}
