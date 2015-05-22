/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author wallejr
 */
public class ShowAesLista extends javax.swing.JFrame {
    
    private String caseStatus;
    private String caseCat;
    private int caseID;
    private String assigne;

    /**
     * Creates new form aesLista
     */
    public ShowAesLista() {
        setLocationRelativeTo(null);
        initComponents();
    }
    
    public void listSearchStatusCases() throws SQLException
    {
         Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String DBURL = "jdbc:mysql://localhost:3306/AES?" +
                "user=root&password=aik71111";
        
        
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBURL);
            
            String sql = "select CASES_ID as \"CaseID\", TITEL as \"Titel\", DESCRIPTION as \"Description\", STATUS as \"Status\", ASSIGNE as \"Assigned\", SKAPATDEN as \"Created\", ANDRATDEN as \"Changed\", SKAPATAV as \"Created by\" from AES.CASES where STATUS='"+getCaseStatus()+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tblCases.setModel(DbUtils.resultSetToTableModel(rs));
            

        }
        catch(SQLException e)
        {
            System.err.println("SQLException: " + e.getMessage());
        }
        catch(ClassNotFoundException clExc)
        {
            System.err.println("ClassNotFoundException: " + clExc.getMessage());
        }
        finally
        {
            if (conn != null)
                conn.close();
        }
        
    } //End method openSearchStatusCases
    
    public void listSearchAssigne() throws SQLException
    {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String DBURL = "jdbc:mysql://localhost:3306/AES?" +
                "user=root&password=aik71111";
        
        
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBURL);
            
            String sql = "select CASES_ID as \"CaseID\", TITEL as \"Titel\", DESCRIPTION as \"Description\", STATUS as \"Status\", ASSIGNE as \"Assigned\", SKAPATDEN as \"Created\", ANDRATDEN as \"Changed\", SKAPATAV as \"Created by\" from AES.CASES where ASSIGNE='"+getAssigne()+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tblCases.setModel(DbUtils.resultSetToTableModel(rs));
            

        }
        catch(SQLException e)
        {
            System.err.println("SQLException: " + e.getMessage());
        }
        catch(ClassNotFoundException clExc)
        {
            System.err.println("ClassNotFoundException: " + clExc.getMessage());
        }
        finally
        {
            if (conn != null)
                conn.close();
        }
    }
    
    public void listSearchCategoryCases() throws SQLException
    {
         Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String DBURL = "jdbc:mysql://localhost:3306/AES?" +
                "user=root&password=aik71111";
        
        
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBURL);
            
            String sql = "select CASES_ID as \"CaseID\", TITEL as \"Titel\", DESCRIPTION as \"Description\", STATUS as \"Status\", ASSIGNE as \"Assigned\", SKAPATDEN as \"Created\", ANDRATDEN as \"Changed\", SKAPATAV as \"Created by\" from AES.CASES where KATEGORI='"+getCaseCat()+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tblCases.setModel(DbUtils.resultSetToTableModel(rs));
            

        }
        catch(SQLException e)
        {
            System.err.println("SQLException: " + e.getMessage());
        }
        catch(ClassNotFoundException clExc)
        {
            System.err.println("ClassNotFoundException: " + clExc.getMessage());
        }
        finally
        {
            if (conn != null)
                conn.close();
        }
    }

    public void listSearchCaseID() throws SQLException
    {
         Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String DBURL = "jdbc:mysql://localhost:3306/AES?" +
                "user=root&password=aik71111";
        
        
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBURL);
            
            String sql = "select CASES_ID as \"CaseID\", TITEL as \"Titel\", DESCRIPTION as \"Description\", STATUS as \"Status\", ASSIGNE as \"Assigned\", SKAPATDEN as \"Created\", ANDRATDEN as \"Changed\", SKAPATAV as \"Created by\" from AES.CASES where CASES_ID='"+getCaseID()+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tblCases.setModel(DbUtils.resultSetToTableModel(rs));
            

        }
        catch(SQLException e)
        {
            System.err.println("SQLException: " + e.getMessage());
        }
        catch(ClassNotFoundException clExc)
        {
            System.err.println("ClassNotFoundException: " + clExc.getMessage());
        }
        finally
        {
            if (conn != null)
                conn.close();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        pnlCases = new javax.swing.JPanel();
        btnOpenCase = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCases = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SEARCH RESULTS");

        pnlCases.setBackground(new java.awt.Color(219, 219, 219));
        pnlCases.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnOpenCase.setText("Open Case");
        btnOpenCase.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnOpenCaseActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCancelActionPerformed(evt);
            }
        });

        tblCases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblCases);

        javax.swing.GroupLayout pnlCasesLayout = new javax.swing.GroupLayout(pnlCases);
        pnlCases.setLayout(pnlCasesLayout);
        pnlCasesLayout.setHorizontalGroup(
            pnlCasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCasesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOpenCase, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1077, Short.MAX_VALUE)
        );
        pnlCasesLayout.setVerticalGroup(
            pnlCasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCasesLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnOpenCase))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCases, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(pnlCases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpenCaseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnOpenCaseActionPerformed
    {//GEN-HEADEREND:event_btnOpenCaseActionPerformed
        openSelectedCase();// TODO add your handling code here:
    }//GEN-LAST:event_btnOpenCaseActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancelActionPerformed
    {//GEN-HEADEREND:event_btnCancelActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    public void openAllCases() throws SQLException
    {
         Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String DBURL = "jdbc:mysql://localhost:3306/AES?" +
                "user=root&password=aik71111";
        
        
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBURL);
            
            String sql = "select CASES_ID as \"CaseID\", TITEL as \"Titel\", DESCRIPTION as \"Description\", STATUS as \"Status\", ASSIGNE as \"Assigned\", SKAPATDEN as \"Created\", ANDRATDEN as \"Changed\", SKAPATAV as \"Created by\" from AES.CASES";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tblCases.setModel(DbUtils.resultSetToTableModel(rs));
            

        }
        catch(SQLException e)
        {
            System.err.println("SQLException: " + e.getMessage());
        }
        catch(ClassNotFoundException clExc)
        {
            System.err.println("ClassNotFoundException: " + clExc.getMessage());
        }
        finally
        {
            if (conn != null)
                conn.close();
        }
    }
    
    private void openSelectedCase()
    {
        NewJDialog dia = new NewJDialog(this, rootPaneCheckingEnabled);
        
        
        try
        {
            if (tblCases.getSelectedRow() >= 0)
            {
               String objId = tblCases.getValueAt(tblCases.getSelectedRow(), 0).toString();
               int id = Integer.parseInt(objId); 

               dia.setCaseID(id);
               dia.openCase();
               dia.updateTasksList(id);

               dia.setVisible(true);


               if(getCaseCat() != null)
               {
                  listSearchCategoryCases();
               }
               else if (getCaseStatus() != null)
               {
                   listSearchStatusCases(); 
               }
               else if(getCaseID() == 0)
               {
                   listSearchCaseID();
               }
               else
               {
                   listSearchAssigne();
               }//End of inner if else..
               
            } //End of outer if
            else{
                throw new NullPointerException("Please choose a case in the list to open");
            }
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShowAesLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowAesLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowAesLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowAesLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowAesLista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOpenCase;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCases;
    private javax.swing.JTable tblCases;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the caseStatus
     */
    public String getCaseStatus()
    {
        return caseStatus;
    }

    /**
     * @param caseStatus the caseStatus to set
     */
    public void setCaseStatus(String caseStatus)
    {
        this.caseStatus = caseStatus;
    }

    /**
     * @return the caseCat
     */
    public String getCaseCat()
    {
        return caseCat;
    }

    /**
     * @param caseCat the caseCat to set
     */
    public void setCaseCat(String caseCat)
    {
        this.caseCat = caseCat;
    }

    /**
     * @return the caseID
     */
    public int getCaseID()
    {
        return caseID;
    }

    /**
     * @param caseID the caseID to set
     */
    public void setCaseID(int caseID)
    {
        this.caseID = caseID;
    }

    /**
     * @return the assigne
     */
    public String getAssigne()
    {
        return assigne;
    }

    /**
     * @param assigne the assigne to set
     */
    public void setAssigne(String assigne)
    {
        this.assigne = assigne;
    }
}
