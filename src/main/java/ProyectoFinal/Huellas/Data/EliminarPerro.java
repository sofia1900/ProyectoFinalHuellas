package ProyectoFinal.Huellas.Data;

import java.sql.SQLException;

import ProyectoFinal.Huellas.Domain.Conexion;

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
