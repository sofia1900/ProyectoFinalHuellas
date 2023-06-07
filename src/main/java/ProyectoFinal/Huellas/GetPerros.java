package ProyectoFinal.Huellas;

import java.sql.SQLException;
import java.util.List;

public class GetPerros {

	private Conexion bd = Conexion.getInstance();
	
	public void execute(List<Perro> perros) {
		try {
			bd.listarPerros();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
