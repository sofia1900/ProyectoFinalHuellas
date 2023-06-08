package ProyectoFinal.Huellas;

import java.sql.SQLException;
import java.util.List;

public class GetPerros {

	private Conexion bd = Conexion.getInstance();
	
	public List<Perro> execute() throws SQLException {
		return bd.listarPerros();
		
	}
}
