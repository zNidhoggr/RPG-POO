package rpg;

import personagens.Enemy;

public class Game {
    public static void main(String[] args) {
        GameFacade facade = new GameFacade();

        // Exemplo de interação pelo console
        facade.createNewGame("Player1");
        facade.startBattle(new Enemy());
        facade.saveGame();
        facade.loadGame("Player1");
        facade.startBattle(new Enemy());

        // Exemplo de interação pela interface gráfica
        facade.manageItems();
        facade.updateExperience();
    }
}
