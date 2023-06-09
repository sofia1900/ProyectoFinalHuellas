package ProyectoFinal.Huellas.Domain;

import java.sql.SQLException;
import java.util.List;

import ProyectoFinal.Huellas.Data.Conexion;

public class ListarAdopcion {
	
	private Conexion bd = Conexion.getInstance();
	
	public List<Registro> execute () throws SQLException {
		
		return bd.listarAdocion();
		
	}

}
