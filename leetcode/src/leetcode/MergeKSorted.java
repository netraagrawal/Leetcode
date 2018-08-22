package leetcode;
import java.util.*;

import leetcode.InsertionSort.ListNode;
public class MergeKSorted {

	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		ListNode head1=new ListNode(2);
		head1.next=new ListNode(2);
		ListNode head2=new ListNode(1);
		head2.next=new ListNode(5);
		head2.next.next=new ListNode(6);
		ListNode[] list={head,head1,head2};
		System.out.println(mergeKLists(list));
		
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
	        
	        ListNode first=new ListNode(0);
	        if(lists.length==0){
	            return null;
	        }
	        Queue<ListNode> que=new PriorityQueue<ListNode>(new Comparator<ListNode>(){
	            public int compare(ListNode a,ListNode b){
	                return a.val-b.val;
	            }
	        });
	        for(int i=0;i<lists.length;i++){
	            if(lists[i]!=null){
	                que.offer(lists[i]);
	            }
	        }
	        ListNode root=first;
	        while(!que.isEmpty()){
	            ListNode temp=que.poll();
	            if(temp.next!=null){
	                que.offer(temp.next);
	            }
	            if(temp!=null){
	                root.next=new ListNode(temp.val);
	                root=root.next;
	            }
	        }
	        return first.next;
	    }

}
