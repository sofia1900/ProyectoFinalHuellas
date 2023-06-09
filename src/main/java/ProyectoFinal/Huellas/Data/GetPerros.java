package ProyectoFinal.Huellas.Data;

import java.sql.SQLException;
import java.util.List;

import ProyectoFinal.Huellas.Domain.Conexion;

public class GetPerros {

	private Conexion bd = Conexion.getInstance();
	
	public List<Perro> execute() throws SQLException {
		return bd.listarPerros();
		
	}
}
