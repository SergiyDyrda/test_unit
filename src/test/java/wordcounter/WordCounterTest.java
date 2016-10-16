package wordcounter;

import org.junit.*;
import org.junit.rules.ExpectedException;
import wordcounter.exception.NotFoundException;

/**
 * Created by Sergiy on 16.10.2016.
 */
public class WordCounterTest {
    private static String USER = "user";
    private static String USER_IGNORE_CASE = "UsEr";
    private static String USER_NOT_FOUND = USER + "!!!";
    private static String ADMIN = "admin";
    private static String ADMIN_IGNORE_CASE = "AdMiN";

    private WordCounter wordCounter = new WordCounter();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        wordCounter.deleteAllWords();
        wordCounter.putWord(USER);
        wordCounter.putWord(ADMIN);
    }

    @Test
    public void putWordUser() throws Exception {
        Assert.assertEquals(Long.valueOf(2), wordCounter.putWord(USER));
    }

    @Test
    public void putWordAdmin() throws Exception {
        Assert.assertEquals(Long.valueOf(2), wordCounter.putWord(ADMIN));
    }

    @Test
    public void putWordUserIgnoreCase() throws Exception {
        Assert.assertEquals(Long.valueOf(2), wordCounter.putWord(USER_IGNORE_CASE));
    }

    @Test
    public void putWordAdminIgnoreCase() throws Exception {
        Assert.assertEquals(Long.valueOf(2), wordCounter.putWord(ADMIN_IGNORE_CASE));
    }

    @Test
    public void getCountOfWordAdmin() throws Exception {
        Assert.assertEquals(Long.valueOf(1), wordCounter.getCountOfWord(ADMIN));
    }

    @Test
    public void getCountOfWordAdminIgnoreCase() throws Exception {
        wordCounter.putWord(ADMIN);
        Assert.assertEquals(Long.valueOf(2), wordCounter.getCountOfWord(ADMIN_IGNORE_CASE));
    }

    @Test
    public void getCountOfWordUser() throws Exception {
        Assert.assertEquals(Long.valueOf(1), wordCounter.getCountOfWord(USER));
    }

    @Test
    public void getCountOfWordUserIgnoreCase() throws Exception {
        wordCounter.putWord(USER);
        Assert.assertEquals(Long.valueOf(2), wordCounter.getCountOfWord(USER_IGNORE_CASE));
    }

    @Test
    public void getCountOfWordNotFound() {
        exception.expect(NotFoundException.class);
        exception.expectMessage(String.format("No such word - %s", USER_NOT_FOUND));
        wordCounter.getCountOfWord(USER_NOT_FOUND);
    }

    @Test
    public void deleteWord() throws Exception {
        Assert.assertEquals(Long.valueOf(1), wordCounter.deleteWord(USER));
    }

    @Test
    public void deleteWordNotFound() throws Exception {
        exception.expect(NotFoundException.class);
        exception.expectMessage(String.format("No such word - %s", USER_NOT_FOUND));
        wordCounter.getCountOfWord(USER_NOT_FOUND);
    }
}