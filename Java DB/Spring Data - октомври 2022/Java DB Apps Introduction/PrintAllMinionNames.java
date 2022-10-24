import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;

public class PrintAllMinionNames {

    private static final String GET_ALL_MINIONS = "SELECT * FROM minions";

    public static void main(String[] args) throws SQLException {

        //Connect to the DB
        final Connection connection = Utils.getSQLConnection();

        //Prepare + execute the statement
        final PreparedStatement getMinionsStatement = connection.prepareStatement(GET_ALL_MINIONS);

        final ResultSet minionsSet = getMinionsStatement.executeQuery();

        //Save minions names to the ArrayDeque
        final ArrayDeque<String> minionsNames = new ArrayDeque<>();

        while (minionsSet.next()) {

            minionsNames.offer(minionsSet.getString("name"));

        }

        //Print minions names in the given format
        while (minionsNames.size() > 2) {

            System.out.println(minionsNames.pollFirst());

            System.out.println(minionsNames.pollLast());

        }

        while (!minionsNames.isEmpty()) {
            System.out.println(minionsNames.poll());
        }

        //Close connection to the DB
        connection.close();

    }
}
