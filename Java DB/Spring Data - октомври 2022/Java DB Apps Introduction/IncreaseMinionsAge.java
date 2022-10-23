import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IncreaseMinionsAge {

    private static final String UPDATE_MINION_AGE_BY_ID = "UPDATE minions SET age = age + 1, name = LOWER(name) WHERE id = ?";

    private static final String INPUT_USER_FORMAT = "Please enter the IDs of the minions you want to change (separated by a space only!): ";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        List<Integer> minionsIds;

        //Read the minion IDs + save them into list
        System.out.print(INPUT_USER_FORMAT);
        final String[] inputIds = scanner.nextLine().split(" ");

        minionsIds = Arrays.stream(inputIds)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //Connect to DB
        final Connection connection = Utils.getSQLConnection();

        //Iter every minion ID from the input and update the age of the minion, if the ID is valid
        for (Integer minionId : minionsIds) {
            //Prepare statement + execute statement
            final PreparedStatement ageUpdateStatement = connection.prepareStatement(UPDATE_MINION_AGE_BY_ID);

            ageUpdateStatement.setInt(1, minionId);

            ageUpdateStatement.executeUpdate();
        }

        //Print the table minions after the update (FUN WAY TO DO IT :))
        DBTablePrinter.printTable(connection, "minions");

        //Close the connection to the DB
        connection.close();

    }
}
