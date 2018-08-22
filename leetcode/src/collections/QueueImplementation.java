package collections;
import java.nio.channels.IllegalSelectorException;
import java.util.*;

import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
public class QueueImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueLinkedList<Integer> que=new QueueLinkedList<>();
		que.offer(1);
		que.offer(2);
		int e=que.poll();
		System.out.println(e);
		que.offer(5);
		que.offer(10);
		System.out.println(que);
		
		QueueArray<Integer> que1=new QueueArray<>(4);
		que1.offer(2);
		que1.offer(1);
		que1.poll();
		que1.offer(0);
		que1.offer(5);
	}

}

class QueueLinkedList<T>{
	
	class ListNode{
		T ele;
		ListNode next;
		ListNode prev;
		ListNode(T ele){
			this.ele=ele;
		}
		ListNode(){
			
		}
	}
	
	ListNode head,tail;
	int total;
	public QueueLinkedList() {
		// TODO Auto-generated constructor stub
		head=new ListNode();
		tail=new ListNode();
		head.next=tail;
		head.prev=null;
		tail.next=null;
		tail.prev=head;
	}
	public void offer(T ele){
		ListNode cur=new ListNode(ele);
		cur.next=head.next;
		head.next.prev=cur;
		cur.prev=head;
		head.next=cur;
		total++;
	}
	
	public T poll(){
		if(total==0)
			throw new NoSuchElementException();
		ListNode temp=tail.prev;
		tail.prev=temp.prev;
		temp.prev.next=tail;
		total--;
		return temp.ele;
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		ListNode cur=head.next;
		while(cur.next!=null){
			sb.append(cur.ele).append(",");
			cur=cur.next;
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
}

class QueueArray<T>{
	
	T[] arr;
	int total,front,rear;
	int capacity;
	
	QueueArray(int cap){
		capacity=cap;
		front=0;
		rear=0;
		arr=(T[]) new Object[capacity];
	}
	
	public boolean isEmpty(){
		return total==0;
	}
	
	public boolean isFull(){
		return total==capacity;
	}
	
	public void offer(T ele){
		if(isFull())
			throw new IllegalStateException();
		rear=(rear+1)%capacity;
		arr[rear]=ele;
		total++;
	}
	
	public T poll(){
		if(isEmpty())
			throw new NoSuchElementException();
		front=(front+1)%capacity;
		T temp=arr[front];
		total--;
		return temp;
	}
	
}
