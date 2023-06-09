package ProyectoFinal.Huellas.Domain;

import java.sql.SQLException;

import ProyectoFinal.Huellas.Data.Conexion;

public class EliminarPerro {
	
	private Conexion bd = Conexion.getInstance();
	
	public void execute (int id) {
		try {
			bd.eliminar(id, "perro");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
