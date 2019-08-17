package range_40_60;
import java.util.*;

/**
 * 数组，找规律
 */
public class No56_MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
    	 if(intervals==null || intervals.size()<1)
             return intervals;
        sort(intervals, 0, intervals.size()-1);
        List<Interval> newIntervals = new ArrayList<Interval>();
        newIntervals.add(intervals.get(0));
        for(int i=1; i<intervals.size(); i++){
        	if(newIntervals.get(newIntervals.size()-1).end >= intervals.get(i).start){
        		if(newIntervals.get(newIntervals.size()-1).end >= intervals.get(i).end)
        			continue;
        		else
        			newIntervals.set(newIntervals.size()-1,new Interval(newIntervals.get(newIntervals.size()-1).start, intervals.get(i).end));
        		//newIntervals.add(new Interval(newIntervals.get(newIntervals.size()-1).start, intervals.get(i).end));
        	}
        	else{
        		newIntervals.add(intervals.get(i));
        	}
        }
        return newIntervals;
    }
    
    public List<Interval> sort(List<Interval> intervals, int low, int high){
    	 Interval key = intervals.get(low);
    	 int l = low;
    	 int h = high;
    	 while(low < high){
    		 while(low<high && (intervals.get(high).start>key.start || intervals.get(high).start==key.start&&intervals.get(high).end>key.end)){
    			 high--;
    		 }
    		 if(low < high){
    			 swap(intervals, low, high);
    			 low++;
    		 }
    			 
    		 while(low<high && (intervals.get(low).start<key.start || intervals.get(low).start==key.start&&intervals.get(low).end<key.end)){
    			 low++;
    		 }
    		 if(low < high){
    			 swap(intervals, low, high);
    			 high--;
    		 }
    			
    	 }
    	 if(l < low){
    		 sort(intervals, l, low-1);
    	 }
    	 if(h > high){
    		 sort(intervals, high+1, h);
    	 }
    	 return intervals;
    }
    
    public void swap(List<Interval> intervals, int low, int high){
    	Interval temp = intervals.get(low);
    	intervals.set(low, intervals.get(high));
    	intervals.set(high, temp);
    }
    
    public static void main(String[] args){
    	List<Interval> list = new ArrayList<Interval>();
    	list.add(new Interval(2, 3));
    	list.add(new Interval(5, 5));
    	list.add(new Interval(2, 2));
    	list.add(new Interval(3, 4));
    	list.add(new Interval(3, 4));
    	new No56_MergeIntervals().merge(list);
    }
}

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}