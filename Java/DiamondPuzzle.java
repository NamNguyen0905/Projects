public class DiamondPuzzle{
	public static void main(String[] args){
		System.out.print("Input n: ");
		int n = IO.readInt();
		Solution(n);
	}

	public static void Solution(int n){
		int x = n/2 + 1;
		for (int i = 1; i <= x; i++){
			for (int j = 1; j <= n;j++)
				if (j > (x-i) && j < (x+i))
					System.out.print("*");
				else
					System.out.print(" ");
			System.out.println();
		}
		for (int i = x - 1; i >= 1; i--){
			for (int j = 1; j <= n;j++)
				if (j > (x-i) && j < (x+i))
					System.out.print("*");
				else
					System.out.print(" ");
			System.out.println();
		}
	}

}