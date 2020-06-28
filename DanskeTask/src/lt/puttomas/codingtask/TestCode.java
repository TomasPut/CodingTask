package lt.puttomas.codingtask;

import java.util.Scanner;

public class TestCode {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the length of the array: ");
		int length = s.nextInt();
		int[] array = new int[length];
		System.out.print("Enter the elements of the array: "); //after each number hit Enter

		for (int i = 0; i < length; i++) {
			array[i] = s.nextInt();
		}

//		int arr[] = { 1, 2, 0, 3, 0, 2, 0 };
		int n = array.length;
		System.out.print("Minimum number of jumps to reach end is " + minJumps(array, 0, n - 1));
	}

	public static int minJumps(int arr[], int a, int b) {
		int min = Integer.MAX_VALUE;

		if (b == a) {
			return 0;
		} 
		if (arr[a] == 0) {
			return Integer.MAX_VALUE;
		}
		
		for (int i = a + 1; i <= b && i <= a + arr[a]; i++) {
			int jumps = minJumps(arr, i, b);
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min) {
				min = jumps + 1;
			}
		}
		return min;
	}
}
