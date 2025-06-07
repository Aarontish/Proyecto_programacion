package modelos;

public class TiposHabitacionn {
    private int idTipoHabitacion;
    private String nombreTipo;
    private String descripcion;
    private int capacidadMaxima;
    private double precioPorNoche; 
    
    public TiposHabitacionn() {
    	
    }

    public TiposHabitacionn(int idTipoHabitacion, String nombreTipo, String descripcion, int capacidadMaxima, double precioPorNoche) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.nombreTipo = nombreTipo;
        this.descripcion = descripcion;
        this.capacidadMaxima = capacidadMaxima;
        this.precioPorNoche = precioPorNoche;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public String toString() {
        return "TiposHabitacionn{" +
               "idTipoHabitacion=" + idTipoHabitacion +
               ", nombreTipo='" + nombreTipo + '\'' +
               ", descripcion='" + descripcion + '\'' +
               ", capacidadMaxima=" + capacidadMaxima +
               ", precioPorNoche=" + precioPorNoche +
               '}';
    }
    
    
}
