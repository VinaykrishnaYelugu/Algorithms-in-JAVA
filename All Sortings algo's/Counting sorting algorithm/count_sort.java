import java.util.Scanner;
import java.util.Random;

class data
{
    private int n;
    private int[] arr1;
    private int[] cnt;

    public void read()
    {
       try( Scanner sc = new Scanner(System.in) )
       {
          Random r = new Random();
          System.out.print("Enter number of elemets :  ");
          n = sc.nextInt();
          arr1 = new int[n];
          cnt = new int[n];
          System.out.print("Enter list of elements :  ");
          for( int i=0 ; i<n ; i++ )
            {
                cnt[i] = 0;
                arr1[i] = r.nextInt()%n;
                System.out.print(" "+arr1[i]+" ");
            }
          System.out.println();
       }
    }

    public int get_n()
    { return n; }

    public int[] get_arr1()
    { return arr1; }

    public int[] get_cnt_arr()
    { return cnt; }
}

class sort extends data
{
    private int[] arr2;
    public int[] sorting()
    {
       read();
       int n = get_n();
       int[] arr1 = get_arr1();
       int[] cnt = get_cnt_arr();
       arr2 = new int[n];

       // creating the counting array 
       int i,j;
       for( i=0 ; i<(n-1) ; i++ )
       {
           for( j=i+1 ; j<n ; j++ )
           {
              if( arr1[i] > arr1[j] )
                 { cnt[i]+=1 ;  }
              else
                 { cnt[j]+=1;   }
            }
       } 

       // finding sorting array in new array2
       for( i=0 ; i<n ; i++ )
          arr2[cnt[i]] = arr1[i];

       return arr2;
    }
}

public class count_sort
{
    public static void main( String args[] )
    {
       sort o = new sort();
       int[] arr = o.get_arr1();
       arr = o.sorting();
       System.out.println("Sorted array => ");
       for( int i=0 ; i<o.get_n() ; i++ )
          System.out.print(" "+arr[i]+" ");
    }
}