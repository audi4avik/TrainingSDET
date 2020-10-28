package JavaActivity1;

import java.util.*;

public class Activity1_2 {
	public static void main(String[] args) {
		//initialize the integer array
		int[] myArr = {10, 57, 88, 10, 120, 21};
		System.out.println("original Array: " + Arrays.toString(myArr));
		
		// define conditions
		int searchNum = 10;
		int targetSum = 30;
		
		// print final result
		System.out.println("Result: " + result(myArr, searchNum, targetSum));
		
	}
	
	public static boolean result(int[] numbers, int num, int sum) {
		int tempSum = 0;
		//Loop through array
		for (int number : numbers) {
			//If value is 10, add them
			if(number == num) {
				tempSum += num;
			}
			//Sum should not be more than 30
			if(tempSum > sum) {
				break;
			}
		}
		//Return boolean <true/false> if condition satisfies
		return tempSum == sum;
	}
}
