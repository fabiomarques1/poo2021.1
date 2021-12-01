
public class ControleRemoto implements Controlador {
	private int volume;
	private boolean ligado;
	private boolean tocando;
	
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public boolean isLigado() {
		return ligado;
	}

	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}

	public boolean isTocando() {
		return tocando;
	}

	public void setTocando(boolean tocando) {
		this.tocando = tocando;
	}

	@Override
	public void ligar() {
		if (!this.ligado) {
			this.ligado = true;
		}
	}

	@Override
	public void desligar() {
		if (this.ligado) {
			this.ligado = false;
		}
		
	}

	@Override
	public String abrirMenu() {
		return "Volume: " + this.volume + "\nLigado: " + this.ligado + "\nTocando: " + this.tocando;
	}

	@Override
	public String fecharMenu() {
		return "Fechando o Menu...";
		
	}

	@Override
	public void maisVolume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menosVolume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ligarMudo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desligarMudo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

}
