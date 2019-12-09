package algo;

public class SortedArrayMergeWithoutExtraSpace
{

    public void merge(int[] a, int[] b){
        int sizea = a.length;
        for(int i=0;i<b.length;i++){
            if(b[i]<a[sizea-1]){
                insertIinBandLargestAinB(a,b,i);
            }
        }
    }
    private void insertIinBandLargestAinB( int[] a, int[] b, int i )
    {
       a.
        
    }
    public static void main( String[] args )
    {
        int[] ar = {1,4,8,9};
        int[] ar2 = {2,3,11};
        

    }
