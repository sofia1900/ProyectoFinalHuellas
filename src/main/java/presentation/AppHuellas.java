package presentation;

import java.util.Scanner;

public class AppHuellas {
	
	static Scanner sc = new Scanner (System.in);
	
	
	public static void main(String[] args) {
		
		int opc;
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
					
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
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

}
