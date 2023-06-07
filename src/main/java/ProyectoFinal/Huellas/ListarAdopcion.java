package ProyectoFinal.Huellas;

import java.sql.SQLException;

public class ListarAdopcion {
	
	private Conexion bd = Conexion.getInstance();
	
	public void execute () {
		try {
			bd.listarAdocion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
