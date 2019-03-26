package EPAMTASK3;
/* ***QUESTION*** */
/* There is an infinite series of bulbs indexed from 1. And there are 40 switches indexed from 1 to 40. Switch with index x is connected to the bulbs with indexes that are multiple of x. i.e switch 2 is connected to bulb 4, 6, 8 ....

You can easily observe that some bulbs are connected to multiple switches and some are not connected to any switch.

Chotu is playing with these switches, he wants to know the Kth glowing bulb from the start if certain switches are in ON state. If any of the switch is ON, connected to any bulb then bulb starts glowing. But chotu has special fond of prime numbers so he only puts prime indexed switches ON.

INPUT-

First line contains number of test cases (T). Each test case contains two lines- First line contains a string S of length 40 containing 0s and 1s that represents the state of bulbs. 1 is ON , 0 is OFF. Second line contains one integer k. Atleast One switch is in ON condition.

OUTPUT-

Output one integer per test case representing kth glowing bulb.*/
import java.util.*;
public class GlowingBulbs
{
    public static long sum = 0;
    public static void combiutil(ArrayList<Integer> arr,int[] data,int start,int end,int index,int r,long mid)
    {
        if(index == r)
        {
            long temp = 1;
            for(int j=0;j<r;j++)
            {
                temp = temp*data[j];/* factors of the current data[j] value */
            }
            long temp1 = mid/temp;/* again adding the glowing bulbs position to sum*/
            sum = sum + temp1;
            return;
        }
        for(int i=start;i<=end && end-i+1>=r-index;i++)
        {
            data[index] = arr.get(i);
            combiutil(arr,data,i+1,end,index+1,r,mid);
        }
    }
    public static void combination(ArrayList<Integer> arr,int n,int r,long mid)
    {
        int[] data = new int[r];
        combiutil(arr,data,0,n-1,0,r,mid);/* calling combiutil function with arrayList,data_array,arrayList_size-1,current ith posioition,mid*/
    }
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();/* reading no.of test cases */
        for(int g=0;g<t;g++)
        {
            String line = in.next();/* reading bulbs status */
            long k = in.nextLong();
            ArrayList<Integer> arr = new ArrayList<Integer>();/* creating arrayList*/
            for(int i=0;i<line.length();i++)
            {
                if(line.charAt(i) == '1')
                {
                    arr.add(i+1);/* pushing the status of ON bulbs position */
                }
            }
            if(arr.size() == 1)/* checking if arrayList contains only one Glowing bulb */
            {
                System.out.println(arr.get(0)*k);
            }
            else
            {
                long low = arr.get(0);
                long high = arr.get(0)*k;
                long glowing_bulb= 0;/* initially glowing bulbs position is zero */
                
                while(low <= high)
                {
                    long count = 0;
                    long mid = (low + high)/2;
                    for(int i=0;i<arr.size();i++)
                    {
                        long d = mid/arr.get(i);/* getting the glowing bulbs position before the mid and add those bulbs position
                        to the count variable*/
                        count = count + d;
                    }
                    
                    for(int i=2;i<=arr.size();i++)
                    {
                        sum = 0;
                        combination(arr,arr.size(),i,mid);/* calling combination function with these parameters */
                        if(i%2==0)
                        {
                            count = count - sum;/* if i is even then we have to deduct sum from count  
                            else we have to add count to sum */
                        }
                        else
                        {
                            count = count + sum;
                        }
                    }
                    //count = count - (arr.size() - 1);
                    //System.out.println(count);
                    if(count < k)
                    {
                        low = mid + 1;
                    }
                    else
                    {
                        glowing_bulb = mid;/* assigning mid to glowing_bulb if count lesser than the given k position*/
                        high = mid - 1 ;
                    }
                }
                System.out.println( glowing_bulb);
            }
        }
        in.close();
    }
}