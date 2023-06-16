package main;

import exceptions.NomeJaExisteException;
import repositorios.ICharacterRepositorio;
import repositorios.CharacterRepositorioArmazem;
import interfaces.Job;
import personagem.*;
import personagem.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RPGGame {
    private List<Character> characters;
    private Character enemy;
    private ICharacterRepositorio characterRepositorio;

    public RPGGame() {
        characters = new ArrayList<>();
        characterRepositorio = new CharacterRepositorioArmazem();
        enemy = new Character("Inimigo", new Mago(10, 10, 10)) {
            @Override
            public void attack(Character target) {
                int damage = 20;
                target.takeDamage(damage);
                System.out.println("Inimigo causou " + damage + " de dano.\n");
            }
        };
    }
    
    private static void printJobOptions() {
        System.out.println("Mago");
        System.out.println("   Descrição: " + new Mago(0, 0, 0).getDescription() + "\n   Atributos: Agilidade, Força, Inteligência");
        System.out.println("Guerreiro");
        System.out.println("   Descrição: " + new Guerreiro(0, 0, 0).getDescription() + "\n   Atributos: Agilidade, Força");
        System.out.println("Arqueiro");
        System.out.println("   Descrição: " + new Arqueiro(0, 0, 0).getDescription() + "\n   Atributos: Agilidade\n");
    }

    public void createCharacter(String name, Job job) throws NomeJaExisteException {
    	
    	Character existingCharacter = characterRepositorio.findCharacterByName(name);
        if (existingCharacter != null) {
            throw new NomeJaExisteException("Nome já existe. Digite outro nome.\n");
        }

        Character newCharacter;
        if (job instanceof Mago) {
            int intelligence = ((Mago) job).getIntelligence();

            newCharacter = new Character(name, job) {
                @Override
                public void attack(Character target) {
                    int damage = intelligence * 2;
                    target.takeDamage(damage);
                    System.out.println("Player causou " + damage + " de dano.");
                }
            };
        } else if (job instanceof Guerreiro) {
            newCharacter = new Character(name, job) {
                @Override
                public void attack(Character target) {
                    int damage = ((Guerreiro) job).getStrength() * 2;
                    target.takeDamage(damage);
                    System.out.println("Player causou " + damage + " de dano.");
                }
            };
        } else {
            newCharacter = new Character(name, job) {
                @Override
                public void attack(Character target) {
                    int damage = ((Arqueiro) job).getAgility() * 2;
                    target.takeDamage(damage);
                    System.out.println("Player causou " + damage + " de dano.");
                }
            };
        }

        characterRepositorio.saveCharacter(newCharacter);
    }
    

    public void showCharacterData(Character character) {
       
        System.out.println("Nome: " + character.getName());
        System.out.println("Vida: " + character.getHealth());
        System.out.println("Job: " + character.getJob().getClass().getSimpleName());
        
    }

    public void showEnemyData() {
        System.out.println("Inimigo:");
        System.out.println("Vida: " + enemy.getHealth());
        System.out.println("Dano: " + enemy.getJob().getIntelligence());
    }
    
    public void attackEnemy(Character character, int damage) {
        enemy.takeDamage(damage);
        System.out.println(character.getName() + " causou " + damage + " de dano.");
    }

    public void battle(String playerName) {
        Character player = null;
        for (Character character : characters) {
            if (character.getName().equals(playerName)) {
                player = character;
                break;
            }
        }
        if (player != null) {
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
        	player.attack(enemy);
            enemy.attack(player);
        }
            if (enemy.getHealth() > 0) {
                player.attack(enemy);
            }
            if (enemy.getHealth() > 0) {
                enemy.attack(player);
            }
            if (player.getHealth() > 0) {
                System.out.println("Você venceu a batalha!\n");
            } else {
                System.out.println("Você foi derrotado!");
            }
        }

        
        else {
            System.out.println("Personagem não encontrado.");
        }
    }

    public static void main(String[] args) {
        RPGGame game = new RPGGame();
        RPGFacade facade = new RPGFacade(game);

        Scanner scanner = new Scanner(System.in);
        String name;
        String job;
        int choice;

        while (true) {
            System.out.println("||========== RPG Game ============||");
            System.out.println("||                                ||");
            System.out.println("||1. Criar personagem             ||");
            System.out.println("||2. Verificar dados do personagem||");
            System.out.println("||3. Verificar dados do inimigo   ||");
            System.out.println("||4. Batalhar                     ||");
            System.out.println("||5. Sair                         ||");
            System.out.println("||================================||\n");

            System.out.print("Escolha uma opção:\n");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Digite o nome do personagem:\n");
                    name = scanner.next();
                    
                    System.out.print("Escolha um job (Mago, Guerreiro, Arqueiro):\n");
                    printJobOptions();
                    job = scanner.next();

                    try {
                        facade.createCharacter(name, job);
                        System.out.println("\nPersonagem criado com sucesso!");
                    } catch (NomeJaExisteException ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;
                case 2:
                	System.out.print("Digite o nome do personagem: ");
                	String characterName = scanner.next();
                	facade.showCharacterData(characterName);
                    break;
                case 3:
                    facade.showEnemyData();
                    break;
                case 4:
                    facade.battle();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

	public List<Character> getCharacters() {
		
		return characters;
	}
}