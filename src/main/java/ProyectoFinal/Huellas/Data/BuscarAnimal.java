package ProyectoFinal.Huellas.Data;

import java.sql.SQLException;

import ProyectoFinal.Huellas.Domain.Conexion;

public class BuscarAnimal {
	
	Conexion bd = Conexion.getInstance();
	
	public Animal execute (int id) throws SQLException {
		Animal animal = bd.buscarAnimal(id);
		return animal;
	}

}
