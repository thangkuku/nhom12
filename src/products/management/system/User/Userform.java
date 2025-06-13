/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package products.management.system.User;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import products.management.system.ConnectDatabase;
import products.management.system.DangNhap;

public class Userform extends javax.swing.JFrame {

    public Userform(int id) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.userId = id;
        initComponents();
        loadUserName();
        loadTableData();
        chart1.removeAll();
        chart1.add(ChartExample.createChartPanel());
        chart1.validate();
        chart2.removeAll();
        chart2.add(new XChartPanel<>(ProductChartUtil.createStatusDistributionChart()));
        chart2.validate();

    }

    private int userId;

    public static class ProductChartUtil {

        // Lấy dữ liệu phân bố sản phẩm theo trạng thái
        public static void getStatusDistribution(List<String> statusList, List<Integer> countList) {
            try (Connection conn = ConnectDatabase.getConnection()) {
                String sql = "SELECT CASE WHEN stock > 0 THEN 'Còn hàng' ELSE 'Tạm hết' END AS status, COUNT(*) as count_status FROM products GROUP BY status";
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    statusList.add(rs.getString("status"));
                    countList.add(rs.getInt("count_status"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Tạo chart phân bố sản phẩm theo trạng thái (chart2)
        public static CategoryChart createStatusDistributionChart() {
            List<String> statusList = new ArrayList<>();
            List<Integer> countList = new ArrayList<>();
            getStatusDistribution(statusList, countList);

            if (statusList.isEmpty() || countList.isEmpty()) {
                // Thêm dữ liệu mặc định để tránh lỗi
                statusList.add("Không có dữ liệu");
                countList.add(0);
            }

            CategoryChart chart = new CategoryChartBuilder()
                    .width(600).height(400)
                    .title("Phân bố sản phẩm theo trạng thái")
                    .xAxisTitle("Trạng thái")
                    .yAxisTitle("Số lượng sản phẩm")
                    .build();

            chart.addSeries("Số lượng", statusList, countList);
            return chart;
        }

    }

    public static class ChartExample {

        public static JPanel createChartPanel() {
            List<String> categories = new ArrayList<>();
            List<Integer> values = new ArrayList<>();

            try {
                Connection conn = ConnectDatabase.getConnection();
                String sql = "SELECT type, SUM(stock) AS total_stock FROM products GROUP BY type";
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    categories.add(rs.getString("type"));
                    values.add(rs.getInt("total_stock"));
                }

                rs.close();
                pst.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            CategoryChart chart = new CategoryChartBuilder()
                    .width(600).height(400)
                    .title("Tồn kho theo loại sản phẩm")
                    .xAxisTitle("Loại sản phẩm")
                    .yAxisTitle("Số lượng tồn")
                    .build();
            if (categories.isEmpty() || values.isEmpty()) {
                categories.clear();
                values.clear();
                categories.add("Không có dữ liệu");
                values.add(0);
            }
            chart.addSeries("Tồn kho", categories, values);

            chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);

            return new XChartPanel<>(chart);
        }
    }

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
                txtname1.setText(name);
            }

            rs.close();
            pst.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
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

        jTable1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtname = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtname1 = new javax.swing.JLabel();
        txtname2 = new javax.swing.JLabel();
        txtname3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        trangchu = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        mnproducts = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        chart1 = new javax.swing.JPanel();
        chart2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(219, 219, 219));
        setMaximumSize(new java.awt.Dimension(1000, 500));
        setMinimumSize(new java.awt.Dimension(1000, 500));
        setPreferredSize(new java.awt.Dimension(1142, 750));
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel1.setText("Xin Chào");

        txtname.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txtname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtname.setText("txtname");
        txtname.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(906, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(96, 96, 96))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1);
        jPanel1.setBounds(0, 0, 1140, 50);

        jPanel2.setBackground(new java.awt.Color(77, 168, 218));
        jPanel2.setMinimumSize(new java.awt.Dimension(220, 650));
        jPanel2.setLayout(null);

        txtname1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txtname1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtname1.setText("txtname");
        txtname1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(txtname1);
        txtname1.setBounds(0, 60, 220, 24);

        txtname2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtname2.setForeground(new java.awt.Color(204, 204, 204));
        txtname2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtname2.setText("Admin");
        txtname2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(txtname2);
        txtname2.setBounds(0, 90, 220, 16);

        txtname3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txtname3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtname3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user (1).png"))); // NOI18N
        txtname3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(txtname3);
        txtname3.setBounds(0, 20, 214, 32);

        jButton1.setBackground(new java.awt.Color(77, 168, 218));
        jButton1.setText("Trang Chủ");
        jPanel2.add(jButton1);
        jButton1.setBounds(325, 394, 139, 46);

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator3);
        jSeparator3.setBounds(50, 190, 121, 10);

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator7);
        jSeparator7.setBounds(10, 110, 200, 10);

        trangchu.setBackground(new java.awt.Color(76, 167, 218));
        trangchu.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        trangchu.setText("Trang Chủ");
        trangchu.setBorder(null);
        trangchu.setFocusPainted(false);
        trangchu.setOpaque(true);
        jPanel2.add(trangchu);
        trangchu.setBounds(0, 130, 220, 50);

        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator8);
        jSeparator8.setBounds(50, 260, 121, 10);

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
        jPanel2.add(mnproducts);
        mnproducts.setBounds(0, 200, 220, 50);

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator9);
        jSeparator9.setBounds(50, 330, 121, 10);

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
        jPanel2.add(jButton9);
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
        jPanel2.add(jButton11);
        jButton11.setBounds(0, 350, 220, 50);

        jPanel3.add(jPanel2);
        jPanel2.setBounds(0, 50, 220, 710);

        chart1.setBackground(new java.awt.Color(255, 255, 255));
        chart1.setLayout(new java.awt.BorderLayout());
        jPanel3.add(chart1);
        chart1.setBounds(227, 60, 350, 200);

        chart2.setBackground(new java.awt.Color(255, 255, 255));
        chart2.setLayout(new java.awt.GridLayout(1, 0));
        jPanel3.add(chart2);
        chart2.setBounds(583, 60, 560, 200);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMinimumSize(new java.awt.Dimension(910, 100000));
        jPanel6.setPreferredSize(new java.awt.Dimension(910, 1000));
        jPanel6.setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(462, 10000));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
                "Mã SP", "Tên SP", "Loại SP", "Giá", "Số Lượng"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel6.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 910, 400);

        jPanel3.add(jPanel6);
        jPanel6.setBounds(230, 270, 910, 10000000);
        jPanel6.getAccessibleContext().setAccessibleName("sanpham");

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 1140, 1000);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        lookup lookupFrame=new lookup(this.userId);
        lookupFrame.setVisible(true);
          lookupFrame.pack();
        lookupFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Userform(1).setVisible(true);  // truyền id hợp lệ vào đây
            }
        });
    }

    public Userform() {
        initComponents();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chart1;
    private javax.swing.JPanel chart2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton mnproducts;
    private javax.swing.JButton trangchu;
    private javax.swing.JLabel txtname;
    private javax.swing.JLabel txtname1;
    private javax.swing.JLabel txtname2;
    private javax.swing.JLabel txtname3;
    // End of variables declaration//GEN-END:variables
}
