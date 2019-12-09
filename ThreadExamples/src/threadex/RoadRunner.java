package threadex;

public class RoadRunner extends Thread {
	
	private Material material;

	RoadRunner(Material m){
		this.material = m;
	}

	@Override
	public void run() {
		System.out.println("ramya");
		try {
			material.displayResult();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
