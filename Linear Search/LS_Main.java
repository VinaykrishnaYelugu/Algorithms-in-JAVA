import java.util.Scanner;

class RnD
{
    public int n,key;
    public int[] arr;

    public RnD()
    {
        try( Scanner sc = new Scanner(System.in) )
        {
            System.out.print("Enter number of items :  ");
            this.n = sc.nextInt();
            arr = new int[this.n];
            System.out.println("Enter list of elements => ");
            for( int i=0 ; i<n ; i++ )
                arr[i] = sc.nextInt(); 
            System.out.print("Enter key element :  ");
            key = sc.nextInt();
        }
    }

    public void display()
    {
        for( int i=0 ; i<n ; i++ )
            System.out.print(" "+arr[i]+" ");
        System.out.println();
    }
}

class LS_class extends RnD
{
    public int Linear_Search()
    {
        for( int i=0 ; i<n ; i++ )
        {
             if( arr[i]==key )
                return (i+1);
        }
        return -1;
    }
}

public class LS_Main
{
    public static void main( String args[] )
    {
        LS_class o = new LS_class();
        o.display();
        int position = o.Linear_Search();
        if( position==-1 )
           System.out.println(o.key+" not found !!\n");
        else
           System.out.println(o.key+" found !! Position= "+position);
    }
}