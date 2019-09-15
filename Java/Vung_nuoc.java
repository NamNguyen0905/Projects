import java.util.*;
public class Vung_nuoc{
	public static void main(String[] args){
		// Start calculate Time
		long startTime = System.currentTimeMillis();

		LinkedList<Integer> Height = new LinkedList<Integer>();
		System.out.println("Number of buildings");
		int size = IO.readInt();
		for (int i = 0; i < size; i++)
			Height.add(IO.readInt());
		System.out.println("Amount of water: " + Solution(Height,0));

		// Stop calculate Time
		long stopTime    = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println(elapsedTime);

	}

	public static int Solution2(LinkedList<Integer> Height,int water,int edge){
		if (edge == Height.size()-1){
			return water;
		}
		else{
			while (Height.get(0) <= Height.get(1)){
				Height.removeFirst();
				if (Height.size() == 1 || Height.size() == 2)
	 				break;
			}
			while (Height.get(Height.size()-1) <= Height.get(Height.size()-2)){
				Height.removeLast();
				if (Height.size() == 1 || Height.size() == 2)
	 				break;
			}
			int edgeLocation = Height.size()-1;
			for (int i = 1; i < Height.size(); i++)
				if (Height.get(i) >= Height.get(0)){
					edgeLocation = i;
					break;
				}
			int base = Height.get(0);
			for (int i = 1; i < edgeLocation; i++){
				water += ( base - Height.get(i) );
				Height.set(i,base);
				Height.removeFirst();
			}
			return Solution2(Height,water,edgeLocation);
		}
	}

	public static int Solution(LinkedList<Integer> Height,int water){
		while (Height.size() != 1 || Height.size() != 2){
			while (Height.get(0) <= Height.get(1)){
				Height.removeFirst();
				if (Height.size() == 1 || Height.size() == 2)
	 				break;
			}
			while (Height.get(Height.size()-1) <= Height.get(Height.size()-2)){
				Height.removeLast();
				if (Height.size() == 1 || Height.size() == 2) 
	 				break;
			}
			if (Height.size() == 1 || Height.size() == 2)
	 			break;
	 		int min         = findMin(Height);
	 		int minLocation = findLocation(Height,min);
	 		int nearMin     = Math.min(Height.get(minLocation-1),Height.get(minLocation+1));
	 		if (Height.get(minLocation-1) == min || Height.get(minLocation+1) == min)
				nearMin = Math.max(Height.get(minLocation-1),Height.get(minLocation+1));
	 			water += (nearMin - min);
	 		Height.set(minLocation, nearMin);
	 	}
 		return water;
	}

	public static int findMin(LinkedList<Integer> Height){
		int min = Height.get(0);
		for (int i = 0; i < Height.size(); i++)
			if (Height.get(i) < min)
				min = Height.get(i);
		return min;
	}

	public static int findLocation(LinkedList<Integer> Height,int n){
		for (int i = 0; i < Height.size()-1; i++)
			if (Height.get(i) == n)
				return i;
		return -1;
	}

}
