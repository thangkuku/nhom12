/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package products.management.system;

/**
 *
 * @author M25
 */
public class ProductsManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DangNhap DangNhapFrame = new DangNhap();
                DangNhapFrame.setVisible(true);
                DangNhapFrame.pack();
                DangNhapFrame.setLocationRelativeTo(null);
            }
        });
    }

}
