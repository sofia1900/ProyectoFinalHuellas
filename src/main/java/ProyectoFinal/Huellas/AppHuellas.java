package ProyectoFinal.Huellas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class AppHuellas {
	
	static AddGato addGatoUseCase = new AddGato ();
	static AddPerro addPerroUseCase = new AddPerro();
	static EliminarGato delG = new EliminarGato();
	static EliminarPerro delP = new EliminarPerro();
	static GetGatos getGatos = new GetGatos();
	static GetPerros getPerros = new GetPerros();
	
	
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
				System.out.println("5. Añadir persona");
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
						delG.execute(id);
						break;
					case 2:
						delP.execute(id);
						break;
					default:
						System.out.println("OPCION NO VALIDA");
					}
					break;
				case 3:
					List<Gato> gatos = new ArrayList<>();
					System.out.println("Lista de gatos:");
					getGatos.execute(gatos);
					break;
				case 4:
					List<Perro> perros = new ArrayList<>();
					System.out.println("Lista de perros: ");
					getPerros.execute(perros);
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
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
