import java.util.Scanner;

class Heapify_sorting
{
   public void swap( int i1,int i2,R_and_D o)
   {
     int temp = o.H[i1];
     o.H[i1] = o.H[i2] ;
     o.H[i2] = temp;
   }

   public void Heapify(int pi,R_and_D o)
   {
      System.out.println("***********\n"+pi);
      if( 2*pi>o.n )
         return;
      int ci=-999 ;
      if( 2*pi==o.n )
         ci = 2*pi;
      else if( 2*pi<o.n )
         ci = ( o.H[2*pi] > o.H[2*pi+1] ) ? (2*pi) : (2*pi+1) ;
      
      if( o.H[pi]<o.H[ci] )
         {
            swap(pi,ci,o);
            Heapify(ci,o);
         }
   }

   public void Heap(R_and_D o)
   {
      int i;
      for( i=(o.n/2) ; i>=1 ; i-- )
          Heapify(i,o);    
   }

   public int sorting(R_and_D o)
   {
      int ne=o.n;
      while( o.n>=1 )
      {
         swap(1,o.n,o);
         o.n--;
         Heapify(1,o);
      }
      return ne;
   }
}

class R_and_D
{
   public int n;
   public int[] H;

   public void read()
   {
      int i;
      try( Scanner sc = new Scanner(System.in) )
      {
        System.out.print("Enter number of vertices :  ");
        n = sc.nextInt();
        H = new int[n+1];
        System.out.println("Enter list of elements \n");
        for( i=1 ; i<=n ; i++ )
            H[i] = sc.nextInt();
      }
   }

   public void display()
   {
      System.out.println("List of elements : ");
      for( int i=1 ; i<=n ; i++ )
         System.out.print(" "+H[i]+" ");
      System.out.println(); 
   }
}

public class HEAP_SORT
{
    public static void main( String args[] )
    {
         R_and_D o = new R_and_D();
         o.read();
         o.display();
         Heapify_sorting o1 = new Heapify_sorting();
         o1.Heap(o);
         o.n = o1.sorting(o);
         o.display();
    }
}
