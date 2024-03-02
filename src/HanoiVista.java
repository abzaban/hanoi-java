import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;

public class HanoiVista extends JFrame {
	
	private JButton BtnIniciar;
	private JTextField TxtNoDiscos;
	private Graphics g;
	private Image backbuffer;
	private Timer T;
	private Disco [] VDiscos;
	private int N;
	private int ContDisTorreA, ContDisTorreB, ContDisTorreC;
	private Vector<Movimiento> Movimientos;
	private Image ImgTorre = Rutinas.AjustarImagen("img/Torre.png", 200, 200).getImage();
	
	public HanoiVista() {
		super("Juego de Torres de Hanói");
		ContDisTorreB = ContDisTorreC = 0;
		HazInterfaz();
	}
	
	public void HazInterfaz() {
		BtnIniciar = new JButton("Iniciar");
		TxtNoDiscos = new JTextField();
		setSize(800, 800);
		BtnIniciar.setBounds(getWidth() - 100, 0, 100, 50);
		add(BtnIniciar);
		TxtNoDiscos.setBounds(getWidth() - 250, 0, 150, 50);
		add(TxtNoDiscos);
		JLabel EtqN = new JLabel("No. de discos");
		EtqN.setBounds(getWidth() - 350, 0, 100, 50);
		add(EtqN);
		setLayout(null);
		setSize(800, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g) {
		g.drawImage(backbuffer, 0, 0, getWidth(), getHeight(), this);
	}
	
	public void Dibuja() {
		super.paint(g);
		g.drawImage(ImgTorre, 50, getHeight() - 500, null);
		g.drawImage(ImgTorre, 300, getHeight() - 500, null);
		g.drawImage(ImgTorre, 550, getHeight() - 500, null);
		if(N != 0) {
			for(int i = N - 1 ; i >= 0 ; i--) {
				System.out.println("Dibujando discos");
				g.setColor(VDiscos[i].getColor());
				g.fillRect(VDiscos[i].getX(), VDiscos[i].getY(), VDiscos[i].getAncho(), VDiscos[i].getAlto());
			}
		}
		repaint();
	}
	
	boolean Bajar = false;
	int Sub = 0;
	public boolean ModificaDiscoTurno() {
		if(Sub == Movimientos.size()) {
			T.stop();
			BtnIniciar.setEnabled(true);
			Dibuja();
			ContDisTorreB = ContDisTorreC = 0;
			return false;
		}
		int i = Movimientos.get(Sub).getNoDisco() - 1;
		if(!Bajar && VDiscos[i].getY() > 290) {
			VDiscos[i].setY(VDiscos[i].getY() - 10);
			return false;
		}
		
		Bajar = true;
		if(Movimientos.get(Sub).getTorreFinal() == 'A' && VDiscos[i].getX() > 140 - VDiscos[i].getAncho() / 2) {
			VDiscos[i].setX(VDiscos[i].getX() - 10);
			return false;
		}
		
		if(Movimientos.get(Sub).getTorreFinal() == 'C' && VDiscos[i].getX() < 640 - VDiscos[i].getAncho() / 2) {
			VDiscos[i].setX(VDiscos[i].getX() + 10);
			return false;
		}
		
		if(Movimientos.get(Sub).getTorreFinal() == 'B' && Movimientos.get(Sub).getTorreInicial() == 'A' && VDiscos[i].getX() < 390 - VDiscos[i].getAncho() / 2) {
			VDiscos[i].setX(VDiscos[i].getX() + 10);
			return false;
		}
		if(Movimientos.get(Sub).getTorreFinal() == 'B' && Movimientos.get(Sub).getTorreInicial() == 'C' && VDiscos[i].getX() > 390 - VDiscos[i].getAncho() / 2) {
			VDiscos[i].setX(VDiscos[i].getX() - 10);
			return false;
		}
		int DiscosEnTorre = 0;
		if(Movimientos.get(Sub).getTorreFinal() == 'A')
			DiscosEnTorre = ContDisTorreA;
		if(Movimientos.get(Sub).getTorreFinal() == 'B')
			DiscosEnTorre = ContDisTorreB;
		if(Movimientos.get(Sub).getTorreFinal() == 'C')
			DiscosEnTorre = ContDisTorreC;
		
		if(VDiscos[i].getY() < getHeight() - 320 - 10 * DiscosEnTorre) {
			VDiscos[i].setY(VDiscos[i].getY() + 10);
			return false;
		}
		
		if(Movimientos.get(Sub).getTorreFinal() == 'A')
			ContDisTorreA++;
		if(Movimientos.get(Sub).getTorreFinal() == 'B')
			ContDisTorreB++;
		if(Movimientos.get(Sub).getTorreFinal() == 'C')
			ContDisTorreC++;
		
		if(Movimientos.get(Sub).getTorreInicial() == 'A')
			ContDisTorreA--;
		if(Movimientos.get(Sub).getTorreInicial() == 'B')
			ContDisTorreB--;
		if(Movimientos.get(Sub).getTorreInicial() == 'C')
			ContDisTorreC--;
		Sub++;
		Bajar = false;
		return true;
	}
	
	public void CreaDiscos() {
		VDiscos = new Disco [N];
		int Y = 480, X = 140, Ancho = 150;
		for(int i = N - 1 ; i >= 0 ; i--) {
			VDiscos[i] = new Disco((i+1), X - Ancho / 2, Y, Ancho, 10);
			Y -= 10;
			Ancho -= 10;
		}
	}
	
	public String getNoDiscos() {
		return TxtNoDiscos.getText();
	}
	
	public void setN(int N) {
		this.N = N;
		ContDisTorreA = N;
	}
	
	public void setMovimientos(Vector<Movimiento> V) {
		Movimientos = V;
	}
	
	public void setControlador(HanoiControlador C) {
		BtnIniciar.addActionListener(C);
		T = new Timer(5, C);
	}
	
	public void IniciaTemporizador() {
		T.start();
		BtnIniciar.setEnabled(false);
	}
	
	public void Muestra() {
		setVisible(true);
		backbuffer = createImage(getWidth(), getHeight());
		g = backbuffer.getGraphics();
		Dibuja();
	}
}
