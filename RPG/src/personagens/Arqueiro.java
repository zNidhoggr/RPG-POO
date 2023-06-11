package personagens;

public class Arqueiro extends Classe{
	public Arqueiro(){
		super(1, 3, 2);
		
		Atributos fatorDano, fatorMana;
		
		//definicoes da skill Atirar Flecha
		//forca, agilidade, inteligencia
		fatorDano = new Atributos(0.3f, 0.5f, 0.0f);
		fatorMana = new Atributos(0.0f, 0.0f, 0.0f);
		habilidades.add(new Habilidade("Atirar Flecha",
				4,false, fatorDano, fatorMana, false));
	}
	
	@Override
	public String toString(){
		return "Arqueiro";
	}
        
}