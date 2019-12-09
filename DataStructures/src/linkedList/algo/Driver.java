package linkedList.algo;

import java.util.Arrays;

public class Driver
{

    public static int[] twoSum(int[] nums, int target) {
        
        Arrays.sort( nums );
        for(int i=0; i<nums.length; i++){
            if(nums[i]>= target){
                continue;
            }
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    System.out.println( i + "  " + j );
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return new int[]{};
    }
    
    public static void main(String[] args){
        
        System.out.println(twoSum((new int[]{3,2,4}), 6));
    }
}
