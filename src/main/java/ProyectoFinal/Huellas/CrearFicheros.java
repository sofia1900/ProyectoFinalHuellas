package ProyectoFinal.Huellas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class CrearFicheros {
	
	public static <T> void listarGatosFichero(String nombre, List<T> lista) {
		
		try {
			FileOutputStream fileOut = new FileOutputStream(new File(nombre));
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			
			objectOut.writeObject(lista);
			
			fileOut.close();
			objectOut.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
