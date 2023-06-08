package ProyectoFinal.Huellas;

import java.sql.SQLException;

public class BuscarAnimal {
	
	Conexion bd = Conexion.getInstance();
	
	public Animal execute (int id) throws SQLException {
		Animal animal = bd.buscarAnimal(id);
		return animal;
	}

}
