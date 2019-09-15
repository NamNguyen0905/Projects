import java.util.*;
public class SlidingPuzzle{

	static LinkedList<TestPuzzle> arrPuzzle_Cost = new LinkedList<TestPuzzle>();

	public static void main(String[] args){
		int[][] puzzle = {
			{7,9,5},
			{8,3,4},
			{1,6,2}
		};
		System.out.println(Solution(puzzle,CostToGo(puzzle)));
	}

	public static int[][] Solution(int[][] puzzle, int Cost){
		if (Cost == 0)
			return puzzle;
		else{
			for (int i = 1; i < 5; i++){
				int[][] puzzle_copy = puzzle;
				Coordinate space = findNum(puzzle,9);
				Coordinate destination = new Coordinate();
				if (checkMovable(space,i, destination)){
					Go(puzzle_copy, space, destination);
					// Create a linked list to contain test puzzles and their costs
					TestPuzzle sample = new TestPuzzle();
					sample.setSample(puzzle_copy);
					sample.setCost(CostToGo(puzzle_copy));
					arrPuzzle_Cost.add(sample);
					// Find the min cost in those test puzzles to do next steps
				}
			}
		}
		return puzzle;
	}

	// Cost from current state to final state
	public static int CostToGo(int[][] puzzle){
		int a = 1;
		int Sum = 0;
		Coordinate current = new Coordinate();
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++){
				current.setX(findNum(puzzle,a).getX());
				current.setY(findNum(puzzle,a).getY());
				Sum += Math.abs((current.getX() - i)) + Math.abs((current.getY() - j));
				a++;
			}
		return Sum;
	}

	// Find location of specific number
	public static Coordinate findNum(int[][] puzzle, int n){
		Coordinate location = new Coordinate();
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (puzzle[i][j] == n){
					location.setX(i);
					location.setY(j);
					return location;
				}
		return location;
	}

	//Check whether the space can move or not
	public static boolean checkMovable(Coordinate n, int direction, Coordinate destination){
		switch(direction){
			case 1:
				if (n.getY() == 0)
					return false;
				else{
					destination.setX(n.getX());
					destination.setY(n.getY()-1);
					return true;
				}
			case 2:
				if (n.getX() == 2)
					return false;
				else{
					destination.setX(n.getX()+1);
					destination.setY(n.getY());
					return true;
				}
			case 3:
				if (n.getY() == 3)
					return false;
				else{
					destination.setX(n.getX());
					destination.setY(n.getY()+1);
					return true;
				}
			case 4:
				if (n.getX() == 0)
					return false;
				else{
					destination.setX(n.getX()-1);
					destination.setY(n.getY());
					return true;
				}
			default:
				return false;
		}
	}

	//Move the space to a specific place
	public static void Go(int[][] puzzle, Coordinate space, Coordinate destination){
		int a = puzzle[space.getX()][space.getY()];
		puzzle[space.getX()][space.getY()] = puzzle[destination.getX()][destination.getY()];
		puzzle[destination.getX()][destination.getY()] = a;
	}

	public static int findMin(LinkedList<TestPuzzle> arrPuzzle_Cost){

	}
}