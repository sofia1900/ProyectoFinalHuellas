package ProyectoFinal.Huellas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppHuellas {
	
	static AddGato addGatoUseCase = new AddGato ();
	static AddPerro addPerroUseCase = new AddPerro();
	static AddAdopcion addAdopcionUseCase = new AddAdopcion();
	static AddAdoptante addAdoptanteUseCase = new AddAdoptante();
	static EliminarGato delGatoUseCase = new EliminarGato();
	static GetGatos listarGatosUseCase = new GetGatos();
	static EliminarPerro delPerroUseCase = new EliminarPerro();
	static GetPerros listarPerrosUseCase = new GetPerros();
	static ListarAdopcion listarAdopcionesUseCase = new ListarAdopcion();
	static BuscarAdoptante buscarAdoptanteUseCase = new BuscarAdoptante();
	static BuscarAnimal buscarAnimalUseCase = new BuscarAnimal();
	static FicheroPDF pdf = new FicheroPDF();
	
	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		int opc;
		int opc2;
		boolean salir = false ;
		
		do {
			
			try {
				
				System.out.println("-- MENU --");
				System.out.println("1. Añadir animal");
				System.out.println("2. Eliminar animal");
				System.out.println("3. Listar gatos");
				System.out.println("4. Listar perros");
				System.out.println("5. Añadir adoptante");
				System.out.println("6. Crear nueva adopcion");
				System.out.println("7. Listar adopciones");
				System.out.println("8. Salir");
				
				opc = sc.nextInt();
				
				switch(opc) {
				case 1:
					//PREGUNTAR SI ES UN GATO O UN PERRO
					System.out.println("1. Gato");
					System.out.println("2. Perro");
					opc2 = sc.nextInt();
					switch (opc2) {
					case 1:
						addGato();
						break;
					case 2:
						addPerro();
						break;
					default:
						System.out.println("OPCION NO VALIDA");
					}
					break;
				case 2:
					//PREGUNTAR SI ES UN GATO O UN PERRO
					System.out.println("1. Gato");
					System.out.println("2. Perro");
					opc2 = sc.nextInt();
					System.out.println("Introduce el ID del animal");
					int id = sc.nextInt();
					
					switch (opc2) {
					case 1:
						delGatoUseCase.execute(id);
						break;
					case 2:
						delPerroUseCase.execute(id);
						break;
					default:
						System.out.println("OPCION NO VALIDA");
					}
					break;
				case 3:
					//LISTAR GATOS
					List<Gato> gatos;
					gatos = listarGatosUseCase.execute();
					pintarLista(gatos);
					pdf.listarEnFichero("gatos.pdf", gatos);
					break;
				case 4:
					//LISTAR PERROS
					List<Perro> perros;
					perros = listarPerrosUseCase.execute();
					pintarLista(perros);
					pdf.listarEnFichero("perros.pdf", perros);
					break;
				case 5:
					//AÑADIR ADOPTANTE
					addAdoptante();
					break;
				case 6:
					//CREAR NUEVA ADOPCION
					addAdopcion();
					break;
				case 7:
					//LISTA ADOPCIONES
					List<Registro> adopciones;
					adopciones = listarAdopcionesUseCase.execute();
					pintarLista(adopciones);
					pdf.listarEnFichero("adopciones.pdf", adopciones);
					break;
				case 8:
					salir = true;
					break;
				default:
					System.out.println("Opcion invalida");
					
				}
				
			}catch(Exception e) {
				System.out.println("Eso NO es un numero");
				sc.next();
			}
			
			
		}while (salir == false);
		
	}
	
	private static <T> void pintarLista(List<T> lista) {
		for (T unidad : lista) {
			System.out.println(unidad);
		}
	}
	
	private static void addAdoptante () {
		sc.nextLine();
		System.out.println("Introduce el nombre del adoptante");
		String nombre = sc.nextLine();
		System.out.println("Introduce los apellidos del adoptante");
		String apellidos = sc.nextLine();
		System.out.println("Introduce el dni del adoptante");
		String dni = sc.next();
		System.out.println("Introduce la fecha de nacimiento del adoptante");
		String fechaNac = sc.next();
		System.out.println("Introduce la direccion del adoptante");
		String direccion = sc.next();
		
		Adoptante adoptante = new Adoptante(0, nombre, apellidos, dni, fechaNac, direccion);
		addAdoptanteUseCase.execute(adoptante);
	}
	
	private static void addAdopcion () throws SQLException {
		
		System.out.println("1. Gato");
		System.out.println("2. Perro");
		int opc = sc.nextInt();
		
		System.out.println("Introduce la fecha");
		String fecha = sc.next();
		System.out.println("Introduce el id del adoptante");
		int idAdoptante = sc.nextInt();
		System.out.println("Introduce el id del animal");
		int idAnimal = sc.nextInt();
		
		Adoptante adoptante = buscarAdoptanteUseCase.execute(idAdoptante);
		Animal animal = buscarAnimalUseCase.execute(idAnimal);
		
		Registro adopcion = new Registro(0, fecha, adoptante, animal);
		addAdopcionUseCase.execute(adopcion);
		
		if (opc == 1) {
			delGatoUseCase.execute(idAnimal);
		}else {
			delPerroUseCase.execute(idAnimal);
		}
	}
	
	private static boolean validarSexo (String sexo) {
		if (sexo.equals("H") || sexo.equals("M")) {
			return true;
		}else {
			return false;
		}
	}
	private static List<String> addAnimal() {
		System.out.println("Introduce el nombre del animal");
		String nombre = sc.next();
		System.out.println("Introduce la fecha de nacimiento");
		String fecha = sc.next();
		String sexo;
		boolean ok;
		do {
			System.out.println("Introduce el sexo del animal: 'M' o 'H'");
			sexo = sc.next();
			ok = validarSexo(sexo);
		}while (ok == false);
		
		
		List<String> datosAnimal = new ArrayList<>();
		datosAnimal.add(nombre);
		datosAnimal.add(fecha);
		datosAnimal.add(sexo);
		
		return datosAnimal;
		
	}
	public static void addGato () {
		List<String> datosAnimal = addAnimal();
		
		System.out.println("Introduce true si el animal tiene virus o false si no lo tiene");
		boolean virus = sc.nextBoolean();
	
		Gato gato = new Gato (0, datosAnimal.get(0), datosAnimal.get(1), datosAnimal.get(2), virus);
		
		addGatoUseCase.execute(gato);
	}
	public static void addPerro () {
		List<String> datosAnimal = addAnimal();
		
		System.out.println("Introduce la raza del perro");
		String raza = sc.nextLine();
		System.out.println("Introduce true si el animal el amigable o false si no lo es");
		boolean amigable = sc.nextBoolean();
		
		Perro perro = new Perro (0, datosAnimal.get(0), datosAnimal.get(1), datosAnimal.get(2), raza, amigable);
		
		addPerroUseCase.execute(perro);
	}

}
