package com.example.user.mysmartapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainGameBoard extends AppCompatActivity {
    private int size;
    TableLayout mainBoard;
    TextView tv_turn;
    char[][] board;
    char turn;
    Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game_board);

        bt = (Button) findViewById(R.id.backHome);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainGameBoard.this, MainActivity.class);
                startActivity(intent);
            }
        });
        size = Integer.parseInt(getString(R.string.size_of_board));
        board = new char[size][size];
        mainBoard = (TableLayout) findViewById(R.id.mainBoard);
        tv_turn = (TextView) findViewById(R.id.turn);

        resetBoard();
        tv_turn.setText("Turn: " + turn);

        for (int i = 0; i < mainBoard.getChildCount(); i++) {
            TableRow row = (TableRow) mainBoard.getChildAt(i);
            for (int j = 0; j < row.getChildCount(); j++) {
                TextView tv = (TextView) row.getChildAt(j);
                tv.setText(R.string.none);
                tv.setOnClickListener(Move(i, j, tv));
            }
        }

        Button rstbtn = (Button) findViewById(R.id.resetGame);
        rstbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent current = getIntent();
                finish();
                startActivity(current);
            }
        });
    }

    protected void resetBoard() {
        turn = 'X';
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }

    protected int gameStatus() {

        //0 Continue
        //1 X Wins
        //2 O Wins
        //-1 Draw

        int rowX = 0, colX = 0, rowO = 0, colO = 0;
        for (int i = 0; i < size; i++) {
            if (check_Row_Equality(i, 'X'))
                return 1;
            if (check_Column_Equality(i, 'X'))
                return 1;
            if (check_Row_Equality(i, 'O'))
                return 2;
            if (check_Column_Equality(i, 'O'))
                return 2;
            if (check_Diagonal('X'))
                return 1;
            if (check_Diagonal('O'))
                return 2;
        }

        boolean boardFull = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ')
                    boardFull = false;
            }
        }
        if (boardFull)
            return -1;
        else return 0;
    }

    protected boolean check_Diagonal(char player) {
        int count_Equal1 = 0, count_Equal2 = 0;
        for (int i = 0; i < size; i++)
            if (board[i][i] == player)
                count_Equal1++;
        for (int i = 0; i < size; i++)
            if (board[i][size - 1 - i] == player)
                count_Equal2++;
        if (count_Equal1 == size || count_Equal2 == size)
            return true;
        else return false;
    }

    protected boolean check_Row_Equality(int r, char player) {
        int count_Equal = 0;
        for (int i = 0; i < size; i++) {
            if (board[r][i] == player)
                count_Equal++;
        }

        if (count_Equal == size)
            return true;
        else
            return false;
    }

    protected boolean check_Column_Equality(int c, char player) {
        int count_Equal = 0;
        for (int i = 0; i < size; i++) {
            if (board[i][c] == player)
                count_Equal++;
        }

        if (count_Equal == size)
            return true;
        else
            return false;
    }

    protected boolean Cell_Set(int r, int c) {
        return !(board[r][c] == ' ');
    }

    protected void stopMatch() {
        for (int i = 0; i < mainBoard.getChildCount(); i++) {
            TableRow row = (TableRow) mainBoard.getChildAt(i);
            for (int j = 0; j < row.getChildCount(); j++) {
                TextView tv = (TextView) row.getChildAt(j);
                tv.setOnClickListener(null);
            }
        }
    }

    View.OnClickListener Move(final int r, final int c, final TextView tv) {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!Cell_Set(r, c)) {
                    board[r][c] = turn;
                    if (turn == 'X') {
                        tv.setText(R.string.X);
                        turn = 'O';
                    } else if (turn == 'O') {
                        tv.setText(R.string.O);
                        turn = 'X';
                    }
                    if (gameStatus() == 0) {
                        tv_turn.setText("Turn: " + turn);
                    } else if (gameStatus() == -1) {
                        tv_turn.setText("Game: Draw");
                        stopMatch();
                    } else {
                        tv_turn.setText(turn + " Loses!");
                        stopMatch();
                    }
                }

            }
        };
    }
}
