package collections;
import java.util.*;
public class StackImplementation {

	public static void main(String args[]){
		StackArray<Integer> o=new StackArray<>();
		o.push(1);
		o.push(2);
		o.push(3);
		o.pop();
		o.push(5);
		System.out.println(o.size());
		
		StackLinkedList<String> o1=new StackLinkedList<>();
		o1.push("netra");
		o1.push("agrawal");
		o1.pop();
		o1.push("patel");
		System.out.println(o1);
		
	}

}

class StackArray<T>{
	T[] arr;
	int total;
	
	public StackArray() {
		// TODO Auto-generated constructor stub
		arr=(T[]) new Object[5];
	}
	
	public void push(T element){
		if(total==arr.length)
			resize(arr.length*2);
		arr[total++]=element;
		
	}
	
	public void resize(int size){
		T[] temp=(T[])new Object[size];
		
	}
	
	public T pop(){
		if(total==0)
			throw new java.util.NoSuchElementException();
		T temp=arr[--total];
		arr[total]=null;
		return temp;
	}
	
	public int size(){
		return total;
	}
	
	public String toString(){
		return Arrays.toString(arr);
	}
	 
}

class StackLinkedList<T>{
	
	class ListNode{
		ListNode next;
		T ele;
		
		ListNode(T ele){
			this.ele=ele;
		}
	}
	
	ListNode top;
	int total;
	
	public void push(T ele){
		ListNode next=top;
		top=new ListNode(ele);
		top.next=next;
		total++;
	}
	
	public T pop(){
		if(top==null)
			throw new NoSuchElementException();
		T temp=top.ele;
		top=top.next;
		total--;
		return temp;
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		ListNode dummy=top;
		while(dummy!=null){
			sb.append(dummy.ele).append(",");
			dummy=dummy.next;
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
}
