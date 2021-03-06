package com.ceep.videoclub.datos;

import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.excepciones.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoDatosImpl implements IAccesoDatos{

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        
        var archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList<>();
        
        try {
            // entrada es el descriptor de lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            // nos devuelve una línea de nuestro archivo
            var lectura = entrada.readLine();
            while(lectura != null){ // hasta null
                // Creamos un objeto de Película con cada línea del archivo
                // Añado cada película a mi listado de películas
                peliculas.add(new Pelicula(lectura));
                // Avanzamos en la lectura
                lectura = entrada.readLine();
            }
            entrada.close();
        
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando las películas");
        } catch (IOException e){
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando las películas");
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.getNombre());
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepción al escribir en el archivo");
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
        int cont = 1;
        String mensaje = "";
        try {
            // entrada es el descriptor de lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            // nos devuelve una línea de nuestro archivo
            var lectura = entrada.readLine();
            while(lectura != null){ // 
                if (lectura.equalsIgnoreCase(buscar)){
                    mensaje = "La película " + buscar + " se encuentra en la "
                            + "línea " + cont + " del catálogo de películas";
                    break;
                }
                lectura = entrada.readLine();
                cont++;
            }
            if (lectura == null) 
                mensaje = "La película " + buscar + " no está "
                    + "en el catálogo de películas.";
            
            entrada.close();
        
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando las películas");
        } catch (IOException e){
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando las películas");
        }
        return mensaje;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        var archivo = new File(nombreArchivo);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al crear el archivo");
        }
        
    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()){
            archivo.delete();
        }
        System.out.println("Se ha borrado el archivo");
    }


    
}
