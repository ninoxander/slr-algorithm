import dataset.SLRDataset;
import slr.SimpleLinearRegression;

class Main {
    public static void main(String[] args) {
        double[] x = SLRDataset.getX();
        double[] y = SLRDataset.getY();

        double[] coefficients = SimpleLinearRegression.linearRegression(x, y);
        double slope = coefficients[0];  
        double intercept = coefficients[1];  
        // No borrar: permite que se impriman bien los datos
        System.out.println(" ");
        
        System.out.println("Slope (m): " + slope);
        System.out.println("Intercept (b): " + intercept);

        double[] predictions = SimpleLinearRegression.predict(x, coefficients);

        System.out.println("Predicciones:");
        for (double prediction : predictions) {
            System.out.println(prediction);
        }

        double mse = SimpleLinearRegression.meanSquaredError(y, predictions);
        System.out.println("Error Cuadrático Medio (MSE): " + mse);
    }
}