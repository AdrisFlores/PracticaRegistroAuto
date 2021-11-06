/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registroautomorflores;

import java.util.Calendar;

/**
 *
 * @author adria
 */
public class Vehiculo {
    
    private String marca;
    private String modelo;
    private String patente;
    private int año_pat;
    private String color;
    private String titular;
    private float precio;
    private boolean nacional;
    
    public Vehiculo(){
        
        marca = "";
        modelo = "";
        patente = "";
        año_pat = 0;
        color = "";
        titular = "";
        precio = 0.0f;
        nacional = false;
        
    }

    public boolean isNacional() {
        return nacional;
    }

    public void setNacional(boolean nacional) {
        this.nacional = nacional;
    }
    
    

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getAño_pat() {
        return año_pat;
    }

    public void setAño_pat(int año_pat) {
        this.año_pat = año_pat;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    public int calcularAntiguedad(){
    
        Calendar calendario;
        calendario = Calendar.getInstance();
        int antiguedad;
        antiguedad = calendario.get(Calendar.YEAR)-año_pat;
        return antiguedad;
       
    }
    
    public String indicarVerficacion (){
        
        String respuesta;
        if (calcularAntiguedad()<=14){
            respuesta = "Verificacion Policial; SI";
        }
        else {
            respuesta = "Verificacion Pocial: NO";
            
        }
        return respuesta;
    }   
        
    public float calcularCostoTransferencia(){
        
        float transferencia;
        if (calcularAntiguedad()<10){
            transferencia = precio * 0.06f + 5000;
        
        }
        else{
            if (calcularAntiguedad()<25){
                transferencia = precio * 0.04f + 2400;
                
            }
            else{
            transferencia = precio * 0.02f;
            if(transferencia<2000){
                transferencia = 2000;
            
            }
            }
        }
        
        //aplicamos un impuesto del 20% adicional para vehiculos importados
        
        if (nacional==false){
            transferencia = transferencia*1.2f;
        
        }
        return transferencia;
    }
        
       
    
}//Fin de clase
