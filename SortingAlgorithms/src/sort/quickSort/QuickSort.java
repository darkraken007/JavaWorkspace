package sort.quickSort;

public class QuickSort
{

    // consider pivot as last index

    public static void sort( int[] ar, int pivotIndex, int startIndex, int endIndex )
    {
        if( startIndex < endIndex )
        {
            int partitionPoint = partition( ar, endIndex , pivotIndex, startIndex);
            sort( ar, partitionPoint - 1, startIndex, partitionPoint - 1 );
            sort( ar, endIndex, partitionPoint + 1, endIndex );
        }
    }


    private static int partition( int[] ar, int endIndex,int pivot, int startIndex )
    {
        int i = startIndex;
        int j = startIndex;
        while(j<endIndex){
            
            if(ar[j]<pivot){
                swap( ar, i, j );
                j++;
                i++;
            }
            else{
                j++;
            }
        }
        swap( ar, i+1, pivot );
        return i+1;
    }


    private static void swap( int[] ar, int i, int j )
    {
        int temp = ar[j];
        ar[j] = ar[i];
        ar[i] = temp;
    }
    
    public static void main(String[] args){
        
        int[] ar = {2,6,3,1,9,7,4};
        sort( ar, 6, 0, 6 );
        for(int i:ar){
            System.out.println( i );
        }
        
    }
}
