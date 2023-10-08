// linear class efficiency
import java.util.Scanner;

class data
{
    private int n;
    private int[] arr;
    Scanner sc = new Scanner(System.in);

    public void set_n()
    {
        System.out.print("Enter number of elements :  ");
        n = sc.nextInt();
    }

    public int get_n()
    { return n; }

    public void set_arr()
    {
        arr = new int[n];
        System.out.println("Enter elements in the list.....");
        for( int i=0 ; i<n ; i++ )
           arr[i] = sc.nextInt();
    }

    public int[] get_arr()
    { return arr; }

}

class find_large
{
   private int max;

   public find_large( data o )
   {
      int n = o.get_n();
      int[] arr = o.get_arr();
      max = divide(arr,0,(n-1));
   }

   public int get_max()
   { return max; }

   public int divide(int[] arr,int l,int r)
   {
      if( l==r )
        return arr[l];
      int mid = (r-l)/2;
      int max1 = divide(arr,l,(l+mid));
      int max2 = divide(arr,(l+mid+1),r);
      return ( (max1>max2) ? max1 : max2 );
   }
}

public class large 
{
    public static void main( String args[] )
    {
       data o = new data();
       o.set_n();
       o.set_arr();
       find_large o1 = new find_large(o);
       System.out.println("Maximum element in list = "+o1.get_max());
    }
}