import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Principal {

	public static void main(String[] args) {

		// Formata Data e Hora
		DateFormat dtHora = DateFormat.getDateTimeInstance();

		Voo v1 = new Voo(1294);
		System.out.println("No. Voo: " + v1.getVoo());
		System.out.println("Data/Hora: " + dtHora.format(v1.getData()));
		System.out.println("Número de vagas: " + v1.vagas());
		
		int assento = 3;
		boolean ocupou = v1.ocupa(assento);
		if (ocupou) {
			System.out.println("O assento " + assento + " foi ocupado com êxito!");
		} else {
			System.out.println("A operação NÃO foi realizada com sucesso");
		}
		
		System.out.println("Número de vagas: " + v1.vagas());
		
		assento = 100;
		int retVerifica = v1.verifica(assento);
		switch (retVerifica) {
		case 0:
			System.out.println("O assento " + assento + " está livre!");
			break;
		case 1:
			System.out.println("O assento " + assento + " está ocupado!");
			break;
		default:
			System.out.println("O assento " + assento + " é inexistente! "
					+ "Favor repetir a operação com um número de assento válido.");
		}

		Voo v2 = v1.clona();
		
		try {
			v1.setData(dtHora.parse("01/08/2021 12:40:34"));
		} catch (Exception e) {
			System.out.println("Data Inválida");
		}
		
		System.out.println(v2);
		
	}

}
