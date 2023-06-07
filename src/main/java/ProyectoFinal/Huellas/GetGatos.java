package ProyectoFinal.Huellas;

import java.sql.SQLException;
import java.util.List;

public class GetGatos {

	private Conexion bd = Conexion.getInstance();
	
	public void execute (List<Gato> gatos) {
		try {
			bd.listarGatos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
