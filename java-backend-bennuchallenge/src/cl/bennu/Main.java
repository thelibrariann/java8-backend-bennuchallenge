package cl.bennu;

import cl.bennu.controller.EngineController;

public class Main {
	
	/**
	 * 
	 * @param args metodo main
	 * Hace un llamado a un cotroller que inicializa la app
	 */
	public static void main(String[] args) {
			
		EngineController engine = new EngineController(); 
	
		engine.Inicializar();
	}	
}
