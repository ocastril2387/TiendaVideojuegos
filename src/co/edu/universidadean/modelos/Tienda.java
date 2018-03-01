package co.edu.universidadean.modelos;

import java.util.ArrayList;

/**
 * @author Oscar Castrillón
 */
public class Tienda {
    private String nombre;
    private ArrayList<Juego> juegos;

    public Tienda() {
        juegos = new ArrayList();
    }

    public Tienda(String nombre) {
        this();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarJuego(Juego juego){
        juegos.add(juego);
    }
    
    public Juego obtenerJuegoMasVendido(){
        if(juegos.size() > 0){
            Juego juego = juegos.get(0);
            
            for (int i = 1; i < juegos.size(); i++) {
                if(juego.getCantidadVendida() > juegos.get(i).getCantidadVendida()){
                    juego = juegos.get(i);
                }
            }
            
            return juego;
        } else {
            return null;
        }        
    }
    
    public int calcularCantidadJuegosVendidos(){
        int cantidadTotalVendidos = 0;
        
        if(juegos.size() > 0){
            for(Juego juegoActual : juegos){
                cantidadTotalVendidos += juegoActual.getCantidadVendida();
            }
            
            return cantidadTotalVendidos;
        } else {
            return cantidadTotalVendidos;
        }
    }
    
    public double calcularMontoJuegosVendidos(){
        double montoTotalJuegosVendidos = 0.0;
        
        if(juegos.size() > 0){
            for(Juego juegoActual : juegos){
                montoTotalJuegosVendidos += juegoActual.getPrecio() * juegoActual.getCantidadVendida();
            }
            
            return montoTotalJuegosVendidos;
        } else {
            return montoTotalJuegosVendidos;
        }
    }
    
    public boolean vender(int indiceJuego){
        if(juegos.size() > 0){
            if(indiceJuego < juegos.size()){
                Juego juego = juegos.get(indiceJuego);
                
                if(juego.getCantidadVendida() < juego.getCantidadDisponible()){
                    juego.vender();
                    
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }        
    }
}
