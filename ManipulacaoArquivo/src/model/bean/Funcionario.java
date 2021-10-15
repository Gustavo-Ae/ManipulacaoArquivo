
package model.bean;


public class Funcionario extends Pessoa{
    
    private String salario;
    private Integer horasExtras;

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public Integer getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(Integer horasExtras) {
        this.horasExtras = horasExtras;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "salario=" + salario + ", horasExtras=" + horasExtras + '}';
    }
    
}
