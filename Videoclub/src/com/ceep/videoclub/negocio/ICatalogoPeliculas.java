package com.ceep.videoclub.negocio;

public interface ICatalogoPeliculas {
    
    // Agrega una Película al catálogo
    void agregarPelicula(String nombrePelicula, String nombreCatalogo);
    
    // Mostrar todas las películas del catálogo
    void listarPelicula(String nombreCatalogo);
    
    // Busca la película "Buscar" en nuestro catálogo
    void buscarPelicula(String nombreCatalogo, String buscar);
    
    // Nos inicia nuestro catálogo
    void iniciarCatalogo(String nombreCatalogo);
}
