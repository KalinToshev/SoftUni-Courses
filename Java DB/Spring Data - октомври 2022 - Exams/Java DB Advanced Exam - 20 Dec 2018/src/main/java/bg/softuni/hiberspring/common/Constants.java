package bg.softuni.hiberspring.common;

public enum Constants {
    ;

    public final static String PATH_TO_FILES = System.getProperty("user.dir") + "/src/main/resources/files/";

    public final static String INCORRECT_DATA_MESSAGE = "Error: Invalid Data!";

    public final static String SUCCESSFUL_IMPORT_MESSAGE = "Successfully imported %s %s.";

    public final static String PRODUCTIVE_EMPLOYEE_OUTPUR_FORMAT = "Name: %s%n" +
                                                                   "Position: %s%n" +
                                                                   "Card Number: %s%n" +
                                                                   "-------------------------%n";
}
