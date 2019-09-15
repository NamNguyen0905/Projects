import java.util.Scanner;

public class Jumping_with_Backtracking{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter n: ");
		int n = scan.nextInt();
		int[] Spaces = new int[2*n + 1];
		for (int i = 0; i < n; i++)
			Spaces[i] = 1; 
		for (int i = n+1; i < 2*n + 1; i++)
			Spaces[i] = 2;

		Solution(n,Spaces);
	}

	public static void printArray(int n, int[] Array){
		for (int i = 0; i < 2*n + 1; i++)
			System.out.print(Array[i] + " | ");
	}

	public static int[] Solution(int n, int[] Spaces){
		return Spaces;
	}
}