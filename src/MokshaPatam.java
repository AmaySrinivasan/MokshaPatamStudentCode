/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Amay Srinivasan
 *
 */

public class MokshaPatam {

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        // I'm thinking either move 6 or take a ladder, and then branch out from there and test each of the options
        // One thing to remember is that if they meet up on a square, say square 30, and one branch is move 5 and one is move 6
        // You can already eliminate one of them.
        Queue<Integer> positions = new LinkedList<>();
        Queue<Integer> moves = new LinkedList<>();
        // Use the bfs stuff based on what we learned earlier. just need to work towards more efficiency.
        // Deleted a lot of bad code

        return 0;
    }
}
