package EPAMTASK3;
/* ***QUESTION*** */
/*You have been given an array A of size N and an integer K. This array consists of N integers ranging from 1 to . Each element in this array is said to have a Special Weight. The special weight of an element  is .

You now need to sort this array in Non-Increasing order of the weight of each element, i.e the element with the highest weight should appear first, then the element with the second highest weight and so on. In case two elements have the same weight, the one with the lower value should appear in the output first.

Input Format:

The first line consists of two space separated integers N and K. The next line consists of N space separated integers denoting the elements of array A.

Output Format:

Print N space separated integers denoting the elements of the array in the order in which they are required. */
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Scanner;

public class DescendingWeights {
    public static void main(String args[] ) throws Exception {
        
        int i,length_of_array,divisor;
        int a[]=new int[100000];/* which is used to store the given array elements */
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Scanner sc= new Scanner(System.in);
        length_of_array=sc.nextInt();/* reading the array length */
        divisor=sc.nextInt();/* reading the divisor */
        for(i=0;i<length_of_array;i++)
        	a[i]=sc.nextInt();/* reading the array */

        for(i=0;i<length_of_array;i++)
        {
        	int remainder=a[i]%divisor;
        	map.put(a[i],remainder);/* putting the a[i] th value and and corresponding remainder to map */
        }
         Set<Entry<Integer, Integer>> set = map.entrySet();/* creating object for the Set */
        List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(set);
        /* Sorting the map based on values in map */
        Collections.sort( list, new Comparator<Map.Entry<Integer, Integer>>()
        {
            public int compare( Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );/* comparing the two values and returning
                 weather to interchange or not */
            }
        } );
        for(Map.Entry<Integer, Integer> entry:list){
            System.out.print(entry.getKey()+" ");/* printing the keys from map using entry object */
     
       sc.close();

    }
}
}

