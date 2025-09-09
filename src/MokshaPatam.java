/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Amay Srinivasan
 *
 */
import java.util.LinkedList;
public class MokshaPatam {

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        // I'm thinking either move 6 or take a ladder, and then branch out from there and test each of the options
        // One thing to remember is that if they meet up on a square, say square 30, and one branch is move 5 and one is move 6
        // You can already eliminate one of them.
        int[] teleport = new int[boardsize + 1];
        for (int i = 0; i<= boardsize; i++) {
            teleport[i] = i;
        }
        for (int i = 0; i < ladders.length; i++) {
            int from = ladders[i][0];
            int to = ladders[i][1];
            teleport[from] = to;
        }
        for (int i = 0; i < snakes.length; i++) {
            int from = snakes[i][0];
            int to = snakes[i][1];
            teleport[from] = to;
        }
        boolean[]visited = new boolean[boardsize + 1];
        visited[1] = true;
        LinkedList<int[]> queue = new LinkedList <>();
        queue.add(new int[]{1,0});
        while (!queue.isEmpty()) {
            int[] current = queue.remove(0);
            int position = current[0];
            int moves = current[1];
            if (position == boardsize) {
                return moves;
            }
            for (int diceRoll = 1; diceRoll < 7; diceRoll++) {
                int nextSpot = position + diceRoll;
                if (nextSpot <= boardsize) {
                    int finalSquare = teleport[nextSpot];
                    if(!visited[finalSquare]) {
                        visited[finalSquare] = true;
                        queue.add(new int[]{finalSquare, moves + 1});
                    }
                }
            }
        }




        return -1;
    }
}
