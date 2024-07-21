package bs2024.pic;

class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for(int i = 0 ; i < chars.length ; i++){
            if(node.children[chars[i] - 'a'] == null){
                node.children[chars[i] - 'a'] = new TrieNode();
            }
            node = node.children[chars[i] - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for(int i = 0 ; i < chars.length ; i++){
            if(node.children[chars[i] - 'a'] == null){
                return false;
            }
            node = node.children[chars[i] - 'a'];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        char[] chars = prefix.toCharArray();
        for(int i = 0 ; i < chars.length ; i++){
            if(node.children[chars[i] - 'a'] == null){
                return false;
            }
            node = node.children[chars[i] - 'a'];
        }
        return true;
    }
}
public class TireTest{
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        System.out.println(obj.search("apple"));
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("app"));
        obj.insert("app");
        System.out.println(obj.search("app"));
    }
}
