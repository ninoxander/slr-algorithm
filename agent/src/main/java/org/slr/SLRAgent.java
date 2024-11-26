package org.slr;

import jade.core.Agent;
import org.slr.behaviours.SLRBehaviour;

public class SLRAgent extends Agent{
    @Override
    protected void setup() {
        addBehaviour(new SLRBehaviour());
    }
}