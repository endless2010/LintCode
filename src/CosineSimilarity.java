import org.junit.Assert;
import org.junit.Test;


public class CosineSimilarity {
    public double cosineSimilarity(int[] A, int[] B) {
        if(A==null || B==null ||A.length!=B.length)
        	return 2.0;
        double AiBi=0.0;
        double Ai2=0.0;
        double Bi2=0.0;
        for(int i=0;i<A.length;++i){
        	AiBi+=A[i]*B[i];
        	Ai2+=A[i]*A[i];
        	Bi2+=B[i]*B[i];
        }
        if(Ai2==0||Bi2==0)
        	return 2.0;
        return AiBi/Math.sqrt(Ai2)/Math.sqrt(Bi2);
    }
    @Test
    public void test(){
    	Assert.assertEquals(0.9926,cosineSimilarity(new int[]{1,2,3},new int[]{2,3,4}),0.0001);
    	Assert.assertEquals(2.0000,cosineSimilarity(new int[]{0},new int[]{0}),0.0001);
    }
}
