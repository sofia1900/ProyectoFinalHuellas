package ProyectoFinal.Huellas.Domain;

import java.sql.SQLException;

import ProyectoFinal.Huellas.Data.Conexion;

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
