package cs5004.marblesolitaire.model;

public class MarbleSolitaireBoard {

//    static class stateNode {
//        String state;
//        stateNode up;
//        stateNode down;
//        stateNode left;
//        stateNode right;
//    };
//
//    // returns head pointer of linked list
//    // constructed from 2D matrix
//    static stateNode construct(String arr[][], int i, int j,
//                          int m, int n) {
//
//        // return if i or j is out of bounds
//        if (i > n - 1 || j > m - 1)
//            return null;
//
//        // create a new node for current i and j
//        // and recursively allocate its up/down and left/right pointers
//        stateNode temp = new stateNode();
//        temp.state = arr[i][j];
//
//        temp.up = construct(arr, i - 1, j, m, n);
//        temp.down = construct(arr, i + 1, j, m, n);
//
//        temp.left = construct(arr, i, j - 1, m, n);
//        temp.right = construct(arr, i, j + 1, m, n);
//        return temp;
//    }
//
//    // utility function for displaying
//    // linked list data
//    static void display(stateNode head) {
//        // pointer to move up
//        stateNode Up = head;
//        // pointer to move down
//        stateNode Dp = head;
//
//        // pointer to move left
//        stateNode Lp;
//        // pointer to move right
//        stateNode Rp;
//
//
//        // loop till node->down is not NULL
//        while (Dp != null) {
//            Rp = Dp;
//
//            // loop till node->right is not NULL
//            while (Rp != null) {
//                System.out.print(Rp.state + " ");
//                Rp = Rp.right;
//            }
//            System.out.println();
//            Dp = Dp.down;
//        }
//    }

    public static void main(String[] args) {
        System.out.println("main function in Board runs...");

        int armThick = 3;
        int sRow = 3, sCol = 3;
        int boardSize = armThick * 2 + 1;

        String[][] board = new String[boardSize][boardSize];
        System.out.println(
                "Default value of String array element: "
                        + board[0][0]);

        System.out.println("Board status initialization...");

        String expression = "";

        for (int row = 0; row < boardSize; ++row) {
            for (int col = 0; col < boardSize; ++col) {
                if (
                        (row < armThick - 1 && col < armThick - 1) ||
                                (row < armThick - 1 && col > boardSize - armThick) ||
                                (row > boardSize - armThick && col < armThick - 1) ||
                                (row > boardSize - armThick && col > boardSize - armThick)
                ) {
                    board[row][col] = " ";
                } else board[row][col] = "O";
                board[sRow][sCol] = "_";
                //System.out.print((board[row][col] + " \t"));
                expression = expression + (board[row][col] + " \t");

            }
            //System.out.println();
            expression = expression + "\n";
        }

        System.out.println(expression);
        System.out.println("\nCheck single position:");

        System.out.println("board[3][3]: " + board[3][3]);
        System.out.println("board[0][1]: " + board[0][1]);
        System.out.println("board[2][3]: " + board[2][3]);

    }

}
