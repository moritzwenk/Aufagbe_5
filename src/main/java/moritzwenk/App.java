package moritzwenk;
import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
	System.out.println("Bitte geben Sie etwas ein: ");
	String eingabe = sc.next();
	String gross = eingabe.toUpperCase();
	System.out.println(gross);
	sc.close();
    }
}
