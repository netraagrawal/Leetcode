package leetcode;

public class ReverseLLII {
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode root=new ListNode(1);
		root.next=new ListNode(2);
		root.next.next=new ListNode(3);
		root.next.next=new ListNode(4);
		ListNode result=reverseBetween(root, 1, 3);
		
		while(result!=null){
			System.out.print(result.val);
			result=result.next;
		}
		

	}
	 public static ListNode reverseBetween(ListNode head, int m, int n) {
		    
	        if(head==null && (m==0 && n==0)){
	            return null;
	        }
	        ListNode prev=null;
	        ListNode Lasthead=head;
	        ListNode node=head;
	        int c=1;
	        
	        while(node!=null && c!=m){
	            Lasthead=node;
	            node=node.next;
	            c++;
	        }
	        
	        while(node.next!=null && c<=n){
	            ListNode next=node.next;
	            node.next=prev;
	            prev=node;
	            node=next;
	            c++;
	        }
	        
	        if(Lasthead!=null){
	            while(Lasthead.next!=null){
	                Lasthead=Lasthead.next;
	            }
	            Lasthead.next=node;
	        }
	        else{
	            Lasthead=prev;
	            head=prev;
	        }
	        
	        return head;
	    
	    }

}
