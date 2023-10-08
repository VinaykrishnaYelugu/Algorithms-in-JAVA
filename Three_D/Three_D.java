import java.util.Scanner;

class RnD
{
    public int x,y,z,al;
    public int D[];

    public void read()
    {
        try( Scanner sc = new Scanner(System.in) )
        {
            System.out.print("Enter x-dimension length :  "); x = sc.nextInt();
            System.out.print("Enter y-dimension length :  "); y = sc.nextInt();
            System.out.print("Enter z-dimension length :  "); z = sc.nextInt();
            System.out.print("Enter t-dimension length :  "); al = sc.nextInt();
        }
        D = new int[(x*y*z*al)];
    }

    public void display()
    {
        int i,j,k,l;
        for( l=0 ; l<al ; l++ )
        {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Screen-"+l+" @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            for( k=0 ; k<z ; k++ )
            {
                System.out.println("~~~~~~~~~~~~ Plate-"+k+" ~~~~~~~~~~~~~");
                for( j=0 ; j<y ; j++ )
                {
                    for( i=0 ; i<x ; i++ )
                        System.out.print(" ("+i+","+j+","+k+","+l+") ");
                    System.out.println();
                }
            } 
        }  
    }
}

public class Three_D
{
    public static void main( String args[] )
    {
        RnD o = new RnD();
        o.read();
        o.display();
    }
}