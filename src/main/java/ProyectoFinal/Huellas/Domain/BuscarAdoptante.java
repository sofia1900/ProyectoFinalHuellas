package ProyectoFinal.Huellas.Domain;

import java.sql.SQLException;

import ProyectoFinal.Huellas.Data.Conexion;

public class BuscarAdoptante {
	
	Conexion bd = Conexion.getInstance();
	
	public Adoptante execute (int id) throws SQLException {
		Adoptante adoptante = bd.buscarAdoptante(id);
		return adoptante;
	}
	
}
