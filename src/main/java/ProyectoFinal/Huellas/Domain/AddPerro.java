package ProyectoFinal.Huellas.Domain;

import java.sql.SQLException;

import ProyectoFinal.Huellas.Data.Conexion;

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
