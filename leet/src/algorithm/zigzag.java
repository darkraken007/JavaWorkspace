package algorithm;

public class zigzag
{

    public static String convert( String s, int numRows )
    {
        String[] str = new String[numRows];
        char[] s1 = s.toCharArray();
        int i = 0;
        while( i < s.length() )
        {
            int j = 0;
            while( j < numRows && i< s.length() )
            {
                if( str[j] == null )
                {
                    str[j] = Character.toString(s1[i]);
                }
                else
                {
                    str[j] = str[j].concat( Character.toString(s1[i]) );
                }
                i++;
                j++;
            }
            while( j-2  >= 1 && i< s.length() )
            {
                if( str[j-2] == null )
                {
                    str[j-2] = Character.toString(s1[i]);
                }
                else
                {
                    str[j-2] = str[j-2].concat( Character.toString(s1[i]) );
                }
                i++;
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for( int j = 0; j < numRows; j++ )
        {
            sb.append( str[ j ] );
        }
        return sb.toString();

    }


    public static void main( String[] args )
    {
        System.out.println( convert( "paypalishiring", 3 ) );

    }

}
