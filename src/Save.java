import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Save {

    /**
     * Creates a new instance of <code>setting</code>.
     */
    private static String F0 = "";
	private static String F00 = "";
	private static String F123 = "";
	private static String F4 = "";
	private static String F5 = "";
	private static String Brd = "";

    public Save(String a, String b, String c, String d, String e, String f) {
    	String textA, textB, textC, textD, textE, textF;
    	set(a, b, c, d, e, f);
	  	try {
            textA = "PotensiF0 = " +F0;
            textB = "PotensiF00 = " +F00;
            textC = "PotensiF123 = " +F123;
            textD = "PotensiF4 = " +F4;
            textE = "PotensiF5 = " +F5;
            textF = "PotensiBrd = " +Brd;
            BufferedWriter out = new BufferedWriter(new FileWriter("C:\\setting.txt"));
            out.write(textA);
            out.newLine();
            out.write(textB);
            out.newLine();
            out.write(textC);
            out.newLine();
            out.write(textD);
            out.newLine();
            out.write(textE);
            out.newLine();
            out.write(textF);
            out.close();
        }
        catch (IOException ex)
        {
            System.out.println("Exception ");
        }
    }

    public static void set(String a, String b, String c, String d, String e, String f){
    	F0 = a;
    	F00 = b;
    	F123 = c;
    	F4 = d;
    	F5 = e;
    	Brd = f;
    }
}
