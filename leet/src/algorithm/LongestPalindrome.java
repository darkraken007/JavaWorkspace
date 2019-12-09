
package algorithm;

import java.util.HashMap;
import java.util.Map;


public class LongestPalindrome
{

    private static boolean isPalindrome( String s, Map<String, Boolean> palindromeMap )
    {
        boolean isPalindrome = false;
        if( null != palindromeMap.get( s ) && palindromeMap.get( s ) )
        {
            isPalindrome = true;
        }
        else if( s.length() < 2 )
        {
            isPalindrome = true;
        }
        else if( s.length() == 2 && s.charAt( 0 ) == s.charAt( 1 ) )
        {
            isPalindrome = true;
        }
        else if( s.charAt( 0 ) == s.charAt( s.length() - 1 ) )
        {
            isPalindrome = isPalindrome( s.substring( 1, s.length() - 1 ), palindromeMap );
        }
        if( isPalindrome )
        {
            palindromeMap.put( s, true );
        }
        return isPalindrome;
    }


    /*
     * private static boolean isPalindrome(String s){ if(null !=
     * palindromeMap.get( s ) && palindromeMap.get( s )){ return true; } else {
     * return isPalindrome2(s); } }
     */

    private static boolean isPalindrome2( String s )
    {
        int len = s.length();
        int l = (len + 1) / 2;
        for( int i = 0; i < l; i++ )
        {
            if( s.charAt( i ) != s.charAt( len - 1 - i ) )
            {
                return false;
            }
        }
        return true;
    }


    /*
     * public static String longestPalindrome(String s){ int lj = 0; int li = 0;
     * int longest = 0; Map<String,Boolean> palindromeMap=new HashMap<>();
     * for(int i=0;i<s.length();i++){ for(int j=i;j<=s.length();j++){
     * if(isPalindrome(s.substring( i,j ), palindromeMap)){ if(longest < (j-i)
     * ){ longest = j-i; li = i; lj = j; } } }
     * 
     * } return s.substring(li,lj); }
     */

    public static String longestPalindrome( String s )
    {
        int len = s.length();
        int longest = 1;
        int li = 0;
        int lj = 0;
        boolean[][] isPalindrome = new boolean[len][len];
        for( int i = 0; i < len; i++ )
        {
            isPalindrome[i][i] = true;
            if( i < len - 1 && s.charAt( i ) == s.charAt( i + 1 ) )
            {
                isPalindrome[i][i + 1] = true;
                longest = 2;
                li = i;
                lj = i + 1;
            }
        }

        for( int l = 2; l < len ; l++ )
        {
            for( int i = 0; i < len; i++ )
            {
                int j = i + l;
                if( j < len )
                {
                    isPalindrome[i][j] =
                        isPalindrome[i + 1][j - 1] && s.charAt( i ) == s.charAt( j );
                    if( isPalindrome[i][j] )
                    {
                        if( j - i + 1 > longest )
                        {
                            li = i;
                            lj = j;
                        }
                    }
                }
            }
        }
        return s.substring( li, lj+1 );
    }


    public static void main( String[] args )
    {
        System.out.println(
            longestPalindrome("malayalam" ) );
    }
}
