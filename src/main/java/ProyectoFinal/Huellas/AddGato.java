package ProyectoFinal.Huellas;

import java.sql.SQLException;

public class AddGato {
	
	private Conexion bd = Conexion.getInstance();
	
	public void execute (Gato g) {
		try {
			bd.addGato(g);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
