package personagem;

import interfaces.Job;

public abstract class Character {
	private String name;
	private int health;
	private Job job;
	
	public Character(String name, Job job) {
	    this.name = name;
	    this.job = job;
	    this.health = 100;
	}
	
	public int getMainAttribute() {
        int mainAttribute = 0;

        if (job instanceof Mago) {
            mainAttribute = ((Mago) job).getIntelligence();
        } else if (job instanceof Guerreiro) {
            mainAttribute = ((Guerreiro) job).getStrength();
        } else if (job instanceof Arqueiro) {
            mainAttribute = ((Arqueiro) job).getAgility();
        }

        return mainAttribute;
    }

	public String getName() {
	    return name;
	}

	public int getHealth() {
	    return health;
	}

	public Job getJob() {
	    return job;
	}

	public void takeDamage(int damage) {
	    health -= damage;
	    if (health < 0) {
	        health = 0;
	    }
	}

	public abstract void attack(Character target);
}