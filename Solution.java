import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void topView(Node root) {
        class QueueObj{
            Node node;
            int hd;
            QueueObj(Node node,int hd){
                this.node = node;
                this.hd = hd;
            }
        }
        if(root==null)
            return;
        TreeMap<Integer,Integer> m = new TreeMap<Integer,Integer>();
        Queue<QueueObj> q = new LinkedList<QueueObj>();
        q.add(new QueueObj(root,0));
        while(!q.isEmpty()){
            QueueObj temp = q.remove();
            if(m.get(temp.hd) == null){
                m.put(temp.hd, temp.node.data);
            }
            if(temp.node.left!=null){
                q.add(new QueueObj(temp.node.left,temp.hd-1));
            }
            if(temp.node.right!=null){
                q.add(new QueueObj(temp.node.right,temp.hd+1));
            }
        } 
        for (Map.Entry hmap:m.entrySet()) 
          System.out.print(hmap.getValue()+" "); 
    } 

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}
