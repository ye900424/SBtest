package bs2024.trackback;

import java.util.ArrayList;
import java.util.List;

public class _93_restoreIpAddresses {
    public static void main(String[] args) {
        _93_restoreIpAddresses instance = new _93_restoreIpAddresses();
        String s = "00010";
        System.out.println(instance.restoreIpAddresses(s));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList();
        List<Integer> cutIdxList = new ArrayList();
        cutIdxList.add(0);
        int idx = 0;

        addIpStr(s,ret,idx,cutIdxList);
        return ret;

    }

    public void addIpStr(String s,List<String> ret,int idx,List<Integer> cutIdxList){
        if(s.length() - idx <= 0){
            return;
        }

        if(cutIdxList.size() == 4){
            if(s.length() - idx > 3){
                return;
            }
            String lastStr = s.substring(idx,s.length());
            if(isLegal(lastStr)){
                cutIdxList.add(s.length());
                ret.add(buildRet(s,cutIdxList));
                cutIdxList.remove(cutIdxList.size() - 1);
            }
            return;
        }

        for(int i = 1; i <= 3; i++){
            if(s.length() - idx >= i && isLegal(s.substring(idx,idx + i))){
                cutIdxList.add(idx + i);
                addIpStr(s,ret,idx + i,cutIdxList);
                cutIdxList.remove(cutIdxList.size() - 1);
            }
        }
    }

    private boolean isLegal(String subStr){
        if(subStr.length() > 1 && subStr.startsWith("0")){
            return false;
        }
        int temp = Integer.parseInt(subStr);
        if(temp > 255){
            return false;
        }

        return true;
    }

    private String buildRet(String s, List<Integer> cutIdxList){
        String ret = "";
        for(int i = 0 ; i<cutIdxList.size() - 1;i++){
            ret += s.substring(cutIdxList.get(i),cutIdxList.get(i+1));
            ret += ".";
        }
        return ret.substring(0,ret.length()-1);
    }
}
