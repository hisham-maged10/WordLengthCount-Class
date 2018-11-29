import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
public class WordLength
{
			
	private File getFile()
	{
		JFileChooser chooser=new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		try{
		do
		{
			System.out.println("Please select a txt file!");
			chooser.showOpenDialog(null);	
		}while(chooser.getSelectedFile()==null);
		}catch(NullPointerException ex){System.out.println("Incorrect Respone"); return getFile();}
		return chooser.getSelectedFile();
	}
	
	public void countWordLengths(File source,int[] counts)
	{
		try(BufferedReader reader=new BufferedReader(new FileReader(source)))
		{
			String line=null;
			for(int i=0;(line=reader.readLine())!=null;i++)
			{
				String[] tokens=modifyTokens(line.split(" "));
				for(int k=1;k<counts.length;k++)
				{
					for(String e:tokens)
					if(e.length()==k)counts[k]++;
					
				}
			}
		}catch(IOException ex){ex.printStackTrace();}
	}
	private String[] modifyTokens(String[] tokens)
	{
		int j=0;
		for(String e:tokens)tokens[j++]=removeNonLetters(e);	
		return tokens;
	}
	private String removeNonLetters(String str)
	{
		StringBuilder sb=new StringBuilder();
		for(int i=0,n=str.length();i<n;i++)
		{
			if(Character.isLetter(str.charAt(i)))
			sb.append(str.charAt(i));
			else if(str.charAt(i)=='\'')
			sb.append(str.charAt(i));
			else
			continue;
		}
		return sb.toString();
	}
	public int indexOfMax(int[] values)
	{
		int[] arrCopy=new int[values.length];
		System.arraycopy(values,0,arrCopy,0,values.length);
		Arrays.sort(arrCopy);
		for(int i=0;i<arrCopy.length;i++)
		if(values[i]==arrCopy[arrCopy.length-1])
		return i;
		return -1;
	}
	
	public void testCountWordLengths(int n)
	{
		int[] counts=new int[n+1];
		countWordLengths(getFile(),counts);
		int i=0;
		for(Integer e:counts)
		System.out.println("words of length "+i+" character"+((i++>1)?"s":"")+": "+e);
		System.out.println("common words' length is: "+indexOfMax(counts));
	}
	
}