import java.util.Scanner;

class read
{
    int[]  arr;
    int n,key; // here n is instance variable

    public read(int n,Scanner sc) // n is local variable
    {
            this.n = n; // this.n referes to instance variable and n refers to local variable
            arr = new int[n];
            System.out.println("Enter list of elements =>");
            for( int i=0 ; i<n ; i++ )
                arr[i] = sc.nextInt();
            System.out.print("Enter key element :  ");
            key = sc.nextInt();
    }
}

class Binarysearch_class  extends read
{
    public Binarysearch_class(int n,Scanner sc)
    {
        super(n,sc);
        System.out.println("Sorted list of elements =>");
        for( int i=0 ; i<n ; i++ )
          System.out.print(" "+arr[i]+" ");
        System.out.println();
    }

    public int Binarysearch_func(int low,int high)
    {
       int mid = (low+high)/2;

       if( arr[mid]==key )
           return mid;
       else if( key < arr[mid] )
           high = mid-1 ;
       else
           low = mid+1 ;

        return Binarysearch_func(low,high);
    }
}

public class BS_Main
{
    public static void main( String args[] )
    {
        int n;
        try( Scanner sc = new Scanner(System.in) )
        {
            System.out.print("Enter number of elements :  ");
            n = sc.nextInt();
            Binarysearch_class o = new Binarysearch_class(n,sc);

            int position = o.Binarysearch_func(0,(o.n-1));
            if( position==-1 )
                System.out.println("\n"+o.key+" Not Found!!");
            else
                System.out.println("\n"+o.key+" Found!! Position="+(1+position));
            sc.close();
        }
    }
}