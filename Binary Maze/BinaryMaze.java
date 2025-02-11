import java.util.*;

public class BinaryMaze {

    static int ROW, COL;

    static class Location {
        int row, col;
        int dist;

        Location(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    
    static boolean isValid(int row, int col, int[][] maze) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && maze[row][col] == 1;
    }

    
    static int shortestPath(int[][] maze, Location src, Location dest) {
        
        if (!isValid(src.row, src.col, maze) || !isValid(dest.row, dest.col, maze)) {
            return -1;
        }

        
        boolean[][] visited = new boolean[ROW][COL];
        visited[src.row][src.col] = true;

        
        Queue<Location> queue = new LinkedList<>();
        queue.add(src);

        
        while (!queue.isEmpty()) {
            Location curr = queue.poll();

            
            if (curr.row == dest.row && curr.col == dest.col) {
                return curr.dist;
            }

            
            int[] rows = {-1, 0, 1, 0};
            int[] cols = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int row = curr.row + rows[i];
                int col = curr.col + cols[i];

                
                if (isValid(row, col, maze) && !visited[row][col]) {
                    visited[row][col] = true;
                    queue.add(new Location(row, col, curr.dist + 1));
                }
            }
        }

        
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        ROW = scanner.nextInt();
        COL = scanner.nextInt();
        int testCases = scanner.nextInt();

        
        int[][] maze = new int[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }

        
        for (int i = 0; i < testCases; i++) {
            int srcRow = scanner.nextInt();
            int srcCol = scanner.nextInt();
            int destRow = scanner.nextInt();
            int destCol = scanner.nextInt();

            Location src = new Location(srcRow, srcCol, 0);
            Location dest = new Location(destRow, destCol, 0);

            int shortest = shortestPath(maze, src, dest);
            System.out.println(shortest);
        }

        scanner.close();
    }
}
