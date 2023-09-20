import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int sortValue = 0, index = 0;
		int[] sortArray = new int[100]; //store up to 100 numbers
		
		while (sortValue != -1) {
			//get the input from the console
			System.out.print("Please enter a value to the list for sorting [-1 to quit]: ");
			sortValue = input.nextInt();
			System.out.println();
			
			//put the value into the array
			sortArray[index++] = sortValue;
		}
		
		//copy the array and then sort it
		int[] finalArray = new int[index];
		for (int a = 0; a < index; a++) {
			finalArray[a] = sortArray[a];
		}
		
		log("Let's Sort \n");

		//		make sure to answer the questions on the lab document as you go
		log("============ Ascending Order result:" + Arrays.toString(BubbleSortAscMethod(finalArray)) + "\n");
		log("============ Descending Order result:" + Arrays.toString(BubbleSortDescMethod(finalArray)) + "\n");
		
		input.close();
	}

	//bubble sort in ascending order
	public static int[] BubbleSortAscMethod(int[] sArr) {
		int temp;
		for (int i = 0; i < sArr.length - 1; i++) {

			for (int j = 1; j < sArr.length - i; j++) {
				if (sArr[j - 1] > sArr[j]) {
					temp = sArr[j - 1];
					sArr[j - 1] = sArr[j];
					sArr[j] = temp;
				}
			}
			log("Iteration " + (i + 1) + ": " + Arrays.toString(sArr));
		}
		return sArr;
	}

	//bubble sort in descending order
	public static int[] BubbleSortDescMethod(int[] sArr) {
		int temp;
		for (int i = 0; i < sArr.length - 1; i++) {

			for (int j = 1; j < sArr.length - i; j++) {
				if (sArr[j - 1] < sArr[j]) {
					temp = sArr[j - 1];
					sArr[j - 1] = sArr[j];
					sArr[j] = temp;
				}
			}
			log("Iteration " + (i + 1) + ": " + Arrays.toString(sArr));
		}
		return sArr;
	}

	//simple log
	private static void log(String result) {
		System.out.println(result);

	}
}