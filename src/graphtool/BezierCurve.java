package graphtool;

import java.awt.Point;
import java.awt.geom.Point2D;

public class BezierCurve {

    private static final float AP = 0.5f;
    private Point2D[] bPoints;

    /**
     * Creates a new Bezier curve.
     *
     * @param points
     */
    /*public BezierCurve(Point2D[] points) {
      int n = points.length;
      if (n < 3) {
        // Cannot create bezier with less than 3 points
        return;
      }
      bPoints = new Point[2 * (n - 2)];
      double paX, paY;
      double pbX = points[0].getX();
      double pbY = points[0].getY();
      double pcX = points[1].getX();
      double pcY = points[1].getY();
      for (int i = 0; i < n - 2; i++) {
        paX = pbX;
        paY = pbY;
        pbX = pcX;
        pbY = pcY;
        pcX = points[i + 2].getX();
        pcY = points[i + 2].getY();
        double abX = pbX - paX;
        double abY = pbY - paY;
        double acX = pcX - paX;
        double acY = pcY - paY;
        double lac = Math.sqrt(acX * acX + acY * acY);
        acX = acX /lac;
        acY = acY /lac;
  
        double proj = abX * acX + abY * acY;
        proj = proj < 0 ? -proj : proj;
        double apX = proj * acX;
        double apY = proj * acY;
  
        double p1X = pbX - AP * apX;
        double p1Y = pbY - AP * apY;
        bPoints[2 * i] = new Point((int) p1X, (int) p1Y);
  
        acX = -acX;
        acY = -acY;
        double cbX = pbX - pcX;
        double cbY = pbY - pcY;
        proj = cbX * acX + cbY * acY;
        proj = proj < 0 ? -proj : proj;
        apX = proj * acX;
        apY = proj * acY;
  
        double p2X = pbX - AP * apX;
        double p2Y = pbY - AP * apY;
        bPoints[2 * i + 1] = new Point((int) p2X, (int) p2Y);
      }
    }
     */
 /*public BezierCurve(Point2D[] points) {
        int n = points.length;
        if (n <= 3) {
            return;
        }
        double[][] MatrizDeInterpolação
                = {
                    {1.0, 0.0, 0.0, 0.0},
                    {-5.5, 9, -4.5, 1},
                    {9, -22.5, 18, -4.5},
                    {-4.5, 13.5, -13.5, 4.5}
                };

        double[] MatrizX = new double[n];
        double[] MatrizY = new double[n];
        for (int posicao = 0; posicao < n; posicao++) {
            MatrizX[posicao] = 0;
            MatrizY[posicao] = 0;
        }

        for (int i = 0; i < MatrizDeInterpolação.length; i++)//Linha
        {
            for (int j = 0; j < MatrizDeInterpolação[i].length; j++)//Coluna
            {
                MatrizX[i] += MatrizDeInterpolação[i][j] * points[j].getX();
                MatrizY[i] += MatrizDeInterpolação[i][j] * points[j].getY();
            }
        }

        bPoints = new Point2D[n];
        for (int posicao = 0; posicao < n; posicao++) {
            bPoints[posicao] = new Point((int) MatrizX[posicao], (int) MatrizY[posicao]);
        }

    }
     */
    public BezierCurve(Point2D[] points) {
        int n = points.length;
        if (n < 2) {
            return;
        }
        int newPoints = 200;
        if (n == 2) {
            bPoints = new Point2D[newPoints];
            for (double t = 0; t < 1; t += (double) (1.0 / (double) newPoints)) {
                bPoints[(int) (t * newPoints)] = new Point(
                        (int) (((1 - t) * points[0].getX()) + (t * points[1].getX())),
                        (int) (((1 - t) * points[0].getY()) + (t * points[1].getY())));
            }
        } else if (n == 3) {
            bPoints = new Point2D[newPoints];
            for (double t = 0; t < 1; t += (double) (1.0 / (double) newPoints)) {
                bPoints[(int) (t * newPoints)] = new Point(
                        (int) ((Math.pow(1 - t, 2) * points[0].getX()) + (2 * t * (1 - t) * points[1].getX()) + (Math.pow(t, 2.0) * points[2].getX())),
                        (int) ((Math.pow(1 - t, 2) * points[0].getY()) + (2 * t * (1 - t) * points[1].getY()) + (Math.pow(t, 2.0) * points[2].getY()))
                );
            }
        } else if (n == 4) {
            bPoints = new Point2D[newPoints];
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
