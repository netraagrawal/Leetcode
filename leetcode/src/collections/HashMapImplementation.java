package collections;
import java.util.*;
import javafx.util.*;
public class HashMapImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMapArray<Integer,String> map=new HashMapArray<>(10);
		map.put(2, "netra");
		map.put(3, "raj");
		System.out.println(map.get(3));
		map.remove(3);
		map.put(2, "agrawal");
		System.out.println(map.get(2));
	}

}

class HashMapArray<K,V>{
	
	List<Pair<K,V>>[] entry;
	int size;
	@SuppressWarnings("unchecked")
	public HashMapArray(int capacity) {
		// TODO Auto-generated constructor stub
		entry=(List<Pair<K,V>>[])new ArrayList[capacity];
	}
	
	public int hashFunction(K key){
		int code=key.hashCode();
		if(code<0)
			code=-code;
		return code%entry.length;
		
	}
	
	public int getPos(K key,int index){
		List<Pair<K,V>> list=entry[index];
		if(list==null)
			return -1;
		for(int i=0;i<list.size();i++){
			if(list.get(i).getKey().equals(key))
				return i;
		}
		return -1;
	}
	
	public void put(K key,V value){
		int index=hashFunction(key);
		int pos=getPos(key,index);
		if(pos<0){
			Pair<K,V> p=new Pair<>(key,value);
			if(entry[index]==null)
				entry[index]=new ArrayList<>();
			entry[index].add(p);
			size++;
		}
		else
			entry[index].set(pos, new Pair<>(key,value));
		
	}
	
	public V get(K key){
		int index=hashFunction(key);
		int pos=getPos(key,index);
		if(pos<0)
			return null;
		else
			return entry[index].get(pos).getValue();
	}
	
	public void remove(K key){
		int index=hashFunction(key);
		int pos=getPos(key, index);
		if(pos<0)
			return;
		entry[index].remove(pos);
		size--;
	}
	
	public int size(){
		return size;
	}
	
}
