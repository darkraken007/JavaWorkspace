package threadex;

public class Counter {
	private int count;
	public Counter(int c){
		this.count = c;
	}
	public int getCount(){
		return count;
	}
	public void incCount(){
		this.count++;
	}
	public void decCount(){
		this.count--;
	}
}
