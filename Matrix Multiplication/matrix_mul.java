import java.util.Scanner;

class read
{
    protected int m1,n1,m2,n2;
    protected double[][] M1,M2;

    public read()
    {
        int i,j;
        try( Scanner sc = new Scanner(System.in) )
        {
            System.out.println("Enter size of matrix-1 ");
            System.out.print(" No.of rows :  "); m1 = sc.nextInt();
            System.out.print("No.of columns :  "); n1 = sc.nextInt();

            System.out.println("Enter size of matrix-2 ");
            System.out.print(" No.of rows :  "); m2 = sc.nextInt();
            System.out.print("No.of columns :  "); n2 = sc.nextInt();
            if( n1!=m2 )
              {
                 System.out.println("Matrix multiplication not possible!!\n");
                 return ;
              }
            M1 = new double[m1][n1];
            System.out.println("Enter Matrix-1 ");
            for( i=0 ; i<m1 ; i++ )
            {
                for( j=0 ; j<n1 ; j++ )
                   M1[i][j] = sc.nextInt();
            }
            M2 = new double[m2][n2];
            System.out.println("Enter Matrix-2 ");
            for( i=0 ; i<m2 ; i++ )
            {
                for( j=0 ; j<n2 ; j++ )
                   M2[i][j] = sc.nextInt();
            }
        }
    }
}

class Multiplication extends read
{
      protected int[][] R = new int[m1][n2];
      
      public Multiplication()
      {
         int i,j,k;
         for( i=0 ; i<m1 ; i++ )
         {
            for( j=0 ; j<n2 ; j++ )
            {
                R[i][j] = 0;
                for( k=0 ; k<n1 /* (or) k<m2 */ ; k++ )
                  R[i][j] += (M1[i][k]*M2[k][j]) ;
            }
         }
      }
}

class display
{
    public display(Multiplication o)
    {
       System.out.println("Matrix Multiplication => \n");
       int i,j;
       for( i=0 ; i<o.m1 ; i++ )
       {
         for( j=0 ; j<o.n2 ; j++ )
            System.out.print(" "+o.R[i][j]+" ");
         System.out.println();
       }
    }
}

public class matrix_mul
{
    public static void main( String[] args )
    {
        Multiplication o = new Multiplication();
        display o1 = new display(o);
        o1 = null;
    }
}