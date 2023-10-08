import java.util.Scanner;
import java.util.Random;

class Quicksort_class
{
    public static void swap(int i1,int i2,RnD o)
    {
        int temp = o.arr[i1];
        o.arr[i1] = o.arr[i2] ;
        o.arr[i2] = temp;
    }

    public static int split_func(int li,int ri,RnD o)
    {
        int lp=li, rp=ri+1, pivot=o.arr[li], split;
        do
        {
            do
            {
               lp++;
               if( o.arr[lp]>=pivot )
                  break;
            }while( lp<ri );

            do
            {
               rp--;
               if( o.arr[rp]<=pivot )
                  break;
            }while( rp>li );

            if( lp<rp )
               swap(lp,rp,o);
        }while( lp<rp );

        swap(li,rp,o);
        split = rp;
        return split;
    }

    public static void Quicksort(int li,int ri,RnD o)
    {
       int n=ri-li+1;
       if( n<=1  )
          return;

       int split = split_func(li,ri,o);
       Quicksort(li,split-1,o);
       Quicksort(split+1,ri,o);
    }
}

class RnD
{
   public int n;
   public int[] arr;

   public void read()
   {
      try( Scanner sc = new Scanner(System.in) )
      {
         Random obj = new Random();
         System.out.print("Enter number of elements :  ");
         n = sc.nextInt();
         arr = new int[n];
         System.out.print("Enter list of elements : \n");
         for( int i=0 ; i<n ; i++ )
             { arr[i] = obj.nextInt(100);  }
      }
   }

   public void display()
   {
       for( int i=0 ; i<n ; i++ )
          System.out.print(" "+arr[i]+"  ");
       System.out.println();
   }
}

public class Quicksort_Main
{
    public static void main( String args[] )
    {
         RnD o = new RnD();
         o.read();
         o.display();
         Quicksort_class.Quicksort(0,(o.n-1),o);
         System.out.println("Sorted Array=>");
         o.display();
    }
} 