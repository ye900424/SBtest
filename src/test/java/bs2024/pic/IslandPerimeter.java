package bs2024.pic;

public class IslandPerimeter {
    public static void main(String[] args) {
        IslandPerimeter instance = new IslandPerimeter();
//        int[][] grid = new int[][]{{'0','1','0','0'},{'1','1','1','0'},{'0','1','0','0'},{'1','1','0','0'}};
        int[][] grid = new int[][]{{'1','0'}};
        System.out.println(instance.islandPerimeter(grid));
    }

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ret = 0;

        for(int i = 0 ; i < m ;i++){
            for(int j = 0 ; j < n ;j++){
                ret += dfs(grid,i,j);
            }
        }
        return ret;

    }

    int dfs(int[][] grid,int x,int y){
        if(!inArea(grid,x,y)){
            return 0;
        }

        if(grid[x][y] - '0' == 0 || grid[x][y] - '0' == 2){
            return 0;
        }
        grid[x][y] = '2';
        int len = getLen(grid,x,y);
        len += dfs(grid,x+1,y);
        len += dfs(grid,x-1,y);
        len += dfs(grid,x,y+1);
        len += dfs(grid,x,y-1);

        return len;
    }

    int getLen(int[][] grid,int x,int y){
        int len = 0;
        if(x == 0 || grid[x-1][y] - '0' == 0){
            len++;
        }
        if(x == grid.length - 1 || grid[x+1][y] - '0' == 0){
            len++;
        }
        if(y == 0 || grid[x][y-1] - '0' == 0){
            len++;
        }
        if(y == grid[0].length - 1 || grid[x][y+1] - '0' == 0){
            len++;
        }
        return len;
    }

    boolean inArea(int[][] grid,int x,int y){
        return x >=0 && x < grid.length && y>=0 && y<grid[0].length;
    }
}
