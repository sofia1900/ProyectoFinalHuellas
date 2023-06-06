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
		String sql = "DELETE INTO gato VALUES WHILE id = ?";
			
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setInt(1, id);
		
		stat.executeUpdate();
		stat.close();
		
		eliminarAnimal(id);
	}
	public void eliminarPerro (int id) throws SQLException {
		String sql = "DELETE INTO perro VALUES WHILE id = ?";
		
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setInt(1, id);
		
		stat.executeUpdate();
		stat.close();
		
		eliminarAnimal(id);
	}
		//eliminar de animal
	private void eliminarAnimal (int id) throws SQLException {
		String sql = "DELETE INTO animal VALUES WHILE id = ?";
		
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
	private void addPersona(Persona p) throws SQLException {
		String sql = "INSERT INTO Persona (id, nombre, apellidos, dni) VALUES (?, ?, ?, ?)";
		
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setInt(1, p.getId());
		stat.setString(2, p.getNombre());
		stat.setString(3, p.getApellidos());
		stat.setString(4, p.getDni());
		
		stat.executeUpdate();
		stat.close();
		
	}
	public void addAdoptante(Adoptante a) throws SQLException {
		addPersona(a);
		String sql = "INSERT INTO Adoptante (id, fechaNac, Direccion) VALUES (?,?,?,?)";
		
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setInt(1, a.getId());
		stat.setString(2, a.getFechaNac());
		stat.setString(3, a.getDireccion());
		
		stat.executeUpdate();
		stat.close();
	}
	
	//CREAR UNA ADOPCION
	public void addAdopcion(Registro r) throws SQLException {
		String sql = "INSERT Adopcion INTO registro (fecha, persona, animal) VALUES (?,?,?)";
		
		PreparedStatement stat = conexion.prepareStatement(sql);
		stat.setString(1,r.getFechaAdopcion());
		stat.setInt(2, r.getAdoptante().getId());
		stat.setInt(3, r.getAnimal().getId());
		
		stat.execute();
		stat.close();

		
	}
	
	//LISTAR ADOPCIONES
	public List<Registro> listarAdocion (){
		List<Registro> adopciones = new ArrayList<>();
		
		return adopciones;
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
