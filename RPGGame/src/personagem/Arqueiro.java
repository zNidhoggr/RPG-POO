package personagem;

import interfaces.Job;

public class Arqueiro implements Job {
	private int agility;
	private int strength;
	private int intelligence;
	
	public Arqueiro(int agility, int strength, int intelligence) {
	    this.agility = agility;
	    this.strength = strength;
	    this.intelligence = intelligence;
	}
	
	public int getAgility() {
	    return agility;
	}
	
	public int getStrength() {
	    return strength;
	}
	
	public int getIntelligence() {
	    return intelligence;
	}
	
	public String getDescription() {
        return "O Arqueiro é um exímio atirador com grande agilidade. Sua destreza e precisão com o arco são suas principais características.";
    }
	
	/*@Override
	public void executeAbility() {
	    
	    System.out.println("O Arqueiro dispara uma flecha precisa!");
	    
	    System.out.println("A flecha acerta um ponto vital do inimigo!");
	    int damage = getAgility() * 2; 
	    System.out.println("Dano causado: " + damage);
	}*/
}