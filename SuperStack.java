import java.io.*; 
import java.util.*;

public class SuperStack {

    public static void main (String[] args)  
    { 
    	Scanner scan = new Scanner(System.in);
 
         // No of operations
        int noofoperations = Integer.parseInt(scan.nextLine());

        String operationlist[] = new String[noofoperations];
 
        // Get the list of operations
        for (int i = 0; i < noofoperations; i++) 
        {
                operationlist[i] = scan.nextLine();
        }
        superStack(operationlist);
    }

    private static void superStack (String[] operationlist)
    {
       ArrayList<Integer> stack = new ArrayList<Integer>();
       if(operationlist == null)
       {
        System.out.println("EMPTY");
       } 

       int stackindex = 0;

       for(int i = 0; i < operationlist.length; i++)
       {
          String operation = operationlist[i];
          if(operation.equals("pop"))
          {
            stackindex = stackindex - 1;
            stack.remove(stackindex);
            if(stackindex < 1)
            {
                System.out.println("EMPTY");
            }
            else
            {
                System.out.println(stack.get(stackindex - 1)); 
            }    
          }  
          else if(operation.startsWith("push"))
          {
            int element = Integer.parseInt(operation.split(" ")[1]);
            stack.add(element);
            System.out.println(stack.get(stackindex));
            stackindex = stackindex + 1;
          }  
          else if(operation.startsWith("inc"))
          {
            String[] elements = operation.split(" ");
            int index = Integer.parseInt(elements[1]);
            int inc = Integer.parseInt(elements[2]);
            if(index >= stack.size())
            {
                System.out.println("Index given for the inc is out of the size of stack try again");
                return;
            }    
            for(int k =0 ; k < index; k++)
            {    
                int newvalue = stack.get(k) + inc;
                stack.remove(k);
                stack.add(k,newvalue);
            } 
            System.out.println(stack.get(stackindex-1));
          }  
       }

    }
}