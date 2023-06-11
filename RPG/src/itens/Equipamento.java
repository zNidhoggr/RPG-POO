package itens;

public class Equipamento extends Item {
    private double attack;
    private double defense;
    private double hp;
    
    // Atributo de Ataque do equipamento //
    
    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }
    
    // Atributo de Defesa do equipamento //
    
    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }
    
    // Atributo de Vida do equipamento //
    
    public double getHp(double hp) {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }
}
