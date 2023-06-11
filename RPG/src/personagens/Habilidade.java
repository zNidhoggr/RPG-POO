package personagens;

import personagens.Player;

public class Habilidade{
	
	private String nome;
	private Atributos fatorDano, fatorMana;
	private int tempo;
	private static int ID_cont = 1;
	public int ID;
	
	public Habilidade(String nome, int tempo, boolean afetaTodos, 
	Atributos fatorDano, Atributos fatorMana, boolean afetaAmigo){
		
		this.setNome(nome);
		this.setTempo(tempo);
		this.setFatorDano(fatorDano);
		this.setFatorMana(fatorMana);
		this.setID();
	}
	
	public void setID(){
		this.ID = Habilidade.ID_cont++;
	}
	
	public int getID(){
		return this.ID;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		if(tempo>0){
			this.tempo = tempo;
		}else{
			//valor default no caso de tempo negativo ou zerado
			this.tempo = 10;
		}
	}
	public Atributos getFatorDano() {
		return fatorDano;
	}
	public void setFatorDano(Atributos fatorDano) {
		this.fatorDano = fatorDano;
	}
	public Atributos getFatorMana() {
		return fatorMana;
	}
	public void setFatorMana(Atributos fatorMana) {
		this.fatorMana = fatorMana;
	}
	
	public int getCustoMP(Player p){
		float mana = 0;
		mana += this.getFatorMana().getForca()*p.getForca();
		mana += this.getFatorMana().getAgilidade()*p.getAgilidade();
		mana += this.getFatorMana().getInteligencia()*p.getInteligencia();
		return (int)(p.getNivel()*Math.ceil(mana));
	}
	
	public int getDano(Player p){
		float dano = 0;
		dano += this.getFatorDano().getForca()*p.getForca();
		dano += this.getFatorDano().getAgilidade()*p.getAgilidade();
		dano += this.getFatorDano().getInteligencia()*p.getInteligencia();
		return (int)(p.getNivel()*Math.ceil(dano));
	}
        
        @Override
        public String toString(){
            return this.getNome();
        }
}