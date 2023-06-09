package ProyectoFinal.Huellas.Data;

import java.sql.SQLException;

import ProyectoFinal.Huellas.Domain.Conexion;

public class BuscarAdoptante {
	
	Conexion bd = Conexion.getInstance();
	
	public Adoptante execute (int id) throws SQLException {
		Adoptante adoptante = bd.buscarAdoptante(id);
		return adoptante;
	}
	
}
