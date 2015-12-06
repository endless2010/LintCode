
public class ClimbStairs {
    public int climbStairs(int n) {
        if(n==1)
    		return 1;
    	if(n==2)
    		return 2;
        int f1=1;
        int f2=2;
        int fn=0;
        for(int i=3;i<=n;++i){
        	fn=f1+f2;
        	f1=f2;
        	f2=fn;
        }
        return fn;
    }
}
