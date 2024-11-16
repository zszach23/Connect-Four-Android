package com.example.connectfour;

public class ConnectFourGame
{
    public static final int ROWS = 7;
    public static final int COLS = 6;
    public static final int EMPTY = 0;
    public static final int BLUE = 1;
    public static final int RED = 2;

    private int[][] board;
    private int player = BLUE;

    public ConnectFourGame()
    {
        board = new int[ROWS][COLS];
    }

    // Initialize the game board with empty cells
    public void newGame()
    {
        player = BLUE;

        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                board[i][j] = EMPTY;
            }
        }
    }

    public boolean isGameOver()
    {
        boolean gameOver = isBoardFilled() || isWin();

        // Change player after win state is checked
        player = (player == BLUE) ? RED : BLUE;

        return gameOver;
    }

    // Check if the game board is full
    public boolean isBoardFilled()
    {
        // Board filled if top row is filled
        for (int i = 0; i < COLS; i++)
        {
            if (board[0][i] == EMPTY)
            {
                return false;
            }
        }

        return true;
    }

    // Check if a player has won the game
    public boolean isWin()
    {
        return checkHorizontal() || checkVertical() || checkDiagonal();
    }

    // Horizontal Win
    public boolean checkHorizontal()
    {
        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col <= COLS - 4; col++)
            {
                // Check for 4 consecutive discs in a row
                if (board[row][col] == player &&
                    board[row][col + 1] == player &&
                    board[row][col + 2] == player &&
                    board[row][col + 3] == player)
                {
                    return true;
                }
            }
        }

        return false;
    }

    // Vertical Win
    public boolean checkVertical()
    {
        for (int row = 0; row <= ROWS - 4; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                // Check for 4 consecutive discs in a column
                if (board[row][col] == player &&
                    board[row + 1][col] == player &&
                    board[row + 2][col] == player &&
                    board[row + 3][col] == player)
                {
                    return true;
                }

            }
        }

        return false;
    }

    // Diagonal Win
    public boolean checkDiagonal()
    {
        return checkLeftDiagonal() || checkRightDiagonal();
    }

    // Diagonal Win (Bottom-Left to Top-Right)
    public boolean checkLeftDiagonal()
    {
        for (int row = 0; row <= ROWS - 4; row++)
        {
            for (int col = 0; col <= COLS - 4; col++)
            {
                // Check for 4 consecutive discs in a diagonal
                if (board[row][col] == player &&
                    board[row + 1][col + 1] == player &&
                    board[row + 2][col + 2] == player &&
                    board[row + 3][col + 3] == player)
                {
                    return true;
                }
            }
        }

        return false;
    }

    // Diagonal Win (Top-Left to Bottom-Right)
    public boolean checkRightDiagonal()
    {
        for (int row = 3; row < ROWS; row++)
        {
            for (int col = 0; col < COLS - 4; col++)
            {
                // Check for 4 consecutive discs in a diagonal
                if (board[row][col] == player &&
                    board[row - 1][col + 1] == player &&
                    board[row - 2][col + 2] == player &&
                    board[row - 3][col + 3] == player)
                {
                    return true;
                }
            }
        }

        return false;
    }

    // Get the value of a specific cell in the game board
    public int getDisc(int row, int col)
    {
        return board[row][col];
    }

    // Select a disc in the game board
    public void selectDisc(int row, int col)
    {
        // Start from bottom row and move up until an empty cell is found
        for (int i = ROWS - 1; i >= 0; i--)
        {
            if (board[i][col] == EMPTY)
            {
                board[i][col] = player;
                break;
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

    // Populate board with the saved game state
    public void setState(String gameState)
    {
        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                board[i][j] = gameState.charAt(i * COLS + j) - '0';
            }
        }
    }
}
