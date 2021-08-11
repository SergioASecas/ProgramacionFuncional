package DTO;

public class inmueble {
    
    private int ano;
    private int metros;
    private int habitaciones;
    private boolean garaje;
    private String zona;
    private Double precio;

    public inmueble(){
        
    }

    public inmueble(int ano, int metros, int habitaciones, boolean garaje, String zona){
        this.ano            = ano;
        this.metros         = metros;
        this.habitaciones   = habitaciones;
        this.garaje         = garaje;
        this.zona           = zona;
    }

    public inmueble(int ano, int metros, int habitaciones, boolean garaje, String zona, double precio){
        this.ano            = ano;
        this.metros         = metros;
        this.habitaciones   = habitaciones;
        this.garaje         = garaje;
        this.zona           = zona;
        this.precio         = precio;
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public int getMetros() {
        return metros;
    }
    public void setMetros(int metros) {
        this.metros = metros;
    }
    public int getHabitaciones() {
        return habitaciones;
    }
    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }
    public boolean isGaraje() {
        return garaje;
    }
    public void setGaraje(boolean garaje) {
        this.garaje = garaje;
    }
    public String getZona() {
        return zona;
    }
    public void setZona(String zona) {
        this.zona = zona;
    } 

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "inmueble [ano=" + ano + ", garaje=" + garaje + ", habitaciones=" + habitaciones + ", metros=" + metros
                + ", precio=" + precio + ", zona=" + zona + "]";
    }

    
    
}
