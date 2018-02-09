import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// Get the input, parse it using Helper
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		
		Scanner in = new Scanner(file);
		
		/*
		 * Data Structure is a map where the key is the variable name
		 * and the value is a String array containing the current value and the data type of said variable.
		 */
		HashMap<String, String[]> map = new HashMap<String, String[]>();
		
		while (in.hasNext()) {
			String data = in.nextLine();
			String[] arr = data.split(" ");
			
			for (int i = 0; i < arr.length; i++) {
				
				// find data type and store key:value pair with data type
				if (arr[i].equals("=")) {
					
					if (arr[i+1].contains("\"")) { // string
						map.put(arr[i-1], new String[] {arr[i+1], "String"});
					}
					
					else { // int
						map.put(arr[i-1], new String[] {arr[i+1], "Int"});
					}
					
				}
				
				else if (arr[i].equals("*=")) {
					int oldVal = Integer.parseInt(map.get(arr[i-1]));
					int newVal = (oldVal * Integer.parseInt(arr[i+1]));
					
					map.replace(arr[i-1], Integer.toString(newVal));
				}
				
				else if (arr[i].equals("+=")) {
					int oldVal = Integer.parseInt(map.get(arr[i-1]));
					
					if (arr[i+1])
					
					int newVal = (oldVal + Integer.parseInt(arr[i+1]));
					
					map.replace(arr[i-1], Integer.toString(newVal));
				}
			}
		}
		
		
		
		in.close();
	}
}
