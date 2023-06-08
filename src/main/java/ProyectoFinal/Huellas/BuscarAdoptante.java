package ProyectoFinal.Huellas;

import java.sql.SQLException;

public class BuscarAdoptante {
	
	Conexion bd = Conexion.getInstance();
	
	public Adoptante execute (int id) throws SQLException {
		Adoptante adoptante = bd.buscarAdoptante(id);
		return adoptante;
	}
	
}
