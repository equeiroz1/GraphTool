/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphtool;

import java.awt.Point;
import java.awt.geom.Point2D;

/**
 *
 * @author wisneytaas
 * @author Ernesto
 */
public class GraphTool extends javax.swing.JFrame {

    public Point2D[] points = new Point2D[0];
    public int opcao = 0;

    /**
     * Creates new form GraphTool1
     */
    public GraphTool() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemBezier = new javax.swing.JMenuItem();
        jMenuItemInterpoladas = new javax.swing.JMenuItem();
        jMenuItemHermite = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 808, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        jMenu1.setText("Curvas Parametricas");

        jMenuItemBezier.setText("Bezier");
        jMenuItemBezier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemBezierMousePressed(evt);
            }
        });
        jMenu1.add(jMenuItemBezier);

        jMenuItemInterpoladas.setText("Interpoladas");
        jMenuItemInterpoladas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemInterpoladasMousePressed(evt);
            }
        });
        jMenu1.add(jMenuItemInterpoladas);

        jMenuItemHermite.setText("Hermite");
        jMenuItemHermite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemHermiteMousePressed(evt);
            }
        });
        jMenu1.add(jMenuItemHermite);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 78, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemBezierMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemBezierMousePressed
        // TODO add your handling code here:
        points = new Point2D[0];
    }//GEN-LAST:event_jMenuItemBezierMousePressed

    private void jMenuItemHermiteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemHermiteMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemHermiteMousePressed

    private void jMenuItemInterpoladasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemInterpoladasMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemInterpoladasMousePressed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        Point2D point2D = new Point(evt.getX(), evt.getY());
        System.out.println("[" + points.length + "] X: " + point2D.getX() + " Y: " + point2D.getY());
        addPoint(point2D);
        if (opcao == 0 && points.length > 3) {
            BezierCurve bezier = new BezierCurve(points);

            for (int x = 0; x < bezier.getPointCount(); x++) {
                System.out.println("[" + x + " - Brezier] X: " + bezier.getPoint(x).getX() + " Y: " + bezier.getPoint(x).getY());
                evt.getComponent().getGraphics().drawLine((int) bezier.getPoint(x).getX(), (int) bezier.getPoint(x).getY(), (int) bezier.getPoint(x).getX(), (int) bezier.getPoint(x).getY());
            }
        }
    }//GEN-LAST:event_jPanel1MouseClicked

    private void addPoint(Point2D p) {
        Point2D[] pointsAux = new Point2D[points.length + 1];
        int i = 0;
        for (i = 0; i < points.length; i++) {
            pointsAux[i] = points[i];
        }
        pointsAux[i] = p;
        points = pointsAux;
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
            java.util.logging.Logger.getLogger(GraphTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphTool().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemBezier;
    private javax.swing.JMenuItem jMenuItemHermite;
    private javax.swing.JMenuItem jMenuItemInterpoladas;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
