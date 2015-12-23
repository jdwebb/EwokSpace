import java.io.*;
import java.util.ArrayList; 
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Set;

/*Hangman Midterm
 * 
 * 4/5/15
 * 
 * Project by:  Qaisha Closeil, Tyler Dresslehouse, and Jim Webb
 * 
 */

public class readDictionary {
	
	public ArrayList<String> partialDictionary = new ArrayList<String>();	//initial reading in of the text file
	public String file; 
	HashMap<Integer, ArrayList<String>> dictionary = new HashMap<Integer, ArrayList<String>>();
	
	private String token1;
	public ArrayList<String> wordOfLength;
    private String wordTBU;

		
	public void readFile(String file) {				//reads in a file and and stores it in a hash
    		try {
    			Scanner in = new Scanner(new File(file));
    			while(in.hasNext()){
    			      token1 = in.next();
    			      partialDictionary.add(token1);				
    			}
    			in.close();
    			for(int i = 0; i < partialDictionary.size(); i++){
    				int length = partialDictionary.get(i).length();
    				if(partialDictionary.contains(length)) {
    	                dictionary.get(length).add(partialDictionary.get(i));
    	                System.out.println("Enters loop and if statement");
    	            } else {
    	                ArrayList<String> set = new ArrayList<String>();
    	                set.add(partialDictionary.get(i)); 
    	                dictionary.put(length, set);
    	            }
    			}
    			
    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    			System.out.println("Problem with the text file");
    		}  
		}
		
	
	public String getWord(int length, int difficulty){			//selects a word using the selected length and difficulty modifiers
		wordOfLength = dictionary.get(length);
		wordTBU = wordOfLength.get(difficulty);
		return wordTBU;
    }
 
    public String getHiddenPhrase() {					//selects a word using the selected length and difficulty modifiers
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < wordTBU.length(); i++) {
            String s = wordTBU.substring(i, i + 1);
            if (s.equals(" ") || s.equals(",")) {
                builder.append(s);
            } else {
                builder.append("_");
            }
        }
        return builder.toString();
    }
	
	
	public void printAll(){				//debugging purposes
	    for(Entry<Integer, ArrayList<String>> entry: dictionary.entrySet()) {
	        System.out.println(entry.getKey());
	        System.out.println(entry.getValue());
	    }
	}	
	 
}
