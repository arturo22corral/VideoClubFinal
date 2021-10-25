
package com.ceep.videoclub.negocio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class CatalogoPeliculas implements ICatalogoPeliculas {
    
    @Override
      //agregarpelicula
    public void agregarPelicula(String nombrePelicula, String nombreArchivo){
         //1. Declaracion del objeto de tipo FILE
        File archivo = new File(nombrePelicula);
        //2. Declarar variable
        try {
            //Invocamos al FileWriter para anexar la informacion y no sobreescribirla
            PrintWriter salida = new PrintWriter(new FileWriter(nombrePelicula, true));
            salida.println(nombreArchivo);
            salida.close();
        } catch (FileNotFoundException e) {
            //Fichero no existe 
            e.printStackTrace(); //Imprime el stack de excepciones
        } catch (IOException e) {
            //Excepcion de entrada-salida
            e.printStackTrace(); //Imprime el stack de excepciones
        }
    }
    
    @Override
    //listar peliculas
    public void listarPelicula(String nombreArchivo){
        
    }
    
    @Override
     //buscar peliculas
    public void buscarPelicula(String nombreArchivo, String buscar){
        
    }
    
    @Override
     //iniciar archivo
    public void iniciarArchivo(String nombreArchivo){
        
    }
}
