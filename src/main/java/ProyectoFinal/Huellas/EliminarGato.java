package ProyectoFinal.Huellas;

import java.sql.SQLException;

public class EliminarGato {
	
	private Conexion bd = Conexion.getInstance();
	
	public void execute (int id) {
		try {
			bd.eliminarGato(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
