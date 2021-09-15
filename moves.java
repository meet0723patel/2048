package src;

import java.util.*;
import java.util.Random;

public class Moves {

    private static int[] inserter = new int[] {2, 2, 2, 2, 2, 2, 2, 2, 2, 4};

    private static void randomizer(ArrayList<Integer[]> pick, BoardT B) {
        if (pick.size() == 0) {
            return;
        }
        Random rand = new Random();
        Integer[] slot = pick.get(rand.nextInt(pick.size()));
        int ins = inserter[rand.nextInt(10)];
        B.board[slot[0]][slot[1]] = ins;
    }

    public static void swipe_left(BoardT B) {

        B.push_left();

        for (int[] i : B.board) {
            for (int x = 0; x < (B.board_size-1); x++) {
                if (i[x] == i[x+1]) {
                    i[x] = i[x]*2;
                    B.score += i[x];
                    for (int y = x+1; y < (B.board_size-1); y++) {
                        i[y] = i[y+1];
                    }
                    i[B.board_size-1] = 0;
                }
            }
        }

        randomizer(B.find_empty(), B);
        
        
    }

    public static void swipe_right(BoardT B) {

        B.push_right();

        for (int[] i : B.board) {
            for (int x = B.board_size-1; x > 0; x--) {
                if (i[x] == i[x-1]) {
                    i[x] = i[x]*2;
                    B.score += i[x];
                    for (int y = x-1; y > 0; y--) {
                        i[y] = i[y-1];
                    }
                    i[0] = 0;
                }
            }
        }

        randomizer(B.find_empty(), B);
        
    }

    public static void swipe_up(BoardT B) {

        B.push_up();

        for (int i = 0; i < B.board_size; i++) {
            for (int x = 0; x < B.board_size-1; x++) {
                if (B.board[x][i] == B.board[x+1][i]) {
                    B.board[x][i] = B.board[x][i]*2;
                    B.score += B.board[x][i];
                    B.board[x+1][i] = 0;
                }
            }
        }

        B.push_up();
        randomizer(B.find_empty(), B);
        
    }

    public static void swipe_down(BoardT B) {

        B.push_down();

        for (int i = 0; i < B.board_size; i++) {
            for (int x = B.board_size-1; x > 0 ; x--) {
                if (B.board[x][i] == B.board[x-1][i]) {
                    B.board[x][i] = B.board[x][i]*2;
                    B.score += B.board[x][i];
                    B.board[x-1][i] = 0;
                }
            }
        }

        B.push_down();
        randomizer(B.find_empty(), B);
        
    }


}
