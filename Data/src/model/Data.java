package model;

public class Data {

	public String dt;
	int dia;
	int mes;
	int ano;

	public Data(String dt) {
		boolean edata = false;
		
		if (dt.length() == 10 && dt.charAt(2) == '/' && dt.charAt(5) == '/') {
			
			try {
				this.ano = Integer.parseInt(dt.substring(6, 10));
			} catch (Exception e) {
				dt = "01/01/0001";
			}
			
			try {
				this.mes = Integer.parseInt(dt.substring(3, 5));
			} catch (Exception e) {
				dt = "01/01/0001";
			}
			
			try {
				this.dia = Integer.parseInt(dt.substring(0, 2));
			} catch (Exception e) {
				dt = "01/01/0001";
			}
			
			if (this.ano > 0 && this.mes > 0 && this.mes <= 12 && this.dia > 0) {
				
				switch(this.mes) {
				case 1, 3, 5, 7, 8, 10, 12:
					if (this.dia <= 31) {
						edata = true;
					}
					break;
				case 4, 6, 9, 11 :
					if (this.dia <= 30) {
						edata = true;
					}
					break;
				case 2 :
					if (isBissexto()) {
						if (this.dia <= 29 ) {
							edata = true;
						}
					} else {
						if (this.dia <= 28) {
							edata = true;
						}
					}
				}
					
				
			}
			
			
		}
		
		if (edata) {
			this.dt = dt;
		} else {
			this.dt = "01/01/0001";
		}
	
	}
	
	public boolean isBissexto() {
		if (this.ano % 4 != 0 && this.ano % 400 != 0) {
			return false;
		} else {
			return true;
		}
	}

	public int comparar(Data outra) {

		if (this.dt.equals(outra.dt)) {
			return 0;

		} else {

			if (this.ano > outra.ano) {

				return 1;

			} else if (this.ano == outra.ano) {

				if (this.mes > outra.mes) {  

					return 1;

				} else if (this.mes == outra.mes) { 

					if (this.dia > outra.dia) { 

						return 1;

					} else {

						return -1;

					}
					
				} else {

					return -1;

				}

			} else {

				return -1;

			}

		}

	}
	
	public String getMesExtenso() {
		String mes[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", 
				"Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
		return mes[this.mes-1];
	}
	
	public Data clone() {
		Data clonada = this;
		return clonada;
	}
	
	public int getDia() {
		return this.dia;
	}
	
	public int getMes() {
		return this.mes;
	}
	
	public int getAno() {
		return this.ano;
	}
	
	
	
}
