class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        int res = m * n  - guards.length - walls.length;
        for(int i = 0; i < walls.length; i++) {
            grid[walls[i][0]][walls[i][1]] = 1;
        }
        for(int i = 0; i < guards.length; i++) {
            grid[guards[i][0]][guards[i][1]] = 2;
        }

        for(int[] g : guards) {
            res -= fill(grid, g);
        }




        return res;
    }
    int fill(int[][] grid, int[] g) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dest = {{-1, 0},{0,1},{1, 0}, {0, -1}};
        for(int[] d : dest) {
            int i = g[0];
            int j = g[1];
            while(i + d[0] < m && i + d[0] >= 0 && j + d[1] < n && j + d[1] >=0 && grid[i + d[0]][j + d[1]] != 1 && grid[i + d[0]][j + d[1]] != 2 ) {
                if(grid[i + d[0]][j + d[1]] == 0) {
                    count++;
                }
                grid[i + d[0]][j + d[1]] = 3;
                i += d[0];
                j += d[1];
            }
        }

        return count;
    }
}