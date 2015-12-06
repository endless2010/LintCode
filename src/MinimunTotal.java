import java.util.Arrays;
import java.util.Collections;

//TODO
pub lic class MinimunTotal {
	public int minimumTotal(int[][] triangle){
		if(triangle==null)
			return 0;
		int result=0;
		for(int[] array:triangle){
			int min=Integer.MAX_VALUE;
			for(int value:array){
				if(value<min)
					min=value;
			}
			result+=min;
		}
		return result;
	}
}
