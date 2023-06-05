package ProyectoFinal.Huellas;

import java.sql.SQLException;

public class AddPerro {
	
	private Conexion bd = Conexion.getInstance();
	
	public void execute (Perro p) {
		try {
			bd.addPerro(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
