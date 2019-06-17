package assessmentA;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;


/*
 * student number: 935771
 * name： chuan yang
 */

public class HyperBitBit {
	private int lgN;
	private long sketch;
	private long sketch2;
	
	public HyperBitBit() {
		//initial values of  the algorithm 
		lgN = 5;
		sketch = 0;
		sketch2 = 0;
	}

	//reset all the attri for new calculation
	public void reset() {
		lgN = 5;
		sketch = 0;
		sketch2 = 0;
	}
	
	//transfer String to utf8bytes
	static byte[] utf8Bytes(String string) {
	    try {
	      return string.getBytes("UTF-8");
	    } catch (UnsupportedEncodingException e) {
	      throw new RuntimeException(e);
	    }
	  }
	
	
	//add a new item ( object), all treated as strings
	public void add(Object o, int hash) {
		if(o instanceof Integer) 
			add(String.valueOf((Integer) o), hash);
		if(o instanceof Long) 
			add(String.valueOf((Long) o), hash);
		if(o instanceof String)
			add((String) o, hash);
	}
	
	// add a string , this part is the central part of  the algorithm
	public void add(String input, int hash) {
		long hashedlong = 0;
		//here we use hash64 from murmurhash64 or metrohash64
		if (hash == 2)
			hashedlong = new MetroHash64(0).apply(ByteBuffer.wrap(utf8Bytes(input))).get();
		else
			hashedlong = MurmurHash.hash64(input);
		
		long k = (hashedlong << 58) >> 58;
		//Calculate the position of the leftmost 1-bit
		int r = Long.numberOfLeadingZeros(hashedlong >> 6) - 6;
		
		if(r > lgN) {
			sketch = sketch | (1L << k);
		}
		if(r > lgN+1) {
			sketch2 = sketch2 | (1L << k);
		}
		if( Long.bitCount(sketch) > 31) {
			sketch = sketch2;
			sketch2 = 0;
			lgN++;
		}
	}
	
	//get the estimated cardinality, emperical constant 5.4 can be adjusted acoording to acutal situation
	public long cardinality() {
		double exponent = lgN + 5.4 + Long.bitCount(sketch)/32.0;
		return (long) Math.pow(2, exponent);
	}
}
