public class Test_Recursion{

	public static void printArray (int[] array){
		for (int i = 0; i < array.length; i++){
	    	System.out.print(array[i]+ " ");
	    }
    	System.out.println();
    }

    public static void Swap(int x){

    }

	public static void main(String[] args){
		int[] array = {1,2,3,4};
		System.out.print("Input n: ");
		int n = IO.readInt();
		System.out.print("Input m: ");
		int m = IO.readInt();
		System.out.print(Distribution(m,n));
	}

	public static int Factorial(int n){
		if (n == 1)
			return 0;
		else
			return Factorial(n-1) + (n-1)*n;
	}

	public static void Permutation(int[] arr,int n){
		if (n == 1)
			printArray(arr);
		else{

		}
	}

	public static int Distribution(int m, int n){
		if (m == 0 || n == 1)
			return 1;
		if (n == 0)
			return 0;
		if (m < n)
			return Distribution(m,m);
		return Distribution(m,n-1) + Distribution(m-n,n);
	}
}