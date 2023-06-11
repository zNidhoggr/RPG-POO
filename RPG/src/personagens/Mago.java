package personagens;

public class Mago extends Classe{
	public Mago(){
		super(1, 2, 3);
		
		Atributos fatorDano, fatorMana;
		
		//definicoes da skill Bola de fogo
		fatorDano = new Atributos(0.3f, 0.2f, 0.5f);
		fatorMana = new Atributos(0.0f, 0.0f, 0.5f);
		habilidades.add(new Habilidade("Bola de fogo",
				5,false, fatorDano, fatorMana, false));
		
	}
	
	@Override
	public String toString(){
		return "Mago";
	}
        
}