/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import dao.ProdutoDAO;
import java.io.FileWriter;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import modelo.Produto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.Usuario;

public class ProdutoForm extends javax.swing.JFrame {
int r = 0;
private Usuario usuario;

    /** Creates new form FormularioPrincipal */

    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private List<Produto> produtos;
    private Produto produtoSelecionada;

    public ProdutoForm() {
        initComponents();
        atualizarTabela();

        atualizarBotao(true);
        habilitarFomulario(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txf_preco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txf_categoria_id = new javax.swing.JTextField();
        btn_cadastrar = new javax.swing.JButton();
        btn_Excluir = new javax.swing.JButton();
        btn_alterar = new javax.swing.JButton();
        btn_Salvar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_Produto = new javax.swing.JTable();
        txf_nome = new javax.swing.JTextField();
        txf_Pesquisa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_Pesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nome");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel2.setText("Pre??o");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        txf_preco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_precoActionPerformed(evt);
            }
        });
        getContentPane().add(txf_preco, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 360, -1));

        jLabel3.setText("Categoria");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
        getContentPane().add(txf_categoria_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 350, -1));

        btn_cadastrar.setText("Cadastrar");
        btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        btn_Excluir.setText("Excluir");
        btn_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        btn_alterar.setText("Alterar");
        btn_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 90, -1));

        btn_Salvar.setText("Salvar");
        btn_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, -1, -1));

        btn_Cancelar.setText("Cancelar");
        getContentPane().add(btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, -1, -1));

        tabela_Produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Pre??o", "Categoria"
            }
        ));
        jScrollPane1.setViewportView(tabela_Produto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 430, 150));

        txf_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_nomeActionPerformed(evt);
            }
        });
        getContentPane().add(txf_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 330, -1));
        getContentPane().add(txf_Pesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 260, -1));

        jLabel5.setText("Texto");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        btn_Pesquisar.setText("Pesquisar");
        btn_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Pesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
        atualizarBotao(false);
        habilitarFomulario(true);
        txf_nome.requestFocus();
        produtoSelecionada = null;


    }//GEN-LAST:event_btn_cadastrarActionPerformed

    private void habilitarFomulario(boolean status) {
        txf_nome.setEnabled(status);
        txf_preco.setEnabled(status);
        txf_categoria_id.setEnabled(status);

    }

    private void atualizarBotao(boolean status) {
        btn_alterar.setEnabled(status);
        btn_Excluir.setEnabled(status);
        btn_Pesquisar.setEnabled(status);
        btn_cadastrar.setEnabled(status);
        btn_Cancelar.setEnabled(!status);
        btn_Salvar.setEnabled(!status);
    }

    private void atualizarTabela() {
        try {
            produtos = produtoDAO.buscarPeloNome(txf_Pesquisa.getText());
            DefaultTableModel model = (DefaultTableModel)tabela_Produto.getModel();
            model.setNumRows(0);

            for (int i = 0; i < produtos.size(); i++) {
                Produto produto = produtos.get(i);
                model.addRow(new Object[]{produto.getNome(), produto.getPreco(), produto.getCategoria_id()});

            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }


    private void btn_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExcluirActionPerformed

        int linha = tabela_Produto.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um produto", "Aten????o", JOptionPane.WARNING_MESSAGE);
            return;
        }

        produtoSelecionada = produtos.get(linha);
        try {
            produtoDAO.remover(produtoSelecionada.getId());
            JOptionPane.showMessageDialog(null, "Produto excluido");
            atualizarTabela();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_ExcluirActionPerformed

    private void btn_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterarActionPerformed
        int linha = tabela_Produto.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um produto para altera????o", "Aten????o", JOptionPane.WARNING_MESSAGE);
            return;
        }
        atualizarBotao(false);
        habilitarFomulario(true);

        produtoSelecionada = produtos.get(linha);
        txf_nome.setText(produtoSelecionada.getNome());
        txf_categoria_id.setText(produtoSelecionada.getCategoria_id());
        txf_preco.setText(produtoSelecionada.getPreco());


    }//GEN-LAST:event_btn_alterarActionPerformed

    private void btn_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalvarActionPerformed
        atualizarBotao(true);
        habilitarFomulario(false);
        String nome = txf_nome.getText();
        String preco = txf_preco.getText();
        String categoria_id = txf_categoria_id.getText();
        int codigo = 0;

        if (nome.length() == 0) {
            JOptionPane.showMessageDialog(null, "Informe um nome ", "Aten????o", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (preco.length() == 0) {
            JOptionPane.showMessageDialog(null, "Informe um preco", "Aten????o", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (categoria_id.length() == 0) {
            JOptionPane.showMessageDialog(null, "Informe uma  categoria", "Aten????o", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (produtoSelecionada == null) {
            Produto produto = new Produto(nome, preco, categoria_id);

            try {
                produtoDAO.adicionar(produto);
                JOptionPane.showMessageDialog(null, "Produto Cadastrado");
                txf_nome.setText("");
                txf_preco.setText("");
                txf_categoria_id.setText("");

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro na hora de inserir os dados", "Erro", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            produtoSelecionada.setNome(nome);
            produtoSelecionada.setPreco(preco);
            produtoSelecionada.setCategoria_id(categoria_id);

            try {
                produtoDAO.alterar(produtoSelecionada);
                JOptionPane.showMessageDialog(null, "Produto alterado");
                atualizarTabela();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        produtoSelecionada = null;
    }//GEN-LAST:event_btn_SalvarActionPerformed

    private void btn_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PesquisarActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btn_PesquisarActionPerformed

    private void txf_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_nomeActionPerformed

    private void txf_precoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_precoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_precoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Excluir;
    private javax.swing.JButton btn_Pesquisar;
    private javax.swing.JButton btn_Salvar;
    private javax.swing.JButton btn_alterar;
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_Produto;
    private javax.swing.JTextField txf_Pesquisa;
    private javax.swing.JTextField txf_categoria_id;
    private javax.swing.JTextField txf_nome;
    private javax.swing.JTextField txf_preco;
    // End of variables declaration//GEN-END:variables
}
