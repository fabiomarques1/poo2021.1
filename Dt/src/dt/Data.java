package dt;

public class Data {
	
	String data;
	
	public Data(String data) {
		boolean erro = false;
		int dia, mes, ano;

		
		if (data.charAt(2) == '/' || data.charAt(5) == '/') {
			dia = Integer.parseInt(data.substring(0, 2));
			mes = Integer.parseInt(data.substring(3, 5));
			ano = Integer.parseInt(data.substring(6, 10));
			
			System.out.println(dia);
			System.out.println(mes);
			System.out.println(ano);
		}
				
		//Se o ano é válido
		// Se o mês é válido
		// Se o dia é válido inclusive se for mês 2 verificar se é bissexto		
		
		
		if (erro) {
			this.data = "01/01/0001"; 
		} else {
			this.data = data;
		}
	}
	

}
