
package com.ceep.videoclub.datos;

import java.util.*;
import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.excepciones.*;

public interface IAccesoDatos {
    
    // Comprueba si el fichero existe 
    boolean existe(String nombreArchivo);
    
    // Lista todas las películas contenidas en el archivo nombreArchivo
    List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx;
    
    // Escribe una nueva película en el archivo nombreArchivo
    // con el parámetro anexar podemos indicar si queremos agregar la película o
    // sobreescribir
    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) 
            throws EscrituraDatosEx;
    
    // Busca la expresión de buscar en el archivo y nos muestra un mensaje en
    // caso de que lo encuentro o no
    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    
    // Crea el archivo
    void crear(String nombreArchivo) throws AccesoDatosEx;
    
    // Borra el archivo
    void borrar(String nombreArchivo);
}
