import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    
    int boardWidth = 600;
    int boardHeight = 650;

    JFrame jFrame = new JFrame("Tic-Tac-Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JButton[][] board = new JButton[3][3];
    JPanel boardPanel = new JPanel();

    String player = "X";
    boolean gameOver = false;
    int turns= 0;

    TicTacToe(){
        jFrame.setVisible(true);
        jFrame.setSize(boardWidth, boardHeight);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setBackground(Color.darkGray);
        jFrame.setLayout(new BorderLayout());

        
        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setSize(new Dimension(600,50));
        textLabel.setFont(new Font("Arial", Font.BOLD,40));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        jFrame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.darkGray);
        jFrame.add(boardPanel);

        for(int row=0 ; row<3 ; row++){
            for(int column=0 ; column<3 ; column++){
                JButton tile = new JButton();
                board[row][column] = tile;
                boardPanel.add(tile);

                tile.setBackground(Color.darkGray);
                tile.setForeground(Color.white);
                tile.setFont(new Font("Arial", Font.BOLD,80));
                tile.setFocusable(false);

                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        
                        if(gameOver)    return;
                        JButton tile = (JButton) e.getSource();
                        if(tile.getText() == ""){
                            tile.setText(player);
                            turns++;
                            check(tile);

                            if(!gameOver){
                                player = (player == "X") ? "O" : "X";
                                textLabel.setText(player + "'s turn");
                            }
                        }
                    }
                });
            }
        }

    }

    void check(JButton tile){
        for(int row=0 ; row<3; row++){
            if((board[row][0].getText() == player) && (board[row][1].getText() == player) && (board[row][2].getText() == player)){
                for(int i=0 ; i<3 ; i++){
                    setWinner(board[row][i]);
                }
                gameOver = true;
                return;
            }
        }

        for(int column=0 ; column<3 ; column++){
            if((board[0][column].getText() == player) && (board[1][column].getText() == player) && (board[2][column].getText() == player)){
                for(int i=0 ; i<3 ; i++){
                    setWinner(board[i][column]);
                }
                gameOver = true;
                return;
            }
        }

        if((board[0][0].getText() == player) && (board[1][1].getText() == player) && (board[2][2].getText() == player)){
            for(int i=0 ; i<3 ; i++){
                setWinner(board[i][i]);
            }            
            gameOver = true;
            return;
        }

        if((board[0][2].getText() == player) && (board[1][1].getText() == player) && (board[2][0].getText() == player)){
                setWinner(board[0][2]);
                setWinner(board[1][1]);
                setWinner(board[2][0]); 
            gameOver = true;
            return;
        }

        if(turns == 9){
            for(int row=0 ; row<3 ; row++){
                for(int column=0 ; column<3 ; column++){
                    setTie(board[row][column]);
                }
            }
            gameOver = true;
            return;
        }
    }


    void setWinner(JButton tile){
        tile.setBackground(Color.gray);
        tile.setForeground(Color.green);
        textLabel.setText(player + " is the Winner!");
    }

    void setTie(JButton tile){
        tile.setBackground(Color.gray);
        tile.setForeground(Color.orange);
        textLabel.setText("It's a Tie!");
    }

}
