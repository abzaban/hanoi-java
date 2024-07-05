
public class AplHanoi {
	
	public AplHanoi() {
		HanoiVista Vista = new HanoiVista();
		HanoiModelo Modelo = new HanoiModelo();
		HanoiControlador Controlador = new HanoiControlador(Modelo, Vista);
		Vista.setControlador(Controlador);
		Vista.Muestra();
	}
	
	public static void main(String [] a) {
		new AplHanoi();
	}
}
