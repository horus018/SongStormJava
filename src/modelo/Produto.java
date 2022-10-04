
package modelo;

import java.util.Objects;

public class Produto {
    private String nome;
    private String preco;
    private String categoria_id;
    private int id;
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.preco);
        hash = 29 * hash + Objects.hashCode(this.categoria_id);
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
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.categoria_id, other.categoria_id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.preco, other.preco);
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", preco=" + preco + ", categoria_id=" + categoria_id + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(String categoria_id) {
        this.categoria_id = categoria_id;
    }

    public Produto(int id, String nome, String preco, String categoria_id) {
        this.nome = nome;
        this.preco = preco;
        this.categoria_id = categoria_id;
        this.id = id;
    }
    
    public Produto(String nome, String preco, String categoria_id) {
        this.nome = nome;
        this.preco = preco;
        this.categoria_id = categoria_id;
    }

}
