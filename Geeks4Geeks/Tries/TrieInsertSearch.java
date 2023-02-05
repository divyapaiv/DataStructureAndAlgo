//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Trie {
    static int ALPHABATE_SIZE = 26;

    // trie node
    static class TrieNode {
        TrieNode children[] = new TrieNode[ALPHABATE_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;
        // Returns new trie node (initialized to NULLs)
        public TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABATE_SIZE; i++) {
                children[i] = null;
            }
        }
    };
    static TrieNode root;

    
// } Driver Code Ends


//Function to insert string into TRIE.
static void insert(String key) 
{
    TrieNode cur=root; 
    for(int i=0;i<key.length();i++){
        int index = key.charAt(i)-'a';
        if(cur.children[index]==null)
            cur.children[index]= new TrieNode(); 
        cur=cur.children[index]; 
    }
    cur.isEndOfWord=true; 
    
}

//Function to use TRIE data structure and search the given string.
static boolean search(String key)
{
  TrieNode cur=root; 
    for(int i=0;i<key.length();i++){
        int index = key.charAt(i)-'a';
         if(cur.children[index]==null) return false; 
         cur=cur.children[index];
    }
    return(cur.isEndOfWord);
}


//{ Driver Code Starts.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            String key[] = new String[n];

            for (int i = 0; i < n; i++) key[i] = sc.next();

            root = new TrieNode();

            for (int i = 0; i < n; i++) {
                insert(key[i]);
            }
            while (q-- > 0) {
                String str = sc.next();
                if (search(str) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
}
// } Driver Code Ends
