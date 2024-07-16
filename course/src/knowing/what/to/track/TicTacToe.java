package knowing.what.to.track;

public class TicTacToe {

    public static void main(String[] args) {
        TicTacToe toe = new TicTacToe(2);
        toe.move(0,1,1);
        toe.move(0,0,2);
        toe.move(1, 0, 1);
        System.out.println("aa");
    }

    int[] rows;
    int[] cols;
    int posDiag = 0;
    int negDiag = 0;
    int n = 0;

    public TicTacToe(int n) {
        this.n = n;
        rows = new int[this.n];
        cols = new int[this.n];
    }

    // move will be used to play a move by a specific player and identify who
    // wins at each move
    public int move(int row, int col, int player) {
        int multiplayer = player == 1 ? 1 : -1;
        if (row == col) {
            posDiag += multiplayer;
            if (Math.abs(posDiag) == n) return player;
        }

        if (row + col == n-1) {
            negDiag += multiplayer;
            if (Math.abs(negDiag) == n) return player;
        }

        rows[row] += multiplayer;
        if (Math.abs(rows[row]) == n) {
            return player;
        }

        cols[col] += multiplayer;
        if (Math.abs(cols[col]) == n) {
            return player;
        }

        return 0;
    }
}
