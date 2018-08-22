package collections;

import java.util.Arrays;

public class ArrayListImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayListUsingArray<Integer> list=new ArrayListUsingArray<>();
		list.add(2);
		list.add(5);
		list.add(0);
		list.add(-1);
		list.get(0);
		//list.get(4);
		list.get(3);
		list.remove(3);
		
	}

}

class ArrayListUsingArray<T>{
	
	T[] arr;
	int total;
	
	public ArrayListUsingArray() {
		// TODO Auto-generated constructor stub
		arr=(T[])new Object[10];
	}
	
	public void add(T ele){
		if(total==arr.length)
			resize();
		arr[total++]=ele;
	}
	
	public void resize(){
		T[] temp=Arrays.copyOf(arr, arr.length*2); 
		arr=temp;
	}
	
	public T get(int i){
		if(i<0 || i>=total)
			throw new IndexOutOfBoundsException();
		return arr[i];
	}
	
	public int size(){
		return total;
	}
	
	public boolean contains(T ele){
		for(int i=0;i<total;i++){
			if(arr[i]==ele)
				return true;
		}
		return false;
	}
	
	public String toString(){
		return Arrays.toString(arr);
	}
	
	public T remove(int i){
		if(i<0 || i>=total)
			throw new IndexOutOfBoundsException();
		T temp=arr[i];
		while(i<total){
			arr[i]=arr[i+1];
			i++;
		}
		total--;
		return temp;
	}
}
