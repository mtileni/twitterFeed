package za.co.twitter.feed.writer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TwitterFeedWriter.class, String.class})
public class TwitterFeedWriterTest {

    @InjectMocks
    private TwitterFeedWriter twitterFeedWriter;

    private String[] tweets = new String[5];
    private String[] users = new String[4];

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        tweets[0] = "Alan> If you have a procedure with 10 parameters, you probably missed some.";
        tweets[1] = "Ward> There are only two hard things in Computer Science: cache invalidation, naming things and off-by-1 errors.";
        tweets[2] = "Alan> Random numbers should not be generated with a method chosen at random.";
        tweets[3] = "Martin> cache invalidation, naming things and off-by-1 errors.";

        users[0] = "Ward follows Alan";
        users[1] = "Alan follows Martin";
        users[2] = "Ward follows Martin, Alan";
    }

    @After
    public void tearDown() {
        tweets = null;
        users = null;
    }

    @Test
    public void writeUserAndTweet() {

        twitterFeedWriter.writeUserAndTweet(users, tweets);
    }
}