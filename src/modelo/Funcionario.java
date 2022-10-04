
package modelo;
import java.util.Objects;

public class Funcionario {
    private String nome;
    private String cpf;
    private String sexo;
    private String cargo;
    private String salario;
    private int id;

    public Funcionario(String nome, String cpf, String sexo, int id, String cargo, String salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.cargo = cargo;
        this.salario = salario;
        this.id = id;
    }
    
     public Funcionario(String nome, String cpf, String sexo, String cargo, String salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.cpf);
        hash = 97 * hash + Objects.hashCode(this.sexo);
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.cargo);
        hash = 97 * hash + Objects.hashCode(this.salario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        return Objects.equals(this.salario, other.salario);
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo + ", id=" + id + ", cargo=" + cargo + ", salario=" + salario + '}';
    }
    
}
