package range_60_80;
/**
 * 二分法，找规律，数学
 * 两种方法，一种使用二分法来搜索这个平方根。第二种使用牛顿迭代法，构造函数f(x)=x*x-n,当f(x)等于0时就找到了平方根，通过不断逼近临界点来寻找平方根
 * */
public class No69_Sqrt {
    public int mySqrt(int x) {
    	if(x<1)
    		return 0;
        long low = 0;
        long hight = x;
        while(hight-low > 1){
        	long middle = (low+hight)/2;
        	if(middle*middle == x)
        		return (int)middle;
        	if(middle*middle > x){
        		hight = middle;
        	}
        	else{
        		low = middle;
        	}
        }
        if(hight*hight == x)
        	return (int) hight;
        return (int) low;
        //return Math.abs(hight*hight-x)>Math.abs(low*low-x) ? low : hight;
        
    }
    
    public int mySqrt1(int x){
    	if(x<1)
    		return 0;
    	long r = x;
    	while(r*r>x){
    		r = (r+x/r)/2;
    		
    	}
    	return (int) r;
    }
}
