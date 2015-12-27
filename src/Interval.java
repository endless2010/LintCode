public class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
	
	@Override
	public String toString(){
		return "["+start+"-"+end+"]";
	}
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Interval))
			return false;
		Interval other=(Interval)obj;
		return start==other.start && end==other.end;
	}
}