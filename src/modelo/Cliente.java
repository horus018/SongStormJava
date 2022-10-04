package modelo;

import java.util.Objects;

public class Cliente {
//SE DER ERRO COM PROBLEMA DE ID FALTANDO VEJ AQ EMBAIXO
    private String nome;
    private String cpf;
    private String sexo;
    private String user_id;

    public Cliente(String nome, String cpf, String sexo, String user_id, int id) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.user_id = user_id;
        this.id = id;
    }
    
    public Cliente(String nome, String cpf, String sexo, String user_id) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo + ", user_id=" + user_id + ", id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.cpf);
        hash = 79 * hash + Objects.hashCode(this.sexo);
        hash = 79 * hash + Objects.hashCode(this.user_id);
        hash = 79 * hash + this.id;
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.user_id, other.user_id)) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return Objects.equals(this.sexo, other.sexo);
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private int id;

    public Cliente() {
    }

}

