package bs2024.pic;

public class NumIslands {
    public static void main(String[] args) {
        NumIslands instance = new NumIslands();
        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(instance.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ret = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] - '0' == 0 || grid[i][j] - '0'  == 2){
                    continue;
                }
                ret ++;
                dfs(grid,i,j);
            }
        }
        return ret;
    }

    void dfs(char[][] grid , int x,int y){
        if(!inArea(grid,x,y)){
            return;
        }

        if(grid[x][y]  - '0' == 2 || grid[x][y]  - '0' == 0){
            return;
        }

        grid[x][y] = '2';
        dfs(grid,x+1,y);
        dfs(grid,x-1,y);
        dfs(grid,x,y+1);
        dfs(grid,x,y-1);
    }

    boolean inArea(char[][] grid , int x,int y){
        if(x >=0 && x < grid.length && y >=0 && y < grid[0].length){
            return true;
        }
        return false;
    }
}
