import java.sql.*;
import java.util.Scanner;

public class IncreaseAgeStoredProcedure {

    private static final String CALL_PROCEDURE = "CALL usp_get_older(?)";

    private static final String GET_MINION_INFO_BY_ID = "SELECT name, age FROM minions WHERE id = ?";

    private static final String INPUT_MESSAGE_FORMAT = "Enter the minion ID: ";

    private static final String INVALID_MINION_ID_FORMAT = "Invalid minion ID!";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        //Get ID from the console as an input
        System.out.print(INPUT_MESSAGE_FORMAT);
        int minionId = scanner.nextInt();

        //Connect to the DB
        Connection connection = Utils.getSQLConnection();

        //Prepare the call + execute the call
        CallableStatement callableStatement = connection.prepareCall(CALL_PROCEDURE);

        callableStatement.setInt(1, minionId);

        callableStatement.executeUpdate();

        //Prepare the GET_MINION_INFO_BY_ID statement + execute
        PreparedStatement minionStatement = connection.prepareStatement(GET_MINION_INFO_BY_ID);

        minionStatement.setInt(1, minionId);

        ResultSet minionInfo = minionStatement.executeQuery();

        if (!minionInfo.next()) {
            System.out.println(INVALID_MINION_ID_FORMAT);
            return;
        }

        minionInfo.next();

        //Save the information about the minion
        String minionName = minionInfo.getString("name");
        int minionAge = minionInfo.getInt("age");

        //Print the result
        System.out.println(minionName + " " + minionAge);

        //Close the connection to the DB
        connection.close();

    }
}
