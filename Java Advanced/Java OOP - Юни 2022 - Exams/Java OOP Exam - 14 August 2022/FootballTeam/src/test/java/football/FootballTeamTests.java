package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {
    private FootballTeam footballTeam;
    private Footballer footballerOne;
    private Footballer footballerTwo;
    private Footballer footballerThree;

    @Before
    public void setUp() {
        footballTeam = new FootballTeam("PSG", 2);
        footballerOne = new Footballer("Kalin");
        footballerTwo = new Footballer("Veselin");
        footballerThree = new Footballer("Martin");
        footballTeam.addFootballer(footballerOne);
        footballTeam.addFootballer(footballerTwo);
    }

    @Test
    public void test_getName_ReturnTheNameOfTheFootballTeam() {
        Assert.assertTrue(footballTeam.getName().equals("PSG"));
    }

    @Test(expected = NullPointerException.class)
    public void test_setName_ShouldThrowException_BecauseTheFootballTeamNameIsNullOrWhitespace() {
        FootballTeam footballTeam1 = new FootballTeam(null, 2);
        FootballTeam footballTeam2 = new FootballTeam("         ", 3);
    }

    @Test
    public void test_getVacantPositions_ReturnTheVacantPositionsOfTheFootballTeam() {
        Assert.assertEquals(2, footballTeam.getVacantPositions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_setVacantPositions_ShouldThrowException_BecauseTheGivenParameterIsNegativeNumber() {
        FootballTeam footballTeam = new FootballTeam("Arsenal", -5);
    }

    @Test
    public void test_getCount_ReturnTheCountOfThePlayersInTheFootballTeam() {
        Assert.assertEquals(2, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addFootballer_ShouldThrowException_BecauseTheCountOfThePLayersAndTheVacantPositionsIsEqual() {
        footballTeam.addFootballer(footballerThree);
    }

    @Test
    public void test_addFootballer_AddFootballerToTheFootballTeam() {
        FootballTeam footballTeam = new FootballTeam("Arsenal", 2);
        Footballer footballer = new Footballer("Pesho");
        footballTeam.addFootballer(footballer);
        Assert.assertEquals(1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_removeFootballer_ShouldThrowException_BecauseTheGivenFootballerNameIsNotExistingInTheFootballTeam() {
        footballTeam.removeFootballer("Kaloqn");
    }

    @Test
    public void test_removeFootballer_SuccessfullyFindFootballerWithTheGivenName_AndRemoveThePlayerFromTheTeam() {
        footballTeam.removeFootballer("Kalin");
        Assert.assertEquals(1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_footballerForSale_ShouldThrowException_BecauseTheGivenFootballerNameIsNotExistingInTheFootballTeam() {
        footballTeam.footballerForSale("Kaloqn");
    }

    @Test
    public void test_footballerForSale_SuccessfullyFindFootballerWithTheGivenName_AndSetHisActiveStatusToFalse_SuccessfullySold() {
        footballTeam.footballerForSale("Kalin");
        Assert.assertFalse(footballerOne.isActive());
    }
}
