package threadex;

public class Material {
	
	public void displayResult() throws InterruptedException{
		int count =0;
		System.out.println("ramya1");
		//synchronized (count) {
			System.out.println("ramya2");
			while(count<100){
				System.out.println(count);
				count++;
			//}
			
		}
		
	}
}
