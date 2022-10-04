
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.Conexao;
import modelo.Categoria;
import modelo.Produto;

public class ProdutoDAO {

    public void adicionar(Produto produto) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "insert into produtos (nome, preco, categoria_id) value (?,?,?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, produto.getNome());
        ps.setString(2, produto.getPreco());
        ps.setString(3, produto.getCategoria_id());
        ps.execute();
        ps.close();
        conexao.close();
    }

    public void remover(int id) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "delete from produtos where id=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        conexao.close();

    }

    public void alterar(Produto produto) throws SQLException {

        Connection conexao = new Conexao().getConexao();
        String sql = "UPDATE produtos set nome=?,preco=?,categoria_id=?"
                + " where id=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, produto.getNome());
        ps.setString(2, produto.getPreco());
        ps.setString(3, produto.getCategoria_id());
        ps.setInt(4, produto.getId());
        ps.executeUpdate();
        ps.close();
        conexao.close();

    }

    public List<Produto> buscarPeloNome(String nome) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "select * from produtos where nome like ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, "%" + nome + "%");
        ResultSet rs = ps.executeQuery();
        List<Produto> produtos = new ArrayList<>();
        while (rs.next()) {
         Produto produto = new Produto(rs.getInt("id"), rs.getString("nome"),
         rs.getString("preco"), rs.getString("categoria_id"));
            produtos.add(produto);
        }
        rs.close();
        ps.close();
        conexao.close();

        return produtos;
    }

}
