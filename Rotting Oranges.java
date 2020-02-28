class Solution {
    private static final int ROTTEN = 2;
    private static final int FRESH = 1;
    
    public int orangesRotting(int[][] grid) {
        
        int[][] DIRS= {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<Point> qu = new ArrayDeque<>();
        
        int r = 0;//# rotten
        int f = 0;//# fresh
        //adding the rotten oranges to the queue and also counting no of rotten and fresh oranges
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == ROTTEN){
                    qu.add(new Point(i, j));
                    r++;
                }
                else if(grid[i][j] == FRESH)
                    f++;
            }
        }
        
        if(f == 0)
            return 0;
        
        int minute;
        for(minute = 1; !qu.isEmpty(); minute++){
            
            int size = qu.size();
            //size keeps track of the initial rotten oranges and then next and so on
            while(size > 0){
                //poll rotten orange
                Point p = qu.poll();
                //traverse all four directions
                for(int[] dir : DIRS){
                    int x = p.i + dir[0];
                    int y = p.j + dir[1];
                    
                    if( x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == FRESH){
                        
                        f--;
                        if(f == 0)
                            return minute;
                        grid[x][y] = ROTTEN;
                        qu.add(new Point(x, y));
                    }
                }
                size--;
            }
        }
        return f == 0 ? minute : -1;
    }
    //class to note the position of a rotten or fresh orange
    private static class Point{
        int i;
        int j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}