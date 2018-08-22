package collections;

public class HashSetImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSetArray set=new HashSetArray(10);
		set.add("netra");
		set.add("patel");
		set.add("agrawal");
		set.add("sagar");
		set.add("patel");
		System.out.println(set);
	}

}

class HashSetArray{
	
	class Node{
		Node next;
		Object item;
		
	}
	
	Node[] bucket;
	int size;
	public HashSetArray(int capacity) {
		// TODO Auto-generated constructor stub
		bucket=new Node[capacity];
	}
	
	public int hashFunction(int hashcode){
		int index=hashcode;
		if(index<0)
			index=-index;
		return index%bucket.length;
	}
	
	public boolean add(Object ele){
		int index=hashFunction(ele.hashCode());
		Node temp=bucket[index];
		while(temp!=null){
			if(temp.item.equals(ele))
				return false;
			temp=temp.next;
		}
		Node n=new Node();
		n.item=ele;
		n.next=bucket[index];
		bucket[index]=n;
		size++;
		return true;
	}
	
	public boolean contains(Object ele){
		int index=hashFunction(ele.hashCode());
		Node temp=bucket[index];
		while(temp!=null){
			if(temp.item.equals(ele))
				return true;
			temp=temp.next;
		}
		return false;
	}
	
	public boolean remove(Object ele){
		int index=hashFunction(ele.hashCode());
		Node temp=bucket[index];
		Node prev=null;
		while(temp!=null){
			if(temp.item.equals(ele)){
				if(prev==null)
					bucket[index]=temp.next;
				else
					prev.next=temp.next;
				size--;
				return true;
			}
			prev=temp;
			temp=temp.next;
		}
		return false;
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<bucket.length;i++){
			if(bucket[i]!=null){
				Node temp=bucket[i];
				sb.append("["+i+"]");
				sb.append(temp.item.toString());
				while(temp.next!=null){
					temp=temp.next;
					sb.append("->"+temp.item.toString());
				}
				sb.append("\n");
			}
		}
		
		
		return sb.toString();
	}
}
