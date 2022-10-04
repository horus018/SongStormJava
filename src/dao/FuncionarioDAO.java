
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.Conexao;
import modelo.Funcionario;

public class FuncionarioDAO {

    public void adicionar(Funcionario funcionario) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "insert into funcionarios (nome, cpf, sexo, cargo, salario) value (?,?,?,?,?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, funcionario.getNome());
        ps.setString(2, funcionario.getCpf());
        ps.setString(3, funcionario.getSexo());
        ps.setString(4, funcionario.getCargo());
        ps.setString(5, funcionario.getSalario());
        ps.execute();
        ps.close();
        conexao.close();
    }

    public void remover(int id) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "delete from funcionarios where id=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        conexao.close();

    }

    public void alterar(Funcionario funcionario) throws SQLException {

        Connection conexao = new Conexao().getConexao();
        String sql = "UPDATE funcionarios set nome=?,cpf=?,sexo=?, cargo = ?, salario = ?"
                + " where id=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, funcionario.getNome());
        ps.setString(2, funcionario.getCpf());
        ps.setString(3, funcionario.getSexo());
        ps.setString(4, funcionario.getCargo());
        ps.setString(5, funcionario.getSalario());
        ps.setInt(6, funcionario.getId());
        ps.executeUpdate();
        ps.close();
        conexao.close();

    }

    public List<Funcionario> buscarPeloNome(String nome) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "select * from funcionarios where nome like ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, "%" + nome + "%");
        ResultSet rs = ps.executeQuery();
        List<Funcionario> funcionarios = new ArrayList<>();
        while (rs.next()) {
         Funcionario funcionario = new Funcionario(rs.getString("nome"),
         rs.getString("cpf"),rs.getString("sexo"),rs.getInt("id"),rs.getString("cargo") ,rs.getString("salario"));
            funcionarios.add(funcionario);
        }
        rs.close();
        ps.close();
        conexao.close();

        return funcionarios;
    }

}
