package org.example;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext; 
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
 
public class XMLToClass_PAXB {
    private static final String MIARCHIVO_XML = "libreria.xml";
    public static void main(String[] args)
                throws JAXBException, IOException {
    
        //Visualizamos ahora los datos del documento XML creado.
        System.out.println("------------ Leo el XML ----------");
        //Creamos el contexto indicando la clase raíz 
        JAXBContext context = JAXBContext.newInstance(Libreria.class);
        //Se crea el Unmarshaller en el contexto de la clase Libreria
        Unmarshaller unmars = context.createUnmarshaller();

        //Utilizamos el método unmarshall para obtener datos de un Reader
        Libreria libreria2 = (Libreria) 
                    unmars.unmarshal(new FileReader(MIARCHIVO_XML));
        
        //Recuperamos los datos y visualizamos
        System.out.println("Nombre de librería: "+ libreria2.getNombre());
        System.out.println("Lugar de la librería: "+ libreria2.getLugar());
        System.out.println("Libros de la librería: ");

        ArrayList<Libro> lista = libreria2.getListaLibro();
        for (Libro libro:lista){
            System.out.println("\tTítulo del libro: "
            + libro.getNombre()+ ",autor: "+libro.getAutor());
        }
    }
}