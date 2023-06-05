package ProyectoFinal.Huellas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
private Connection conexion;
	
	private static final String CLASE = "com.mysql.cj.jdbc.Driver";
	
	public Conexion () throws SQLException {
		
		//Driver del controlador
		try {
			Class.forName(CLASE);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		//Conexion
		conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/huellas", "root", "");
		
	}
	
	//cerrar conexion
	public void cerrarConexion () throws SQLException {
		if (conexion != null && !conexion.isClosed()) {
			conexion.close();
		}
	}

}
