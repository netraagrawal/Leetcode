package Strings;
import java.util.*;
public class SmallestRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> input=new ArrayList<>();
		input.add(new ArrayList<>(Arrays.asList(4,10,15,24,26)));
		input.add(new ArrayList<>(Arrays.asList(0,9,12,20)));
		input.add(new ArrayList<>(Arrays.asList(5,18,22,30)));
		
		int[][] input2={{4,10,15,24,26},{0,9,12,20},{5,18,22,30}};
		smallestRange(input);
	}
	
	/*public static int[] smallestRange(int[][] nums) {
		PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>() {
			public int compare(Element a, Element b) {
				return a.val - b.val;
			}
		});
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			Element e = new Element(i, 0, nums[i][0]);
			pq.offer(e);
			max = Math.max(max, nums[i][0]);
		}
		int range = Integer.MAX_VALUE;
		int start = -1, end = -1;
		while (pq.size() == nums.length) {

			Element curr = pq.poll();
			if (max - curr.val < range) {
				range = max - curr.val;
				start = curr.val;
				end = max;
			}
			if (curr.idx + 1 < nums[curr.row].length) {
				curr.idx = curr.idx + 1;
				curr.val = nums[curr.row][curr.idx];
				pq.offer(curr);
				if (curr.val > max) {
					max = curr.val;
				}
			}
		}

		return new int[] { start, end };
	}

	static class Element {
		int val;
		int idx;
		int row;

		public Element(int r, int i, int v) {
			val = v;
			idx = i;
			row = r;
		}
	}*/
	
	static class Element{
        int col;
        int row;
        int val;
        Element(int col,int row,int val){
            this.col=col;
            this.row=row;
            this.val=val;
        }
    }
	
	public static int[] smallestRange(List<List<Integer>> nums) {
        if(nums.size()==0)
            return new int[]{};
        Queue<Element> que=new PriorityQueue<Element>(new Comparator<Element>(){
           public int compare(Element e1,Element e2){
                return e1.val-e2.val;
           }
              
        });
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++){
            Element e=new Element(0,i,nums.get(i).get(0));
            que.offer(e);
            max=Math.max(max,e.val);
        }
        int start=-1,end=-1,range=Integer.MAX_VALUE;
        while(que.size()==nums.size()){
            Element e=que.poll();
            if(max-e.val<range){
                range=max-e.val;
                start=e.val;
                end=max;
            }
            if(e.col+1<nums.get(e.row).size()){
                e.col=e.col+1;
                e.val=nums.get(e.row).get(e.col);
                que.offer(e);
                
                if(max<e.val)
                    max=e.val;
            }
        }
        return new int[]{start,end};
    }

}
