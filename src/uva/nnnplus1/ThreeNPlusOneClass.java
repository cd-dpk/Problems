package uva.nnnplus1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ThreeNPlusOneClass {
	static int maxCycle =0,minNum=1,maxNum=9999; 
	// pairing(number, cycle path) 
	// for example, (1,1)
	static Map<Integer, Integer> cycleMap = new HashMap<Integer, Integer>();
	static{
		cycleMap.put(1, 1);
	}
	
	public static void main(String[] args) {
		takeInputOfOnePairFromScanner();
		long time = System.currentTimeMillis();
		for (int i = minNum; i <=maxNum; i++) {
			setCounterForNumber(i);
		}
		System.out.println(minNum+" "+maxNum+" "+maxCycle);
		System.out.println((System.currentTimeMillis()-time)+" ms ");
	}
	private static void takeInputOfOnePairFromScanner(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Min Number: ");
		minNum = scanner.nextInt();
		System.out.print("Enter Max Number: ");
		maxNum = scanner.nextInt();
		scanner.close();
	}
	
	private static void setCounterForNumber(int number) {
		if (cycleMap.containsKey(number)) {
			return ;
		}
		else {
			int temp = 0;
			if (number%2 == 0) {
				temp = number/2;
			} else {
				temp= 3*number+1;
			}
			setCounterForNumber(temp);
			cycleMap.put(number, cycleMap.get(temp)+1);
			if (number>= minNum && number <= maxNum && cycleMap.get(number)>maxCycle ) {
					maxCycle = cycleMap.get(number);
			}
		}
	}
}
