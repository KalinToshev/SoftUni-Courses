package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS HeroRepository
    private Hero heroOne;
    private Hero heroTwo;
    private Hero heroThree;
    private HeroRepository repo;
    private HeroRepository testRepo;

    @Before
    public void setUp() {
        repo = new HeroRepository();
        testRepo = new HeroRepository();
        heroOne = new Hero("Калин", 10);
        heroTwo = new Hero("Мартин", 12);
        heroThree = new Hero("Влади", 13);
        repo.create(heroOne);
        repo.create(heroTwo);
    }

    @Test
    public void testToReturnTheNumberOfHeroesFromTheCollection() {
        Assert.assertEquals(2, repo.getCount());
    }

    @Test
    public void testToSuccessfullyAddTheHeroToTheCollection() {
        repo.create(heroThree);
        Assert.assertTrue(repo.getCount() == 3);
    }

    @Test(expected = NullPointerException.class)
    public void testForPassingANullHeroToTheCreateMethod() {
        repo.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForPassingAAlreadyExistingHeroToTheCreateMethod() {
        repo.create(heroOne);
    }

    @Test(expected = NullPointerException.class)
    public void testForPassingANullHeroToTheRemoveMethod() {
        repo.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testForPassingAnEmptySpaceAsAHeroToTheRemoveMethod() {
        repo.remove("    ");
    }

    @Test
    public void testForRemovingAHeroFromTheCollectionUsingTheRemoveMethodWhenACorrectNameIsPassedAsAParameter() {
        Assert.assertTrue(repo.remove("Калин"));
    }

    @Test
    public void testForRemovingAHeroFromTheCollectionUsingTheRemoveMethodWhenAWrongNameIsPassedAsAParameter() {
        Assert.assertFalse(repo.remove("Весо"));
    }

    @Test
    public void testForAMethodThatReturnsTheHeroWithTheHighestLevelInTheCollection() {
        Assert.assertEquals(12,repo.getHeroWithHighestLevel().getLevel());
    }

    @Test
    public void testForAMethodThatReturnsTheHeroWithTheHighestLevelInTheCollectionButTheCollectionIsActuallyEmpty() {
        Assert.assertTrue(testRepo.getHeroWithHighestLevel() == null);
    }

    @Test
    public void testOfTheMethodThatReturnsAHeroByGivenName() {
        Assert.assertTrue(repo.getHero("Калин").getLevel() == 10);
    }

    @Test
    public void testOfTheMethodThatReturnsAHeroByAGivenNameButAHeroWithSuchANameDoesNotExistInTheCollection() {
        Assert.assertEquals(null, repo.getHero("Йордан"));
    }

    @Test
    public void getterTestThatReturnsTheHeroCollection() {
        Assert.assertEquals(2, repo.getHeroes().size());
    }
}
