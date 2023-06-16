package personagem;

import java.util.Scanner;

import exceptions.NomeJaExisteException;
import interfaces.Job;
import main.RPGGame;

 public class RPGFacade {
    private RPGGame game;
    private Scanner scanner;

    public RPGFacade(RPGGame game) {
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    public void createCharacter(String name, String job) throws NomeJaExisteException {
        Job selectedJob;

        switch (job.toLowerCase()) {
            case "mago":
                selectedJob = new Mago(5, 3, 12);
                break;
            case "guerreiro":
                selectedJob = new Guerreiro(4, 15, 3);
                break;
            case "arqueiro":
                selectedJob = new Arqueiro(14, 4, 5);
                break;
            default:
                throw new IllegalArgumentException("Job inválido.");
        }

        game.createCharacter(name, selectedJob);
    }

    public void showCharacterData() {
        System.out.print("Digite o nome do personagem: ");
        String name = scanner.next();

        for (Character character : game.getCharacters()) {
            if (character.getName().equals(name)) {
                game.showCharacterData(character);
                return;
            }
        }

        System.out.println("Personagem não encontrado.");
    }

    public void showEnemyData() {
        game.showEnemyData();
    }

    public void battle() {
        System.out.print("Digite o nome do personagem: ");
        String name = scanner.next();
        

        for (Character character : game.getCharacters()) {
            if (character.getName().equals(name)) {
            	int damage = character.getMainAttribute() * 2;
                game.attackEnemy(character, damage);
                game.battle(name);
                return;
            }
        }

        System.out.println("Personagem não encontrado.");
    }
}