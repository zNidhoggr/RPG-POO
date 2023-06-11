package principal;

import personagens.*;

public class Luta{
	Equipe aliados;
    Equipe inimigos;
    Player atacante;
    String textoFase;
	boolean vezAliados;
	boolean fim;
	Clip clip;
	static int turno = 0;
    List<String> fases;
    Iterator<String> fase;
        
	
	public Luta(){
		fim = false;
                aliados = new Equipe();
                fases = new LinkedList<>();
                fase = fases.iterator();
	}
        
        public Equipe getAliados(){
            return this.aliados;
        }
        
        
        
        public Equipe quemJoga(){
            if(vezAliados){
                return this.aliados;
            }
            return this.inimigos;
        }
        
        public Equipe quemEhAtacado(){
            if(vezAliados){
                return this.inimigos;
            }
            return this.aliados;
        }
        
        public Equipe getInimigos() {
            return this.inimigos;
        }
        
        public Classe.Tipo[] getTipos(){
            return Classe.Tipo.values();
        }
	
	 
        public String getTextoFase() {
            return textoFase;
        }

        public void setTextoFase(String textoFase) {
            this.textoFase = textoFase;
        }
        
        public void carregaFases(){
            Path arquivo = Paths.get("game.txt");
            List<String> fases_temp = new LinkedList<>();
            BufferedReader buf_fases;
            String linha;
            if(Files.exists(arquivo)){
                try {
                        buf_fases = Files.newBufferedReader(arquivo);
                        while((linha = buf_fases.readLine()) != null){
                            fases_temp.add(linha);
                        } 
                }catch (IOException ex) {
                    Logger.getLogger(Luta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            fases = fases_temp;
            fase = fases.iterator();
        }
        
        public boolean acabouTudo(){
            return (fase == null);
        }
                
	
	private Classe.Tipo selecionaTipo(String tipo){
		Classe.Tipo retorno = null;
		switch(tipo){
			case "monstro":
				retorno = Classe.Tipo.MONSTRO;
			break;
			case "mago":
				retorno = Classe.Tipo.MAGO;
			break;
			case "arqueiro":
				retorno = Classe.Tipo.ARQUEIRO;
			break;
			case "guerreiro":
				retorno = Classe.Tipo.GUERREIRO;
			break;
                        case "anao":
				retorno = Classe.Tipo.ANAO;
			break;
		}
		return retorno;
	}
        
        public void adicionaAliado(String nome, Classe.Tipo tipo){
                    if(!nome.trim().isEmpty() && tipo != null){
                        Player p = new Player(nome, tipo);
			aliados.adicionaPlayer(p);
                    }
		}
        
        public boolean rodadaAcabou(){
            return !(aliados.contaConscientes() > 0 && inimigos.contaConscientes() > 0 && !fim);
        }

        public void terminar(){
            this.fim = true;
        }
        
	
	public void print(String p){
		System.out.println(p);
	}
        
        public Player getAtacante(){
            return atacante;
        }
		
	public Player escolheAtacante(){
		atacante = null;
		Player aliado, inimigo;
		int sorte = (int)(Math.random()*100);
		sorte = sorte%2;
		aliado = aliados.proximoQueAtaca();
		inimigo = inimigos.proximoQueAtaca();
		
		if(aliado != null && inimigo != null){
			if(sorte == 0){
				atacante = aliado;
				vezAliados = true;
			}else{
				atacante = inimigo;
				vezAliados = false;
			}
		}else if(inimigo == null){
			atacante = aliado;
			vezAliados = true;
		}else if(aliado == null){
			atacante = inimigo;
			vezAliados = false;
		}
		
		return atacante;
	}

}