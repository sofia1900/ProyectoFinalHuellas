package ProyectoFinal.Huellas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Conexion {
	
	private Connection conexion;
	
	private static final String CLASE = "com.mysql.cj.jdbc.Driver";
	
	//Patron SINGLETON
	public static Conexion instance = null;
	
	//CONEXION Y CIERRE DE LA CONEXION
	private Conexion () throws SQLException {

		try {
			Class.forName(CLASE);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/huellas", "root", "");
		
	}
	public void cerrarConexion () throws SQLException {
		if (conexion != null && !conexion.isClosed()) {
			conexion.close();
		}
	}
	
	//DEVOLVER ULTIMO ID
	private int devolverId () throws SQLException {
		String sql = "SELECT last_insert_id()";
		PreparedStatement stat = conexion.prepareStatement(sql);
		ResultSet result = stat.executeQuery();
		
		result.next();
		int id = result.getInt(1);
		stat.close();
		result.close();
		
		return id;
	}
	
	//AÑADIR ANIMAL (PERROS Y GATOS)
	private void addAnimal (Animal a) throws SQLException {
		String sql = "INSERT INTO animal (nombre, fecha, sexo) VALUES (?, ?, ?)";
		
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setString(1, a.getNombre());
		stat.setString(2, a.getFechaNac());
		stat.setString(3, a.getSexo());
		
		stat.executeUpdate();
		stat.close();
	}
	public void addGato (Gato g) throws SQLException {
		addAnimal(g);
		 
		 int id = devolverId();
		 String sql = "INSERT INTO gato VALUES (?, ?)";
			
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setInt(1, id);
		stat.setBoolean(2, g.getVirus());
		
		stat.executeUpdate();
		stat.close();
		
	}
	public void addPerro (Perro p) throws SQLException {
		addAnimal(p);
		 
		 int id = devolverId();
		 String sql = "INSERT INTO perro VALUES (?, ?, ?)";
			
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setInt(1, id);
		stat.setString(2, p.getRaza());
		stat.setBoolean(3, p.getAmigable());
		
		stat.executeUpdate();
		stat.close();
		
	}
	
	//ELIMINAR ANIMAL 
		//eliminar de gato/perro
	public void eliminarGato (int id) throws SQLException {
		String sql = "DELETE FROM gato WHERE id = ?";
			
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setInt(1, id);
		
		stat.executeUpdate();
		stat.close();
		
		eliminarAnimal(id);
	}
	public void eliminarPerro (int id) throws SQLException {
		String sql = "DELETE FROM perro WHERE id = ?";
		
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setInt(1, id);
		
		stat.executeUpdate();
		stat.close();
		
		eliminarAnimal(id);
	}
		//eliminar de animal
	private void eliminarAnimal (int id) throws SQLException {
		String sql = "DELETE FROM animal WHERE id = ?";
		
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setInt(1, id);
		
		stat.executeUpdate();
		stat.close();
		
	}
	
	//LISTAR GATOS
	public List<Gato> listarGatos (){
		List<Gato> gatos = new ArrayList<>();
		
		return gatos;
	}
	
	//LISTAR PERROS
	public List<Perro> listarPerros (){
		List<Perro> perros = new ArrayList<>();
		
		return perros;
	}

	//AÑADIR PERSONA - ADOPTANTE
	private void addPersona() {
		
	}
	public void addAdoptante() {
		
	}
	
	//CREAR UNA ADOPCION
	public void addAdopcion() {
		
	}
	
	//LISTAR ADOPCIONES
	public List<Registro> listarAdocion () throws SQLException{
		String sql = "SELECT * FROM registro";
		
		PreparedStatement stat = conexion.prepareStatement(sql);
		ResultSet result = stat.executeQuery();
		
		int id;
		String fecha;
		int persona;
		int animal;
		
		Registro r;
		List<Registro> adopciones = new ArrayList<>();
		
		while (result.next()) {
			id = result.getInt("id");
			fecha = result.getString("fecha");
			persona = result.getInt("persona");
			animal = result.getInt("animal");
			
			Adoptante adoptante = buscarAdoptante(persona);
			Animal animalObjeto = buscarAnimal(animal);
			
			r = new Registro (id, fecha, adoptante, animalObjeto);
			adopciones.add(r);
			
		}
		
		return adopciones;
	}
	
	//BUSCAR PERSONA
	private Persona buscarPersona (int id) throws SQLException {
		String sql = "SELECT * FROM persona WHERE id = ?";
		
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setInt(1, id);
		
		ResultSet result = stat.executeQuery();
		
		result.next();
		int idP = result.getInt("id");
		String nombre = result.getString("nombre");
		String apellidos = result.getString("apellidos");
		String dni = result.getString("dni");
		
		Persona p = new Persona(idP, nombre, apellidos, dni);
		return p;
		
	}
	//BUSCAR ADOPTANTE
	private Adoptante buscarAdoptante (int id) throws SQLException {
		
		Persona p = buscarPersona (id);
		
		String sql = "SELECT * FROM adoptante WHERE id = ?";
		
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setInt(1, id);
		
		ResultSet result = stat.executeQuery();
		
		result.next();
		int idA = result.getInt("id");
		String fecha = result.getString("fecha_nacimiento");
		String direccion = result.getString("direccion");
		
		Adoptante adopt = new Adoptante (p.getId(), p.getNombre(), p.getApellidos(), p.getDni(), fecha, direccion);
		
		return adopt;
		
	}
	
	//BUSCAR ANIMAL
	private Animal buscarAnimal (int id) throws SQLException {
		String sql = "SELECT * FROM animal WHERE id = ?";
		
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setInt(1, id);
		
		ResultSet result = stat.executeQuery();
		
		result.next();
		int idA = result.getInt("id");
		String nombre = result.getString("nombre");
		String fecha = result.getString("fecha");
		String sexo = result.getString("sexo");
		
		Animal animal = new Animal(idA, nombre, fecha, sexo);
		return animal;
		
	}
	
	
	//Patron SINGLETON
	public static Conexion getInstance () {
		if (instance == null) {
			try {
				instance = new Conexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return instance;
	}

}
