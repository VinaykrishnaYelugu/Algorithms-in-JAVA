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

class Selectionsort_class extends read
{
   public Selectionsort_class()
   {
      System.out.println("Entered list if elements =>");
      display();
      System.out.println("Selection Sorting...");
      int mi;
      for( int i=0 ; i<n-1 ; i++ )
      {
        mi = i;
        for( int j=i+1 ; j<n ; j++ )
        {
            if( arr[j] < arr[mi] )
              mi = j;
        }
        swap(mi,i);
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

public class S_sort_Main
{
    public static void main( String args[] )
    {
        Selectionsort_class o = new Selectionsort_class();
        System.out.println("Sorted array =>");
        o.display();
    }
}