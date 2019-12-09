package algo.ubiquitousBinary;

public class UbiquitousBinarySeach
{
    public static int search(int[] arr, int k, int l, int f){
        
       
        
        while (f < (l-1)) { 
            
            int m = f + (l-f)/2 ; 
            if( arr[m] <= k ) {
                
                f = m ;
                
            }
            else{
                l = m;
            }
            
        }
        
        if(arr[l] <= k){
            return l;
        }
        else if(arr[f] <= k){
            return f;
        }
        
        else if(f > 1) { return arr[f-1];}
        
        else return -1;
        
    }

    public static void main( String[] args )
    {
       int[] arr = {2,4,5,7};
       System.out.println( search( arr, 3, arr.length -1, 0 ) );

    }

}
