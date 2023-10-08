import java.util.Scanner;

class data
{
    private String text,pattern;

    public String get_text()
    { return text; }

    public String get_pattern()
    { return pattern; }

    public data()
    {
        try( Scanner sc = new Scanner(System.in) )
        {
           System.out.print("Enter text...=>\n");
           text = sc.nextLine();
           System.out.print("Enter pattern...=>\n");
           pattern = sc.nextLine();
        }
    }
}

class Shift_table 
{
    private int[] s_value;
    public void shift_table_making( data o )
    {
       int i,j;
       String pattern = o.get_pattern();
       s_value = new int[256];
       for( i=0 ; i<=255 ; i++ )
        {  s_value[i] = pattern.length();  }

       // giving value of the characters of the text
       for( i=(pattern.length()-2),j=1 ; i>=0 ; i-- )
       {
           if( s_value[(int)pattern.charAt(i)]>j )
                 s_value[(int)pattern.charAt(i)]=j;
           j++;
       }
    }

    public int[] get_value()
    { return s_value; }
}

class string_match extends Shift_table
{
    public void string_match_algo( data o )
    {
         String text = o.get_text(), pattern = o.get_pattern();
         int[] value = get_value(); 
         int i,j;

         for( i=0 ; i<(text.length()-pattern.length()+1) ;  i+=value[text.charAt(i+pattern.length()-1)] )
         {
            for( j=(pattern.length()-1) ; j>=0 ; j-- )
            {
                if( pattern.charAt(j)!=text.charAt(i+j) )
                     break;   
            }
            if( j==-1 )
              { 
                System.out.println("Pattern ''"+pattern+"'' found in text ''"+text+"'' from position = "+(i+1));
                return;
              }
         }
         System.out.println("Pattern ''"+pattern+"'' not found int text ''"+text+"'' !!");
    }
}

public class Horsepool
{
    public static void main( String[] args )
    {
        data o = new data();
        string_match o1 = new string_match();
        o1.shift_table_making(o);
        o1.string_match_algo(o);
    }
}