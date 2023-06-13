package ProyectoFinal.Huellas.Presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ProyectoFinal.Huellas.Data.FicheroPDF;
import ProyectoFinal.Huellas.Domain.AddAdopcion;
import ProyectoFinal.Huellas.Domain.AddAdoptante;
import ProyectoFinal.Huellas.Domain.AddGato;
import ProyectoFinal.Huellas.Domain.AddPerro;
import ProyectoFinal.Huellas.Domain.Adoptante;
import ProyectoFinal.Huellas.Domain.Animal;
import ProyectoFinal.Huellas.Domain.BuscarAdoptante;
import ProyectoFinal.Huellas.Domain.BuscarAnimal;
import ProyectoFinal.Huellas.Domain.EliminarGato;
import ProyectoFinal.Huellas.Domain.EliminarPerro;
import ProyectoFinal.Huellas.Domain.Gato;
import ProyectoFinal.Huellas.Domain.GetGatos;
import ProyectoFinal.Huellas.Domain.GetPerros;
import ProyectoFinal.Huellas.Domain.ListarAdopcion;
import ProyectoFinal.Huellas.Domain.Perro;
import ProyectoFinal.Huellas.Domain.Registro;

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
				System.out.println("");
				System.out.println("-- MENU --");
				System.out.println("1. Nuevo animal");
				System.out.println("2. Eliminar animal");
				System.out.println("3. Listar gatos");
				System.out.println("4. Listar perros");
				System.out.println("5. Nuevo adoptante");
				System.out.println("6. Crear nueva adopcion");
				System.out.println("7. Listar adopciones");
				System.out.println("8. Salir");
				System.out.println("");
				
				opc = sc.nextInt();
				
				switch(opc) {
				case 1:
					//AÑADIR ANIMAL
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
					//ELIMINAR ANIMAL
					//PREGUNTAR SI ES UN GATO O UN PERRO
					System.out.println("1. Gato");
					System.out.println("2. Perro");
					opc2 = sc.nextInt();
		
					int id;
					switch (opc2) {
					case 1:
						System.out.println("Introduce el ID del animal");
						id = sc.nextInt();
						delGatoUseCase.execute(id);
						break;
					case 2:
						System.out.println("Introduce el ID del animal");
						id = sc.nextInt();
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
					if (gatos.size() > 0) {
						pintarLista(gatos);
						pdf.listarEnFichero("gatos.pdf", gatos);
					}else {
						System.out.println("No hay ningun gato");
					}
					break;
				case 4:
					//LISTAR PERROS
					List<Perro> perros;
					perros = listarPerrosUseCase.execute();
					if (perros.size() > 0) {
						pintarLista(perros);
						pdf.listarEnFichero("perros.pdf", perros);
					}else {
						System.out.println("No hay ningun perro");
					}
					
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
					if (adopciones.size() > 0) {
						pintarLista(adopciones);
						pdf.listarEnFichero("adopciones.pdf", adopciones);
					}else {
						System.out.println("No hay ninguna adopcion registrada");
					}
					
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
		
		boolean correcto = false;
		String dni;
		do {
			System.out.println("Introduce el dni del adoptante");
			dni = sc.next();
			
			if (dni.matches("^[0-9]{7,8}[T|R|W|A|G|M|Y|F|T|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$")) {
				correcto = true;
			}
		}while (correcto == false);
		
		correcto = false;
		String fechaNac;
		do {
			System.out.println("Introduce la fecha de nacimiento del adoptante (dd/mm/yyyy)");
			fechaNac = sc.next();
			
			if (fechaNac.matches("^([0-2]\\d|3[01])/(0\\d|1[012])/\\d{4}")){
				correcto = true;
			}
		}while (correcto == false);
		
		
		System.out.println("Introduce la direccion del adoptante");
		String direccion = sc.next();
		
		Adoptante adoptante = new Adoptante(0, nombre, apellidos, dni, fechaNac, direccion);
		addAdoptanteUseCase.execute(adoptante);
	}
	
	private static void addAdopcion () throws SQLException {
		String fecha;
		boolean correcto = false;
		do {
			System.out.println("Introduce la fecha (dd/mm/yyyy)");
			fecha = sc.next();
			if (fecha.matches("^([0-2]\\d|3[01])/(0\\d|1[012])/\\d{4}")) {
				correcto = true;
			}
			
		}while (correcto == false);
		
		System.out.println("Introduce el id del adoptante");
		int idAdoptante = sc.nextInt();
		System.out.println("Introduce el id del animal");
		int idAnimal = sc.nextInt();
		
		Adoptante adoptante = buscarAdoptanteUseCase.execute(idAdoptante);
		Animal animal = buscarAnimalUseCase.execute(idAnimal);
		
		if (adoptante.getDni() != null && animal.getNombre() != null) {
			Registro adopcion = new Registro(0, fecha, adoptante, animal);
			addAdopcionUseCase.execute(adopcion);
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
		String fecha;
		boolean correcto = false;
		do {
			System.out.println("Introduce la fecha de nacimiento (dd/mm/yyyy)");
			fecha = sc.next();
			if (fecha.matches("^([0-2]\\d|3[01])/(0\\d|1[012])/\\d{4}")) {
				correcto = true;
			}
			
		}while (correcto == false);

		String sexo;
		boolean ok;
		do {
			System.out.println("Introduce el sexo del animal: 'M' o 'H'");
			sexo = sc.next().toUpperCase();
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
		
		boolean correcto = false;
		boolean virus = false;
		do {
			try {
				System.out.println("Introduce true si el animal tiene virus o false si no lo tiene");
				virus = sc.nextBoolean();
				correcto = true;
			}catch (InputMismatchException e) {
				System.out.println("Introduce true o false");
				sc.next();
			}
			
		}while (correcto == false);
		
		Gato gato = new Gato (0, datosAnimal.get(0), datosAnimal.get(1), datosAnimal.get(2), false, virus);
		
		addGatoUseCase.execute(gato);
	}
	public static void addPerro () {
		List<String> datosAnimal = addAnimal();
		
		sc.nextLine();
		System.out.println("Introduce la raza del perro");
		String raza = sc.nextLine();
		
		boolean correcto = false;
		boolean amigable = true;
		do {
			try {
				System.out.println("Introduce true si el animal el amigable o false si no lo es");
				amigable = sc.nextBoolean();
				correcto = true;
			}catch (InputMismatchException e) {
				System.out.println("Introduce true o false");
				sc.next();
			}
			
		}while (correcto == false);
		
		
		Perro perro = new Perro (0, datosAnimal.get(0), datosAnimal.get(1), datosAnimal.get(2), false, raza, amigable);
		
		addPerroUseCase.execute(perro);
	}

}
