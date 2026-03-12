import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char[][] board = new char[3][3];
        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        for(int row=0 ; row<board.length ; row++){
            for(int column=0 ; column<board[row].length ; column++){
                board[row][column] = ' ';
            }
        }

        while(!gameOver){
            printBoard(board);
            System.out.println("Player " + player + "'s move : ");
            int r = sc.nextInt();
            int c = sc.nextInt();

            if(board[r][c] == ' '){
                board[r][c] = player;
                gameOver = checkGameOver(board, player);

                if(!gameOver){
                    player = (player == 'X') ? 'O' : 'X';
                }
            }
            else{
                System.out.println("Invalid move. Try again!");
            }
        }
        
        printBoard(board);
        System.out.println("Player " + player + " has won!");
        sc.close();
    }

    public static void printBoard(char[][] board){

        System.out.println("--------------------");
        for(int row=0 ; row<board.length ; row++){
            for(int column=0 ; column<board[row].length ; column++){
                System.out.print(board[row][column] + "|");
            }
            System.out.println("");
        }
        System.out.println("--------------------");

    }

    public static boolean checkGameOver(char[][] board, char player){

        for(int row=0 ; row<board.length ; row++){
            if((board[row][0] == player) && (board[row][1] == player) && (board[row][2] == player)){
                return true;
            }
        }

        for(int column=0 ; column<3 ; column++){
            if((board[0][column] == player) && (board[1][column] == player) && (board[2][column] == player)){
                return true;
            }
        }

        if((board[0][0] == player) && (board[1][1] == player) && (board[2][2] == player)){
            return true;
        }

        if((board[0][2] == player) && (board[1][1] == player) && (board[2][0] == player)){
            return true;
        }
        return false;
    }
}
