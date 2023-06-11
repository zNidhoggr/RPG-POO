package rpg;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Component;

public class GameGUI extends JFrame {
    private JLabel titleLabel;
    private JButton createCharacterButton;
    private JTextArea characterInfoTextArea; // JTextArea para exibir informações do personagem
    private JTextArea gameLogTextArea; // JTextArea para o histórico de eventos do jogo
    private JTextArea enemyInfoTextArea; // JTextArea para exibir informações do inimigo
    private int maxHP; // Pontos de vida do jogador
    private int strength; // Pontos de vida do inimigo
    private int playerHP;
    private int enemyHP = 200;
    private int level;
    private String characterClass;
    private String name;
    
    public GameGUI() {
        super("Jogo RPG");

        titleLabel = new JLabel("Jogo RPG");
        createCharacterButton = new JButton("Criar personagem");
        characterInfoTextArea = new JTextArea(); // JTextArea para exibir informações do personagem
        gameLogTextArea = new JTextArea(); // JTextArea para o histórico de eventos do jogo
        enemyInfoTextArea = new JTextArea(); // JTextArea para exibir informações do inimigo
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Adicionando o título //

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // ocupa a largura completa da linha
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // margem de 10 pixels em todas as direções
        panel.add(titleLabel, gbc);

        // Adicionando o botão "Criar personagem" //

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.add(createCharacterButton, gbc);

        // Adicionando a JTextArea para exibir informações do personagem //

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(50, 5, 5, 5);
        panel.add(new JLabel("Informações do Personagem: "), gbc);

        gbc.gridy = 3;
        gbc.insets = new Insets(5, 5, 5, 5);
        JScrollPane characterScrollPane = new JScrollPane(characterInfoTextArea);
        panel.add(characterScrollPane, gbc);

        // Adicionando a JTextArea para o histórico de eventos do jogo //

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);
        JPanel gameLogPanel = new JPanel(new BorderLayout());
        gameLogPanel.add(new JLabel("Histórico de Eventos: "), BorderLayout.NORTH);
        JScrollPane logScrollPane = new JScrollPane(gameLogTextArea);
        gameLogPanel.add(logScrollPane, BorderLayout.CENTER);
        panel.add(gameLogPanel, gbc);

