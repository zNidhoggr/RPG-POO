package personagens;

public class Guerreiro extends Classe {
	public Guerreiro(){
		super(4, 1, 1);
		
		Atributos fatorDano, fatorMana;
		
		//definicoes da skill Golpe de Espada
		fatorDano = new Atributos(0.7f, 0.3f, 0.0f);
		fatorMana = new Atributos(0.0f, 0.0f, 0.0f);
		habilidades.add(new Habilidade("Golpe de Espada",
				5,false, fatorDano, fatorMana, false));
	}
	
	@Override
	public String toString(){
		return "Guerreiro";
	}
	
}