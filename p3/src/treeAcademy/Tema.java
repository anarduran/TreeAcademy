package treeAcademy;
import java.util.ArrayList;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Clase heredada de ItemAsig. Clase de un tema de una asignatura
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class Tema extends ItemAsig{
	private static final long serialVersionUID = 1L;/*id del Serializable*/
	private ArrayList<ItemAsig> items;/*array de items, es decir, apuntes, ejercicios o subtemas*/
	private int numEjercicios;

	/**
	 * Constructor de la clase Tema
	 * @param nombre nombre del tema
	 * @param visible visibilidad del tema
	 */
	public Tema(String nombre, boolean visible){
		super(nombre, visible);
		this.items = new ArrayList<ItemAsig>();
		this.numEjercicios = 0;
	}

	/**
	 * @param it item
	 * @return null retorna null
	 */
	public ItemAsig buscarItem(String it){
		for (ItemAsig item : this.getItems()){
			if (item.getNombre().compareTo(it) == 0){
				return item;
			}
		}
		return null;
	}
	
	
	/**
	 * Funcion que obtiene los items. 
	 * @return puede ser apunte, ejercicio o un tema (que sera un subtema)
	 */
	public ArrayList<ItemAsig> getItems() {
		return this.items;
	}

	/**
	 * Funcion que aniade un nuevo item al array
	 * @param item item que se desea aniadir
	 */
	public void aniadirItem(ItemAsig item) {
		if (this.items.contains(item) == false){
			 this.items.add(item);
		}
	}
  
	/**
	 * Funcion que elimina un item del array
	 * @param item item que se desea eliminar
	 */
	public void eliminarItem(ItemAsig item){
		if ((this.items.contains(item)) || !(item instanceof Tema)){
			this.items.remove(item);
		}
	}
	
	@Override
	public String toString() {
		return "Temas: "+ this.getNombre() + "\n";
	}

	public boolean contains(Tema tema) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Funcion para establecer la visibilidad de todos los items
	 * @throws FailedInternetConnectionException excepcion
	 * @throws InvalidEmailAddressException excepcion
	 */
	public void modificarVisibilidad() throws InvalidEmailAddressException, FailedInternetConnectionException{
		if (this.getVisibilidad()){
			this.setVisibilidad(false);
			for (ItemAsig ia : this.items){
				ia.setVisibilidad(false);
			}
		}else{
			this.setVisibilidad(true);
			for (ItemAsig ia : this.items){
				ia.setVisibilidad(true);
				TreeAcademy.enviarNotificacion();
			}
			
		}
	}
	
	/**
	 * 
	 */
	public void numeroDeEjercicios(){
		for (ItemAsig item : this.items){
			if (item instanceof Ejercicio){
				this.numEjercicios ++;
			}
		}
	}
	
	/**
	 * @return nota nota del ejercicio
	 */
	public double notaEjercicio(){
		for (ItemAsig item: this.items){
			if (item instanceof Ejercicio){
				this.nota += ((Ejercicio) item).getNota();
				
			}
		}
		return this.nota;
	}

	/**
	 * @return numEjercicios numero de ejercicios
	 */
	public int getNumEjercicios() {
		this.numeroDeEjercicios();
		return this.numEjercicios;
	}
}