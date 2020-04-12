package Plague;

import SimStation.*;
import mvc.Utilities;

import java.util.Random;

public class Plague extends Agent {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Random rand = new Random();
    private boolean infected;
    private boolean immunity;
    public int speed;

    public Plague(Simulation thisSimulation) {

        super("Plague", thisSimulation);
        int safezone = Utilities.rng.nextInt(100);
        immunity = safezone < PlagueSimulation.RESISTANCE; //safe from virus
        speed = rand.nextInt(11) + 1;
        infection();



    }

    public boolean isImmunity() { return immunity; }

    public boolean isInfected() {return infected;}

    public void infection(){
        if(!isImmunity()){
            int safezone = Utilities.rng.nextInt(100);
            this.infected = safezone < PlagueSimulation.VIRULENCE;

        }
    }
    @Override
    public void update() {
        Random rand = new Random();
        this.setHeading(Heading.getRandomHeading());
        this.move(rand.nextInt(11) + 1);
    }
}
