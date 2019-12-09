package algo.contains;

public class StringContains
{
    public static boolean contains(char[] str, char[] pattern, int f, int l){
        if(l ==pattern.length-1 && str[f] == pattern[pattern.length - 1]){
            return true;
        }
        if(f>=str.length-1 || str.length < pattern.length){
            return false;
        }
        if( str[f] == pattern[l]){
            
            f = f+1;
            l = l+1;
            return contains( str, pattern, f, l );
        }
        else if( str[f] != pattern[l]){
            f = f+1;
            l = 0;
            return contains( str, pattern, f, l );
        }
        return false;
    }

    public static void main( String[] args )
    {
        System.out.println( contains( "zeeshan is awesome".toCharArray(), "is ".toCharArray(), 0, 0 ) );

    }

}
