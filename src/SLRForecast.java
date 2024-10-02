package src;

import jade.core.behaviours.OneShotBehaviour;

public class SLRForecast extends OneShotBehaviour {
    private DiscreteMath maths;
    private DataSet ds;

    public SLRForecast(DataSet ds) {
        this.ds = ds;
        this.maths = new DiscreteMath(this.ds);
    }

    @Override
    public void action() {
        float[] data = {55, 60, 65, 125, 340, 1200};
        System.out.println("\nForecast");
        for(float item: data){
            float predictedY = this.maths.getBeta0() + this.maths.getBeta1() * item;
            System.out.println("Forecast " + item + " ≈ " + predictedY);
        }
    }
}
