package personagem;

import interfaces.Job;

public class Mago implements Job {
	private int agility;
	private int strength;
	private int intelligence;
	
	public Mago(int agility, int strength, int intelligence) {
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

	public void setIntelligence(int intelligence) {
	    this.intelligence = intelligence;
	}
	 
	public String getDescription() {
	    return "O Mago é um mestre das artes mágicas. Sua inteligência é sua principal característica, permitindo lançar poderosos feitiços.";
	}
	
	/*@Override
	public void executeAbility() {
	    System.out.println("O Mago lança um feitiço!");
	    
	    System.out.println("O feitiço do Mago causa uma explosão de poder mágico!");
	    int damage = intelligence * 2; 
	    System.out.println("Dano causado: " + damage);
	}*/
}