package bs2024.tree;

public class _96_numTrees_ {

    public static void main(String[] args) {
        _96_numTrees_ instance = new _96_numTrees_();
        System.out.println(instance.numTrees(3));
    }

    public int numTrees(int n) {
        if(n <= 1){
            return 1;
        }
        int[] states = new int[n +1];
        states[0] = 1;
        states[1] = 1;

        for(int i = 2 ; i <= n; i++){
            for(int j = 1 ; j <= i; j++){
                states[i] += states[j-1]*states[i-j];
            }
        }

        return states[n];
    }
}
