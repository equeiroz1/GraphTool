/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphtool;

import java.awt.Graphics;
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
        jLabel1 = new javax.swing.JLabel();
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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bezier");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemBezierMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemBezierMousePressed
        // TODO add your handling code here:
        opcao = 0;
        points = new Point2D[0];
        jLabel1.setText("Bezier - Esse algoritimo foi implementado para comportar até 4 pontos");
    }//GEN-LAST:event_jMenuItemBezierMousePressed

    private void jMenuItemHermiteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemHermiteMousePressed
        // TODO add your handling code here:
        opcao = 1;
        points = new Point2D[0];
        jLabel1.setText("Hermite - A linha só será representada após de dar 4 clicks");
    }//GEN-LAST:event_jMenuItemHermiteMousePressed

    private void jMenuItemInterpoladasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemInterpoladasMousePressed
        // TODO add your handling code here:
        opcao = 2;
        points = new Point2D[0];
        jLabel1.setText("Curva Interpolada");
    }//GEN-LAST:event_jMenuItemInterpoladasMousePressed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        Point2D point2D = new Point(evt.getX(), evt.getY());
        System.out.println("[" + points.length + "] X: " + point2D.getX() + " Y: " + point2D.getY());
        addPoint(point2D);
        if (opcao == 0 && points.length >= 2) {
            clearGraphics(evt.getComponent().getGraphics());
            BezierCurve bezier = new BezierCurve(points);
            for (int x = 0; x < bezier.getPointCount(); x++) {
                Point2D p = bezier.getPoint(x);
                if (p != null) {
                    System.out.println("[" + x + " - Brezier] X: " + p.getX() + " Y: " + p.getY());
                    evt.getComponent().getGraphics().drawOval((int) p.getX(), (int) p.getY(), 1, 1);
                }
            }
            if (points.length == 4) {
                points = new Point2D[0];
            }
        } else if (opcao == 1 && points.length == 4) {
            clearGraphics(evt.getComponent().getGraphics());
            HermiteCurve hermiteCurve = new HermiteCurve();
            hermiteCurve.DrawHermiteCurve(evt.getComponent().getGraphics(),
                    new Point((int) points[0].getX(), (int) points[0].getY()),
                    new Point((int) points[1].getX(), (int) points[1].getY()),
                    new Point((int) points[2].getX(), (int) points[2].getY()),
                    new Point((int) points[3].getX(), (int) points[3].getY()),
                    10000);
            points = new Point2D[0];
        } else if (opcao == 2 && points.length == 4) {
            clearGraphics(evt.getComponent().getGraphics());
            for (double value = 0; value < 1; value += 0.001) {
                double x = points[0].getX()
                        + points[1].getX() * value
                        + points[2].getX() * (value * value)
                        + points[3].getX() * (value * value * value);
                double y = points[0].getY()
                        + points[1].getY() * value
                        + points[2].getY() * (value * value)
                        + points[3].getY() * (value * value * value);
                evt.getComponent().getGraphics().drawOval((int) x, (int) y, 1, 1);
            }
            points = new Point2D[0];
        }
    }//GEN-LAST:event_jPanel1MouseClicked

    /*
    * @pam p Ponto que será adicionado no array
     */
    private void addPoint(Point2D p) {
        Point2D[] pointsAux = new Point2D[points.length + 1];
        int i = 0;
        for (i = 0; i < points.length; i++) {
            pointsAux[i] = points[i];
        }
        pointsAux[i] = p;
        points = pointsAux;
    }

    private void clearGraphics(Graphics g) {
        g.clearRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemBezier;
    private javax.swing.JMenuItem jMenuItemHermite;
    private javax.swing.JMenuItem jMenuItemInterpoladas;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
