package graphtool;

import java.awt.Point;
import java.awt.geom.Point2D;

/**
 * Bezier Curve
 * @author wisneytaas
 * @author Ernesto
 */
public class BezierCurve {

    private static final float AP = 0.5f;
    private Point2D[] bPoints;


    /**
     * Creates a new Bezier curve.
     *
     * @param points
     */
    public BezierCurve(Point2D[] points) {
        int n = points.length;
        if (n < 2) {/*O algoritimo só funciona para 2 ou mais pontos*/
            return;
        }
        int newPoints = 1000;/*número de vezes que o t será dividido*/
        bPoints = new Point2D[newPoints];
        if (n == 2) {/*Curva de Bézier Linear*/
            for (double t = 0; t < 1; t += (double) (1.0 / (double) newPoints)) {
                bPoints[(int) (t * newPoints)] = new Point(
                        (int) (((1 - t) * points[0].getX()) + (t * points[1].getX())),
                        (int) (((1 - t) * points[0].getY()) + (t * points[1].getY())));
            }
        } else if (n == 3) {/*Curva de Bézier Quadrática*/
            for (double t = 0; t < 1; t += (double) (1.0 / (double) newPoints)) {
                bPoints[(int) (t * newPoints)] = new Point(
                        (int) ((Math.pow(1 - t, 2) * points[0].getX()) + (2 * t * (1 - t) * points[1].getX()) + (Math.pow(t, 2.0) * points[2].getX())),
                        (int) ((Math.pow(1 - t, 2) * points[0].getY()) + (2 * t * (1 - t) * points[1].getY()) + (Math.pow(t, 2.0) * points[2].getY()))
                );
            }
        } else if (n == 4) {/*Curva de Bézier Cúbica*/
            for (double t = 0; t < 1; t += (double) (1.0 / (double) newPoints)) {
                bPoints[(int) (t * newPoints)] = new Point(
                        (int) ((Math.pow(1 - t, 3) * points[0].getX()) + (3 * t * Math.pow(1 - t, 2) * points[1].getX()) + (3 * Math.pow(t, 2.0) * (1 - t) * points[2].getX()) + (Math.pow(t, 3.0) * points[3].getX())),
                        (int) ((Math.pow(1 - t, 3) * points[0].getY()) + (3 * t * Math.pow(1 - t, 2) * points[1].getY()) + (3 * Math.pow(t, 2.0) * (1 - t) * points[2].getY()) + (Math.pow(t, 3.0) * points[3].getY()))
                );
            }
        }
    }

    /**
     * Returns the calculated bezier points.
     *
     * @return the calculated bezier points
     */
    public Point2D[] getPoints() {
        return bPoints;
    }

    /**
     * Returns the number of bezier points.
     *
     * @return number of bezier points
     */
    public int getPointCount() {
        return bPoints.length;
    }

    /**
     * Returns the bezier points at position i.
     *
     * @param i
     * @return the bezier point at position i
     */
    public Point2D getPoint(int i) {
        return bPoints[i];
    }

}
