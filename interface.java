import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JTextField[][] numberButtons = new JTextField[4][4];
    JButton[] functionButtons = new JButton[5];
    JButton upButton, downButton, leftButton, rightButton, newgameButton;
    JPanel panel;

    Font myFont = new Font("Calibri", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;
    BoardT game = new BoardT(4);

    Interface() {

        frame = new JFrame("2048 GAME !");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 650);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        upButton = new JButton("UP");
        downButton = new JButton("DOWN");
        leftButton = new JButton("LEFT");
        rightButton = new JButton("RIGHT");
        newgameButton = new JButton("NEW GAME");

        functionButtons[0] = upButton;
        functionButtons[1] = downButton;
        functionButtons[2] = leftButton;
        functionButtons[3] = rightButton;
        functionButtons[4] = newgameButton;

        for (int i = 0; i < 5; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(new Font("Calibri", Font.BOLD, 15));
            functionButtons[i].setFocusable(false);
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                numberButtons[i][j] = new JTextField();
                // numberButtons[i][j].addActionListener(this);
                numberButtons[i][j].setHorizontalAlignment(JTextField.CENTER);
                numberButtons[i][j].setFont(myFont);
                numberButtons[i][j].setEditable(false);
                if (game.board[i][j] == 0) {
                    numberButtons[i][j].setText("");
                } else {
                    numberButtons[i][j].setText(String.valueOf(game.board[i][j]));
                }
            }
        }

        upButton.setBounds(165, 430, 90, 50);
        downButton.setBounds(165, 550, 90, 50);
        leftButton.setBounds(50, 490, 90, 50);
        rightButton.setBounds(280, 490, 90, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 12, 12));

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                panel.add(numberButtons[i][j]);
            }
        }

        frame.add(panel);
        frame.add(upButton);
        frame.add(downButton);
        frame.add(leftButton);
        frame.add(rightButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        Interface calc = new Interface();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == upButton) {
            Moves.swipe_up(game);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (game.board[i][j] == 0) {
                        numberButtons[i][j].setText("");
                    } else {
                        numberButtons[i][j].setText(String.valueOf(game.board[i][j]));
                    }

                }
            }
            textfield.setText("SCORE: " + String.valueOf(game.get_score()));
            if (game.get_lose()) {
                textfield.setText("YOU LOSE !");
                System.out.println("lose");
            } else if (game.get_win()) {
                textfield.setText("YOU WIN !");
                System.out.println("win");
            }
        }
        if (e.getSource() == downButton) {
            Moves.swipe_down(game);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (game.board[i][j] == 0) {
                        numberButtons[i][j].setText("");
                    } else {
                        numberButtons[i][j].setText(String.valueOf(game.board[i][j]));
                    }
                }
            }
            textfield.setText("SCORE: " + String.valueOf(game.get_score()));
            if (game.get_lose()) {
                textfield.setText("YOU LOSE !");
            } else if (game.get_win()) {
                textfield.setText("YOU WIN !");
            }
        }
        if (e.getSource() == leftButton) {
            Moves.swipe_left(game);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (game.board[i][j] == 0) {
                        numberButtons[i][j].setText("");
                    } else {
                        numberButtons[i][j].setText(String.valueOf(game.board[i][j]));
                    }
                }
            }
            textfield.setText("SCORE: " + String.valueOf(game.get_score()));
            if (game.get_lose()) {
                textfield.setText("YOU LOSE !");
            } else if (game.get_win()) {
                textfield.setText("YOU WIN !");
            }
        }
        if (e.getSource() == rightButton) {
            Moves.swipe_right(game);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (game.board[i][j] == 0) {
                        numberButtons[i][j].setText("");
                    } else {
                        numberButtons[i][j].setText(String.valueOf(game.board[i][j]));
                    }
                }
            }
            textfield.setText("SCORE: " + String.valueOf(game.get_score()));
            if (game.get_lose()) {
                textfield.setText("YOU LOSE !");
            } else if (game.get_win()) {
                textfield.setText("YOU WIN !");
            }
        }

    }
}