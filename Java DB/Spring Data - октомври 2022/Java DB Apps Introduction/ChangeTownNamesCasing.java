import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeTownNamesCasing {

    private static final String UPDATE_TOWN_CASING =
            "UPDATE towns t" +
            " SET t.name = UPPER(t.name)" +
            " WHERE t.country = ?";

    private static final String GET_TOWNS_BY_COUNTRY = "SELECT t.name FROM towns t WHERE country = ?";

    private static final String COUNT_OF_TOWNS_AFFECTED = "%d town names were affected.%n";

    private static final String NO_TOWNS_NAME_AFFECTED = "No town names were affected.";

    private static final String COUNTRY_INPUT_MESSAGE = "Enter country name: ";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        //save town name from the input

        System.out.print(COUNTRY_INPUT_MESSAGE);
        String countyName = scanner.nextLine();

        //connect to the database

        final Connection connection = Utils.getSQLConnection();

        //update all towns to uppercase with the given country name from the input

        final PreparedStatement townUpdateStatement = connection.prepareStatement(UPDATE_TOWN_CASING);

        townUpdateStatement.setString(1, countyName);

        townUpdateStatement.executeUpdate();

        //save all towns with the given country + print the output

        List<String> towns = new ArrayList<>();

        final PreparedStatement townsStatement = connection.prepareStatement(GET_TOWNS_BY_COUNTRY);

        townsStatement.setString(1, countyName);

        final ResultSet townsSet = townsStatement.executeQuery();

        while (townsSet.next()) {
            towns.add(townsSet.getString("name"));
        }

        outputTowns(towns);

        //close the connection to the database

        connection.close();

    }

    private static void outputTowns(List<String> towns) {
        if (towns.isEmpty()) {
            System.out.println(NO_TOWNS_NAME_AFFECTED);
        } else {
            System.out.printf(COUNT_OF_TOWNS_AFFECTED, towns.size());
            System.out.println("[" + String.join(", ", towns) + "]");
        }
    }
}
