
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.Conexao;
import modelo.Categoria;

public class CategoriaDAO {

    public void adicionar(Categoria categoria) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "insert into categorias (nome) value (?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, categoria.getNome());
        ps.execute();
        ps.close();
        conexao.close();
    }

    public void remover(int id) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "delete from categoria where id=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        conexao.close();

    }

    public void alterar(Categoria categoria) throws SQLException {

        Connection conexao = new Conexao().getConexao();
        String sql = "UPDATE categoria set nome=?"
                + " where id=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, categoria.getId());
        ps.setString(2, categoria.getNome());
        ps.executeUpdate();
        ps.close();
        conexao.close();

    }

    public List<Categoria> buscarPeloNome(String nome) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "select * from categorias where nome like ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, "%" + nome + "%");
        ResultSet rs = ps.executeQuery();
        List<Categoria> categorias = new ArrayList<>();
        while (rs.next()) {
         Categoria categoria = new Categoria( rs.getString("nome"),rs.getInt("id"));
            categorias.add(categoria);
        }
        rs.close();
        ps.close();
        conexao.close();

        return categorias;
    }

}

