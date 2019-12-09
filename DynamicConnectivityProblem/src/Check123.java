
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Check123 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] abc = {"abc","aab","bbc","ccd","eef","efg","hij"};
		int length = abc.length;
		for(int i=0;i<length;i++){
			for(int j=i;j<length;j++){
				if(abc[i].compareTo(abc[j])>1){
					String temp = abc[i];
					abc[i] = abc[j];
					abc[j]= temp;
				}
			}
		}
		List<String> xyz = new ArrayList<String>();
		xyz.add("abc");
		xyz.add("aab");
		xyz.add("bbc");
		xyz.add("ccd");
		xyz.add("ccd");
		xyz.add("eef");
		xyz.add("efg");
		xyz.add("hij");
		Collections.sort(xyz);
		for(Iterator i = xyz.iterator();i.hasNext();){
			System.out.println(i.next());
		}
		
	}



}
