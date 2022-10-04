
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.Conexao;
import modelo.Usuario;
import modelo.Usuario;


public class UsuarioDAO {

    public Usuario login (String login, String senha)throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql = "select * from usuarios where login =? and senha = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, login);
        ps.setString(2, senha);
        
        ResultSet rs = ps.executeQuery();
        
        Usuario usuario = null;
        while(rs.next()){
            usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setNivel(rs.getString("nivel"));
        }
            rs.close();
            ps.close();
            conexao.close();
        
            return usuario;
    
}
    
//    private String nome;
//    private String login;
//    private String senha;
//    private String nivel;
    
     public void adicionar(Usuario usuario) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "insert into usuarios (nome, login, senha, nivel) value (?,?,?,?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getLogin());
        ps.setString(3, usuario.getSenha());
        ps.setString(4, usuario.getNivel());
        ps.execute();
        ps.close();
        conexao.close();
    }

    public void remover(int id) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "delete from usuarios where id=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        conexao.close();

    }

    public void alterar(Usuario usuario) throws SQLException {

        Connection conexao = new Conexao().getConexao();
        String sql = "UPDATE usuarios set nome=?,preco=?,categoria_id=?"
                + " where id=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getLogin());
        ps.setString(3, usuario.getSenha());
        ps.setString(4, usuario.getNivel());
        ps.setInt(5, usuario.getId());
        ps.executeUpdate();
        ps.close();
        conexao.close();

    }

    public List<Usuario> buscarPeloNome(String nome) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "select * from usuarios where nome like ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, "%" + nome + "%");
        ResultSet rs = ps.executeQuery();
        List<Usuario> usuarios = new ArrayList<>();
        while (rs.next()) {
         Usuario usuario = new Usuario(rs.getString("nome"), rs.getString("login"),rs.getString("senha"),rs.getString("nivel"), rs.getInt("id"));
            usuarios.add(usuario);
        }
        rs.close();
        ps.close();
        conexao.close();

        return usuarios;
    }

}

