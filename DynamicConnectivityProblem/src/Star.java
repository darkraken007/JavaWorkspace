
public class Star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 5;
		printOutPut(n);
	}

	private static void printOutPut(int n) {
		// TODO Auto-generated method stub
		for(int i=1;i<=n;i++){
			printChar(n-i," ");
			printChar(i,"*");
			
			System.out.println();
		}
	}

	private static void printChar(int n, String string) {
		// TODO Auto-generated method stub
		for(int i=0;i<n;i++){
			System.out.print(string);
		}
	}


}
