package abcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

public class Abcd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		modbynewWay();
		
	}

	private static void modbynewWay(){

		   try {
			final Field field = String.class.getDeclaredField("value");
			field.setAccessible(true);
			try {
				BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
				String N=inp.readLine();
				final char[] chars = (char[]) field.get(N);
				System.out.println(chars[0]);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   

		  
	}
}

