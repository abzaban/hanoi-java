import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class HanoiControlador implements ActionListener {
	
	private HanoiModelo Modelo;
	private HanoiVista Vista;
	
	public HanoiControlador(HanoiModelo Modelo, HanoiVista Vista) {
		this.Modelo = Modelo;
		this.Vista = Vista;
	}
	
	public void actionPerformed(ActionEvent Evt) {
		
		if(Evt.getSource() instanceof javax.swing.JButton) {
			int NoDiscos = Modelo.VerificaN(Vista.getNoDiscos());
			Vista.setN(NoDiscos);
			Vista.CreaDiscos();
			Modelo.Hanoi('A', 'B', 'C', NoDiscos);
			Vector<Movimiento> Movimientos = Modelo.getMovimientos();
			Vista.setMovimientos(Movimientos);
			Vista.IniciaTemporizador();
		}
		
		if(Evt.getSource() instanceof javax.swing.Timer) {
			Vista.Dibuja();
			Vista.ModificaDiscoTurno();
		}
	}
}
