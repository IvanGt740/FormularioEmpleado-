package modelo;

import javax.swing.JOptionPane;

public class Empleado extends Persona {
    private String nit;
    private double sueldo;
    private double bono;
    private double total; // Cambiado a private

    public Empleado() {}

    public Empleado(String nit, double sueldo, double bono, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.nit = nit;
        this.sueldo = sueldo;
        this.bono = bono;
        calcularTotal(); // Calcula el total en el constructor
    }

    // Getters y Setters
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
        calcularTotal(); // Recalcula el total cuando se cambia el sueldo
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
        calcularTotal(); // Recalcula el total cuando se cambia el bono
    }

    public double getTotal() {
        return total; // Devuelve el total correcto
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // Método para calcular el total
    public void calcularTotal() {
        this.total = this.sueldo + this.bono;
    }

    @Override
    protected String[] crear() {
        try {
            String[] datos = new String[9];
            datos[0] = getNit();
            datos[1] = getNombres();
            datos[2] = getApellidos();
            datos[3] = getDireccion();
            datos[4] = getTelefono();
            datos[5] = getFecha_nacimiento();
            datos[6] = String.valueOf(getSueldo());
            datos[7] = String.valueOf(getBono());
            datos[8] = String.valueOf(getTotal()); // Asegúrate de que esto sea el total correcto
            return datos;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Query", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}

