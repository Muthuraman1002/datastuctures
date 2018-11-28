import java.io.*; 
import java.util.*;

public class CountingPairs {


    public static void main (String[] args)  
    { 
    	Scanner scan = new Scanner(System.in);
    	int arraylength = scan.nextInt();
    	if(arraylength < 1 || arraylength > 200000)
    	{
    		System.out.println("Enter values less than 2000 or greater than 0"); // As per the constrain given in the pdf
    		return;
     	}	
    	long [] arr = new long[arraylength];
        for (int i = 0; i < arraylength; i++) 
        {
            arr[i] = scan.nextLong();
            if(arr[i] < 0 || arr[i] > 1000000000l)
            {
                System.out.println("Enter values less than  1000000000 or greater than 0"); // As per the constrain given in the pdf
    		    return;
            }	
        }
        long diff = scan.nextInt();
        if(diff < 0 || diff > 1000000000l)
        {
            System.out.println("Enter values less than 1000000000 or greater than 0"); // As per the constrain given in the pdf
            return;
        }   
        System.out.println(getThePairCount(arr, diff));
    } 

    private static int getThePairCount(long[] arr, long diff)
    {
    	Arrays.sort(arr);
    	
        int paircount = 0;
        int left_index = 0;
        int right_index = 1;

        int arr_length = arr.length;
        while(right_index < arr_length)
        {    
            if(arr[right_index] - arr[left_index] == diff)
            {
                paircount = paircount + 1;
                left_index = (left_index + 1 < arr_length && arr[left_index] == arr[left_index + 1] ) ? right_index : right_index - 1;
                right_index++;
            }    
            else if(arr[right_index] - arr[left_index] > diff)
            {
                left_index++;
            }    
            else
            {
                right_index++;
            }  
        }
        return paircount;      
    }

}