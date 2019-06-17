
import libs.StdRandom;

public class CMLS {
	private char[][] T; // Yan is happy
	private Hash hfs[];
	private int d=5,w=211;
	
	private int n;
	
	public CMLS(int n){
		this.n = n;
		T = new char[d][w]; // in Java arrays
			// initial with a char, no matter what
		for(int i=0; i<d; i++)
			for(int j=0; j<w; j++)
				T[i][j] = '0';
		hfs = new Hash[d];
		for(int i=0;i<d;i++){
			hfs[i] = new Hash(n,w);
		}
	}
	// ideally take Object
	// we'll stick with int items for now
	//Count-Min-Log sketch
	//method with log(2) to increase the index, with probability
	public void add(int x, int count){
		int c = get(x);
		for(int j=0; j<count; j++) //do it 'count' times, with probability 1/pow(2,c).
			if(increaseDecision(c)) {
				for(int i=0;i<d;i++){
					T[i][hfs[i].hash(x)]= (char) (T[i][hfs[i].hash(x)]+1);
//					T[i][hfs[i].hash(x)] +=1;
//					System.err.format("hash[%2d](%6d)=%5d%n",i,x,hfs[i].hash(x));
				}
			}		
	}
	

	
	//probability to increase pow(b, -c)
	public boolean increaseDecision(int c) {
//		Random rand = new Random(100);
		if(StdRandom.uniform() <= 1/(double)Math.pow(2, c))
			return true;
		else return false;
	}
	
	
	//
	public int get(int y) {
//		int m = (int)(T[0][hfs[0].hash(y)] - '0');
		int m = T[0][hfs[0].hash(y)];
		for(int i=1;i<d;i++){
 			m = Math.min(m,(int)(T[i][hfs[i].hash(y)] - '0'));
//			m = Math.min(m,T[i][hfs[i].hash(y)] );
		}
		return value(m);
	}
	
	//get pow(2,c) value
	public int pointValue(int c) {
		if(c==0) 
			return 0;
		else
			return (int) Math.pow(2, c-1);
	}
	//get estimated count
	public int value(int c) {
		if(c <= 1)
			return pointValue(c);
		else {
			int v = pointValue(c+1);
			return (1-v)/(1-c);
		}
	}
	

}
