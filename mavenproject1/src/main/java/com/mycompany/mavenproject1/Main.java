/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author nguth
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form NahnVien
     */
    
    public final String __FILE__ = "data.txt";
    
    private DefaultTableModel _model;
    private QLNV<NhanVien> _qlnv;
    private Thread _time;
    public Main() {
        initComponents();
        this._qlnv = new QLNV();
        this._model = (DefaultTableModel)tbl_nhan_vien.getModel();
        tbl_nhan_vien.setAutoCreateRowSorter(true);
        _time = new Thread() {
            @Override
            public void  run() {
                while (true) {
                    tbl_time
                    .setText("time: " + new SimpleDateFormat("hh:mm:ss")
                            .format(new Date()));                    
                }
            }
        };
        _time.start();
    }
    
    public void ShowMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    public boolean NameaMatches() {
        if ((!Pattern.matches("^[a-zA-Z][a-zA-Z ]+", txt_name.getText())
            || txt_name.getText().equals(""))
            || txt_name.getText().length() < 6) {
            txt_name.setBackground(Color.YELLOW);
            return false;
        }
        return true;
    }
    
    public boolean idMatches() {
        if  (txt_id.getText().length() == 7) {
            return true;
        } 
        txt_id.setBackground(Color.YELLOW);
        return false;
    }
    
    public boolean DateMatches() {
        try {
            new SimpleDateFormat("dd/mm/yyyy").parse(txt_date.getText());
        } catch(Exception e) {
            txt_date.setBackground(Color.YELLOW);
            return false;
        }
        return true;
    }
    
    public boolean SalaryMatches() {    
        if(!Pattern.matches("^[1-9][0-9.]*",txt_salary.getText())) {
            txt_salary.setBackground(Color.YELLOW);
            return false;
        }
        return true;
    }               
    
    public boolean loadFromFile() throws IOException {
        FileUtils fu = new FileUtils();
        _qlnv = fu.open(__FILE__, FileUtils.__IN__)
                .read();
        fu.close();
        loadToTable();
        return true;
    }
    
    public boolean saveToFile() throws IOException {
        try {
            new FileUtils()
                    .open(this.__FILE__, FileUtils.__OUT__)
                    .write(_qlnv)
                    .close();
        } catch(Exception e) {
            return false;
        }
        _model.setRowCount(0);
        _qlnv.clear();
        return true;
    }
    
    public NhanVien loadfromText() throws ParseException {
        try {
            return new NhanVien(
                    txt_id.getText(),
                    txt_name.getText().trim(),
                    new SimpleDateFormat("dd/mm/yyyy").parse(txt_date.getText()),
                    Double.parseDouble(txt_salary.getText()),
                    rb_sex.isSelected(),
                    cbb_position.getSelectedItem().toString());           
        } catch(NumberFormatException nfe) {
            ShowMessage("ERROR");
        } catch(ParseException pe) {
            ShowMessage("ERROR");
        }
        return new NhanVien();
    }
    
    public void defaultBackgroundColor() {
        txt_id.setBackground(Color.WHITE);
        txt_name.setBackground(Color.WHITE);
        txt_date.setBackground(Color.WHITE);
        txt_salary.setBackground(Color.WHITE);
    }
    
    public boolean infoDetect() {
        if (idMatches() &&
                NameaMatches() &&
                DateMatches() &&
                SalaryMatches()) {
            defaultBackgroundColor();
            return true;
        }
        return false;
    }
    
    public boolean loadToTable() {
        _model.setRowCount(0);
        for (NhanVien i: _qlnv) {
            this._model.addRow(new String[] {
                i.getId(),
                i.getName(),
                new SimpleDateFormat("dd/mm/yyyy").format(i.getDate()),
                String.format("%.2f", i.getSalary()),
                (i.isSex()) ? "nam" : "nu",
                i.getPosition()
            });
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_date = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        rb_sex = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_nhan_vien = new javax.swing.JTable();
        txt_salary = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_clear = new javax.swing.JButton();
        cbb_sort = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cbb_sort_type = new javax.swing.JComboBox<>();
        tbl_time = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        cbb_position = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_add.setText("add\\");
            btn_add.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btn_addActionPerformed(evt);
                }
            });

            btn_update.setText("edit");
            btn_update.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btn_updateActionPerformed(evt);
                }
            });

            btn_delete.setText("remove");
            btn_delete.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btn_deleteActionPerformed(evt);
                }
            });

            jLabel1.setText("ma nhan vien");

            jLabel2.setText("ten sinh vien");

            jLabel3.setText("ngay sinh");

            txt_date.setText("25/1/2003");

            txt_name.setText("thinh nguyen");

            txt_id.setText("poly001");

            jTextField4.setText("jTextField1");

            buttonGroup1.add(rb_sex);
            rb_sex.setSelected(true);
            rb_sex.setText("nam");

            tbl_nhan_vien.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "id", "name", "date", "salary", "sex", "position"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            tbl_nhan_vien.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            tbl_nhan_vien.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            tbl_nhan_vien.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tbl_nhan_vienMouseClicked(evt);
                }
            });
            jScrollPane2.setViewportView(tbl_nhan_vien);

            txt_salary.setText("10000000");

            jLabel5.setText("luong");

            btn_clear.setText("xoa form");
            btn_clear.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    btn_clearMouseClicked(evt);
                }
            });
            btn_clear.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btn_clearActionPerformed(evt);
                }
            });

            cbb_sort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id", "name", "date", "salary", "sex", "position" }));
            cbb_sort.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cbb_sortActionPerformed(evt);
                }
            });

            jButton1.setText("laod from file");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            jButton2.setText("save to file");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });

            cbb_sort_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "tang dan", "giam dan" }));
            cbb_sort_type.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cbb_sort_typeActionPerformed(evt);
                }
            });

            jButton3.setText("find by id");
            jButton3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
                }
            });

            cbb_position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "truong phong", "nhan vien" }));

            buttonGroup1.add(jCheckBox1);
            jCheckBox1.setText("nu");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_name)
                                .addComponent(txt_date)
                                .addComponent(txt_salary)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(11, 11, 11)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbb_position, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rb_sex)
                            .addGap(18, 18, 18)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(cbb_sort, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbb_sort_type, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tbl_time, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_delete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_clear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_update, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_add, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(16, 16, 16))
                .addComponent(jScrollPane2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(506, Short.MAX_VALUE)))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(jButton2)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btn_add)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btn_update)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btn_delete)
                                    .addGap(10, 10, 10)
                                    .addComponent(btn_clear))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cbb_position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rb_sex)
                                        .addComponent(jCheckBox1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbb_sort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbb_sort_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tbl_time, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(429, Short.MAX_VALUE)))
            );

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            if (infoDetect()) {
                _qlnv.add(loadfromText());
               loadToTable();
               ShowMessage("da them");                
            }
        } catch (ParseException ex) {
            
        }
    }//GEN-LAST:event_btn_addActionPerformed

    public boolean pushToText(int index) {
        NhanVien nv = _qlnv.get(index);
        txt_id.setText(nv.getId());
        txt_name.setText(nv.getName());
        txt_date.setText(nv.getDate().toString());
        txt_salary.setText(nv.getSalary() + "");
        cbb_position.setSelectedItem(nv.getPosition());
        return true;
    }
    
    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if (tbl_nhan_vien.getSelectedRowCount() == 1) {
            int i = tbl_nhan_vien.getSelectedRow();
            try {
                if (infoDetect()) {
                    _qlnv.set(i, loadfromText());
                    loadToTable();
                    ShowMessage("da sua");                    
                }
            } catch (ParseException ex) {
                ShowMessage(ex.getMessage());
            }
        } else ShowMessage("hay chon 1 cot");
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if (tbl_nhan_vien.getSelectedRowCount() == 1) {
            int i = tbl_nhan_vien.getSelectedRow();
            _qlnv.remove(i);    
            loadToTable();
        } else ShowMessage("hay chon 1 hang");
    }//GEN-LAST:event_btn_deleteActionPerformed

    
    public boolean loadToText(int i) {
        txt_id.setText((String)_model.getValueAt(i, 0));
        txt_name.setText((String)_model.getValueAt(i, 1));
        txt_date.setText((String)_model.getValueAt(i, 2));
        txt_salary.setText((String)_model.getValueAt(i, 3));
        cbb_position.setSelectedItem(_model.getValueAt(i, 4));
        return true;
    }
    
    private void tbl_nhan_vienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nhan_vienMouseClicked
        loadToText(tbl_nhan_vien.getSelectedRow());
    }//GEN-LAST:event_tbl_nhan_vienMouseClicked

    private void btn_clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearMouseClicked
        _model.setRowCount(0);
        _qlnv.clear();;
    }//GEN-LAST:event_btn_clearMouseClicked
    
    public boolean writeToFile(String file_name, QLNV<NhanVien> obj) throws IOException {
        
        try {
            ObjectOutputStream oo = new ObjectOutputStream(
                    new FileOutputStream(file_name)
             );
        } catch (Exception e) {
            ShowMessage(e.getMessage());
            return false;
        }
        return true;
    }    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            loadFromFile();
            ShowMessage("loaded");
        } catch (IOException ex) {
            ShowMessage(ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public boolean sort() {
        try {
            Collections.sort(_qlnv, new Sorter(_qlnv)
                            .getSorter()
                            .get(cbb_sort
                            .getSelectedItem()
                            .toString()));
        if (cbb_sort_type
                    .getSelectedItem()
                    .toString()
                    .split(" ")[0]
                    .equals("giam")) {
                Collections.reverse(_qlnv);
            }
            loadToTable();   
            
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    
    private void cbb_sortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_sortActionPerformed
        sort();
    }//GEN-LAST:event_cbb_sortActionPerformed

    private void cbb_sort_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_sort_typeActionPerformed
        sort();
    }//GEN-LAST:event_cbb_sort_typeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (_qlnv.size() == 0) {
                ShowMessage("do lieu trong");
            } else if (JOptionPane
                    .showConfirmDialog(
                            this
                            ,"ban co chac muon luwu data vao file khong?"
                            ,"save to file"
                            ,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                saveToFile();
                ShowMessage("saved");
            }
        } catch (IOException ex) {
            ShowMessage(ex.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String result = JOptionPane.showInputDialog("nhap ma sinh vien");
        for (int i = 0 ; i < _model.getRowCount(); ++i) {
            if (_qlnv
                .get(i)
                .getId()
                .equals(result)) {
                tbl_nhan_vien.setRowSelectionInterval(i, i);
                return;
            }
        }
        ShowMessage("khong tim thay sinh vien co ma " + result);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        txt_id.setText("");
        txt_name.setText("");
        txt_date.setText("");
        txt_salary.setText("");
        
        _model.setRowCount(0);
        _qlnv.clear();
        
    }//GEN-LAST:event_btn_clearActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbb_position;
    private javax.swing.JComboBox<String> cbb_sort;
    private javax.swing.JComboBox<String> cbb_sort_type;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JRadioButton rb_sex;
    private javax.swing.JTable tbl_nhan_vien;
    private javax.swing.JLabel tbl_time;
    private javax.swing.JTextField txt_date;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_salary;
    // End of variables declaration//GEN-END:variables
}
