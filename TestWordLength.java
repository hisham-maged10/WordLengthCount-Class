/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
import java.util.Scanner;
public class TestWordLength
{
	public static void main(String[] args)
	{
		testing();
	}
	public static void testing()
	{
		WordLength wl=new WordLength();
		System.out.println("Enter the length you want to check on (integer only): ");
		try{wl.testCountWordLengths(new Scanner(System.in).nextInt());}
		catch(NumberFormatException | NegativeArraySizeException ex ){
			System.out.println("Incorrect number format");
			return;
		}
	}
}