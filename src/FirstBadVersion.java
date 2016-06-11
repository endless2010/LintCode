import org.junit.Assert;
import org.junit.Test;

/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
 * The code base version is an integer start from 1 to n. 
 * One day, someone committed a bad version in the code case, 
 * so it caused this version and the following versions are all failed in the unit tests. 
 * Find the first bad version.

 *  You can call isBadVersion to help you determine which version is the first bad one.
 *  The details interface can be found in the code's annotation part.

 * Example
 * Given n = 5:

 * isBadVersion(3) -> false
 * isBadVersion(5) -> true
 * isBadVersion(4) -> true
 * Here we are 100% sure that the 4th version is the first bad version.

*/
public class FirstBadVersion {
    public int findFirstBadVersion(int n) {
    	return findFirstBadVersion(n,1,n);
    }
    public int findFirstBadVersion(int n,int from,int to) {
        int mid=(from+to)/2;
        if(SVNRepo.isBadVersion(mid))
        	if(from==to)
        		return from;
        	else return findFirstBadVersion(n,from,mid);
        else{
        	return findFirstBadVersion(n,mid+1,to);
        }
    }
    
    @Test
    public void test(){
    	Assert.assertEquals(4,findFirstBadVersion(5));
    }
}

class SVNRepo {
	public static boolean isBadVersion(int k){
		return k>3?true:false;
	}
}