import java.util.Scanner;

class read
{
    protected int n;
    protected int[] arr;

    read()
    {
        int i;
        try( Scanner sc = new Scanner(System.in) )
        {
            System.out.print("Enter number of elements :  ");
            n = sc.nextInt();
            arr = new int[n];
            System.out.print("Enter array elements.. \n");
            for( i=0 ; i<n ; i++ )
              arr[i] = sc.nextInt();
        }
    }
}

class unique_check extends read
{
    unique_check()
    {
        int i,j=0;
        for( i=0 ; i<n ; i++ )
        {
            for( j=i+1 ; j<n ; j++ )
            {
                if( arr[i]==arr[j] )
                   break; 
            }
            if( j!=n )
                break;
        }

        if( j!=n )
          System.out.println("Element "+arr[i]+" repeated !!");
        else
          System.out.println("All elements in list are unique !!");
    }
}


public class uniqueness
{
    public static void main( String args[] )
    {
        unique_check o = new unique_check();
    }
}