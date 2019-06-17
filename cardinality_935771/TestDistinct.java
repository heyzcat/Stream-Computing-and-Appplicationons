package assessmentA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * student number: 935771
 * name： chuan yang
 */

// TestDistinct.java
// Example "main class" for distinct elements counter
// awirth for COMP90056
// Sep 2017

public class TestDistinct{
	
	public static void main(String args[]){
//		int i;
		
//		Map<String, Boolean> unique = (Map<String, Boolean>) new HashMap<String, Boolean>();
		
		//variables for test Integer cardinality err, N begins from large int
//		int repeattime = 2;
//		int size = 10000000;
//		int baseint = 10000000;
//		int addtime = 10;
//		int addstep = 2000000;
		
		//variables for collecting all errs with different N
//		double errs[] = new double[addtime];
//		long times[] = new long[addtime];
		//here is for NJKST1 test Integer
//		for(int t=0; t<addtime; t++) {
//			Distinct b = new BJKST1(0x0fffffff,1);
//			long start_bj1 = System.currentTimeMillis();
//			for(int k=0; k < repeattime; k++) {
////				for(int j =0; j < 1; j++) 
//					for(int i=0; i<baseint; i++) 
//						b.add(2*i);			
//
//			}
//			double err = Math.abs(b.distinct() - baseint)/(double)baseint;
//			errs[t] = err; 
//			long time = System.currentTimeMillis() - start_bj1;
//			times[t] = time;
//			System.out.println("bjk3 err: " + err);
//			System.out.println("time: " + time);
//			baseint += addstep;
//
//		}
		
		//here is for NJKST3 for testing Integer
//		
//		for(int t=0; t<addtime; t++) {
//			Distinct c = new BJKST3(0x0fffffff,1);
//			long start_bj3 = System.currentTimeMillis();
//			for(int k=0; k < repeattime; k++) {
////				for(int j =0; j < 1; j++) 
//					for(int i=0; i<baseint; i++) 
//						c.add(2*i);			
//
//			}
//			double err = Math.abs(c.distinct() - baseint)/(double)baseint;
//			errs[t] = err;
//			System.out.println("bjk3 err: " + err);
//		long time = System.currentTimeMillis() - start_bj3;
//		times[t] = time;
//			System.out.println("time: " + time);
//			baseint += addstep;
//
//		}
		
					
		//here is for bhh for testing Integer
//		for(int t=0; t<addtime; t++) {
//			HyperBitBit hbb = new HyperBitBit();
//
//			long start_hbb = System.currentTimeMillis();
//
//			for(int k =0; k<repeattime; k++) {
////				for(int j =0; j < 1; j++) 
//					for(int i=0; i<baseint; i++) 
//						hbb.add(2*i -199, 1);
//					
//				
//			}
//			
//			double err = Math.abs(hbb.cardinality()-baseint)/(double)baseint;
//			System.out.println("HyperBitBit: " + err );
//			long time = System.currentTimeMillis() - start_hbb;
//			times[t] = time;
//			System.out.println("time: " + time);
//			errs[t] = err;
//			baseint += addstep;
//		}
//		for(double a : errs)
//			System.out.print(a + " ");
//		for(Long t : times)
//			System.out.print(t + " ");
//		StdStats.plotLines(errs);

		
		
//		System.out.println("BJKST3: " + Math.abs(c.distinct()-size)/(double)size);
//		System.out.println("BJKST1: " + Math.abs(b.distinct()-size)/(double)size);
		
		
		if(args.length == 0){
			System.err.println("No fileName argument.");
			System.exit(1);
		}
		String fileName = args[0];
		
		Scanner scanner;
		try{
			File f = new File(fileName);
			scanner = new Scanner(f);
			String s;
			HyperBitBit hbb = new HyperBitBit();
//			BJKST3  bjk3 = new BJKST3(0x0fffffff,1);
//			BJKST1  bjk1 = new BJKST1(0x0fffffff,1);
			long start = System.currentTimeMillis();
			while(scanner.hasNextLine()){
				s = scanner.nextLine();
				hbb.add(s, 2);
//				bjk3.add(s);
//				bjk1.add(s);
//				unique.put(s, true)  ;
//				c.add(s);
			}
			System.out.println("time: " + (System.currentTimeMillis() - start));
			scanner.close();
			System.out.println("hyperbitbit estimate cardinality: " + hbb.cardinality());
//			System.out.println("actual cardinality: " + unique.size());
//			System.out.println("njk1 err: " + Math.abs(bjk1.distinct()- unique.size())/(double)unique.size());
//
//			System.out.println("njk3 err: " + Math.abs(bjk3.distinct()- unique.size())/(double)unique.size());
//			System.out.println("hbb err: " + Math.abs(hbb.cardinality()- unique.size())/(double)unique.size());
		} catch (FileNotFoundException ex) {
			System.err.println("No file: "+fileName);
		}

	}
}