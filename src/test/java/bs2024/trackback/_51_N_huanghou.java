package bs2024.trackback;

import java.util.ArrayList;
import java.util.List;

public class _51_N_huanghou {
    public static void main(String[] args) {
        _51_N_huanghou instance = new _51_N_huanghou();
        System.out.println(instance.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        boolean[][] states = new boolean[n][n];
        List<List<String>> retList = new ArrayList();

        backtrack(states,0,retList);

        return retList;


    }

    public void backtrack(boolean[][] states,int rowIdx,List<List<String>> retList){
        if(rowIdx >= states.length){
            assembleRet(states,retList);
        }
        for(int i = 0        ; i < states.length ; i++){
            int x = rowIdx;
            int y = i;
            if(checkRow(states,x,y) && checkCol(states,x,y) && checkX1(states,x,y) && checkX2(states,x,y)){
                states[x][y] = true;
                backtrack(states,rowIdx + 1,retList);
                states[x][y] = false;
            }
        }

        return ;
    }

    public boolean checkRow(boolean[][] states,int x,int y){
        while(x >= 0){
            if(states[x][y]){
                return false;
            }
            x--;
        }
        return true;
    }
    public boolean checkCol(boolean[][] states,int x,int y){
        while(y >= 0){
            if(states[x][y]){
                return false;
            }
            y--;
        }
        return true;
    }
    public boolean checkX1(boolean[][] states,int x,int y){
        while(x >= 0 && y >= 0){
            if(states[x][y]){
                return false;
            }
            x--;
            y--;
        }
        return true;
    }
    public boolean checkX2(boolean[][] states,int x,int y){
        while(x >= 0 && y < states.length){
            if(states[x][y]){
                return false;
            }
            x--;
            y++;
        }
        return true;
    }

    public void assembleRet(boolean[][] states,List<List<String>> retList){
        for(int i = 0 ; i < states.length ; i++){
            List<String> list = new ArrayList();
            for(int j = 0 ; j < states.length ; j++){
                list.add(states[i][j] ? "Q" : ".");
            }
            retList.add(list);
        }
    }
}
