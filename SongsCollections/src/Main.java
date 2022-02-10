import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	private static String line;

	public static void main(String[] args) throws IOException {
		
		
		 BufferedReader in = new BufferedReader(new FileReader("C:\\\\Test\\\\songs.txt"));
		 
		 StringBuffer sb = new StringBuffer();
		
		 while ((line=in.readLine())!= null)
		 {
			// System.out.println(line);
			 //sb.append(line); 
			 //sb.append("\n"); 
		String[] a = line.split("::");	
		
		for(String s:a) {
			
			System.out.println(s);
		}
		// System.out.println(line);
		 
	
		 }
		 in.close();
			 

	}

}
