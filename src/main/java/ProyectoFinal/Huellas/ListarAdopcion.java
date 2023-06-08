package ProyectoFinal.Huellas;

import java.sql.SQLException;
import java.util.List;

public class ListarAdopcion {
	
	private Conexion bd = Conexion.getInstance();
	
	public List<Registro> execute () throws SQLException {
		
		return bd.listarAdocion();
		
	}

}
