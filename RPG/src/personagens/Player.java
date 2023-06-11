package personagens;

import itens.Item;

public class Player {
	private String nome;
	private int nivel;
	private float HP, MP;
    private Classe classe;
	private int ID;
	private static int ID_cont = 1;
	
    
	public Player(String nome, Classe.Tipo classe){
		this.setNome(nome);
		this.setNivel(1);
		this.setID();
                
		if(classe == Classe.Tipo.GUERREIRO){
			this.classe = new Guerreiro();
		}else if(classe == Classe.Tipo.ARQUEIRO){
			this.classe = new Arqueiro();
		}else if(classe == Classe.Tipo.MAGO){
			this.classe = new Mago();
		}else if(classe == Classe.Tipo.ENEMY){
			this.classe = new Enemy();
        }
		
		this.setHP(this.getMaxHP());
		this.setMP(this.getMaxMP());
		
		this.setPE(0);
                
	}
        
       
	
	
	public void setNome(String nome){
		if(!nome.trim().isEmpty()){
			this.nome = nome;
		}else{
			this.nome = Double.toString(Math.random());
		}
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setHP(float HP){
		if(HP < 0){
			this.HP = 0;
		}else if(HP > this.getMaxHP()){
			this.HP = this.getMaxHP();
		}else{
			this.HP = HP;
		}
	}
	
	public int getHP(){
		return (int)Math.ceil(this.HP);
	}
	
	public void setMP(float MP){
		if(MP < 0){
			this.MP = 0;
		}else if(MP > this.getMaxMP()){
			this.MP = this.getMaxMP();
		}else{
			this.MP = MP;
		}
	}
	
	public int getMP(){
		return (int)Math.ceil(this.MP);
	}
	
	public int getMaxHP(){
		return this.getNivel()*this.getForca()+
				this.getNivel()*this.getAgilidade()/2;
	}
	
	public int getMaxMP(){
		return this.getNivel()*this.getInteligencia()+
				this.getNivel()*this.getAgilidade()/3;
	}
	
	private void setNivel(int nivel){
		if(nivel < 1){
			this.nivel = 1;
		}else{
			this.nivel = nivel;
		}		
	}
	
	public void sobeParaNivel(int nivel){
		this.setNivel(nivel);
	}
	
	public int getNivel(){
		return this.nivel;
	}
	
	public int getPE(){
		return this.PE;
	}
	
	private void setPE(int PE){
		if(PE < 0){
			this.PE = 0;
		}else{
			this.PE = PE;
		}
	}
	
	public int getForca(){
		return this.getNivel()*this.getClasse().getForca();
	}
	
	public int getAgilidade(){
		return this.getNivel()*this.getClasse().getAgilidade();
	}
	
	public int getInteligencia(){
		return this.getNivel()*this.getClasse().getInteligencia();
	}
	
	public void recuperaHP(){
		this.setHP((float)(this.HP+0.1*this.getForca()+this.getNivel()*0.1));
	}
	
	public void recuperaMP(){
		this.setMP((float)(this.MP+0.1*this.getInteligencia()+this.getNivel()*0.05));
	}
	
	//metodo verifica se o Player sobe de nivel
	//com os pontos de experiencia ganhados
	//retorna true se subir de nivel
	public boolean ganhaExpSobeNivel(int pontos){
		boolean retorno = false;
		int excedente = 0;
		int pexp;
		
		//se pontos nao forem negativos, ok
		if(pontos > 0){
			pexp = this.getPE();
			pexp += pontos; //faco a soma aos pontos atuais
			if(pexp >= this.getNivel()*25){
				//se tiver pontos necessarios pra subir de nivel,
				//calculo o excedente e aumento nivel+1
				excedente = pexp - (this.getNivel()*25);
				this.setNivel(this.getNivel()+1);
				retorno = true;
			}else{
				//senao o excedente sera igual aos pontos ganhos
				//somados aos ja existentes
				excedente = pexp;
			}
			//no final, o excedente fica nos pontos de experiencia
			//para subir para o proximo nivel
			this.setPE(excedente);
		}
		//retorna true se subir de nivel
		return retorno;
	}
	
	public Classe getClasse(){
		return this.classe;
	}
	
	public boolean ataca(Habilidade hab, Player inimigo){
		boolean retorno = false;
		int dano = hab.getDano(this);
		int custoMagia = hab.getCustoMP(this);
		if(custoMagia <= this.getMP()){
			this.setMP(this.getMP()-custoMagia);
			inimigo.tomaDano(dano);
			retorno = true;
		}
		return retorno;
	}
        
        public boolean ataca(Habilidade hab, Equipe inimigos){
            for(Player inimigo: inimigos.getEquipe()){
		ataca(hab,inimigo);
            }
            return true;
	}
	
	
	private void tomaDano(int dano){
		this.setHP(this.getHP()-dano);
	}

	public int getID() {
		return ID;
	}

	public void setID() {
		this.ID = Player.ID_cont++;
	}
	
	@Override
	public String toString(){
		return this.getNome();
	}
}