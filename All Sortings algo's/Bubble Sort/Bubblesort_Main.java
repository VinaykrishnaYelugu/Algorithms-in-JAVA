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

class Bubblesort_class extends read
{
   public Bubblesort_class()
   {
      System.out.println("Entered list if elements =>");
      display();
      System.out.println("Bubble Sorting...");
      for( int i=0 ; i<n-1 ; i++ )
      {
        for( int j=0 ; j<n-i-1 ; j++ )
        {
           if( arr[j+1]<arr[j] )
              swap((j+1),j);
        }
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

public class Bubblesort_Main
{
    public static void main( String args[] )
    {
        Bubblesort_class o = new Bubblesort_class();
        System.out.println("Sorted array =>");
        o.display();
    }
}