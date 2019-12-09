package abcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class RhezoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String N=null;
		int i=0;
		String LandR;
		int Q;
		
		//Scanner input = new Scanner(System.in);
		//N=input.nextLine();
		try(BufferedReader inp = new BufferedReader(new InputStreamReader(System.in))){
			N=inp.readLine();
			
			Q=Integer.parseInt(inp.readLine());
			while(i<Q)
			{
				LandR=inp.readLine();
				if(N!=null&&LandR!=null){
				ShowUsTheMagic(LandR , N);
				}
				i=i+1;
			}
		} catch (IOException e) {

		}
	}

	private static void ShowUsTheMagic(String landR, String N) {
			int L;
			int R;
			BigInteger Num;
			try {
				L=Integer.parseInt(landR.split(" ")[0]);
				R=Integer.parseInt(landR.split(" ")[1]);
				if(new BigInteger(N.substring(L-1,R)).mod(new BigInteger("7")).equals(new BigInteger("0")))
				{ System.out.println("YES");
				}
				else
				{
					System.out.println("NO");
				}
			} catch (NumberFormatException e) {

			}
			
	}

}
