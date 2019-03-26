package EPAMTASK3;
/* *** QUESTION **** */
/* Protection of the Indian border and safe transport of items from one point to another along the border are the paramount jobs for the Indian army. However they need some information about the protection status along the length of the border. The border can be viewed as the real x-axis. Along the axis, Indian army has N checkpoints for lookout. 

We know that each checkpoint is located at an integer location xi. Each checkpoint must have a fleet of armed men which are responsible for guarding the neighboring areas of the checkpoint and provide military assistance of all kinds. The size of the fleet is based on the location of the checkpoint and how active the region is for terrorist activities. 

Given the number of armed men assigned at the ith checkpoint, as pi, this information is available for all checkpoints. 
With the skills of the armed men, it is known that if for the ith checkpoint, the length on the x axis that they can defend is a closed interval [xi-pi, xi+pi].

Now, your task is to transport some military items from position S to the end position E on the x-axis. 

Input:
First line of the input contains 3 integers N, S and E. N is the number of checkpoints that the Indian Army has on the border.
Then N lines follow. ith line contains 2 integers, xi and pi.

Output:
Print the total distance of the x-axisfrom S to E, that is not protected by the armed forces.*/  

/*import for Scanner and other utility classes*/
import java.util.*;

public class IndianArmy {
  public static void main(String args[] ) throws Exception {
      
  
      int i,no_of_checkPoints;
      long start,end,area_covered=0;
       long x[] = new long[10000000];
        long p[] = new long[1000000]; 
         TreeMap<Long,Long> map=new TreeMap<Long,Long>();
      Scanner sc= new Scanner(System.in);
      no_of_checkPoints=sc.nextInt(); /* reading number of checkpoints */
      start=sc.nextLong();/* reading starting  checkpoint */
      end=sc.nextLong();/* reading ending  checkpoint */
      for(i=0;i<no_of_checkPoints;i++)
      {
          x[i]=sc.nextLong();
          p[i]=sc.nextLong();
      }
     
    
     for(i=0;i<no_of_checkPoints;i++)
     {
         map.put(x[i]-p[i],x[i]+p[i]);/* pushing  the range of ith soldier can protect the area into treemap */
     }
      Long low=start;/* assigning starting area to the low  */
     Long high,partial_low,partial_high;
  
             for(Map.Entry<Long,Long> treemap:map.entrySet())
            	 /*Retrieving the values from tree_map using map object */
             { 
  
              partial_low=(long)treemap.getKey();/* retrieving xi-pi */
              partial_high=(long)treemap.getValue();/* retrieving xi+pi */
     
           
               high=partial_high;/* assigning the partial highest protected area to the high*/
              if(end<partial_low)/* if partial_high area is greater than the end then we need to break */
              break;
              if(low<partial_low)/* if lower area is lesser than the partial area we are adding (partial_low-low) to area_covered */
              area_covered+=partial_low-low;
              if(high>low)/* if higher area is greater than lower area we have assign higher area to lower area */
              low=high;
               
           }
           if(low<end)/* if lower area is not in between the starting and ending of area we need to add( end-low ) to area_covererd*/
           area_covered+=end-low;
           System.out.println(area_covered);/* printing the area_covered*/
           sc.close();
     }

  }