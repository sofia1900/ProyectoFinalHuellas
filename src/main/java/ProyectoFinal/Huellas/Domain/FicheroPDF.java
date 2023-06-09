package ProyectoFinal.Huellas.Domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class FicheroPDF {
	
	public <T> void listarEnFichero(String nombre, List<T> lista) {
		try {
            File file = new File(nombre);
            PdfWriter pdfWriter = new PdfWriter(file);
 
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
 
            Document document = new Document(pdfDocument);
 
            for (int i = 0; i < lista.size(); i++) {
            	Paragraph paragraph = new Paragraph(lista.get(i).toString());
            	document.add(paragraph);
            }
            document.close();
 
            pdfWriter.close();
 
            System.out.println("PDF creado");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
	}
}
