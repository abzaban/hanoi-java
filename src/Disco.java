import java.awt.Color;

public class Disco {
	
	private int No, x, y, Ancho, Alto;
	private Color C;
	static int ContadorColor = 0;
	Color [] VColores = {Color.RED, Color.BLUE, Color.ORANGE};
	
	public Disco(int No, int x, int y, int Ancho, int Alto) {
		this.No = No;
		this.x = x;
		this.y = y;
		this.Ancho = Ancho;
		this.Alto = Alto;
		C = VColores[ContadorColor];
		ContadorColor++;
		if(ContadorColor == VColores.length)
			ContadorColor = 0;
	}
	
	public Color getColor() {
		return C;
	}
	
	public void setNo(int No) {
		this.No = No;
	}
	
	public int getNo() {
		return No;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	
	public void setAncho(int Ancho) {
		this.Ancho = Ancho;
	}
	
	public int getAncho() {
		return Ancho;
	}
	
	public void setAlto(int Alto) {
		this.Alto = Alto;
	}
	
	public int getAlto() {
		return Alto;
	}
}
