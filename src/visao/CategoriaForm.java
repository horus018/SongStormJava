/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import dao.CategoriaDAO;
import java.sql.SQLException;
import java.util.List;
import modelo.Categoria;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CategoriaForm extends javax.swing.JFrame {

    private CategoriaDAO categoriaDao = new CategoriaDAO();
    private List<Categoria> categorias;
    private Categoria categoriaSelecionada;

    public CategoriaForm() {
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
        btn_cadastrar = new javax.swing.JButton();
        btn_Excluir = new javax.swing.JButton();
        btn_alterar = new javax.swing.JButton();
        btn_Salvar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_Categoria = new javax.swing.JTable();
        txf_nome = new javax.swing.JTextField();
        txf_Pesquisa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_Pesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nome");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        btn_cadastrar.setText("Cadastrar");
        btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        btn_Excluir.setText("Excluir");
        btn_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        btn_alterar.setText("Alterar");
        btn_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 80, -1));

        btn_Salvar.setText("Salvar");
        btn_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        btn_Cancelar.setText("Cancelar");
        getContentPane().add(btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));

        tabela_Categoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nome"
            }
        ));
        jScrollPane1.setViewportView(tabela_Categoria);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 400, 110));

        txf_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_nomeActionPerformed(evt);
            }
        });
        getContentPane().add(txf_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 330, -1));
        getContentPane().add(txf_Pesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 260, -1));

        jLabel5.setText("Texto");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        btn_Pesquisar.setText("Pesquisar");
        btn_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Pesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
        atualizarBotao(false);
        habilitarFomulario(true);
        txf_nome.requestFocus();
        categoriaSelecionada = null;


    }//GEN-LAST:event_btn_cadastrarActionPerformed

    private void habilitarFomulario(boolean status) {
        txf_nome.setEnabled(status);
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
            categorias = categoriaDao.buscarPeloNome(txf_Pesquisa.getText());
            DefaultTableModel model = (DefaultTableModel) tabela_Categoria.getModel();
            model.setNumRows(0);

            for (int i = 0; i < categorias.size(); i++) {
                Categoria categoria = categorias.get(i);
                model.addRow(new Object[]{categoria.getNome()});

            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }


    private void btn_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExcluirActionPerformed

        int linha = tabela_Categoria.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma categoria", "Aten????o", JOptionPane.WARNING_MESSAGE);
            return;
        }

        categoriaSelecionada = categorias.get(linha);
        try {
            categoriaDao.remover(categoriaSelecionada.getId());
            JOptionPane.showMessageDialog(null, "Categoria excluida");
            atualizarTabela();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_ExcluirActionPerformed

    private void btn_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterarActionPerformed
        int linha = tabela_Categoria.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma categoria para altera????o", "Aten????o", JOptionPane.WARNING_MESSAGE);
            return;
        }
        atualizarBotao(false);
        habilitarFomulario(true);

        categoriaSelecionada = categorias.get(linha);
        txf_nome.setText(categoriaSelecionada.getNome());
    }//GEN-LAST:event_btn_alterarActionPerformed

    private void btn_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalvarActionPerformed
        atualizarBotao(true);
        habilitarFomulario(false);
        String nome = txf_nome.getText();
        int id = 0;

        if (nome.length() == 0) {
            JOptionPane.showMessageDialog(null, "Informe um nome ", "Aten????o", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (categoriaSelecionada == null) {
            Categoria categoria = new Categoria(nome);
            try {
                categoriaDao.adicionar(categoria);
                JOptionPane.showMessageDialog(null, "Categoria Cadastrada");
                txf_nome.setText("");
            } catch (SQLException ex) {
                ex.printStackTrace();
//                JOptionPane.showMessageDialog(null, "Erro na hora de inserir os dados", "Erro", JOptionPane.ERROR_MESSAGE);
System.out.print(ex);
            }
        } else {
            categoriaSelecionada.setNome(nome);
            try {
                categoriaDao.alterar(categoriaSelecionada);
                JOptionPane.showMessageDialog(null, "Categoria alterada");
                atualizarTabela();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        categoriaSelecionada = null;
    }//GEN-LAST:event_btn_SalvarActionPerformed

    private void btn_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PesquisarActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btn_PesquisarActionPerformed

    private void txf_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_nomeActionPerformed

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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_Categoria;
    private javax.swing.JTextField txf_Pesquisa;
    private javax.swing.JTextField txf_nome;
    // End of variables declaration//GEN-END:variables
}
