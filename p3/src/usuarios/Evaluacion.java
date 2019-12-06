package usuarios;

import java.io.Serializable;
import java.util.ArrayList;

import ejercicios.Pregunta;
import ejercicios.PreguntaAbierta;
import ejercicios.PreguntaUnica;
import ejercicios.PreguntaVF;
import ejercicios.Respuesta;
import treeAcademy.Ejercicio;

import java.time.LocalDate;

/**
 * Clase Evaluacion
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class Evaluacion implements Serializable {
	private static final long serialVersionUID = 1L; /*id para la implementazion Serializable*/
	private double respuestaCorrecta; /*numero de respuestas correctas*/
	private ArrayList<Respuesta> respuestaProfesor; /*array de las respuestas del profesor*/
	private ArrayList<Respuesta> respuestaEstudiante; /*array de las respuestas del estudiante*/
	private Ejercicio ejercicio; /*ejercicio del que se hara la evaluacion*/
	private double nota; /*nota de la evaluacion*/
	private double nota_total; /*nota total de la asignatura*/
	private boolean ejercicioterminado; /*variable para determinar si un ejercicio ha finalizado*/
	private double respuestaincorrecta; /*numero de respuestas incorrectas*/
	private double sinContestar; /*numero de preguntas sin contestar*/
	private Matricula matricula; /*matricula del estudiante*/
	private int estudiantesContestaron; /*estudiantes que contestaron */
	
	/**
	 * Constructor de la clase Evaluacion
	 */
	public Evaluacion (){
		this.respuestaProfesor = new ArrayList<Respuesta>();
		this.respuestaEstudiante = new ArrayList<Respuesta>();
		this.setNota(0.0);
		this.nota_total = 0.0;
		this.ejercicioterminado = false;
		this.respuestaCorrecta = 0;
		this.respuestaincorrecta = 0;
		this.sinContestar = 0.0;
		this.estudiantesContestaron = 0;
	}
	/**
	 * Funcion que obtiene el numero de estudiantes que contestaron
	 * @return estudiantesContestaron estudiantes que contestaron un ejercicio
	 */
	public int getEstudiantesContestaron(){
		return this.estudiantesContestaron;
	}
	/**
	 * Funcion que obtiene la matricula 
	 * @return matricula matricula
	 */
	public Matricula getMatricula(){
		return this.matricula;
	}
	
	/**
	 * Funcion que obtiene el numero de las preguntas sin contestar
	 * @return sinContestar preguntas sin contestar
	 */
	public double getSinContestar(){
		return this.sinContestar;
	}
	/**
	 * Funcion que obtiene la nota total
	 * @return nota_total nota total
	 */
	public double getNotaTotal(){
		return this.nota_total;
	}
	/**
	 * Funcion que obtiene el numero de repsuestas correctas
	 * @return respuestaCorrecta respuestas correctas
	 */
	public double getRespuestaCorrecta() {
		return this.respuestaCorrecta;
	}

	/**
	 * Funcion que obtiene las respuestas del profesor
	 * @return respuestaProfesor respuestas del profesor
	 */
	public ArrayList<Respuesta> getRespuestaProfesor() {
		return respuestaProfesor;
	}

	/**
	 * Funcion que obtiene las respuestas del estudiante
	 * @return respuestaEstudiante respuesta del estudiante
	 */
	public ArrayList<Respuesta> getRespuestaEstudiante() {
		return respuestaEstudiante;
	}
	
	/**
	 * Funcion que aniaade respuestas al array del profesor 
	 * @param r respuesta a aniadir
	 */
	public void aniadirRespuestaProfesor(Respuesta r){
		if(!this.ejercicioterminado){
			if(!this.respuestaProfesor.contains(r)){
					this.respuestaProfesor.add(r);
			}
		}	
	}
	
	/**
	 * Funcion que aniade respuestas al array del estudiante
	 * @param r respuesta a aniadir
	 */
	public void aniadirRespuestaEstudiante(Respuesta r){
		if(!this.respuestaEstudiante.contains(r)){
			this.respuestaEstudiante.add(r);
		}
	}
	
	/**
	 * Funcion que cancela un ejercicio
	 */
	public void cancelar(){
		 this.respuestaEstudiante.removeAll(respuestaEstudiante);
	}
	
	/**
	 * Funcion que corrige una pregunta 
	 * @param preg pregunta a corregir
	 */
	public void corregirPregunta(Pregunta preg){
		String profesor = null;
		String estudiante = null;
		ArrayList<Respuesta> prof = new ArrayList<Respuesta>();
		ArrayList<Respuesta> estu = new ArrayList<Respuesta>();
		int contador = 0;
		
		if (preg instanceof PreguntaVF || preg instanceof PreguntaUnica){
			for (int i = 0; i< this.getRespuestaProfesor().size(); i++){
				if (this.getRespuestaProfesor().get(i).getId() == preg.getIdPregunta()){
					profesor = this.getRespuestaProfesor().get(i).getRespuesta();
				}
			}
			for (int j = 0; j<this.getRespuestaEstudiante().size(); j++){
				if (this.getRespuestaEstudiante().get(j).getId() == preg.getIdPregunta()){
					estudiante = this.getRespuestaEstudiante().get(j).getRespuesta();
				}
			}
			if (profesor == estudiante){
				this.nota += preg.getNota();
				this.respuestaCorrecta ++;
			}else{
				this.nota -= preg.getPenalizacion();
				this.respuestaincorrecta ++;
				if (estudiante == "" || estudiante == " "){
					this.sinContestar ++;
				}
			}
			
			
		}else{
			if (preg instanceof PreguntaAbierta){
				for (int i = 0; i< this.getRespuestaProfesor().size(); i++){
					if (this.getRespuestaProfesor().get(i).getId() == preg.getIdPregunta()){
						 prof.add(this.getRespuestaProfesor().get(i));
					}
				}
				for (int j = 0; j<this.getRespuestaEstudiante().size(); j++){
					if (this.getRespuestaEstudiante().get(j).getId() == preg.getIdPregunta()){
						estudiante = this.getRespuestaEstudiante().get(j).getRespuesta();
					}
				}
				for (int k = 0; k<prof.size(); k++){
					if (prof.get(k).getRespuesta() == estudiante){
						contador = 1;
					}
				}
				if (contador == 1){
					this.nota += preg.getNota();
					this.respuestaCorrecta ++;
				}else{
					this.nota -= preg.getPenalizacion(); 
					this.respuestaincorrecta ++;
					if (estudiante == "" || estudiante == " "){
						this.sinContestar ++;
					}
				}
			}else{
				for (int i = 0; i< this.getRespuestaProfesor().size(); i++){
					if (this.getRespuestaProfesor().get(i).getId() == preg.getIdPregunta()){
						 prof.add(this.getRespuestaProfesor().get(i));
					}
				}
				for (int j = 0; j<this.getRespuestaEstudiante().size(); j++){
					if (this.getRespuestaEstudiante().get(j).getId() == preg.getIdPregunta()){
						estu.add(this.getRespuestaEstudiante().get(j));
					}
				}
				
				for (int l = 0; l< prof.size(); l++){
					for (int m = 0; m< estu.size(); m++){
						if (prof.get(l).getRespuesta() == estu.get(m).getRespuesta()){
							contador++;
							break;
						}
					}
				}
				if (contador == prof.size()){
					this.nota += preg.getNota();
					this.respuestaCorrecta ++;
				}else{
					this.nota -= preg.getPenalizacion(); 
					this.respuestaincorrecta ++;
					if (estu.size() == 0){
						this.sinContestar ++;
					}
				}
			}
		}
		
		this.nota_total += preg.getNota();
		
	}
	
	/**
	   * Funcion que normaliza la nota sobre 10
	   */
	  public void calculaNormalizacion() {
			this.nota = (this.nota * 10)/this.nota_total;
			if (this.nota < 0){
				this.nota = 0.0;
			}
			 this.estudiantesContestaron ++;
	  }
	  
	  /**
	   * Funcion que normaliza el procentaje de las estadisticas
	   * @param ejer ejercicio del que se calculara las estadisticas
	   */
	  public void normalizarPorcentaje(Ejercicio ejer){
		  this.respuestaCorrecta = (this.respuestaCorrecta * 100) / ejer.getPreguntas().size();
		  this.respuestaincorrecta = (this.respuestaincorrecta * 100) / ejer.getPreguntas().size();
		  this.sinContestar = (this.sinContestar * 100) / ejer.getPreguntas().size();
		  ejer.setNota(this.nota);
	  }
	  
	  /**
	   * Funcion que muestra las estadisticas
	   * @param ejer ejercicio del que mostrara las estadisticas
	   */
	  public void mostrarEstadisticas(Ejercicio ejer){
		  System.out.println("Estadisticas: \n"+"\t-" + ejer.getNombre() + "\n\t-Preguntas correctas: " + this.getRespuestaCorrecta() + "%"
		  + "\n\t-Preguntas incorrectas: " + this.getRespuestaIncorrecta() + "%" + "\n\t-Preguntas sin contestar: "
				  + this.getSinContestar() + "%");
	  }
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evaluacion other = (Evaluacion) obj;
		if (respuestaCorrecta != other.respuestaCorrecta)
			return false;
		if (respuestaEstudiante == null) {
			if (other.respuestaEstudiante != null)
				return false;
		} else if (!respuestaEstudiante.equals(other.respuestaEstudiante))
			return false;
		if (respuestaProfesor == null) {
			if (other.respuestaProfesor != null)
				return false;
		} else if (!respuestaProfesor.equals(other.respuestaProfesor))
			return false;
		return true;
	}
	
	
	/**
	 * Funcion que obtiene si el ejercicio ha terminado
	 * @return ejercicioterminado true si ha finalizado y false en caso contrario
	 */
	public boolean isEjercicioterminado() {
		return ejercicioterminado;
	}

	/**
	 * Funcion que obtiene el numero de respuestas incorrectas
	 * @return respuestaincorrecta respuestas incorrectas
	 */
	public double getRespuestaIncorrecta() {
		return this.respuestaincorrecta;
	}

	@Override
	public String toString() {
		if(LocalDate.now().isAfter(this.ejercicio.getFechaFin()) && isEjercicioterminado()){
			
			return "Respuesta correcta: "  + this.respuestaProfesor;
		} 
		else
			return "La fecha no ha finalizado";
	}

	/**
	 * Funcion que obtiene la nota de la evaluacion
	 * @return nota nota
	 */
	public double getNota() {
		return nota;
	}

	/**
	 * Funcion que establece la nota de la evaluacion
	 * @param nota nota a establecer
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}
}