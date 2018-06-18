
import java.awt.List;
import java.io.*; // needed for buffered reader 
import java.util.LinkedList;
public class scanner
{
	static int lineRead = 1; // variable used to print the line being read 
	
	//keywords 
  	static String[] keywords = {"specifications", "symbol", "forward", "references", "function", "pointer", "array", "type", "struct", "integer", "enum",
  						"global", "declarations", "implementations", "main", "parameters", "constant", "begin", "endfun", "if", "then", "else", "endif", 
  						"repeat", "until", "endrepeat", "display", "set", "return"};
  	
  	//operators 
  	static String[] operators = {"=", "<=", "<", ">=", ">", "==", "~=", "+", "-", "*", "/"};
  	
  	public static boolean isInteger(String s) // this will see if the lexeme is an int 
  	{ 
        try
        {
           Integer.parseInt(s);
   
           // s is a valid integer
   
           return true;
        }
        catch (NumberFormatException ex)
        {
           // s is not an integer
        }
   
        return false;
     }
  	
  	private static boolean checkKeywords(String string) {
		
  		for(int i = 0; i < keywords.length; i++)//checking for match in keywords
  		{
  			if(string.equals(keywords[i])){
  				System.out.print("Line: " + lineRead + " ");
  				System.out.print("Token found: " + (i + 1) + " "); // token value is based on position in table 
  				return true;
  			}
  		}
  		
  		return false;
	}
  	
  	private static boolean checkOperators(String string) {
		
  		for(int i = 0; i < operators.length; i++)//checking for match in keywords
  		{
  			if(string.equals(operators[i])){
  				System.out.print("Line: " + lineRead + " ");
  				System.out.print("Token found: " + ((i) + (keywords.length + 1)) + " "); //token value is based on position in table plus length of key words 
  				return true;
  			}
  		}
  		
		return false;
	}
  	
  	private static boolean checkint(String string) {
		
  		
  			if(isInteger(string)) { 
  				System.out.print("Line: " + lineRead + " ");
  				System.out.print("Token found: " + (((operators.length) + (keywords.length + 1))+1) + " "); //obtains assigned token value 
  				return true;
  			
  			
  		}
  		
		return false;
	}
  	
  	private static boolean checkFloat(String string) {
		
  		try
        {
            // checking valid float using parseInt() method
            Float.parseFloat(string);
            System.out.print("Line: " + lineRead + " ");
            System.out.print("Token found: " + (((operators.length) + (keywords.length + 1))+2) + " "); //obtains assigned token value 
            return true;
        } 
        catch (NumberFormatException e)
        {
            return false;
        }
		
			
  	}
  	
  	public static void printLiteral(String string)
  	{
  		System.out.print("Line: " + lineRead + " ");
        System.out.print("Token found: " + (((operators.length) + (keywords.length + 1))+3) + " "); //obtains assigned token value 
  	}
  	
  	public static void check(String[] splited)
  	{
  		for(int i = 0; i < splited.length; i++)//going through all substrings
  		{
  			String st = splited[i].replace("\\s+", "");
  			
  			if(checkKeywords(st))//checks if lexeme is a keyword 
  			{
  				System.out.println("Lexeme found: " + st);
  			}
  			else if(checkOperators(st))//checks if lexeme is an operator 
  			{
  				System.out.println("Lexeme found: " + st);
  			}
  			else if(checkint(st)) //checks if lexeme is an int
  			{
  				System.out.println("Lexeme found: " + st);
  			}
  			else if(checkFloat(st)) //checks if lexeme is an int
  			{
  				System.out.println("Lexeme found: " + st);
  			}
  			else
  			{
  				printLiteral(st);
  				System.out.println("Lexeme found: " + st);
  			}
  		}
  	}

	public static void main(String[] args)throws Exception
	{
		  File file = new File("C:\\Users\\Public\\eclipse-workspace\\Scanner\\ScannedFile"); //file reading from 
		  FileReader fileReader = new FileReader(file);
	      BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) { //while some of file is remaing 
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append(line); //seperates by white space 
				stringBuffer.append(" ");
				
				String str = stringBuffer.toString();
	 		    String[] splited = str.split(" "); //splits string into several for analysis
			    check(splited);// checks 
			    lineRead++; //used to display the line from file read from 
			}
			fileReader.close();
	 }
}