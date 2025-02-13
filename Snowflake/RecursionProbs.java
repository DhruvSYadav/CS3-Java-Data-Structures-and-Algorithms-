import java.util.*;
/**
 * Write a description of class RecursionProbs here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RecursionProbs
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class RecursionProbs
     */
    public RecursionProbs()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static double sumReciprocals(int n)
    {
        // put your code here
        if (n == 1)
        {
            return 1;
        }
        
        return (double)(1.0/n) + sumReciprocals(n-1);
        
    }
    
    public static int productOfEvens(int n)
    {
        if(n==1)
        {
            return 2;
        }
        else{
            return productOfEvens(n-1) * (n*2);
        }
        
        
       
    }
    
    public static String conversion(int num, int base)
    {
        if(num== 0)
        {
            return "";
        }
        
        return"" + conversion(num/base,base) + num%base;
    
    }
    
    /*public int matchingDigits(int a, int b)
    {
         //divide by 10 to get to the next digit and then modulus 10 to see if they are equal
        if(a==0)
        {
           return 0;
        }
        if(b==0)
        {
            if(a%10 == b%10)
            {
               return 
            }
        }
        
    }*/
    
    /*public void doubleup (Stack<Integer> nums)
    {
        if(nums.isEmpty())
        {
            return;
        }
        
        int duplicate = nums.pop();
        
        doubleup(nums);
        
        nums.push(duplicate);
        nums.push(duplcate);
        
        return nums;
    }*/
    
    public static void printThis(int n)
    {
        if(n==1)
        {
            System.out.print("*") ;
        }
        
        else if(n==2)
        {
            System.out.print("**");
        }
        else{ 
            System.out.print("<");
            printThis(n-2);
            System.out.print(">");
            
        }
        
    }
    
    public static void printNums2(int n)
    {
         if(n==1)
        {
            System.out.print("1") ;
        }
        
        else if(n==2)
        {
            System.out.print("1 1");
        }
        else{ 
            System.out.print(n/2 + " ");
            printNums2(n-2);
            System.out.print(" " + n/2);
            
        }
    }
    
    
    
    
    
    public static void main ( String[] args )
    {
        System.out.println(sumReciprocals(10));
        System.out.println(productOfEvens(4));
        System.out.println(conversion(10,2));
        
    }
    
}






