package graphtool;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.Graphics;

/**
 * HermiteCurve
 * @author wisneytaas
 * @author Ernesto
 */

public class HermiteCurve{

    private Point2D[] hPoints;
    private double H[] = {2, 1, -2, 1, -3, -2, 3, -1, 0, 1, 0, 0, 1, 0, 0, 0};
 
    
    /**
     * Get Hermite Coefficient
     */
    Vector4 GetHermiteCoeff(double x0, double s0, double x1, double s1) {

        Matrix4 basis = new Matrix4(H);
        Vector4 v = new Vector4(x0, s0, x1, s1);
        return basis.multiply(v);
    }

        
    /**
     * Drawing Hermite Curve
     */
    void DrawHermiteCurve(Graphics g, Point P0, Point T0, Point P1, Point T1, int numpoints) {
        Vector4 xcoeff = GetHermiteCoeff(P0.getX(), T0.getX(), P1.getX(), T1.getX());
        Vector4 ycoeff = GetHermiteCoeff(P0.getY(), T0.getY(), P1.getY(), T1.getY());
        System.out.println("Xcoeff"+xcoeff.getValue(0)+", "+xcoeff.getValue(1)+", "+xcoeff.getValue(2)+", "+xcoeff.getValue(3));
        System.out.println("Ycoeff"+ycoeff.getValue(0)+", "+ycoeff.getValue(1)+", "+ycoeff.getValue(2)+", "+ycoeff.getValue(3)+", ");
        
        if (numpoints < 2) {
            return;
        }
        double dt = 1.0 / (numpoints - 1);

        for (double t = 0; t <= 1; t += dt) {
            Vector4 vt = new Vector4();
            vt.setValue(3, 1);
            for (int i = 2; i >= 0; i--) {
                vt.setValue(i, vt.getValue(i + 1) * t);
            }
            int x = (int) Math.round(xcoeff.DotProduct(vt));
            int y = (int) Math.round(ycoeff.DotProduct(vt));
            g.drawOval(x, y, 1, 1);
        }
    }

        
    /**
     * Vector4 - Auxiliary class
     */
    class Vector4 {

    public double v[] = new double[4];

    public Vector4() {
    }

    public Vector4(double a, double b, double c, double d) {
        v[0] = a;
        v[1] = b;
        v[2] = c;
        v[3] = d;
    }

    public double[] getV() {
        return v;
    }

    public double getValue(int index) {
        return v[index];
    }

    public void setValue(int index, double value) {
        v[index] = value;
    }

    public double DotProduct(Vector4 b) {
        return v[0] * b.v[0] + v[1] * b.v[1] + v[2] * b.v[2] + v[3] * b.v[3];
    }
    }

    class Matrix4 {

    public Vector4 M[] = new Vector4[4];

    public Matrix4(double A[]) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            M[i]=new Vector4();
            for (int j = 0; j < 4; j++) {
                System.out.println(A[count]);
                System.out.println( M[i].getValue(0));
                M[i].setValue(j, A[count]);
                count++;
            }
        }
    }

    public Vector4[] getM() {
        return M;
    }

    Vector4 multiply(Vector4 b) {
        Vector4 res = new Vector4();
        double count = 0.0d;
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                count += M[i].getValue(j) * b.getValue(j);
            }
            res.setValue(i, count);
            count = 0;
        }

        return res;
    }
    }
}