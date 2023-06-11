package rpg;

import personagens.Enemy;

public class GameFacade {
    private GameController controller;
    private GameConsole console;
    private GameGUI gui;

    public GameFacade() {
        controller = new GameController();
        console = new GameConsole();
        gui = new GameGUI();
    }

    public void createNewGame(String playerName) {
        controller.createPlayer(playerName);
    }

    public void loadGame(String playerName) {
        controller.loadPlayer(playerName);
    }

    public void saveGame() {
        controller.savePlayer();
    }

    public void startBattle(Enemy enemy) {
        controller.startBattle(enemy);
    }

    public void manageItems() {
        // Gerencia os itens obtidos após a batalha
    }

    public void updateExperience() {
        // Atualiza a experiência do jogador
    }
}
