package algorithm;

public class MedianOfSortedArray
{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = mergeSortedArray(nums1, nums2);
        if(nums3.length % 2 == 0){
            return ((double)nums3[(nums3.length-1)/2] + nums3[nums3.length/2]) /2;
        }
        else return nums3[nums3.length/2];

    }
    
        private static int[] mergeSortedArray( int[] nums1, int[] nums2 )
    {

        int[] nums3 = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while( i < nums1.length && j < nums2.length )
        {
            if( nums1[i] > nums2[j] )
            {
                nums3[k] = nums2[j];
                j++;
            }
            else
            {
                nums3[k] = nums1[i];
                i++;
            }
            k++;
        }
        while( i < nums1.length )
        {
            nums3[k] = nums1[i];
            i++;
            k++;
        }
        while( j < nums2.length )
        {
            nums3[k] = nums2[j];
            j++;
            k++;
        }
        
        return nums3;

    }


    public static void main( String[] args )
    {
       int[] nums1 = {1,2};
       int[] nums2 = {3,4};
       double  m = findMedianSortedArrays( nums1, nums2 );

    }

}
