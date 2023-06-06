package ProyectoFinal.Huellas;

import java.sql.SQLException;

public class EliminarPerro {
	
	private Conexion bd = Conexion.getInstance();
	
	public void execute (int id) {
		try {
			bd.eliminarPerro(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
