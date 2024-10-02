import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import src.DiscreteMath;
import src.DataSet;

public class SLRAgent extends Agent{
    @Override
    protected void setup() {
        // Create a new dataset
        DataSet dataset = new DataSet();

        System.out.println("I'm " + getLocalName() +  " and I'm running!");

        // Starting behaviour
        addBehaviour(new SLRBehaviour(dataset));
    }

    private class SLRBehaviour extends OneShotBehaviour {
        private DiscreteMath maths;
        private DataSet dataset;
        public SLRBehaviour(DataSet ds){
            this.dataset = ds;
            this.maths = new DiscreteMath(this.dataset);
        }

        @Override
        public void action(){
            // Printing data
            System.out.println("SLR Algorithm by Daniela Nava");
            this.maths.linearRegression();

            System.out.println("Beta 0 = " + this.maths.getBeta0());
            System.out.println("Beta 1 = " + this.maths.getBeta1());
            System.out.println("Beta 0 SE = " +  this.maths.B0StandError);
            System.out.println("Beta 1 SE = " + this.maths.B1StandError);
            System.out.println("R Squared = " + this.maths.RSquared);
            System.out.println("R correlation = " + this.maths.R);

        }
    }
}
