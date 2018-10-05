package pruebas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import modelo.Persona;

public class TestSerializacion {
	
	public static void main(String[]args){
		
		Persona p = new Persona("Maria",30);
		Persona m = new Persona("Pedro",30);
		//< > esto indica qué tipos específicos de datos que quieas en tu lista
		ArrayList<Persona> lista = new ArrayList<Persona>();
		lista.add(p);
		lista.add(m);
		
		try {
			FileOutputStream archivo = new FileOutputStream("archivoPrueba.txt");
			ObjectOutputStream oos = new ObjectOutputStream(archivo); //Esto convierte a binario
			//siempre y cuando implementes Serializable
			oos.writeObject(lista);
			oos.close();
			archivo.close();//cerrando los flujos de informacion
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileInputStream archivoLectura = new FileInputStream("archivoPrueba.txt");
			ObjectInputStream ois = new ObjectInputStream(archivoLectura);//Este recibe binario y transforma
			//a objeto, a su estado natural "deserializa"
			
			ArrayList<Persona> listaRes = (ArrayList<Persona>) ois.readObject();
			for(Persona item:listaRes){
				//item viene siendo "Persona[i]"
				if(item instanceof Persona){
					System.out.println(item.toString());
				}
			}
			
			//Esto era antes de hacerlo lista
			//Persona res=(Persona) ois.readObject();
			ois.close();
			archivoLectura.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
