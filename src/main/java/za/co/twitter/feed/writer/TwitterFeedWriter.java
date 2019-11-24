package za.co.twitter.feed.writer;

import za.co.twitter.feed.util.ConstantUtil;

import java.util.*;

public class TwitterFeedWriter {

    public void writeUserAndTweet(String [] users, String [] tweets) {

        Set<String> setOfUsers = getSetOfUsers(users);
        List<String> sortedList = new ArrayList<>(setOfUsers);
        Collections.sort(sortedList);
        Map<String, Set<String>> followedUsers = getFollowedUsers(setOfUsers, users);
        for (String name : sortedList) {

            System.out.println(name);
            Set<String> setOfFollowedUsers =  followedUsers.get(name);

            if(Objects.nonNull(setOfFollowedUsers)) {
                for (String followedUser : setOfFollowedUsers) {

                    for (String tweet : tweets) {

                        if (Objects.nonNull(tweet) && !followedUser.isEmpty() && tweet.startsWith(followedUser)) {

                            System.out.print("\t");
                            System.out.println(tweet.replace(followedUser + ">", "@" + followedUser + ": "));
                        }
                    }
                }
            }
        }

    }

    /**
     * @Param setOfUsers, users
     * @return getFollowedUsers return a map with followed users
     */
    private Map<String, Set<String>> getFollowedUsers(Set<String> setOfUsers, String[] users) {

        Map<String, Set<String>> followedUsers = new HashMap<>();
        for (String user : setOfUsers) {

            for (String str : users) {

                if ( Objects.nonNull(str) && str.startsWith(user + ConstantUtil.REGEX+ ConstantUtil.FOLLOWS)) {
                    String[] splitNames = str.replace(ConstantUtil.FOLLOWS, "")
                            .replace(ConstantUtil.COMMA,"").split(ConstantUtil.REGEX);

                    if (followedUsers.containsKey(user)) {

                        Set<String> setOfFollowedUsers = followedUsers.get(user);
                        setOfFollowedUsers.addAll(Arrays.asList(splitNames));

                    } else {
                        Set<String> setOfFollowedUsers = new HashSet<>();
                        setOfFollowedUsers.addAll(Arrays.asList(splitNames));
                        followedUsers.put(user, setOfFollowedUsers);
                    }
                }
            }

            Set<String> setOfFollowedUsers = new HashSet<>();
            setOfFollowedUsers.add(user);
            followedUsers.putIfAbsent(user, setOfFollowedUsers);
        }

        return followedUsers;
    }

    /**
     * @Param users
     * @return getSetOfUsers return a set of users
     */
    private Set<String> getSetOfUsers(String[] users) {

        Set<String> setOfUsers = new HashSet<>();

        for(String user : users) {

            if(Objects.nonNull(user)) {

                String[] splitNames = user.replace(ConstantUtil.FOLLOWS, "")
                        .replace(ConstantUtil.COMMA, "").split(ConstantUtil.REGEX);

                setOfUsers.addAll(Arrays.asList(splitNames));
            }

        }

        return setOfUsers;
    }
}
