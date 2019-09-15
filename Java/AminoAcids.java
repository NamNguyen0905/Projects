import java.util.Scanner;

public class AminoAcids{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter DNA sequence: ");
		String DNA = scan.nextLine();

	}

	public static String Solution(String sequence){
		String amino_acids = "";
		String codons = "";
		for (int i = 0; i < sequence.length(); i++) {
			int three = 0;

			codons += sequence.charAt(i);
			three++;

			if ( three == 3 ){
				String temp = codons;
				char[] charArray = codons.toCharArray();
				Arrays.sort(charArray);
				String sortedString = new String(charArray);
				if (sortedString == "")	// Get file 
					amino_acids += "";
				codons.charAt(0) = codons.charAt(1);
				codons.charAt(1) = codons.charAt(2);
				codons.charAt(2) = "";
			}
		}
	}
}