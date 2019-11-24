package za.co.twitter.feed.runApp;

import org.apache.log4j.Logger;
import za.co.twitter.feed.reader.TwitterFeedFileReader;
import za.co.twitter.feed.writer.TwitterFeedWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class TwitterFeedApp {
    private final static Logger logger = Logger.getLogger(TwitterFeedApp.class);
//    static {
//        String log4jConfPath = "../resources/log4j.properties";
//        PropertyConfigurator.configure(log4jConfPath);
//    }
    public static void main(String... args){

        TwitterFeedFileReader fileReader = new TwitterFeedFileReader();
        TwitterFeedWriter twitterFeedWriter = new TwitterFeedWriter();

        try {
            if (Objects.nonNull(args) && args.length >= 2) {

                logger.info("Reading args from args[]");
                Path userFilePath = Paths.get(args[0]);
                Path tweetFilePath = Paths.get(args[1]);

                fileReader.readUserFile(userFilePath);
                fileReader.readTweetFile(tweetFilePath);

                String[] users = new String[fileReader.getUsers().size()];
                users = fileReader.getUsers().toArray(users);

                String[] tweets = new String[fileReader.getTweets().size()] ;
                tweets = fileReader.getTweets().toArray(tweets);
                twitterFeedWriter.writeUserAndTweet(users, tweets);

            } else {
                logger.info("No arguments ");
            }
        }catch (IOException ioe) {
            logger.error("Error while reading file: ", ioe);
        }
    }
}
