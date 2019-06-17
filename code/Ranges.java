

public class Ranges{
	int level;
	int powers2[];
	CMLS[] cs;
	int TT=32;
	
	//init 
	public Ranges(int n){
		powers2 = new int[TT];
		powers2[0] = 1;
		for(int i= 1;i<TT;i++){
			powers2[i] = powers2[i-1]*2;
		}
		cs = new CMLS[TT];
		for(int i=0;i<TT;i++){
			cs[i] = new CMLS(n);
		}
		
	}
	//add count to all CMLS, to seperate cells
	public void add(int x, int count){
		for(int j = 0;j<TT;j++){
			cs[j].add(x, count);
			x /= 2;
		}
	}
		
	//to decompose the section to combination of power of 2. get the rang count
	public int getRangeFre(int start, int end) {
		int rangeCount = 0;
	
		//assume numbers to count start from 0. if odd, add it first
		if(start%2 == 1) {
			rangeCount += cs[0].get(start++);
		}
		while(start + Math.pow(2, level) <= end) {
			if(start == 0)
				level = TT;
			else {
				while( ((start)% Math.pow(2, level)) == 0) 
					level++;
				level--; //get the right level
			}
			
			while( (start + Math.pow(2, level)) > end) {
				level--;
			}
			// c to get count from different CMS;
			int c = (int) (start/Math.pow(2, level));
			rangeCount += cs[level].get(c);
			
			start += Math.pow(2, level);

			level = 0;
			
		}
		return rangeCount;
	}
	
	public int getPointFre(int c) {
		return cs[0].get(c);
	}
	
}