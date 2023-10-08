import java.util.Scanner;
import java.util.Random;

class read
{
   public int n;
   public int[] arr;

   public read()
   {
      try( Scanner sc = new Scanner(System.in) )
      {
        Random r = new Random();
        System.out.print("Enter number of elements :  ");
        n = sc.nextInt();
        arr = new int[n];
        System.out.println("Enter list of elements =>");
        for( int i=0 ; i<n ; i++ )
           arr[i] = r.nextInt(100);
      }
   }
}

class Insertionsort_class extends read
{
   public Insertionsort_class()
   {
      System.out.println("Entered list if elements =>");
      display();
      System.out.println("Insertion Sorting...");
      int i,j,insert;
      for(  i=1 ; i<n ; i++ )
      {
        insert = arr[i];
        for(  j=i-1 ; j>=0 ; j-- )
        {
            if( arr[j] < insert )
              break;
            else
               arr[j+1] = arr[j];
        }
        arr[j+1] = insert;
      }
   }

   public void swap(int i1,int i2)
   {
      int temp = arr[i1];
      arr[i1] = arr[i2];
      arr[i2] = temp;
   }

   public void display()
   {
       for( int i=0 ; i<n ; i++ )
          System.out.print(" "+arr[i]+" ");
       System.out.println();
   }
}

public class I_sort_Main
{
    public static void main( String args[] )
    {
        Insertionsort_class o = new Insertionsort_class();
        System.out.println("Sorted array =>");
        o.display();
    }
}