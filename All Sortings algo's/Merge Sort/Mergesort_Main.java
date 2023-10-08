import java.util.Scanner;
import java.util.Random;

class Mergesort_class
{
    public static void Merge_sort(int li1,int ri1,int li2,int ri2,RnD o)
    {
       int i=li1, j=li2, k=-1;
       int n1=(ri1-li1+1), n2=(ri2-li2+1);

       int[] dup = new int[(n1+n2)];

       while( i<=ri1 && j<=ri2 )
       {
         if( o.arr[i]<o.arr[j] )
              dup[++k] = o.arr[i++];
         else
              dup[++k] = o.arr[j++];
       }

       while( i<=ri1 )
         {  dup[++k] = o.arr[i++];  }
       while( j<=ri2 )
         {  dup[++k] = o.arr[j++];  }

       for(  i=0 ; i<=k ; i++ )
          o.arr[li1+i] = dup[i] ;

       dup = null;
    }

    public static void separate(int li,int ri,RnD o)
    {
       int n=ri-li+1;
       if( n<=1 )
          {  return;  }
       int li1=li , ri1=(li+(ri-li)/2) , li2=ri1+1 , ri2=ri;
       separate(li1,ri1,o);
       separate(li2,ri2,o);
       Merge_sort(li1,ri1,li2,ri2,o);
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
            System.out.print("Enter list of elements :  ");
            for( int i=0 ; i<n ; i++ )
               arr[i] = obj.nextInt(100);
        }
    }

    public void display(int li,int ri)
    {
        System.out.println("----------------------------------------------------------------------------------------");
        for( int i=li ; i<=ri ; i++ )
           System.out.print(" "+arr[i]+" ");
        System.out.println("\n----------------------------------------------------------------------------------------");
    }
}

public class Mergesort_Main
{
    public static void main( String args[] )
    {
        RnD o = new RnD();
        o.read();
        o.display(0,o.n-1);
        Mergesort_class.separate(0,(o.n-1),o);
        o.display(0,o.n-1);
    }
}

