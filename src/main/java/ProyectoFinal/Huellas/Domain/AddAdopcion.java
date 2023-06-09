package ProyectoFinal.Huellas.Domain;
import java.sql.SQLException;

import ProyectoFinal.Huellas.Data.Conexion;

public class AddAdopcion {
	
	private Conexion bd = Conexion.getInstance();
		
		public void execute (Registro ad) {
			try {
				bd.addAdopcion(ad);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
