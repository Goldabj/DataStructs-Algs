import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Class used to find possible and legal links for given works
 *
 * @author goldacbj.
 *         Created Nov 1, 2015.
 */
public class Links {
	private HashSet<String> dictionary;
	private static final char[] ALPHABET = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	
	/**
	 * Initalizes the dictionary Set which we will compare possible links to
	 *
	 * @param fileName
	 */
	public Links(String fileName) {
		this.dictionary = new HashSet<String>();
		File file = new File(fileName);
		Scanner in = null;
		try{
			in = new Scanner(file);
		}
		catch(FileNotFoundException wrongFile){
			System.out.println("Error: File not found");
		}
		while(in.hasNextLine()) {
			this.dictionary.add(in.nextLine());
		}
	}
	
	/**
	 * creates a Set of possible candidates of the given word
	 *
	 * @param word
	 * @return
	 */
	public Set<String> getCandidates(String word) {
		HashSet<String> allCandidates = new HashSet<String>();
		// change one letter of the word with a letter in the alphabet
		// make sure the letter is not the same as leter in the word
		char[] letters = word.toCharArray();
		for(int i = 0; i < letters.length; i++) {
			char currentLetter = letters[i];
			for(int j = 0; j < this.ALPHABET.length; j++) {
				// make sure letter your replacing isn't the same 
				if(this.ALPHABET[j] != currentLetter) {
					letters[i] = this.ALPHABET[j]; // replace the letter
					// check to see if it is a legal word 
					String currentString = String.valueOf(letters);
					if(this.dictionary.contains(currentString)) {
						allCandidates.add(currentString);
					}
				}
			}
			letters[i] = currentLetter; // reset the letter array
		}
		
		if(allCandidates.size() == 0) {
			return null;
		}
		// else
		return allCandidates;
	}
}
