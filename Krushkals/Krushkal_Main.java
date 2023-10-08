import java.util.Scanner;

class RnD
{
    public int n,mi,f,r;
    public boolean cycle;
    public boolean[] visit,Q_visit,flag;
    public double[][] M;
    public int[] vx,vy,Q;
    public double[] value;

    public void read()
    {
        try( Scanner sc = new Scanner(System.in) )
        {
            int i,j;
            System.out.print("Enter number of vertices :   ");
            n = sc.nextInt();
            visit = new boolean[n];
            Q_visit = new boolean[n];
            Q = new int[n];
            M = new double[n][n];
            vx = new int[(n*(n-1)/2)];
            vy = new int[(n*(n-1)/2)];
            value = new double[(n*(n-1)/2)];
            flag = new boolean[(n*(n-1)/2)];
            System.out.print("Enter cost matrix :  ");
            for( i=0 ; i<n ; i++ )
            {
                visit[i] = Q_visit[i] = flag[i] = false;
                vx[i] = vy[i] = Q[i] = -1;
                value[i] = -1;
                for( j=0 ; j<n ; j++ )
                    {
                        M[i][j] = sc.nextDouble();
                    }
            }
        }
    }
}

class Krushkal_class
{
    public void sort(RnD o)
    {
       int i,j,temp1;
       double temp;
       int n=o.mi+1;
       for( j=0 ; j<n-1 ; j++ )
       {
         for( i=0 ; i<(n-j-1) ; i++ )
         {
            if( o.value[i+1]<o.value[i] )
            {
                temp = o.value[i+1];
                o.value[i+1] = o.value[i];
                o.value[i] = temp;

                temp1 = o.vx[i+1];
                o.vx[i+1] = o.vx[i];
                o.vx[i] = temp1;

                temp1 = o.vy[i+1];
                o.vy[i+1] = o.vy[i];
                o.vy[i] = temp1;
            }
         } 
       }
    }

    public void ordering(RnD o)
    {
       int i,j;
       o.mi=-1;
       for( i=0 ; i<o.n ; i++ )
       {
         for( j=0 ; j<o.n ; j++ )
         {
            if( o.M[i][j]!=-1 )
            {
                o.vx[++o.mi] = i;
                o.vy[o.mi] = j;
                o.value[o.mi] = o.M[i][j];
                o.M[j][i] = o.M[i][j] = -1;
            }
         }
       }
       sort(o);
    }

    public void dfs(RnD o,int x,int parent)
    {
        int v=o.Q[x],u;
        o.visit[v] = true;
        for( int i=o.f ; i<=o.r ; i++ )
        {
            u = o.Q[i];
            if( o.M[v][u]!=-1)
            {
                    if( o.visit[u]==false )
                        dfs(o,i,x);
                    else if( o.visit[u]==true && u!=o.Q[parent] )
                    {
                        o.cycle = true;
                        return;
                    }
            }
        }
    }

    public void cycle_check(RnD o)
    {
        int v;
        for( int i=o.f ; i<=o.r ; i++ )
        {
            v = o.Q[i];
            o.cycle = false;
            if( o.visit[v]==false )
                 dfs(o,i,i);
            if( o.cycle==true )
               return;
        }
    }

    public void add_edge(int x,int y,double cost,RnD o)
    {
        o.M[x][y] = o.M[y][x] = cost;
    }    
    
    public void remove_edge(int x,int y,RnD o)
    {
        o.M[x][y] = o.M[y][x] = -1;
    }

    public void MST(RnD o)
    {
        int i,j;
        o.f=0;
        o.r=-1;
        for( i=0 ; i<=o.mi ; i++ )
        {
           if( o.Q_visit[o.vx[i]]==false )
              {
                 o.Q[++o.r] = o.vx[i];
                 o.Q_visit[o.vx[i]] = true;
              }
           if( o.Q_visit[o.vy[i]]==false )
              {
                 o.Q[++o.r] = o.vy[i];
                 o.Q_visit[o.vy[i]] = true;
              }  
        
           add_edge(o.vx[i], o.vy[i],o.value[i], o);

           o.cycle = false;
           cycle_check(o);

           for( j=o.f ; j<=o.r ; j++ )
                o.visit[o.Q[j]] = false; // making visit[] to false for further iterations

           if( o.cycle==true )
              remove_edge(o.vx[i],o.vy[i],o);  // if cycle exits ignore that edge
           else
              o.flag[i] = true; // if cycle doesn't exist accept the edge
        }

        double sum=0;
        System.out.println("\nMinimum Spanning Tree =>");
        for( i=0 ; i<=o.mi ; i++ )
        {
        if( o.flag[i]==true)
            { 
                sum += o.value[i];
                System.out.println("("+o.vx[i]+","+o.vy[i]+") =>"+o.value[i]);
            }
        }
        System.out.println("\nMinimum cost => "+sum);
    }
}

public class Krushkal_Main
{
    public static void main( String[] args )
    {
        RnD o = new RnD();
        o.read();
        Krushkal_class o1 = new Krushkal_class();
        o1.ordering(o);
        o1.MST(o);
    }
}
