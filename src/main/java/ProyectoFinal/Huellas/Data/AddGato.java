package ProyectoFinal.Huellas.Data;

import java.sql.SQLException;

import ProyectoFinal.Huellas.Domain.Conexion;

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
