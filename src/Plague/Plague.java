package Plague;

import SimStation.*;
import mvc.AppPanel;

public class Plague extends Simulation {

    public String[] getStats(){
        String[] stats = new String[3];
        stats[0] = "#agents = "; //+ agents.size();
        stats[1] = "clock = "; //+ clock;
        stats[2] = "% infected = ";
        return stats;

    }


    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();
    }


}
