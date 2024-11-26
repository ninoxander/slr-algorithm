package slr;

import discretemaths.*;

public class SimpleLinearRegression {

    // Método para calcular los coeficientes de la regresión lineal simple
    public static double[] linearRegression(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Los arreglos x e y deben tener el mismo tamaño.");
        }

        int n = x.length;

        // Calcular las sumas necesarias utilizando los métodos de DiscreteMaths
        double sumX = DiscreteMaths.sum(x);                 // Σx_i
        double sumY = DiscreteMaths.sum(y);                 // Σy_i
        double sumXy = DiscreteMaths.weightedSum(x, y);     // Σx_i * y_i
        double sumX2 = DiscreteMaths.sum(DiscreteMaths.power(x, 2));  // Σx_i^2

        // Calcular la pendiente m
        double m = (n * sumXy - sumX * sumY) / (n * sumX2 - sumX * sumX);

        // Calcular el intercepto b
        double b = (sumY - m * sumX) / n;

        // Retornar los coeficientes [m, b]
        return new double[] {m, b};
    }

    // Método para predecir los valores de y usando la regresión lineal
    public static double[] predict(double[] x, double[] coefficients) {
        double m = coefficients[0];  // pendiente
        double b = coefficients[1];  // intercepto

        double[] predictions = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            predictions[i] = m * x[i] + b;  // y = mx + b
        }
        return predictions;
    }

    // Método para calcular el error cuadrático medio (MSE)
    public static double meanSquaredError(double[] actual, double[] predicted) {
        if (actual.length != predicted.length) {
            throw new IllegalArgumentException("Los arreglos deben tener el mismo tamaño.");
        }

        double errorSum = 0.0;
        for (int i = 0; i < actual.length; i++) {
            errorSum += Math.pow(actual[i] - predicted[i], 2);
        }
        return errorSum / actual.length;
    }

    public static void main(String[] args) {
        // Datos de ejemplo
        
    }
}
