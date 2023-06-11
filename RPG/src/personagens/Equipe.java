package personagens;

import personagens.Player;
import java.util.ArrayList;

public class Equipe {
	private ArrayList<Player> grupo;
	
	public Equipe(){
		grupo = new ArrayList<Player>();
	}
	
	public boolean adicionaPlayer(Player p){
		boolean retorno = false;
		if(p != null){
			grupo.add(p);
			retorno = true;
		}
		return retorno;
	}
	
	public int contaConscientes(){
		int retorno = 0;
		for(Player p: grupo){
			if(p.getHP() > 0){
				retorno++;
			}
		}
		return retorno;
	}
	
	// public void ganharExperiencia(Equipe inimigos){
		
	
	
	public final ArrayList<Player> getEquipe(){
		return grupo;
	}
	
	public Player proximoQueAtaca(){
		Player atacante = null;
		for(Player p: grupo){
			if(p.getHP() > 0){
				atacante = p;
			}
		}
		return atacante;
	}
	
	
	public Player getPlayer(int id){
		Player retorno = null;
                try{
                    for(Player p: grupo){
                            if(p.getID() == id){
                                    retorno = p;
                            }
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println(e.getMessage());
                }
		return retorno;
	}
	
	@Override
	public String toString(){
		String retorno = "";
		retorno += "--------------------------------------------------------\n";
		retorno += String.format("%1$-3s %2$-18s %3$10s %4$6s %5$4s %6$4s %7$4s %8$7s\n","Id","Nome", "Classe","Nível","HP","MP","PE","Espera");

		
		return retorno;
	}
}