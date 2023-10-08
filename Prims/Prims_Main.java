import java.util.Scanner;

class RnD
{
    public int n,sv,f,r;
    public int[] Q;
    public boolean[] Q_visit;
    public double[][] M,MST;

    public void read()
    {
        try( Scanner sc = new Scanner(System.in) )
        {
            int i,j;
            System.out.print("Enter number of vertices :   ");
            n = sc.nextInt();
            Q = new int[n];
            Q_visit = new boolean[n];
            M = new double[n][n];
            MST = new double[n][n];
            System.out.print("Enter adjcency matrix :  ");
            for( i=0 ; i<n ; i++ )
            {
                Q[i] = -1;
                Q_visit[i] = false;
                for( j=0 ; j<n ; j++ )
                  {
                    M[i][j] = sc.nextDouble();
                    MST[i][j] = -1;
                  }
            }
            System.out.print("Enter starting vertex :  ");
            sv = sc.nextInt();
        }
    }

    public void display()
    {
        int i,j;
        System.out.print("\nAdjacency Matrix => \n");
        for( i=0 ; i<n ; i++ )
        {
            for( j=0 ; j<n ; j++ )
                System.out.print(" "+M[i][j]+" ");
            System.out.println();
        }

        System.out.println("\nQueue =>");
        for( i=0 ; i<n ; i++ )
          System.out.print(" "+Q[i]+" ");
        System.out.println("\n\nQueue visit => ");
        for( i=0 ; i<n ; i++ )
          System.out.print(" "+Q_visit[i]+" ");
        System.out.println("\n");       
    }

}

class Prims_Class
{
   public void min_spanning_tree(RnD o)
   {
       int i,j;
       double sum=0;
       System.out.println("Minimum Spanning Tree=>");
       for( i=0 ; i<o.n ; i++ )
       {
         for( j=0 ; j<o.n ; j++ )
         {
            if( o.MST[i][j]!=-1 )
            {
                System.out.println("("+i+"--"+j+") ==> "+o.MST[i][j]);
                sum+=o.MST[i][j];
            }
         }
       }
       System.out.println("\nMinimum cost=>"+sum);
   }

   public void Prims(RnD o)
   {
      int i,c,r,mc,mr,flag=1;
      double min=9999999;
      o.f = 0;
      o.r = -1;
      mc = mr = o.sv;
      
      while( true )
      {
        if( flag==1 && o.Q_visit[mr]==false)
           o.Q[++o.r] = mr;
        else if( flag==0 &&o.Q_visit[mr]==false )
           { 
            mr = (mr+1)%o.n ;
            o.Q[++o.r] = mr;
           }

        if( o.r==(o.n-1) )
            break;
        min = 9999;
        flag = 0;
        for( i=o.f ; i<=o.r ; i++ )
        {
           c = o.Q[i];
           for( r=0 ; r<o.n ; r++ )  
            {
                if( o.M[r][c]!=-1 )
                {   
                    if( (o.M[r][c]<min) && (o.Q_visit[r]==false) )
                    {
                        min = o.M[r][c];
                        mc = c;
                        mr = r;
                        flag = 1;
                    }
                }
            }
        }
        System.out.println("\n-----mr="+mr);
        o.Q_visit[o.Q[o.r]] = true;
        if( flag==1 && o.Q_visit[mr]==false )
             o.MST[mr][mc] = min;
        o.M[mc][mr] = o.M[mr][mc] = -1;
      }
   }
}

public class Prims_Main
{
    public static void main( String[] args )
    {
        RnD o = new RnD();
        o.read();
        o.display();

        Prims_Class o1 = new Prims_Class();
        o1.Prims(o);
        o1.min_spanning_tree(o);
        o.display();
    }
}

