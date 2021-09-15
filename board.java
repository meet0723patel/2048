package src;

import java.util.*;

public class Board {

    public int[][] board;
    public int board_size;
    public int score;
    public boolean win;
    public boolean lose;

    public BoardT(int s) {
        board_size = s;
        board = new int[board_size][board_size];
        for (int[] i : board) {
            for (int j = 0; j < board_size; j++) {
                i[j] = 0;
            }
        }
        Random rand = new Random();
        int[] inserter = new int[] {2, 2, 2, 2, 2, 2, 2, 2, 2, 4};
        for (int i = 0; i < 2; i++) {
            int x = rand.nextInt(4);
            int y = rand.nextInt(4);
            int ins = inserter[rand.nextInt(10)];
            board[x][y] = ins;
        }
        score = 0;
        win = false;
        lose = false;
    }

    public BoardT(int[][] given_board) {
        board_size = given_board.length;
        if (given_board.length != board_size || given_board[0].length != board_size || given_board[1].length != board_size
             || given_board[2].length != board_size || given_board[3].length != board_size) {
            throw new IllegalArgumentException("Input size is invalid");
        }

        board = given_board;
        score = 0;
        win = false;
        lose = false;
    }

    public void lost() {
        if (this.find_empty().isEmpty() == false) {
            return;
        }
        for (int y = 0; y < board_size-1; y++) {
            if (board[0][y] == board[0][y+1]) {
                return;
            }
        }

        for (int i = 1; i < board_size; i++ ) {
            for (int x = 0; x < board_size; x++) {
                if (x == 0) {
                    if (board[i][x] == board[i-1][x]) {
                        return;
                    }
                }
                else {
                    if (board[i][x] == board[i-1][x] || board[i][x] == board[i][x-1]) {
                        return;
                    }
                }
            }
        }
        lose = true;
    }
    
    public ArrayList<Integer[]> find_empty() {    
        ArrayList<Integer[]> answer = new ArrayList<>();
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                if (board[i][j] == 0) {
                    answer.add(new Integer[] {i, j});
                }
                if (board[i][j] == 2048) {
                    win = true;
                }
            }
        } 
        return answer;
    }

    public boolean equal_board(BoardT s, int n) {

        if (board_size != s.board_size) {
            return false;
        }

        int counter = 0;
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                if (board[i][j] != s.board[i][j]) {
                    counter++;
                }
            }
        }
        if (counter > n) {
            return false;
        }
        return true;
    }

    /**
   * @brief Pushes all board values to left.
   * @details Moves all 0s in the board to the right.
   */
    public void push_left() {

        for (int[] i : board) {
            int counter = 0;
            for (int x = 0; x < board_size; x++) {
                if (i[x] != 0) {
                    i[counter++] = i[x];
                }
            }
            while (counter < board_size) {
                i[counter++] = 0;
            }
        }
    }

    /**
   * @brief Pushes all board values to right.
   * @details Moves all 0s in the board to the left.
   */
    public void push_right() {

        for (int[] i : board) {
            int counter = board_size-1;
            for (int x = board_size-1; x >= 0; x--) {
                if (i[x] != 0) {
                    i[counter--] = i[x];
                }
            }
            while (counter >= 0) {
                i[counter--] = 0;
            }
        }
    }

    /**
   * @brief Pushes all board values up.
   * @details Moves all 0s in the board to the bottom.
   */
    public void push_up() {

        for (int i = 0; i < board_size; i++) {
            int counter = 0;
            for (int x = 0; x < board_size; x++) {
                if (board[x][i] != 0) {
                    board[counter++][i] = board[x][i];
                }
            }
            while (counter < board_size) {
                board[counter++][i] = 0;
            }
        }
    }

    /**
   * @brief Pushes all board values down.
   * @details Moves all 0s in the board to the top.
   */
    public void push_down() {

        for (int i = 0; i < board_size; i++) {
            int counter = board_size-1;
            for (int x = board_size-1; x >= 0; x--) {
                if (board[x][i] != 0) {
                    board[counter--][i] = board[x][i];
                }
            }
            while (counter >= 0) {
                board[counter--][i] = 0;
            }
        }
    }

    /**
   * @brief Gets the score value.
   * @return An integer that represents the score.
   */
    public int get_score() {

        return score;
    }

    /**
   * @brief Gets the win value.
   * @return A boolean that represents the win status.
   */
    public boolean get_win() {

        return win;
    }

    /**
   * @brief Gets the lose value.
   * @return A boolean that represents the lose status.
   */
    public boolean get_lose() {

        return lose;
    }

    /**
   * @brief Resets the board, win, lose and score values just like the constructor.
   */
    public void reset() {
        board = new int[board_size][board_size];
        for (int[] i : board) {
            for (int j = 0; j < board_size; j++) {
                i[j] = 0;
            }
        }
        Random rand = new Random();
        int[] inserter = new int[] {2, 2, 2, 2, 2, 2, 2, 2, 2, 4};
        for (int i = 0; i < 2; i++) {
            int x = rand.nextInt(4);
            int y = rand.nextInt(4);
            int ins = inserter[rand.nextInt(10)];
            board[x][y] = ins;
        }
        score = 0;
        win = false;
        lose = false;
    }

}