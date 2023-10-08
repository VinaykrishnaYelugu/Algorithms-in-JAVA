import java.util.Scanner;
import java.util.Arrays;

public class uniq
{
    private int n;
    private int[] arr;
    public static void main( String args[] )
    {
       try( Scanner sc = new Scanner( System.in ) )
       {
          uniq o = new uniq();
          System.out.print("Enter number of elements :  ");
          o.n = sc.nextInt();
          o.arr = new int[o.n];
          System.out.println("Enter list of elements....");
          for( int i=0 ; i<o.n ; i++ )
            o.arr[i] = sc.nextInt();
          Arrays.sort(o.arr);
          System.out.println("Sorted array :  ");
          for( int i=0 ; i<o.n ; i++ )
            System.out.print(" "+o.arr[i]+" ");
        
          // Finding uniqueness
          int index=0,i;
          for( i=0 ; i<=o.n-2 ; i++ )
          {
              if( o.arr[i]==o.arr[i+1] )
                {
                    index = i;
                    break;
                }
          }
          if( i==o.n-1 )
            System.out.println("\nAll elements are unique!!");
          else
            System.out.println("\nElement-"+o.arr[index]+" has been repeated !!");
       }

    }
}