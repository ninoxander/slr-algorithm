package org.slr.behaviours;

import jade.core.behaviours.OneShotBehaviour;

public class SLRBehaviour extends OneShotBehaviour {
    @Override
    public void action() {
        double[] x = dataset.SLRDataset.getX();
        double[] y = dataset.SLRDataset.getY();

        double[] coefficients = slr.SimpleLinearRegression.linearRegression(x, y);
        double slope = coefficients[0];
        double intercept = coefficients[1];

        System.out.println("Slope (m): " + slope);
        System.out.println("Intercept (b): " + intercept);

        double[] predictions = slr.SimpleLinearRegression.predict(x, coefficients);

        System.out.println("Predictions:");
        for (double prediction : predictions) {
            System.out.println(prediction);
        }

        double mse = slr.SimpleLinearRegression.meanSquaredError(y, predictions);
        System.out.println("MSE: " + mse);
    }
}
