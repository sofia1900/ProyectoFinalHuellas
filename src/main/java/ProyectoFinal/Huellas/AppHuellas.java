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
	static EliminarPerro delPerroUseCase = new EliminarPerro();
	static ListarAdopcion listarAdopcionesUseCase = new ListarAdopcion();
	static BuscarAdoptante buscarAdoptanteUseCase = new BuscarAdoptante();
	static BuscarAnimal buscarAnimalUseCase = new BuscarAnimal();
	
	
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
					
					break;
				case 4:
					
					break;
				case 5:
					//AÑADIR ADOPTANTE
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
		
	}
	
	private static void addAdopcion () throws SQLException {
		
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
