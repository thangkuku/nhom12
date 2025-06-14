/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package products.management.system.User;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import products.management.system.ConnectDatabase;
import products.management.system.DangNhap;

/**
 *
 * @author cucda
 */
public class managementProductsAdmin extends javax.swing.JFrame {

    private int userId;

    public managementProductsAdmin(int id) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.userId = id;
        initComponents();
        loadUserName();
        loadTableData();

    }

    /**
     * Creates new form managementProductsAdmin
     */
    private void loadUserName() {

        try {
            Connection conn = ConnectDatabase.getConnection();
            String sql = "SELECT name FROM users WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                txtname.setText(name);
                txtname.setText(name);
            }

            rs.close();
            pst.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadTableData() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Tên sản phẩm", "Type", "Price", "Số lượng"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // khóa hết, không cho chỉnh sửa
            }
        };
        try {
            Connection conn = ConnectDatabase.getConnection();
            String sql = "SELECT id, nameProducts, type, price, stock FROM products";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("nameProducts");
                String type = rs.getString("type");
                BigDecimal price = rs.getBigDecimal("price");
                int stock = rs.getInt("stock");

                model.addRow(new Object[]{id, name, type, price, stock});
            }

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        jTable2.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtname = new javax.swing.JLabel();
        txtname2 = new javax.swing.JLabel();
        txtname3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        trangchu = new javax.swing.JButton();
        mnproducts = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnRemove = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1132, 760));

        jPanel2.setBackground(new java.awt.Color(77, 168, 218));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(77, 168, 218));
        jPanel3.setMinimumSize(new java.awt.Dimension(220, 650));
        jPanel3.setLayout(null);

        txtname.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txtname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtname.setText("txtname");
        txtname.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(txtname);
        txtname.setBounds(0, 50, 220, 24);

        txtname2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtname2.setForeground(new java.awt.Color(204, 204, 204));
        txtname2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtname2.setText("Admin");
        txtname2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(txtname2);
        txtname2.setBounds(0, 80, 220, 16);

        txtname3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txtname3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtname3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user (1).png"))); // NOI18N
        txtname3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(txtname3);
        txtname3.setBounds(0, 20, 214, 32);

        jButton1.setBackground(new java.awt.Color(77, 168, 218));
        jButton1.setText("Trang Chủ");
        jPanel3.add(jButton1);
        jButton1.setBounds(325, 394, 139, 46);

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator3);
        jSeparator3.setBounds(50, 190, 121, 10);

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator7);
        jSeparator7.setBounds(10, 110, 200, 10);

        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator8);
        jSeparator8.setBounds(50, 260, 121, 10);

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator9);
        jSeparator9.setBounds(50, 340, 121, 10);

        trangchu.setBackground(new java.awt.Color(76, 167, 218));
        trangchu.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        trangchu.setText("Trang Chủ");
        trangchu.setBorder(null);
        trangchu.setFocusPainted(false);
        trangchu.setOpaque(true);
        trangchu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trangchuActionPerformed(evt);
            }
        });
        jPanel3.add(trangchu);
        trangchu.setBounds(0, 130, 220, 50);

        mnproducts.setBackground(new java.awt.Color(77, 168, 218));
        mnproducts.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        mnproducts.setText("Quản Lý SP");
        mnproducts.setBorder(null);
        mnproducts.setFocusPainted(false);
        mnproducts.setOpaque(true);
        mnproducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnproductsActionPerformed(evt);
            }
        });
        jPanel3.add(mnproducts);
        mnproducts.setBounds(0, 200, 220, 50);

        jButton9.setBackground(new java.awt.Color(77, 168, 218));
        jButton9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton9.setText("Tra cứu");
        jButton9.setBorder(null);
        jButton9.setFocusPainted(false);
        jButton9.setOpaque(true);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9);
        jButton9.setBounds(0, 270, 220, 50);

        jButton11.setBackground(new java.awt.Color(77, 168, 218));
        jButton11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton11.setText("Đăng xuất");
        jButton11.setBorder(null);
        jButton11.setFocusPainted(false);
        jButton11.setOpaque(true);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11);
        jButton11.setBounds(0, 350, 220, 50);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 50, 220, 710);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dustbin.png"))); // NOI18N
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pen.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-interface-symbol.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtsearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh-button.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(0, 0, 1140, 50);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(910, 10000));
        jPanel4.setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(462, 10000));

        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên Sp", "Loại SP", "Gía", "Số Lượng"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 910, 670);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(220, 50, 910, 670);
        jPanel4.getAccessibleContext().setAccessibleParent(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1132, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow >= 0) {
            int id = Integer.parseInt(jTable2.getValueAt(selectedRow, 0).toString());
            String ten = jTable2.getValueAt(selectedRow, 1).toString();
            String gia = jTable2.getValueAt(selectedRow, 3).toString();
            String soluong = jTable2.getValueAt(selectedRow, 4).toString();
            String loai = jTable2.getValueAt(selectedRow, 2).toString();

            // Truyền this (tức form cha) vào
            Edit editFrame = new Edit(this, id, ten, gia, soluong, loai);
            editFrame.setVisible(true);
            editFrame.pack();
            editFrame.setLocationRelativeTo(null);
        } else {
            JOptionPane.showMessageDialog(null, "Ông phải chọn một hàng trong bảng trước đã.");
        }

    }//GEN-LAST:event_btnEditActionPerformed

    public void updateTableSelectedRow(String ten, String gia, String soluong, String loai) {
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow >= 0) {
            String idString = jTable2.getValueAt(selectedRow, 0).toString();
            int id = Integer.parseInt(idString);

            try {
                Connection conn = ConnectDatabase.getConnection();
                String sql = "UPDATE products SET nameProducts=?, type=?, price=?, stock=? WHERE id=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, ten);
                pst.setString(2, loai);
                pst.setString(3, gia);
                pst.setString(4, soluong);
                pst.setInt(5, id);

                int rowsUpdated = pst.executeUpdate();
                if (rowsUpdated > 0) {
                    jTable2.setValueAt(ten, selectedRow, 1);
                    jTable2.setValueAt(loai, selectedRow, 2);
                    jTable2.setValueAt(gia, selectedRow, 3);
                    jTable2.setValueAt(soluong, selectedRow, 4);
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật database thất bại!");
                }
                pst.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi kết nối hoặc cập nhật database!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không có hàng nào được chọn.");
        }
    }

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn hàng để xóa");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Ông có chắc muốn xóa không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        Object id = jTable2.getValueAt(selectedRow, 0);

        boolean deleted = deleteFromDatabase(id);
        if (deleted) {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Xóa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }

