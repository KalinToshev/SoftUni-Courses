import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        Map<String, Trainer> trainerList = new LinkedHashMap<>();

        String inputLines;
        while (!"Tournament".equals(inputLines = scanner.nextLine())) {
            //{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}
            String trainerName = inputLines.split("\\s+")[0];
            String pokemonName = inputLines.split("\\s+")[1];
            String pokemonElement = inputLines.split("\\s+")[2];
            int pokemonHealth = Integer.parseInt(inputLines.split("\\s+")[3]);

            trainerList.putIfAbsent(trainerName, new Trainer(trainerName));
            Trainer singleTrainer = trainerList.get(trainerName);
            singleTrainer.addPokemon(new Pokemon(pokemonName, pokemonElement, pokemonHealth));
        }

        String element;
        while (!"End".equals(element = scanner.nextLine())){
            String finalElement = element;
            trainerList.values().forEach(trainer -> trainer.applyCommand(finalElement));
        }
        trainerList.values().stream().sorted(Comparator.comparing(Trainer::getBadges).reversed()).forEach(System.out::println);
    }
}
