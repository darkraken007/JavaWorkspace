package algo.binarysearch;

public class BinarySearch
{

    public static int search(int[] array, int key, int f, int l){
        int mid = (l+f)/2;
        int midElement = array[mid];
        if(midElement == key){
            return mid;
        }
        else if(midElement > key) {
            
            return search(array,key,f,mid -1);
            
        }
        else { 
           return search(array,key,mid + 1, l);
        }
    }
    public static void main( String[] args )
    {
        int[] a = {2,3,6,19,22,45,67,109,120,145,294,256,321,333};
        System.out.println( search(a, 22, 0, a.length -1) );

    }

}
