package aguerre.cristian.pmm;

/**
 * Created by Cristian Aguerre Clavel on 17/02/14.
 */
public class Personal {

    private int cod_centro;
    private int dni;
    private String apellido;
    private String funcion;
    private double salario;

    public Personal(int cod_centro,int dni,String apellido,String funcion, double salario){
        this.setCod_centro(cod_centro);
        this.setDni(dni);
        this.setApellido(apellido);
        this.setFuncion(funcion);
        this.setSalario(salario);
    }

    public int getCod_centro() {
        return cod_centro;
    }

    public void setCod_centro(int cod_centro) {
        this.cod_centro = cod_centro;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
