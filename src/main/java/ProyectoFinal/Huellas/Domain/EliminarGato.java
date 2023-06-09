package ProyectoFinal.Huellas.Domain;

import java.sql.SQLException;

import ProyectoFinal.Huellas.Data.Conexion;

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
