package ProyectoFinal.Huellas;

import java.sql.SQLException;
import java.util.List;

public class GetGatos {

	private Conexion bd = Conexion.getInstance();
	
	public List<Gato> execute() throws SQLException {
		return bd.listarGatos();
	}
}
