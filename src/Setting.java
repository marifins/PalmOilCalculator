import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Setting {

    /**
     * Creates a new instance of <code>setting</code>.
     */
    private static String F0 = "";
	private static String F00 = "";
	private static String F123 = "";
	private static String F4 = "";
	private static String F5 = "";
	private static String Brd = "";

    public Setting() {
    	String str; String s = "";
    	File file = new File("C:\\setting.txt");
		if(file.exists()){
	        try{
	        	BufferedReader in = new BufferedReader(new FileReader("C:\\setting.txt"));
	        	while((str = in.readLine())!= null){
	        		s += str + "\n";
	        	}
	        	//System.out.println(s);
	        	in.close();
	        }catch(IOException ioe){}
			String[] hsArray = s.split("\n");
			int a = hsArray[0].lastIndexOf("=") + 2;
			int b = hsArray[1].lastIndexOf("=") + 2;
			int c = hsArray[2].lastIndexOf("=") + 2;
			int d = hsArray[3].lastIndexOf("=") + 2;
			int e = hsArray[4].lastIndexOf("=") + 2;
			int f = hsArray[5].lastIndexOf("=") + 2;
			F0 = hsArray[0].substring(a);
			F00 = hsArray[1].substring(b);
			F123 = hsArray[2].substring(c);
			F4 = hsArray[3].substring(d);
			F5 = hsArray[4].substring(e);
			Brd = hsArray[5].substring(f);
		}else{
			F0 = "0";
			F00 = "0";
			F123 = "0";
			F4 = "0";
			F5 = "0";
			Brd = "0";
		}
    }


    public static String getF0(){
    	return F0;
    }

    public static String getF00(){
    	return F00;
    }

    public static String getF123(){
    	return F123;
    }

    public static String getF4(){
    	return F4;
    }

    public static String getF5(){
    	return F5;
    }

    public static String getBrd(){
    	return Brd;
    }
}
