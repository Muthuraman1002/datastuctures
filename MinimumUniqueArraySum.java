import java.util.Arrays;
import java.util.Scanner;

public class MinimumUniqueArraySum {


    public static void main (String[] args)  
    { 
    	Scanner scan = new Scanner(System.in);
    	int arraylength = scan.nextInt();
    	if(arraylength < 1 || arraylength > 2000)
    	{
    		System.out.println("Enter values less than 2000 or greater than 0"); // As per the constrain given in the pdf
    		return;
     	}	
    	int [] arr = new int[arraylength];
        for (int i = 0; i < arraylength; i++) 
        {
            if (scan.hasNextInt()) 
            {
                arr[i] = scan.nextInt();
                if(arr[i] < 1 || arr[i] > 3000)
                {
                	System.out.println("Enter values less than 3000 or greater than 0"); // As per the constrain given in the pdf
    		        return;
                }	
            } 
        }
        System.out.println(getMinimumUniqueArraySum(arr));
    } 

    private static int getMinimumUniqueArraySum(int[] arr)
    {
    	Arrays.sort(arr);
    	int sum = arr[0];
    	for(int i=1; i < arr.length; i++)
    	{	
            int prev = arr[i-1];
            int curr = arr[i];
        	if(arr[i] == prev)
        	{
        		curr = curr + 1;     // Increments the value if the element and previous element are same
        	}	
        	else if(arr[i] < prev)
        	{
        		curr = prev + 1;  // Increment the previous element and assign it to the array at current index 
            }    
            arr[i] = curr;
         	sum = sum + curr;
        }

        return sum;
    }

}