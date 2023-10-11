import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 //Trevor McDonough
 */
public class TicTacToeFrame extends JFrame
{
    private static JButton boardButts[] = new JButton[9]; // create 9 buttons

    /**
     * creates frame and adds buttons for the tic tac toe board
     */
    public TicTacToeFrame(){
        JFrame frame = new JFrame ("Tic Tac Toe");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout (new GridLayout (3, 3));

        for(int i=0; i<=8; i++){ // adding buttons to board
            boardButts[i] = new MyButton();
            panel.add(boardButts[i]);
        }

        frame.getContentPane().add (panel);
        frame.setVisible(true);
        frame.setSize(500, 500);
    }

    public static int moves = 0; // used for counting

    private static int[][] winCombos = new int[][] { // array that holds win combinations for the button spots
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // horizontal wins
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // vertical wins
            {0, 4, 8}, {2, 4, 6}
    };

    /**
     * nested class that allows for it to use other implementations of the surrounding class.
     */
    public class MyButton extends JButton implements ActionListener {

        int repeat = 1000;// used to make sure we don't play again without prompt
        boolean win = false;
        String XO; // x or o

        /**
         * creates the board with blank spots
         */
        public MyButton() {	// creating blank board
            super();
            XO = " ";
            setFont(new Font("Dialog", 1, 60));
            setText(XO);
            addActionListener(this);
        }

        /**
         * shows what letter will be placed based on start of the game and moves thereafter in blank spots.
         * @param e is our action event.
         */
        public void actionPerformed(ActionEvent e) { // placing x or o's
            if((moves % 2) == 0 && getText().equals(" ") && win == false){
                XO = "X";
                moves = moves + 1;
                System.out.println(XO + "\n" + moves);
            } else if((moves % 2) == 1 && getText().equals(" ") && win == false) {
                XO = "O";
                moves = moves + 1;
                System.out.println(XO + "\n" + moves);
            } // if user does click on a button that is already played, nothing will happen

            setText(XO); // place the x or the o on the actual board


            for(int i=0; i<=7; i++){ // check for the winning combinations
                if( boardButts[winCombos[i][0]].getText().equals(boardButts[winCombos[i][1]].getText()) &&
                        boardButts[winCombos[i][1]].getText().equals(boardButts[winCombos[i][2]].getText()) &&
                        boardButts[winCombos[i][0]].getText() != " "){// the winning is true
                    win = true;
                }
            }

            if(win == true){ // tell who winner is and ask if they want to keep playing
                repeat = JOptionPane.showConfirmDialog(null, XO + " wins the game.  Do you want to play again?", XO + "won.", JOptionPane.YES_NO_OPTION);

            } else if(moves == 9 && win == false){// say they tied and ask if they want to play again
                repeat = JOptionPane.showConfirmDialog(null, "The game was tie.  Do you want to play again?", "Tie game.", JOptionPane.YES_NO_OPTION);
                win = true;
            }

            if(repeat == JOptionPane.YES_OPTION && win == true){ // if yes to play again clear board and restart
                clearButtons();
                win = false;
            }
            else if(repeat == JOptionPane.NO_OPTION){
                System.exit(0);
            }
        }
    }

    /**
     * clears the board and sets the move counter to the start.
     */
    public static void clearButtons(){

        for(int i=0; i<=8; i++){// clear board
            boardButts[i].setText(" ");
        }
        moves = 0; // reset move count
    }
}
