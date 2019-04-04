package project.generators;

import project.model.Country;
import project.model.Team;

import java.util.List;
import java.util.Random;

public class DataGenerator {

    // --------------------------------------------------------------
    // ------------------- country generator ------------------------
    // --------------------------------------------------------------
    public List<Country> generateCountries() {
        return List.of(
                Country.builder().name("POLAND").capital("WARSAW").build(),
                Country.builder().name("GERMANY").capital("BERLIN").build(),
                Country.builder().name("UK").capital("LONDON").build()
        );
    }

    // --------------------------------------------------------------
    // ------------------- team generator ---------------------------
    // --------------------------------------------------------------
    // kiedy bedziesz mial repozytoria to wtedy dopiero dokonczymy generacje
    public List<Team> generateTeams() {
        return List.of(
                Team.builder()
                        .name(generateString(5))
                        .points(generateInt(0, 100))
                        .build()
        );
    }

    // ---------------------------------------------------------------
    // ------------------- generating methods ------------------------
    // ---------------------------------------------------------------
    private String generateString(int howManyChars) {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < howManyChars; i++) {
            sb.append((char)(rnd.nextInt('Z' - 'A' + 1) + 'A'));
        }
        return sb.toString();
    }

    private int generateInt(int minRange, int maxRange) {
        minRange = Integer.min(minRange, maxRange);
        maxRange = Integer.max(minRange, maxRange);
        return new Random().nextInt(maxRange - minRange + 1) + minRange;
    }
}
