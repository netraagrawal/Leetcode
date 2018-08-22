package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ComponentsInLinkedList {
	
	static class Node{
		int val;
		Node next;
		Node(int x) { val = x; }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n=new Node(5);
		Node n2=new Node(3);
		Node n3=new Node(2);
		Node n4=new Node(8);
		Node n5=new Node(9);
		Node n6=new Node(1);
		n.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		Node[] nn=new Node[]{n3,n2,n4,n6};
		System.out.println(calculate(nn));
	}
	
	public static int calculate(Node[] nodes){
		int count=0;
		Set<Node> val=new HashSet<>();
		Set<Node> result=new HashSet<>();
		for(int i=0;i<nodes.length;i++){
			val.add(nodes[i]);
		}
		for(int i=0;i<nodes.length;i++){
			Node temp=nodes[i];
			if(result.contains(temp)){
				continue;
			}
			if(result.contains(temp.next)){
				result.add(temp);
				continue;
			}
			result.add(temp);
			count++;
			while(val.contains(temp.next)){
				result.add(temp.next);
				temp=temp.next;
			}
		}
		return count;
	}
}
