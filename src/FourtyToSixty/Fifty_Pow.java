package FourtyToSixty;

public class Fifty_Pow {
	public double myPow(double x, int n) {
        if(x == 0)
            return 0;
        if(n == 0)
            return 1;
        else if(n == 2)
        	return x*x;
        else if(n == -2)
        	return 1/(x*x);
        double count = 1;
        count = Math.abs(n)%2==0 ? myPow(myPow(x, n/2), 2) : myPow(myPow(x, n/2), 2)*x;
        return n>0 ? count:1/count;
    }
	
	public static void main(String[] args){
		new Fifty_Pow().myPow(4, 3);
	}
}
