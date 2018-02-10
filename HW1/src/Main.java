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
		
		int lineNum = 0;
		
		while (in.hasNext()) {
			String data = in.nextLine();
			lineNum++;
			String[] arr = data.split(" ");
			
			for (int i = 0; i < arr.length; i++) {
				
				// find data type and store key:value pair with data type
				if (arr[i].equals("=")) {
					boolean isNum = true;
					
					try {
						int num = Integer.parseInt(arr[i+1]);
					}
					catch (Exception e) {
						isNum = false;
					}
					
					if (arr[i+1].contains("\"")) { // string
						map.put(arr[i-1], new String[] {arr[i+1], "String"});
					}
					
					else if (isNum == true) { // int
						map.put(arr[i-1], new String[] {arr[i+1], "Int"});
					}
					
					else { // assigning variable to another variable
						map.put(arr[i-1], new String[] {map.get(arr[i+1])[0], map.get(arr[i+1])[1]});
					}
					
				}
				
				else if (arr[i].equals("*=")) {
					
					if (map.containsKey(arr[i-1]) && map.get(arr[i-1])[1].equals("Int")) {
						try {
							if (arr[i+1].matches("-\\d+")) { // arg on right side of *= is an integer
								int newVal = Integer.parseInt(map.get(arr[i-1])[0]) * Integer.parseInt(arr[i+1]);
								map.replace(arr[i-1], new String[] {Integer.toString(newVal), "Int"});
							}
							else if (map.containsKey(arr[i+1])) { // arg on right side of *= is another variable
								int rightVal = Integer.parseInt(map.get([arr+1])[0]);
								int newVal = Integer.parseInt(map.get(arr[i-1])[0]) * rightVal;
								map.replace(arr[i-1], new String[] {Integer.toString(newVal), "Int"});
							}
							else {
								System.out.println("Error on line " + lineNum);
								System.exit(0);
							}
						}
						catch (NumberFormatException e) {
							System.out.println("Error on line " + lineNum);
							System.exit(0);
						}
					}
				}
				
				else if (arr[i].equals("+=")) {
					
					if (map.containsKey(arr[i-1]) && map.get(arr[i-1])[1].equals("Int")) {
						
					}
					else if (map.containsKey(arr[i-1]) && map.get(arr[i-1])[1].equals("String")) {
						
					}
					else {
						
					}
				}
			}
		}
		
		
		
		in.close();
	}
}
