
public class Principal {

	public static void main(String[] args) {
		boolean v[] = new boolean[100];
		
		for (int i=0; i < v.length; i++) {
			v[i] = true;
		}
		
		
		
		
		
		for (int i=0; i < v.length; i++) {
			System.out.println("Vaga " + (i+1) + ": " + v[i]);
		}

	}

}
