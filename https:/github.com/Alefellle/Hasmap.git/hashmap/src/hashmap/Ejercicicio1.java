package hashmap;

import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.NonReadableChannelException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Collections;

public class Ejercicicio1 {
	
	static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	static HashMap<String,Integer > agenda = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		menu();
	}
	
	public static void menu() throws NumberFormatException, IOException {
        int eleccion = 0;
        
        do {
            System.out.print("\n---Acciones---\n" +
                    "[1] Agendar a un amigo \n" +
                    "[2] Consultar el numero de amigos que hay agendados\n" +
                    "[3] Consultar el numero de amigos \n" +
                    "[4] Modificar el numero de amigos \n" +
                    "[5] Consultar a quien pertenece un numero de telefono\n" +
                    "[6] Borrar a un examigo de la agenda \n" +
                    "[7] Mostrar el contenido de la agenda\n" +
                    "[8] Listar unicamente los nombres de los amigo\n" +
                    "[9] Ordenar agenda por nombres\n" +
                    "[10] Ordenar agenda por telefonos\n" +
                    "[11] Salir\n" +
                    "Introduzca acción (1-11): " + "\n" 
            ); // esto para que cree toda las opciones para elegir
            
            try {
                eleccion = Integer.parseInt(entrada.readLine()); //esto para guardar el numero que te den en la eleccion  
            } catch (Exception e) {
                System.out.println("Por favor, introduzca un número entero válido.");
                eleccion = 0;
                continue; // Vuelve al inicio del bucle
            }
            
            switch (eleccion) {
                case 1:
                    agendaramigo(); // esto llama al metodo  idice que una vez lo llame se haga break porque sino se hara infinitamente
                    
                    break; 
                    
                case 2:
                    consultarnumeroamigosagendados();// esto llama al metodo  idice que una vez lo llame se haga break porque sino se hara infinitamente
                    break;
                    
                case 3:
                    consultartelefonoamigo();// esto llama al metodo  idice que una vez lo llame se haga break porque sino se hara infinitamente
                    
                    break;
                    
                case 4:

                    modificartelefonoamigo();// esto llama al metodo  idice que una vez lo llame se haga break porque sino se hara infinitamente
                    
                    break; 
                    
                case 5:
                    consultaraquienpertenece();// esto llama al metodo  idice que una vez lo llame se haga break porque sino se hara infinitamente
                    
                    break; 
                    
                case 6:
                    borrarexamigo();// esto llama al metodo  idice que una vez lo llame se haga break porque sino se hara infinitamente
                    break;
                    
                case 7:
                    System.out.println("Aqui tienes toda la agenda");
                    mostraragenda();// esto llama al metodo  idice que una vez lo llame se haga break porque sino se hara infinitamente
                    
                    break; 
                    
                case 8:
                    System.out.println("Aqui tienes los nombres de tus amigos agendados");
                    listarunicamentenombresamigos();// esto llama al metodo  idice que una vez lo llame se haga break porque sino se hara infinitamente
                    
                    break;
                case 9:
                    System.out.println("La agenda ordenada por nombres");
                    Ordenarpornombres();// esto llama al metodo  idice que una vez lo llame se haga break porque sino se hara infinitamente
                    
                    break;
                case 10:
                    System.out.println("La agenda ordenada por telefonos");
                    Ordenarportelefonos();// esto llama al metodo  idice que una vez lo llame se haga break porque sino se hara infinitamente
                    
                    break;
                    
                case 11:
                    System.out.println("Saliendo del programa..."); // este es el ultimo i es para salir del programa 
                    break; 
                    
                default:
                    System.out.println("Opción no válida. Debes elegir entre 1 y 11." + "\n");
                    break;
            }
        } while (eleccion != 11);
    }
	
	
    public static String pedirnombre() throws IOException {
    	System.out.println("Dime el nombre de tu amigo");
    	String nombre = entrada.readLine();
    	return nombre;
    }
    
    public static int pedirnumero() throws IOException {
    	System.out.println("Dime el numero de telefono");
    	int numero = Integer.parseInt(entrada.readLine()) ;
    	return numero;
    }
    
    public static boolean devolverlistavacia() {
    	boolean estavacia = agenda.isEmpty();
    	if (estavacia) {
    		System.out.println("La agenda esta vacia");
		}
    	return estavacia;
    	
    }
	

	private static void agendaramigo() {
		try {
			String nombre = pedirnombre(); // guarda el nombre 
			
			if (agenda.containsKey(nombre)) { // aqui dices que si el nombre ya esta en la agenda que diga que ya existe 
				System.out.println("Este amigo ya esta en la agenda");
			}else {// que sino  
				int numero = pedirnumero();//  
				
				// tengo que comprobar el numero para que sea mayor de 111111111 i menor que 999999999
				if (numero >= 900000000 && numero <= 999999999) {
					agenda.put(nombre, numero);// aqui ya dices que ponga el nombre i el numero en el hashmap
					System.out.println("Añadido correctamente");	//muestra que se añadio correctamente
				}else {
					System.out.println("El numero de es menor o mayor que 9 cifras");
				}
			}
			
		} catch (IOException e) {
			
		System.out.println("Debes introducir un numero entero");
		}
		
	}
	

	

	private static void consultarnumeroamigosagendados() {
	int namigos = agenda.size();// aqui guarda en una variable el tamaño del hasmap que sera el numero de personas agendadas
	
	System.out.println("Tienes " + namigos +" Agendados");
	
	}

	private static void consultartelefonoamigo() {
		try {
			String nombre = pedirnombre(); // aqui pides el nombre de tu amigo para guardarla ipoder jugar con ella 
			
			
			if (agenda.containsKey(nombre)) { // aqui ya empieza que si tiene el nombre en el hasmap
				
				int numero  = agenda.get(nombre); // que te de el valor de nombre i se guarde en nombre 
				System.out.println("El numero de tu amigo es: " + numero );// i que muestre el valor de numero 
				
			}
		} catch (Exception e) {
			System.out.println("Debes introducir un nombre que este en la agenda"); 
		}
		
	}

	private static void modificartelefonoamigo() {

		try {
			devolverlistavacia();
			String nombre = pedirnombre();
			
			if (agenda.containsKey(nombre)) {//esto comprueba que este dentro 
				int numeronuevo  = pedirnumero();// esto llama al metodo que he creadp para pedir el numero  
				agenda.put(nombre, numeronuevo);// esto pone el valor que ya has pedido porque el valor nombre no cambia
				System.out.println("Numero añadido correctamente");
			}else {
				System.out.println("El nombre no esta en la agenda");
			}
			
		} catch (IOException e) {
			System.out.println("Debes introducir un nombre que este en la agenda");
		}
		
	}

	private static void consultaraquienpertenece() {
		try {
			int numero = pedirnumero();
			boolean encontrado = false;
			
			
			for (String nombre : agenda.keySet()) {//esto inicia un bucle para recorrer todo el hasmap i extrae solo los valores key
				if (agenda.get(nombre) == numero) { // esto te da del valor nombre el numero 
					System.out.println("El numero le pertenece a: " + nombre );//esto muesra al amigo 
					encontrado = true;//esto cambia el estado de encontrado a true para que cuente como que lo ha encontrado
					break;
					
				}if (!encontrado) {  // esto es para que si es false porque se ha cambiado a true , que si es false que muesto lo siguiente
					System.out.println("El numero no esta en la agenda");
					
				}
				}		
		} catch (Exception e) {
			System.out.println("Debes introducir un numero que este en la agenda"); 
		}
		
	}

	private static void borrarexamigo() {
		
		devolverlistavacia();
		
		try {
			String nombre = pedirnombre();
			
			if (agenda.containsKey(nombre)) {
				agenda.remove(nombre);
				System.out.println("Tu amigo a sudo eliminado");
				
			}else {
				System.out.println("No tienen ningun amigo guardado asi");
			}
			
		} catch (Exception e) {
			System.out.println("Error al poner el nombre");
		}
	
		
	}

	private static void mostraragenda() {
		
		devolverlistavacia();
		
		try {
			
				
			for (Map.Entry<String, Integer> entrada : agenda.entrySet()) { // esto recorre todo el hasmap i lo hace por pares nombre y telefono ,i asi hasta recorrer todo i eso va en un pack
				String nombre = entrada.getKey();//esto abre el par actual  y saca el valor key que es el nombre 
				int numero = entrada.getValue();//esto abre el par que esta actualmente abierto ya que lo ha abierto el nombre por el valor
				System.out.println("Nombre : " + nombre +" el numero es:  " + numero  );
				System.out.println("---------------------------------------------------------");	
			
			}
			
		} catch (Exception e) {

			System.out.println("Error al mostrar la agenda");
		}
		
		
		
	}

	private static void listarunicamentenombresamigos() {
		
		devolverlistavacia();
		try {
			
				
			for (Map.Entry<String,Integer> entrada : agenda.entrySet()) { // esto recorre todo el hasmap i lo hace por pares nombre y telefono ,i asi hasta recorrer todo i eso va en un pack
				String nombre = entrada.getKey();//esto abre el par actual  y saca el valor key que es el nombre 
				System.out.println("El nombre es : " + nombre  );
				System.out.println("---------------------------------------------------------");
			
			}
		} catch (Exception e) {

			System.out.println("Error al mostrar la agenda");
		}
		
		
		
		
		
	}

	private static void Ordenarpornombres() {
		if (devolverlistavacia()) {
			return;
		}
			
			TreeMap<String,Integer> agendaordenadanombres = new TreeMap<>(agenda);
			agendaordenadanombres.putAll(agenda);
			
			for (Map.Entry<String, Integer> entrada:agendaordenadanombres.entrySet()) {
				String nombre = entrada.getKey();//esto abre el par actual  y saca el valor key que es el nombre 
				int numero = entrada.getValue();//esto abre el par que esta actualmente abierto ya que lo ha abierto el nombre por el valor
				System.out.println("Nombre : " + nombre +" el numero es:  " + numero  );
				System.out.println("---------------------------------------------------------");
				
		}
		
	}
	
	private static void Ordenarportelefonos() {
		if (devolverlistavacia()) {
			return;
		
		}
			
			TreeMap<String,Integer> agendaordenadatelefonos = new TreeMap<>();
			agendaordenadatelefonos.putAll(agenda);
			
			
			for (Map.Entry<String, Integer> entrada:agendaordenadatelefonos.entrySet()) {
				String nombre = entrada.getKey();//esto abre el par actual  y saca el valor key que es el nombre 
				int numero = entrada.getValue();//esto abre el par que esta actualmente abierto ya que lo ha abierto el nombre por el valor
				System.out.println("Nombre : " + nombre +" el numero es:  " + numero  );
				System.out.println("---------------------------------------------------------");
					
			
		}
		
		
	}


	

}






