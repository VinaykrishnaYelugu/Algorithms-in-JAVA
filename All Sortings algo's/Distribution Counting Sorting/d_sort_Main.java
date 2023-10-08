import java.util.Scanner;
import java.util.Random;

class data
{
    private int n;
    private int[] arr;

    public int get_n()
    { return n; }

    public int[] get_arr()
    { return arr; }

    public data()
    {
        try( Scanner sc = new Scanner(System.in) )
        {
            Random r = new Random();
            System.out.print("Enter number of elements :  "); 
            n = sc.nextInt();
            arr = new int[n];
            System.out.print("Enter list of elements...\n");
            for( int i=0 ; i<n ; i++ )
            {
                arr[i] = r.nextInt()%n;
                System.out.print(" "+arr[i]+" "); // to check random elements
            }
            System.out.println("_______________________________________________________________________________");
        }
    }
}

class distribution extends data
{
    private int[] D;
    private int ll,ul;

    public int get_lower_limit()
    { return ll; }

    public int[] get_distribution_array()
    {  return D; }

    public distribution()
    {
        int i,n = get_n();
        int[] arr = get_arr();
        ll = ul = arr[0];
        for( i=1 ; i<n ; i++ )
        {
            if( arr[i]<ll )
                ll = arr[i];
            else if( arr[i]>ul )
                ul = arr[i];
        }
        D = new int[ul-ll+1];
        for( i=0 ; i<=(ul-ll) ; i++ )
              D[i] = 0;
        for( i=0 ; i<n ; i++ )
              D[arr[i]-ll]+=1;  
        for( i=1 ; i<=(ul-ll) ; i++ )
              D[i]+=D[i-1];  
    }    
}

class sorting extends distribution
{
    public int[] arr2;

    public int[] get_sorted_array()
      { return arr2; }

    public sorting()
    {
        int j,i,n = get_n(),ll = get_lower_limit();
        int[] arr = get_arr(),D = get_distribution_array();
        arr2 = new int[n];
        for( i=n-1 ; i>=0 ; i-- )
        {
            j = arr[i]-ll;
            arr2[D[j]-1] = arr[i];
            D[j]-=1;
        }
    }
}

public class d_sort_Main
{
    public static void main( String[] args )
    {
       sorting o = new sorting();
       int [] arr = o.get_sorted_array();
       System.out.println("Sorted array =>");
       for( int i=0 ; i<o.get_n() ; i++ )
          System.out.print(" "+arr[i]+" ");
    }
}