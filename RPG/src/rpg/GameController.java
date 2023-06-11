package rpg;

import itens.Item;
import personagens.Enemy;
import personagens.Player;

public class GameController {
    private Player player;
    private PlayerRepository repository;

    public void createPlayer(String name) {
        // Cria um novo jogador com o nome especificado
        player = new Player();
        player.setName(name);
        repository.create(player);
    }

    public void loadPlayer(String name) {
        // Carrega o jogador pelo nome
        player = repository.read(name);
    }

    public void savePlayer() {
        // Salva o jogador no banco de dados ou arquivo
        repository.update(player);
    }

    public void startBattle(Enemy enemy) {
        // Inicia uma batalha contra o inimigo
        while (player.getHealthPoints() > 0 && enemy.getHealthPoints() > 0) {
            player.attack(enemy);
            enemy.attack(player);
        }
        if (player.getHealthPoints() <= 0) {
            // O jogador perdeu a batalha
        } else {
            // O jogador ganhou a batalha
            int exp = calculateExperience(enemy);
            player.gainExperience(exp);
            Item item = generateItem(enemy);
            player.addItem(item);
        }
    }

    private int calculateExperience(Enemy enemy) {
        // Calcula a experiência que o jogador ganhou após derrotar o inimigo
        return 0;
    }

    private Item generateItem(Enemy enemy) {
        // Gera um item aleatório após derrotar o inimigo
        return null;
    }
}