package ProyectoFinal.Huellas.Domain;

import java.sql.SQLException;
import java.util.List;

import ProyectoFinal.Huellas.Data.Conexion;

public class GetGatos {

	private Conexion bd = Conexion.getInstance();
	
	public List<Gato> execute() throws SQLException {
		return bd.listarGatos();
	}
}
