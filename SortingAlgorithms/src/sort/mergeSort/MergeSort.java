package sort.mergeSort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort
{

    public static List<Integer> merge(List<Integer> a, List<Integer> b){
        

        List<Integer> mergedList = new ArrayList<>();
        while(a.size() > 0 &&  b.size() >0){
            if(a.get( 0 ) < b.get( 0 )){
                mergedList.add( a.remove( 0 ) );
                
            }
            else {
                mergedList.add( b.remove( 0 ) );
            }
        }
        
        if( a.size() > 0){
            
            mergedList.addAll( a );
        }
        else{
            mergedList.addAll( b );
        }
        
        return mergedList;
    }
    
    
    public static List<Integer> sort(List<Integer> arr){
        if( arr.size() <= 1 )
        {
            return arr;
        }
       int mid = (arr.size())/2;
       List<Integer> arrA = new ArrayList<>(arr.subList( 0, mid ));
       List<Integer> arrB = new ArrayList<>(arr.subList(  mid, arr.size() ));
    return  merge(sort(arrA), sort(arrB));
    }
    
    public static void main(String[] args){
        
        List<Integer> list = new ArrayList<>();
        list.add( 2 );
        list.add( 3 );
        list.add( 6 );
        list.add( 10 );
        list.add( 0 );
        list.add( 1 );
        list.add( 8 );
        list.add( 7 );
        System.out.println(sort(list));
    }
}
