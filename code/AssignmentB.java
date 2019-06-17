
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import sun.misc.GC;

public class AssignmentB {

	public static void main(String args[]) {
		if(args.length == 0){
			System.err.println("No fileName argument.");
			System.exit(1);
		}
		//invoke gc
//		System.gc();
		long startMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		Ranges ranges = new Ranges(100);
		Scanner scanner;
		String fileName = args[0];

		String s;
		String[] list;
		try {//read file 
			File f = new File(fileName);
			scanner = new Scanner(f);
			
			
			long startTime = System.currentTimeMillis();
			while(scanner.hasNextLine()) {
				s = scanner.nextLine();
				list = s.split(" ");// split line into seperate characters
				if(list.length == 2) {
					if(list[0].equals("f"))
						System.out.println(ranges.getPointFre(Integer.parseInt(list[1])) );
					else 
						ranges.add(Integer.parseInt(list[0]), Integer.parseInt(list[1]));
				} else if(list[0].equals("r"))
						System.out.println(ranges.getRangeFre(Integer.parseInt(list[1]), Integer.parseInt(list[2])));
					
			}
			scanner.close();
//			System.gc();
			// long spendTime = System.currentTimeMillis() - startTime;
			// long endMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			// long usedMem = endMem - startMem;
			// System.out.println("time: " + spendTime);
			// System.out.println("memory: " + usedMem);
		}
		catch (Exception e) {
			System.err.println("error: " +e.getMessage());
		}
	}
}
