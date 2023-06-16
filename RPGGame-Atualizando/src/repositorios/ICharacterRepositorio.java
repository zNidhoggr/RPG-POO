package repositorios;

import java.util.List;

import personagem.Character;

public interface ICharacterRepositorio {
    void saveCharacter(Character character);
    Character findCharacterByName(String name);
    List<Character> getAllCharacters();
}