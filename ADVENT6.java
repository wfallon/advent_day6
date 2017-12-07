import java.util.ArrayList;
import java.util.Arrays;

public class ADVENT6 
{
	//14 0 15 12 11	11 3 5 1 6 8 4 9 1 8 4
	public static void main(String[] args)
	{
		ArrayList<Integer> inputs = new ArrayList<Integer>(Arrays.asList(14, 0, 15, 12, 11, 11, 3, 5, 1, 6, 8, 4, 9, 1, 8, 4));
		System.out.print(findCycles(inputs));
	}
	
	public static int findCycles (ArrayList<Integer> inputs)
	{
		ArrayList<ArrayList<Integer>> iterations = new ArrayList<ArrayList<Integer>>();
		
		while(true)
		{
			int index = findMaxIndex(inputs);
			int holder = inputs.get(index);
			inputs.set(index, 0);
			
			while(holder != 0)
			{
				index++;
				if(index >= inputs.size())
					index = 0;
				inputs.set(index, inputs.get(index) + 1);
				holder--;
				
			}
			
			for(int i = 0; i< iterations.size(); i++)
			{
				if(inputs.equals(iterations.get(i)))
				{
					return iterations.size() + 1;
				}
			}
			
			ArrayList<Integer> newlist = new ArrayList<Integer>();
			for(int i = 0; i < inputs.size(); i++)
			{
				newlist.add(i, inputs.get(i));
			}
			iterations.add(newlist);
			
			
		}
	}	
	//finds and returns the highest index in array (ties won by lowest index)
	public static int findMaxIndex (ArrayList<Integer> arr)
	{
		int holder = 0;
		int max = 0;
		for(int i = 0; i< arr.size(); i++)
		{
			if(arr.get(i) > max)
			{
				max = arr.get(i);
				holder = i;
			}
		}
		return holder;
	}
}
