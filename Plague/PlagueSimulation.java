package Plague;

import SimStation.Simulation;
import SimStation.SimulationPanel;
import mvc.AppPanel;

public class PlagueSimulation extends Simulation {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection

    public double counter =0.0;
    //public int agentSize = this.getAgents().size();


    public void populate() {
        for(int i = 0; i < 50; i++) {
            this.addAgent(new Plague(this));
        }
    }

    public double getAgentSize() {
        return this.getAgents().size();
    }

    public String[] getStats(){
        counter = 0;
        for(int i =0; i < getAgentSize(); i++){
            if(((Plague)getAgents().get(i)).isInfected()) {
                counter++;
            }
        }
        String[] stats = new String[3];
        stats[0] = "#agents = " + getAgentSize();
        stats[1] = "clock = " + this.getClock();
        stats[2] = "% infected = " + (counter/getAgentSize())*100 ;
        return stats;

    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();
    }

}