        // Adicionando as JTextAreas para exibir informações do inimigo //

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);
        JPanel enemyPanel = new JPanel(new BorderLayout());
        enemyPanel.add(new JLabel("Inimigo: "), BorderLayout.NORTH);
        JScrollPane enemyScrollPane = new JScrollPane(enemyInfoTextArea);
        enemyPanel.add(enemyScrollPane, BorderLayout.CENTER);
        panel.add(enemyPanel, gbc);

        // Adicionando botões para permitir que o jogador realize várias ações //

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(10, 0, 10, 10);
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton attackButton = new JButton("Atacar");
        JButton castSpellButton = new JButton("Lançar Feitiço");
        JButton pickupItemButton = new JButton("Pegar Item");
        actionPanel.add(attackButton);
        actionPanel.add(castSpellButton);
        actionPanel.add(pickupItemButton);
        panel.add(actionPanel, gbc);

        getContentPane().add(panel, BorderLayout.CENTER);
                
        // Define as propriedades da janela //
        
        pack();
        setSize(500, 900); // define o tamanho da janela em pixels (largura x altura)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        // Configura o listener do botão "Criar personagem" //
        
        createCharacterButton.addActionListener(event -> {
            // Lógica para criar um novo personagem //
        	name = JOptionPane.showInputDialog(this, "Digite o nome do seu personagem:");
            String[] classes = {"Guerreiro", "Mago", "Arqueiro"};
            int classIndex = JOptionPane.showOptionDialog(this, "Escolha a classe do seu personagem:", "Classe", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, classes, classes[0]);
            characterClass = classes[classIndex];

            int level = 1;
            int maxHP = 0;
            int strength = 0;

            switch (characterClass) {
                case "Guerreiro":
                    maxHP = 130;
                    strength = 15;
                    break;
                case "Mago":
                    maxHP = 100;
                    strength = 10;
                    break;
                case "Arqueiro":
                    maxHP = 110;
                    strength = 12;
                    break;
            }
            
            
            // Mostra uma mensagem confirmando a criação do personagem
            JOptionPane.showMessageDialog(this, "Personagem criado com sucesso!");

            // Habilita os botões de ação agora que o personagem está criado
            attackButton.setEnabled(true);
            castSpellButton.setEnabled(true);
            pickupItemButton.setEnabled(true);

            // Exibe as informações do personagem na JTextArea
            characterInfoTextArea.setText("Nome: " + name + "\nClasse: " + characterClass + "\nNível: " + level + "\nPontos de Vida: " + playerHP + "/" + maxHP + "\nPontos de Magia: 5/5\nInventário: Espada, Poção de Cura x3\n");
            playerHP = maxHP;
        });
        
     // Configura o listener do botão "Atacar" //

        attackButton.addActionListener(event -> {
        	// Verifica se o personagem foi criado //
        	
            if (name == null || characterClass == null) {
                JOptionPane.showMessageDialog(this, "Crie um personagem antes de atacar.");
                return;
            }
            
            // Calcula o dano causado pelo personagem //
        	
            int damage = calcularDanoDoPersonagem(characterClass);
            
            // Mostra uma mensagem com o resultado do ataque //
            
            gameLogTextArea.append(name + " atacou o inimigo e causou "+damage+" pontos de dano!\n");
                
            // Subtrai os pontos de vida do inimigo de acordo com o dano causado //
            
            enemyHP -= damage;
            
            // Atualiza as informações do inimigo na JTextArea //
            
            enemyInfoTextArea.setText("Pontos de Vida: "+enemyHP+"/200\n");
            
            // Verifica se o inimigo foi derrotado //
            
            if (enemyHP <= 0) {
                mostrarMensagemDeFimDeJogo(true);
            }
            
            // Caso contrário, o inimigo ataca o jogador //
            
            else {
                int enemyDamage = calcularDanoDoInimigo();
                
                gameLogTextArea.append("O inimigo te atacou e causou "+enemyDamage+" pontos de dano!\n");
                
                playerHP -= enemyDamage;
                
                characterInfoTextArea.setText("Nome: " + name + "\nClasse: " + characterClass + "\nNível: " + level + "\nPontos de Vida: " + playerHP + "/" + maxHP + "\nPontos de Magia: 5/5\nInventário: Espada, Poção de Cura x3\n");
                
                // Verifica se o jogador foi derrotado //
                
                if (playerHP <= 0) {
                    mostrarMensagemDeFimDeJogo(false);
                }
            }
        });
        
        // Configura o listener do botão "Lançar Feitiço" //
        
        castSpellButton.addActionListener(event -> {
        	// Verifica se o personagem foi criado //
        	
            if (name == null || characterClass == null) {
                JOptionPane.showMessageDialog(this, "Crie um personagem antes de atacar.");
                return;
            }
        	
        	int damage = calcularDanoDoPersonagem(characterClass);
        	
        	// Adiciona uma mensagem ao histórico de eventos do jogo //
        	
        	gameLogTextArea.append("Você lançou um feitiço de bola de fogo e causou "+damage+" pontos de dano!\n");
        	
        	// Subtrai os pontos de vida do inimigo de acordo com o dano causado //

            enemyHP -= damage;
            
            // Atualiza as informações do inimigo na JTextArea //
            
            enemyInfoTextArea.setText("Pontos de Vida: "+enemyHP+"/200\n");
            
            // Verifica se o inimigo foi derrotado //
            
            if (enemyHP <= 0) {
                mostrarMensagemDeFimDeJogo(true);
            }
            
            // Caso contrário, o inimigo ataca o jogador //
            
            else {
                int enemyDamage = calcularDanoDoInimigo();
                
                gameLogTextArea.append("O inimigo te atacou e causou "+enemyDamage+" pontos de dano!\n");
                
                playerHP -= enemyDamage;
                
                characterInfoTextArea.setText("Nome: " + name + "\nClasse: " + characterClass + "\nNível: " + level + "\nPontos de Vida: " + playerHP + "/" + maxHP + "\nPontos de Magia: 5/5\nInventário: Espada, Poção de Cura x3\n");
                
                // Verifica se o jogador foi derrotado //
                
                if (playerHP <= 0) {
                    mostrarMensagemDeFimDeJogo(false);
                }
            }
        });
        
        // Configura o listener do botão "Pegar Item" //
        
        pickupItemButton.addActionListener(event -> {
            // Lógica para pegar um item //
        	
    

        	// Adiciona uma mensagem ao histórico de eventos do jogo
        	gameLogTextArea.append("Você pegou um item: Poção de Cura!\n");
        });
    }

    // Função para calcular o dano causado pelo personagem //

    int calcularDanoDoPersonagem(String characterClass) {
    	    switch (characterClass) {
    	        case "Guerreiro":
    	            maxHP = 130;
    	            strength = 15;
    	            break;
    	        case "Mago":
    	            maxHP = 100;
    	            strength = 10;
    	            break;
    	        case "Arqueiro":
    	            maxHP = 110;
    	            strength = 12;
    	            break;
    	    }
    	    
    	    int forca = strength;
    	    int nivel = 1;
    	    int danoBase = 5;
    	        
    	    return danoBase + (forca * nivel);
    	}
    
    
    // Função para calcular o dano causado pelo inimigo //

    int calcularDanoDoInimigo() {
        int forca = 10;
        int nivel = 1;
        int danoBase = 3;
        
        return danoBase + (forca * nivel);
    }

    // Função para mostrar uma mensagem de vitória ou derrota //

    void mostrarMensagemDeFimDeJogo(boolean vitoria) {
        String mensagem = vitoria ? "Parabéns, você venceu!" : "Você foi derrotado...";
        JOptionPane.showMessageDialog(this, mensagem);
        
        // Desabilita os botões de ação para impedir que o jogador continue jogando //
        
        Component[] components = getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                JPanel panel = (JPanel) component;
                Component[] panelComponents = panel.getComponents();
                for (Component c : panelComponents) {
                    if (c instanceof JButton) {
                        JButton button = (JButton) c;
                        button.setEnabled(false);
                    }
                }
            }
        }
    }
    
    
public static void main(String[] args) {
    new GameGUI();
}
}