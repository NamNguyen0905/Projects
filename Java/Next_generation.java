import java.util.*;

public class Next_generation{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Input n: ");
		int n = scan.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n ; i++)
			array[i] = i+1;
		Solution(n, array);
	}

	public static void Solution(int n, int[] array){
		int[] last = new int[n];
		for (int i = 0; i < n ; i++)
			last[i] = n-i;
		while (Arrays.equals(array,last) == false){
			for (int i = n-2; i >= 0; i--) {
				if(array[i] < array[i+1]){
					for (int j = n-1; j > i; j--)
						if(array[j] > array[i]){
							SwapTwo(array, i, j);
							if(j - i == 1){
								printArray(array);
								break;
							}
							else{
								SwapWhole(array, i+1, j);
								printArray(array);
							}
						}	
				}
			}
		}
	}

	public static void SwapTwo(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void SwapWhole(int[] array, int a, int b){
		for (int i = 0; i < (b-a+1)/2; i++)
			SwapTwo(array, a+i, b-i);
	}

	public static void printArray(int[] array){
		for (int i = 0; i < array.length ; i++)
			System.out.print(array[i] + " ");
      System.out.println();
	}
}