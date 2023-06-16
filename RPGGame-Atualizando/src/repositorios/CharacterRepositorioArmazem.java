package repositorios;

import java.util.ArrayList;
import java.util.List;

import personagem.Character;

public class CharacterRepositorioArmazem implements ICharacterRepositorio {
    private List<Character> characters;

    public CharacterRepositorioArmazem() {
        characters = new ArrayList<>();
    }

    
    public void saveCharacter(Character character) {
        characters.add(character);
    }

    
    public Character findCharacterByName(String name) {
        for (Character character : characters) {
            if (character.getName().equals(name)) {
                return character;
            }
        }
        return null;
    }

    
    public List<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }
}