package leetcode;

import leetcode.ComponentsInLinkedList.Node;

public class FlattenDoublyLinkedList {

	static class Node{
		int val;
		Node next;
		Node prev;
		Node child;
		Node(int x,Node prev,Node next,Node child) { 
			val = x; 
			next=next;
			prev=prev;
			child=child;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n=new Node(1,null,null,null);
		Node n2=new Node(2,n,null,null);
		Node n3=new Node(3,n2,null,null);
		Node n4=new Node(4,n3,null,null);
		Node n5=new Node(5,n4,null,null);
		
		Node n6=new Node(7,null,null,null);
		Node n7=new Node(8,null,null,null);
		Node n8=new Node(9,null,null,null);
		
		Node n9=new Node(11,null,null,null);
		Node n10=new Node(12,null,null,null);
		
		n.next=n2;
		n2.next=n3;
		n2.prev=n;
		n3.next=n4;
		n3.prev=n2;
		n3.child=n6;
		n4.next=n5;
		n4.prev=n3;
		n5.prev=n4;
		
		n6.next=n7;
		n7.prev=n6;
		n7.next=n8;
		n7.child=n9;
		n8.prev=n7;
		
		n9.next=n10;
		n10.prev=n9;
		
		Node h=flatten(n);
	}
	
	public static Node flatten(Node head) {
        if(head==null)
            return head;
        
        Node temp=head;
        Node child=null;
        while(temp!=null){
            if(temp.child!=null){
                child=flatten(temp.child);
                Node next=temp.next;
                temp.next=child;
                temp.child=null;
                child.prev=temp;
                while(child.next!=null)
                	child=child.next;
                child.next=next;
                next.prev=child;
            }
            temp=temp.next;
        }
        return head;
    }

}
