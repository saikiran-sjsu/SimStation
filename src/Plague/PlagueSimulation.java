package Plague;

import SimStation.Simulation;
import SimStation.SimulationPanel;
import mvc.AppPanel;

public class PlagueSimulation extends Simulation {

    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection


    public void populate() {
        for(int i = 0; i < 50; i++) {
            this.addAgent(new Plague(this));
        }
    }

    public String[] getStats(){
        String[] stats = new String[3];
        stats[0] = "#agents = " + this.getAgents().size();
        stats[1] = "clock = "; //+ clock;
        stats[2] = "% infected = ";
        return stats;

    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();
    }





}
