
public class quickFind {
	
	int ar[];
		
	public quickFind(int N, int ar[] ){
		for(int i=0;i<N;i++){
			ar[i]=i;
		}
	}
	
	 public boolean  connected(int p, int q){
		if(ar[p]==ar[q]){
			return true;
		}
		return false;
	}
}
