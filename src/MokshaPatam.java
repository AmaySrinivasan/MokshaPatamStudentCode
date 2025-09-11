/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 * <p>
 * Completed by: Amay Srinivasan
 */

import java.util.LinkedList;

public class MokshaPatam {

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    // Function to calculate and return the fewest number of dice rolls to traverse to the last square of the board
    // Provided a set of ladders/snakes and starting from first square, use BFS
    // Explore all possible routes and find the fewest moves
    // If it is unreachable, return -1
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        // Creates a map array that maps each square to the position a player would land on
        int[] mapPosition = new int[boardsize + 1];
        // Starts off with each square mapping to itself (without ladders or snakes)
        for (int i = 0; i <= boardsize; i++) {
            mapPosition[i] = i;
        }
        // Adding ladders into the map array
        // Each ladder has a start and end, so if a player lands on start (from), they go to (to)
        for (int i = 0; i < ladders.length; i++) {
            int from = ladders[i][0];
            int to = ladders[i][1];
            mapPosition[from] = to;
        }
        // Adding snakes into the map array
        // Each snake has a start and end, so if a player lands on start (from), they go to (to)
        for (int i = 0; i < snakes.length; i++) {
            int from = snakes[i][0];
            int to = snakes[i][1];
            mapPosition[from] = to;
        }
        // Array to track which squares have already been visited
        boolean[] visited = new boolean[boardsize + 1];
        // Start at square 1, so already marked as visited
        visited[1] = true;
        // Creating a queue that stores pairs of (square, moves), for the current position
        // and num of moves to reach that position
        LinkedList<int[]> queue = new LinkedList<>();
        // Adding the starting point (square 1, no moves)
        queue.add(new int[]{1, 0});
        // Performs BFS
        while (!queue.isEmpty()) {
            // Gets the current position and the number of moves from queue
            int[] current = queue.remove(0);
            int position = current[0];
            int moves = current[1];
            // If we have reached the final square, return the number of moves taken
            if (position == boardsize) {
                System.out.println(moves);
                return moves;
            }
            // Loop all possible dice rolls from 1-6
            for (int diceRoll = 1; diceRoll <= 6; diceRoll++) {
                // Calculate next square the roll would land on
                int nextSpot = position + diceRoll;
                // Check if that next square is within the board
                if (nextSpot <= boardsize) {
                    // If it is, use the map to check if ladder/snake/nothing and teleport/remain to/in correct square
                    int finalSquare = mapPosition[nextSpot];
                    // If we haven't visited the final square, mark as visited and add to queue
                    if (!visited[finalSquare]) {
                        visited[finalSquare] = true;
                        queue.add(new int[]{finalSquare, moves + 1});
                    }
                }
            }
        }
        // If we've gone through the queue and haven't reached final square return -1
        // Because this means the final square can't be reached in this map
        return -1;
    }
}
