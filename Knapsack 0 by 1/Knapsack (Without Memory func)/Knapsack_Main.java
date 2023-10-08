import java.util.Scanner;

class read_display
{
    public int n,W,top=-1;
    public int[] w,v,M,order;

    public void display_elements()
    {
       System.out.println("Item.no"+"  "+"Weight"+"  "+"Value");
       for( int i=1 ; i<=n ; i++ )
         {   System.out.println("  "+(i)+"       "+w[i]+"       "+v[i]);   }
       System.out.println("Knapsack Table => ");
       for( int i=0 ; i<=n ; i++ )
       {
         for( int j=0 ; j<=W ; j++ )
         {
            System.out.print(" "+M[((W+1)*i+j)]+" ");
         }
         System.out.println();
       }
    }
    
    public void read_elements()
    {
        int i,j;
        try( Scanner sc = new Scanner( System.in ) )
        {
            System.out.print("Enter number of items :  ");
            n = sc.nextInt();
            System.out.print("Enter maximum capacity :  ");
            W = sc.nextInt();
            w = new int[(n+1)];
            v = new int[(n+1)];
            order = new int[(n+1)];
            M = new int[((n+1)*(W+1))];

            for( i=0 ; i<=n ; i++ )
            {
                if( i>=1 )
                {
                    System.out.println("         Item-"+(i));
                    System.out.print("Item-"+(i)+" weight ? :  ");
                    w[i] = sc.nextInt();
                    System.out.print("Item-"+(i)+" value ? :  ");
                    v[i] = sc.nextInt();
                }
                for( j=0 ; j<=W ; j++ )
                {
                    if( ((i==0)||(j==0)) )
                      {   M[ ((W+1)*i+j) ] = 0;   }
                    else
                      {   M[ ((W+1)*i+j) ] = -1;  }
                }
            }
            
        }
    }
}

class Knapsack
{
    public int Max( int a ,int b )
    {
        return ( (a>b) ? a : b );
    }

    public void Max_Capacitybag(read_display o)
    {
       int i=o.n, rw=o.W;
       while( ((i>=1)&&(rw>=0)) )
       {
           if( o.M[((o.W+1)*i+rw)]!=o.M[((o.W+1)*(i-1)+rw)] )
           {
              o.order[++o.top] = i;
              rw = rw-o.w[i];
           }
           i = i-1 ;
       }

       System.out.println("Max Capacity Bag => ");
       System.out.println("Item.no"+"  "+"Weight"+"  "+"Value");
       for( i=o.top ; i>=0 ; i-- )
         {   System.out.println("  "+(o.order[i])+"        "+o.w[o.order[i]]+"       "+o.v[o.order[i]]);   }
    }

    public void Matrix_table(read_display o)
    {
        int i,j,d;
        for( i=1 ; i<=o.n ; i++ )
        {
            for( j=1 ; j<=o.W ; j++ )
            {
                d = j-o.w[i];
                if( d<0 )
                   o.M[i*(o.W+1)+j] = o.M[(i-1)*(o.W+1)+j];
                else
                   o.M[i*(o.W+1)+j] = Max( o.M[(i-1)*(o.W+1)+j], ( o.v[i]+o.M[(i-1)*(o.W+1)+d] ) ); 
            }
        }
        o.display_elements();
        Max_Capacitybag(o);
    }
}

public class Knapsack_Main
{
    public static void main( String args[] )
    {
       read_display o1 = new read_display();
       o1.read_elements();

       Knapsack o2 = new Knapsack();
       o2.Matrix_table(o1);
    }
}
