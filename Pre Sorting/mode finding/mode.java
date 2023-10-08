import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;


class data
{
    private static int n;
    private static int[] arr;

    public static void set_data()
    {
        try( Scanner sc = new Scanner(System.in) )
        {
            Random r = new Random();
            System.out.print("Enter number of elements :  ");
            n = sc.nextInt();
            arr = new int[n];
            System.out.print("Enter array elements..\n");
            for( int i=0 ; i<n ; i++ )
                 arr[i] = r.nextInt()%(n);
            System.out.print("Array elements..\n");
            for( int i=0 ; i<n ; i++ )
                 System.out.print(" "+arr[i]+" ");
            System.out.println();           
        }
    }

    public static int get_n()
    { return n; }

    public static int[] get_arr()
    { return arr; }
}

class find_mode
{
    private static int fm;
    public static int mode_value()
    {
        int i,count;
        int n = data.get_n();
        int[] arr = data.get_arr();

        // sorting
        Arrays.sort(arr);
        System.out.print("Array elements..\n");
        for(  i=0 ; i<n ; i++ )
            System.out.print(" "+arr[i]+" ");
        System.out.println();

        int mi=0;
        fm=1;
        i=0; count=1;
        do
        {
           count=1;
           while( (i<(n-1)) && arr[i+1]==arr[i] )
           { count++;  i++;  }

           if( count>fm )
           {  fm = count; mi = i; }
           i++;
        }while( i<=(n-2) );

        return mi;
    }
    public static int get_max_freq()
    { return fm; }
}

class mode
{
    public static void main( String[] args )
    {
       data.set_data();
       int i=find_mode.mode_value();
       int[] arr=data.get_arr();
       System.out.println("\nMode is = "+arr[i]+" frequency = "+find_mode.get_max_freq());
    }
}