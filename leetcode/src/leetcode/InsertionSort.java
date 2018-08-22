package leetcode;

public class InsertionSort {
	
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(4);
		head.next=new ListNode(1);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(2);
		System.out.println(insertionSortList(head));
	}
	
	public static ListNode insertionSortList(ListNode head) {
        
        if(head==null){
            return null;
        }
        
        ListNode dummy=new ListNode(0);
        ListNode pre=dummy;
        ListNode node=head;
        ListNode next=null;
        
        while(node!=null){
            next=node.next;
            
            while(pre.next!=null && pre.next.val<node.val){
                pre=pre.next;
            }
            
            node.next=pre.next;
            pre.next=node;
            pre=dummy;
            node=next;
        }
        return pre.next;
    }

}
