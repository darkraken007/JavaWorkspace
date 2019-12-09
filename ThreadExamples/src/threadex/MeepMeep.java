package threadex;

public class MeepMeep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Material m = new Material();
        RoadRunner r1 = new RoadRunner(m);
        Thread t1  = new Thread(r1);
        RoadRunner r2 = new RoadRunner(m);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        
        
	}

}
