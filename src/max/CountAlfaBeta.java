package max;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountAlfaBeta {
	public static void main(String[] args) {
		System.out.println("Enter the string: ");
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		//replace the white space
		s=s.replace(" ", "");
		//
		char arr[]=s.toCharArray();
		
		//apply the logic
		int count=0;
		
		Map <Character,Integer> map=new TreeMap<>();
		for(int i=0; i<arr.length; i++)
		{
			count=0;
			for(int j=0; j<arr.length; j++)
			{
				if(arr[i]==arr[j])
				{
					count++;
				}
			}
			//store the char and count
			map.put(arr[i],count );
			
		}
		System.out.println(map);
	}

}
