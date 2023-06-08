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
	private static Conexion instance = null;
	
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
		
	
	//AÑADIR PERSONA - ADOPTANTE
	private void addPersona(Persona p) throws SQLException {
		String sql = "INSERT INTO persona (nombre, apellidos, dni) VALUES (?, ?, ?)";
		
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setString(1, p.getNombre());
		stat.setString(2, p.getApellidos());
		stat.setString(3, p.getDni());
		
		stat.executeUpdate();
		stat.close();
		
	}
	public void addAdoptante(Adoptante a) throws SQLException {
		addPersona(a);
		String sql = "INSERT INTO adoptante (fechaNac, Direccion) VALUES (?,?,?)";
		
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setString(1, a.getFechaNac());
		stat.setString(2, a.getDireccion());
		
		stat.executeUpdate();
		stat.close();
	}
	
	//CREAR UNA ADOPCION
	public void addAdopcion(Registro r) throws SQLException {
		String sql = "INSERT INTO registro (fecha, persona, animal) VALUES (?,?,?)";
		
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setString(1,r.getFechaAdopcion());
		stat.setInt(2, r.getAdoptante().getId());
		stat.setInt(3, r.getAnimal().getId());
		
		stat.execute();
		stat.close();

		
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
	public Adoptante buscarAdoptante (int id) throws SQLException {
		
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
	
	//listar perro
	public List<Perro> listarPerros() throws SQLException{
		String sql = "SELECT * FROM perro";
		
		PreparedStatement stat = conexion.prepareStatement(sql);
		ResultSet result = stat.executeQuery();
		
		int id;
		String raza;
		boolean amigable;
		int animal = 0;
		
		List<Perro> perros = new ArrayList<>();
		
		while (result.next()) {
			id = result.getInt("id");
			raza = result.getString("raza");
			amigable = result.getBoolean("amigable");
			
			
			Perro perro = buscarPerro(animal);
			perros.add(perro);
			
		}
		
		return perros;
	}
	//listar gatos
	public List<Gato> listarGatos() throws SQLException{
		
		String sql = "SELECT * FROM gato";
		
		PreparedStatement stat = conexion.prepareStatement(sql);
		ResultSet result = stat.executeQuery();
		
		int id;
		boolean virus;
		int gato = 0;
		
		List<Gato> gatos = new ArrayList<>();
		
		while (result.next()) {
			id = result.getInt("id");
			virus = result.getBoolean("virus");
			
		Gato gatito = buscarGato(gato);
		gatos.add(gatito);
		
		}
			return gatos;
		
		
	}

	
	//BUSCAR ANIMAL
	public Animal buscarAnimal (int id) throws SQLException {
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
	
	private Perro buscarPerro(int id) throws SQLException{
		
		Animal animal = buscarAnimal(id);
		
		String sql = "SELECT * FROM perro WHERE id = ?";
		
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setInt(1, id);
		
		ResultSet result = stat.executeQuery();
		result.next();
		
		int idP = result.getInt("id");
		String raza = result.getString("raza");
		boolean amigable = result.getBoolean("amigable");
		
		Perro p = new Perro(animal.getId(),animal.getNombre(),animal.getFechaNac(),animal.getSexo(),raza,amigable);
		
		return p;
	}
	private Gato buscarGato(int id) throws SQLException{
		
		Animal animal = buscarAnimal(id);
		String sql = "SELECT * FROM gato WHERE id = ?";
		
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setInt(1, id);
		
		ResultSet result = stat.executeQuery();
		result.next();
		
		int idGato = result.getInt("id");
		boolean virus = result.getBoolean("virus");
		
		Gato g = new Gato(animal.getId(),animal.getNombre(),animal.getFechaNac(),animal.getSexo(),virus);
		return g;
		
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