// Hàm xóa trong database như tôi đã viết ở trên
    private boolean deleteFromDatabase(Object id) {
        try {
            Connection conn = ConnectDatabase.getConnection();
            String sql = "DELETE FROM products WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setObject(1, id);
            int result = pst.executeUpdate();
            pst.close();
            conn.close();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Add addForm = new Add(userId); // Truyền ID của user đang login
        addForm.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keyword = txtsearch.getText().trim().toLowerCase();
        DefaultTableModel oldModel = (DefaultTableModel) jTable2.getModel();

        // Tạo model mới với cùng cột
        DefaultTableModel newModel = new DefaultTableModel(){
             @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // khóa hết, không cho chỉnh sửa
            }
        };
        
        for (int i = 0; i < oldModel.getColumnCount(); i++) {
            newModel.addColumn(oldModel.getColumnName(i));
        }

        // Duyệt từng dòng, lấy những dòng khớp tên
        for (int i = 0; i < oldModel.getRowCount(); i++) {
            String tenSP = oldModel.getValueAt(i, 1).toString().toLowerCase(); // cột tên sản phẩm
            if (tenSP.contains(keyword)) {
                Vector row = new Vector();
                for (int j = 0; j < oldModel.getColumnCount(); j++) {
                    row.add(oldModel.getValueAt(i, j));
                }
                newModel.addRow(row);
            }
        }

        // Gán lại model mới cho bảng
        jTable2.setModel(newModel);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void mnproductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnproductsActionPerformed
        // TODO add your handling code here:
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                managementProductsAdmin managementProductsAdminFrame = new managementProductsAdmin(userId);
                managementProductsAdminFrame.setVisible(true);
                managementProductsAdminFrame.pack();
                managementProductsAdminFrame.setLocationRelativeTo(null);

            }

        });
        this.dispose();
    }//GEN-LAST:event_mnproductsActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        DangNhap DangNhapFrame = new DangNhap();
        DangNhapFrame.setVisible(true);
        DangNhapFrame.pack();
        DangNhapFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void trangchuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trangchuActionPerformed
        Userform UserformFrame=new Userform(this.userId);
        UserformFrame.setVisible(true);
        UserformFrame.pack();
       UserformFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_trangchuActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
          lookup lookupFrame=new lookup(this.userId);
        lookupFrame.setVisible(true);
         lookupFrame.pack();
        lookupFrame.setLocationRelativeTo(null);
          this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        managementProductsAdmin managementProductsAdminFrame=new managementProductsAdmin(this.userId);
        managementProductsAdminFrame.setVisible(true);
         managementProductsAdminFrame.pack();
        managementProductsAdminFrame.setLocationRelativeTo(null);
          this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(managementProductsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managementProductsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managementProductsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managementProductsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managementProductsAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton mnproducts;
    private javax.swing.JButton trangchu;
    private javax.swing.JLabel txtname;
    private javax.swing.JLabel txtname2;
    private javax.swing.JLabel txtname3;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
    public managementProductsAdmin() {
        initComponents();
    }
}
