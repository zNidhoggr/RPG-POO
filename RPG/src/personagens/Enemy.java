package personagens;

public class Enemy extends Classe{
	public Enemy(){
		super(4, 1, 0);
		
		Atributos fatorDano, fatorMana;
		//definicoes da skill Chutar
		fatorDano = new Atributos(1.0f, 0.5f, 0.0f);
		fatorMana = new Atributos(0.0f, 0.0f, 0.0f);
		habilidades.add(new Habilidade("Chutar",
				8,false, fatorDano, fatorMana, false));
		
		//definicoes da skill Socar; mana igual de cima
		fatorDano = new Atributos(0.8f, 0.4f, 0.0f);
		fatorMana = new Atributos(0.0f, 0.0f, 0.0f);
		habilidades.add(new Habilidade("Socar",
				5,false, fatorDano, fatorMana, false));
	}
	
	@Override
	public String toString(){
		return "Monstro";
	}
        
}