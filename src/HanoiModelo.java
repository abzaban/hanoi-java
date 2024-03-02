import java.util.*;

public class HanoiModelo {
	
	private Vector<Movimiento> V;
	private Movimiento M;

	public HanoiModelo() {
		V = new Vector<Movimiento>();
	}
	
	public int VerificaN(String N) {
		int NvaN;
		try {
			NvaN = Integer.parseInt(N);
		} catch(NumberFormatException NFE) {
			return NvaN = 3;
		}
		if(NvaN > 15)
			return NvaN = 15;
		return NvaN;
	}
	
	public void Hanoi(char Inicial, char Central, char Final, int N) {
		if(N == 1) {
			M = new Movimiento(N, Inicial, Final);
			V.add(M);
			return;
		}
		Hanoi(Inicial, Final, Central, N - 1);
		M = new Movimiento(N, Inicial, Final);
		V.add(M);
		Hanoi(Central, Inicial, Final, N - 1);
	}
	
	public Vector<Movimiento> getMovimientos() {
		return V;
	}
}
