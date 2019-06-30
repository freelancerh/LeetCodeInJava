package range_40_60;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 分情况来分析问题
 * 假设新区间的start为nstart,end为nend
 * 区间集合最校的start为ostart，最大的end为oend
 * 1, nstart<=ostart&&nend>=oend
 * 2, nstart>oend
 * 3, nend<ostart
 * 4, nstart<=ostart&&nend<oend
 * 5, nstart>ostart&&nend>=oend
 * 6, nstart>ostart&&nend<oend(这里又要分几个情况)
 * 此题分析不难，但是要仔细，调试起来会出现各种问题*/

public class No57_InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	if(intervals==null || newInterval==null)
    		return intervals;
    	if(intervals.size() < 1){
    		intervals.add(newInterval);
    		return intervals;
    	}	
        Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if(o1.start<o2.start || o1.start==o2.start&&o1.end<o2.end)
					return -1;
				else if(o1.start>o2.start || o1.start==o2.start&&o1.end>o2.end)
					return 1;
				return 0;
			}
        });
        List<Interval> newIntervals = new ArrayList<Interval>();
        boolean foundStart = false;
        boolean foundEnd = false;
        int startIndex = 0;
        int endIndex = 0;
        for(int i=0; i<intervals.size(); i++){
        	if(!foundStart){
            	if(intervals.get(i).start<=newInterval.start && intervals.get(i).end>=newInterval.start){
            		startIndex = i;
            		foundStart = true;
            	}
        	}
        	if(!foundEnd){
            	if(intervals.get(i).start<=newInterval.end && intervals.get(i).end>=newInterval.end){
            		endIndex = i;
            		foundEnd = true;
            		break;
            	}
        	}
        }
        if(!foundStart && !foundEnd){
        	intervals.clear();
        	if(newInterval.end < intervals.get(0).start){
        		intervals.add(0, newInterval);
        	}
        	else{
        		intervals.add(newInterval);
        	}
        	return intervals;
        }
        if(!foundStart){
        	intervals.set(endIndex, new Interval(newInterval.start, intervals.get(endIndex).end));
        	intervals.subList(endIndex, intervals.size());
        	return intervals;
        }
        if(!foundEnd){
        	intervals.set(startIndex, new Interval(intervals.get(startIndex).start, newInterval.end));
        	intervals.subList(0, startIndex+1);
        	return intervals;
        }
        intervals.set(startIndex, new Interval(intervals.get(startIndex).start, intervals.get(endIndex).end));
        for(int i=endIndex-startIndex; i>0; i--){
        	intervals.remove(startIndex+1);
        }
        return intervals;
    }
    
    public List<Interval> insert2(List<Interval> intervals, Interval newInterval){
    	if(intervals==null || newInterval==null)
    		return intervals;
    	if(intervals.size() < 1){
    		intervals.add(newInterval);
    		return intervals;
    	}
        Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if(o1.start<o2.start || o1.start==o2.start&&o1.end<o2.end)
					return -1;
				else if(o1.start>o2.start || o1.start==o2.start&&o1.end>o2.end)
					return 1;
				return 0;
			}
        });
        if(newInterval.start<=intervals.get(0).start && newInterval.end>=intervals.get(intervals.size()-1).end){
        	intervals.clear();
        	intervals.add(newInterval);
        	return intervals;
        }
        if(newInterval.end<intervals.get(0).start){
        	intervals.add(0, newInterval);
        	return intervals;
        }
        if(newInterval.start>intervals.get(intervals.size()-1).end){
        	intervals.add(newInterval);
        	return intervals;
        }
        if(newInterval.start<=intervals.get(0).start){
        	int place = find(intervals, newInterval.end);
        	if(intervals.get(place).end<newInterval.end){
        		intervals.set(place, new Interval(newInterval.start, newInterval.end));
        	}
        	else{
        		intervals.set(place, new Interval(newInterval.start, intervals.get(place).end));
        	}
        	return intervals.subList(place, intervals.size());
        }
        if(newInterval.end>=intervals.get(intervals.size()-1).end){
        	int place = find(intervals, newInterval.start);
        	if(intervals.get(place).end<newInterval.start){
        		intervals.set(place+1, new Interval(newInterval.start, newInterval.end));
        		return intervals.subList(0, place+2);
        	}
        	else{
        		intervals.set(place, new Interval(intervals.get(place).start, newInterval.end));
        		return intervals.subList(0, place+1);
        	}
        }
        int start = find(intervals, newInterval.start);
        int end = find(intervals, newInterval.end);
        if(intervals.get(start).end>=newInterval.start && intervals.get(end).end>=newInterval.end){
        	intervals.set(start, new Interval(intervals.get(start).start, intervals.get(end).end));
        	List<Interval> list = intervals.subList(0, start+1);
        	list.addAll(intervals.subList(end+1, intervals.size()));
        	return list;
        }
        if(intervals.get(start).end<newInterval.start && intervals.get(end).end<newInterval.end){
        	intervals.add(start+1, new Interval(newInterval.start, newInterval.end));
        	List<Interval> list = intervals.subList(0, start+2);
        	list.addAll(intervals.subList(end+2, intervals.size()));
        	return list;
        }
        if(intervals.get(start).end>=newInterval.start && intervals.get(end).end<newInterval.end){
        	intervals.set(start, new Interval(intervals.get(start).start, newInterval.end));
        	List<Interval> list = intervals.subList(0, start+1);
        	list.addAll(intervals.subList(end+1, intervals.size()));
        	return list;
        }
        if(intervals.get(start).end<newInterval.start && intervals.get(end).end>=newInterval.end){
        	intervals.set(start+1, new Interval(newInterval.start, intervals.get(end).end));
        	List<Interval> list = intervals.subList(0, start+2);
        	list.addAll(intervals.subList(end+1, intervals.size()));
        	return list;
        }
        return null;
    }
    
    public int find(List<Interval> intervals, int num){
    	for(int i=0; i<intervals.size(); i++){
    		if(intervals.get(i).start<=num&&intervals.get(i).end>=num || i+1<intervals.size()&&num<intervals.get(i+1).start&&intervals.get(i).end<num){
    			return i;
    		}
    	}
    	return -1;
    }
    
    public static void main(String[] args){
    	List<Interval> list = new ArrayList<Interval>();
    	list.add(new Interval(3, 5));
    	list.add(new Interval(12, 15));
    	new No57_InsertInterval().insert2(list, new Interval(6, 6));
    }
}
