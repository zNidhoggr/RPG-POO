package rpg;

import itens.Item;

public class Consumivel extends Item {
	private String buff;
    private double mana;
    private double hp;
    
    // Nome do Buff que o consumivel fornece //
    
    public String getBuff() {
        return buff;
    }

    public void setBuff(String buff) {
        this.buff = buff;
    }
    
    // Quantidade de Mana que o consumivel regenera //
    
    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }
    
    // Quantidade de Vida que o consumivel regenera //
    
    public double getHp(double hp) {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }
}
