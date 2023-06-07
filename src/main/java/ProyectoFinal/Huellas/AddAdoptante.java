package ProyectoFinal.Huellas;

import java.sql.SQLException;

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
