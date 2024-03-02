
public class Movimiento {
	
	private char TorreInicial;
	private char TorreFinal;
	private int NoDisco;
	
	public Movimiento(int NoDisco, char TorreInicial, char TorreFinal) {
		this.NoDisco = NoDisco;
		this.TorreInicial = TorreInicial;
		this.TorreFinal = TorreFinal;
	}
	
	public int getNoDisco() {
		return NoDisco;
	}
	
	public char getTorreInicial() {
		return TorreInicial;
	}
	
	public char getTorreFinal() {
		return TorreFinal;
	}
}
