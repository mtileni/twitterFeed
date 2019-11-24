package za.co.twitter.feed.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;

public class TwitterFeedFileReader {

    private List<String> tweets;
    private List<String> users;
    private final static Logger logger = Logger.getLogger(TwitterFeedFileReader.class);

    private BufferedReader readFile(Path filePath) throws IOException {

        Reader fileReader = new FileReader(filePath.toFile());
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        return bufferedReader;
    }

    public void readTweetFile(Path filePath) throws IOException {

        List<String> tweets = new ArrayList<>();
        BufferedReader fileReader = readFile(filePath);
        String tweet;
        while ((tweet = fileReader.readLine()) != null) {

            tweets.add(tweet);
        }

        if(Objects.nonNull(fileReader)) {
            fileReader.close();
        }
        setTweets(tweets);
    }

    public void readUserFile(Path filePath) throws IOException {

        List<String> users = new ArrayList<>();
        BufferedReader fileReader = readFile(filePath);

        String user;
        while ((user = fileReader.readLine()) != null) {

            users.add(user);
        }

        if(Objects.nonNull(fileReader)) {
            fileReader.close();
        }
        
        setUsers(users); }

    public List<String> getTweets() {
        return tweets;
    }

    public void setTweets(List<String> tweets) {
        this.tweets = tweets;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}
