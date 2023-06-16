package personagem;

import interfaces.Job;

public class Guerreiro implements Job {
	private int agility;
	private int strength;
	private int intelligence;
	
	public Guerreiro(int agility, int strength, int intelligence) {
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
        return "O Guerreiro é um combatente habilidoso e resistente. Sua força física é sua principal característica, permitindo causar grandes danos com suas armas.";
    }
	
	/*@Override
	public void executeAbility() {
	    System.out.println("O Guerreiro realiza um ataque poderoso!");
	    
	    System.out.println("O a ataque do Guerreiro para o inimigo ao meio!");
	    int damage = getStrength() * 2; 
	    System.out.println("Dano causado: " + damage);
	}*/
}