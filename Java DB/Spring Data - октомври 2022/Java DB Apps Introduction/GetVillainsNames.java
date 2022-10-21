import java.sql.*;

public class GetVillainsNames {
    private static final String getVillainsNames =
            "SELECT v.name, COUNT(DISTINCT mv.minion_id) AS minions_count" +
            " FROM villains AS v" +
            " JOIN minions_villains mv on v.id = mv.villain_id" +
            " GROUP BY mv.villain_id" +
            " HAVING minions_count > ?" +
            " ORDER BY minions_count DESC";

    private static final String columnLabelName = "name";
    private static final String columnLabelMinionsCount = "minions_count";

    private static final String printFormat = "%s %d%n";

    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getSQLConnection();

        final PreparedStatement statement = connection.prepareStatement(getVillainsNames);
        statement.setInt(1, 15);

        final ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            final String villainName = resultSet.getString(columnLabelName);
            final int minionsCount = resultSet.getInt(columnLabelMinionsCount);

            System.out.printf(printFormat, villainName, minionsCount);
        }

        connection.close();
    }
}
