
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.Conexao;
import modelo.Cliente;

public class ClienteDAO {

    public void adicionar(Cliente cliente) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "insert into clientes (nome, sexo, cpf, user_id) value (?,?,?,?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getSexo());
        ps.setString(3, cliente.getCpf());
        ps.setString(4, cliente.getUser_id());
        ps.execute();
        ps.close();
        conexao.close();
    }

    public void remover(int id) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "delete from clientes where id=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        conexao.close();

    }

    public void alterar(Cliente cliente) throws SQLException {

        Connection conexao = new Conexao().getConexao();
        String sql = "UPDATE clientes set nome=?,sexo=?,cpf=?, user_id = ?"
                + " where id=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getSexo());
        ps.setString(3, cliente.getCpf());
        ps.setString(4, cliente.getUser_id());
        ps.setInt(5, cliente.getId());
        ps.executeUpdate();
        ps.close();
        conexao.close();

    }

    public List<Cliente> buscarPeloNome(String nome) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "select * from clientes where nome like ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, "%" + nome + "%");
        ResultSet rs = ps.executeQuery();
        List<Cliente> clientes = new ArrayList<>();
        while (rs.next()) {
         Cliente cliente = new Cliente(rs.getString("nome"),
         rs.getString("sexo"), rs.getString("cpf"),rs.getString("user_id") ,rs.getInt("id"));
            clientes.add(cliente);
        }
        rs.close();
        ps.close();
        conexao.close();

        return clientes;
    }

}
