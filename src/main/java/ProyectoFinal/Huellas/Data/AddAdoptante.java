package ProyectoFinal.Huellas.Data;

import java.sql.SQLException;

import ProyectoFinal.Huellas.Domain.Conexion;

public class AddAdoptante {
	
	private Conexion bd = Conexion.getInstance();
	
	public void execute (Adoptante ad) {
		try {
			bd.addAdoptante(ad);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
