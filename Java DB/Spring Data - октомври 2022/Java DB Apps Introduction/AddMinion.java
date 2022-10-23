import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AddMinion {

    private static final String GET_TOWN_BY_NAME = "SELECT t.id FROM towns t WHERE t.name = ?";

    private static final String GET_VILLAIN_BY_NAME = "SELECT v.id FROM villains v WHERE v.name = ?";

    private static final String INSERT_INTO_TOWNS = "INSERT INTO towns(name) VALUES(?)";

    private static final String INSERT_VILLAIN = "INSERT INTO villains(name, evilness_factor) VALUES(?,?)";

    private static final String EVILNESS_FACTOR = "evil";

    private static final String INSERT_INTO_MINIONS = "INSERT INTO minions(name, age, town_id) values(?,?,?)";

    private static final String GET_LAST_MINION = "SELECT m.id FROM minions m  ORDER BY m.id DESC LIMIT 1";

    private static final String INSERT_INTO_MINIONS_VILLAINS = "INSERT INTO minions_villains(minion_id, villain_id) VALUES(?,?)";

    private static final String RESULT_FORMAT = "Successfully added %s to be minion Of %s%n";

    private static final String TOWN_ADDED_FORMAT = "Town %s was added to the database.%n";

    private static final String VILLAIN_ADDED_FORMAT = "Villain %s was added to the database.%n";

    private static final String COLUMN_LABEL_ID = "id";

    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getSQLConnection();

        final Scanner scanner = new Scanner(System.in);

        final String[] minionInfo = scanner.nextLine().split(" ");

        final String minionName = minionInfo[1];
        final int minionAge = Integer.parseInt(minionInfo[2]);
        final String minionTown = minionInfo[3];

        final String villainName = scanner.nextLine().split(" ")[1];

        final int townId = getId(connection,
                List.of(minionTown),
                GET_TOWN_BY_NAME,
                INSERT_INTO_TOWNS,
                TOWN_ADDED_FORMAT);

        final int villainId = getId(connection,
                List.of(villainName, EVILNESS_FACTOR),
                GET_VILLAIN_BY_NAME,
                INSERT_VILLAIN,
                VILLAIN_ADDED_FORMAT);

        final PreparedStatement insertMinionStatement = connection.prepareStatement(INSERT_INTO_MINIONS);

        insertMinionStatement.setString(1, minionName);
        insertMinionStatement.setInt(2, minionAge);
        insertMinionStatement.setInt(3, townId);

        insertMinionStatement.executeUpdate();

        final PreparedStatement lastMinion = connection.prepareStatement(GET_LAST_MINION);

        final ResultSet lastMinionResultSet = lastMinion.executeQuery();

        lastMinionResultSet.next();

        final int lastMinionId = lastMinionResultSet.getInt(COLUMN_LABEL_ID);

        final PreparedStatement insertIntoMinionsVillains = connection.prepareStatement(INSERT_INTO_MINIONS_VILLAINS);

        insertIntoMinionsVillains.setInt(1, lastMinionId);
        insertIntoMinionsVillains.setInt(2, villainId);

        insertIntoMinionsVillains.executeUpdate();

        System.out.printf(RESULT_FORMAT, minionName, villainName);

        connection.close();

    }

    private static int getId(Connection connection,
                             List<String> arguments,
                             String selectQuery,
                             String insertQuery,
                             String printFormat) throws SQLException {

        final String name = arguments.get(0);

        final PreparedStatement selectStatement = connection.prepareStatement(selectQuery);

        selectStatement.setString(1, name);

        final ResultSet resultSet = selectStatement.executeQuery();

        if (!resultSet.next()) {
            final PreparedStatement insertStatement = connection.prepareStatement(insertQuery);

            for (int index = 1; index <= arguments.size(); index++) {
                insertStatement.setString(index, arguments.get(index - 1));
            }

            insertStatement.executeUpdate();

            final ResultSet newResultSet = selectStatement.executeQuery();

            newResultSet.next();

            int id = newResultSet.getInt(COLUMN_LABEL_ID);

            System.out.printf(printFormat, name);

            return id;
        }

        return resultSet.getInt(COLUMN_LABEL_ID);
    }
}
