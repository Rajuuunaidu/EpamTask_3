package EPAMTASK3;
/* ***QUESTION*** */ 


/*A young mischievous boy Harsh, got into a trouble when his mechanical workshop teacher told him to cut Iron rods. The rod cutting algorithm is as follows:

Step 1. If the rod can be divided into two equal parts, cut it and choose any one of them.

Step 2. Else cut the rod into two parts having non-zero integral lengths such that the difference between the lengths of the two pieces is minimized, and then choose the piece having smaller length.

Step 3. Repeat the above algorithm with the currently chosen piece. If the length of the currently chosen piece becomes 1 , stop the algorithm.

There can be special rods which require Step 2 in every step of its cutting. Harsh want to find out the number of such special rods. Help Harsh to find out the answer. */

	
	
	/*import for Scanner and other utility classes*/
	import java.util.Scanner;

	public class RodCutting {
	    public static void main(String args[] ) throws Exception {
	        
	        int test_cases,rod_length,no_of_specialRods=0;
	        Scanner sc=new Scanner(System.in);
	        /* creating object for scanner scale */
	        test_cases=sc.nextInt();
	        for(int i=0;i<test_cases;i++)
	        {
	        	rod_length=sc.nextInt();/* reading the rod length from user */
	        	int length=3;/* we have assigned with 3 because for 1,2 special rods count is zero 
	        	we have started from 3*/
	        	while(length<=rod_length) /* checking the length less than or equal to length of given rod */
	        	{
	        		no_of_specialRods++;/*incrementing the number of special rods */
	        		length=length*2+1; /* making the number as odd*/
	        	}
	    
	        	System.out.println(no_of_specialRods);/* printing the number of special rods */
	        	no_of_specialRods=0; /* assigning special rods to zero for next test case */
	        	sc.close();
	        }	        
	    }
	}


