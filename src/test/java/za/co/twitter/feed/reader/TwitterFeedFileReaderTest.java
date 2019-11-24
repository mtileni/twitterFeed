package za.co.twitter.feed.reader;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

import java.io.File;

@RunWith(org.powermock.modules.junit4.PowerMockRunner.class)
@PrepareForTest(TwitterFeedFileReader.class)
public class TwitterFeedFileReaderTest {
    
    @InjectMocks
    private TwitterFeedFileReader twitterFeedFileReader;
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();
    private File rootFilePath, userFile, tweetFile;

    @Before
    public void setUp(){
        
        MockitoAnnotations.initMocks(this);

        try {
            rootFilePath = temporaryFolder.getRoot();
            tweetFile = temporaryFolder.newFile("tweet.txt");
            userFile = temporaryFolder.newFile("user.txt");


        }catch(Exception e){e.printStackTrace();}
    }
    
    @Test
    public void testReadUserFile() throws Exception{

        Whitebox.invokeMethod(twitterFeedFileReader,"readUserFile",userFile.toPath());
    }

    @Test
    public void testReadTweetFile() throws Exception{

        Whitebox.invokeMethod(twitterFeedFileReader,"readTweetFile",tweetFile.toPath());
    }
}
