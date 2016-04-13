import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.security.auth.kerberos.KerberosKey;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Main 
{

	/*
	private static long result = 0;
	public static boolean D = true;
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();
	*/
	
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		System.out.println(solve(9));
	}
	
	public static List<String> solve(int n)
	{
		
		List<String> returnRes = new ArrayList<String>();
		
		List<String> list = new ArrayList<String>();
		list.add("");
		
		List<String> possibleSymbols = permutation("+-&", list, n-1);
		
		for(String symbol : possibleSymbols)
		{
			if(isEqual(symbol, 100))
			{
				returnRes.add(generateEquation(symbol));
			}
		}
		
		
		return returnRes;
	}
	
	public static String generateEquation(String symbols)
	{
		String string = "1";
		for(int i=0;i<symbols.length();i++)
		{
			char c = symbols.charAt(i);
			if(c == '&')
			{
				string = string + (i+2);
			}else
			{
				string = string + c + (i+2);
			}
			
		}
		
		return string;
	}
	
	public static boolean isEqual (String symbols, int result)
	{
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		
		for (int i=0;i<symbols.length();i++)
		{
			
			if(symbols.charAt(i)=='+')
			{
				list.add(i+2);
			}else if(symbols.charAt(i)=='-')
			{
				list.add(-(i+2));
			}else {
				int lastdig = list.remove(list.size()-1);
				int newdig = lastdig*10;
				if (newdig>0){
					newdig = newdig + i+2;
				}else
				{
					newdig = newdig -( i+2);
				}
				
				list.add(newdig);
			}
		}
		int sum = 0;
		for(int i : list){
			sum += i;
		}
		
		return sum==result;
	}
	public static List<String> permutation (String optionChars, List<String> permutation, int length)
	{
		
		if (permutation.get(0).length()==length) return permutation;
		
		ArrayList<String> newPermutation = new ArrayList<String>();
		
		for (int i=0; i < optionChars.length(); i++)
		{
			char c = optionChars.charAt(i);
			for (int j = 0; j < permutation.size(); j++)
			{
				String perItem = permutation.get(j);
				newPermutation.add(c + perItem);
			}
		}
		
		return permutation(optionChars, newPermutation, length);
		
	}
}
