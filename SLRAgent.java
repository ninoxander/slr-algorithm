import jade.core.Agent;
import src.DataSet;
import src.SLRBehaviour;
import src.SLRForecast;

public class SLRAgent extends Agent{
    @Override
    protected void setup() {
        // Create a new dataset
        DataSet dataset = new DataSet();

        // System.out.println("I'm " + getLocalName() +  " and I'm running!");

        // Starting behaviours
        addBehaviour(new SLRBehaviour(dataset));
        addBehaviour(new SLRForecast(dataset));
    }
}
