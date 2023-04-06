import java.util.HashMap;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String,String>();
        trackList.put("Anti-Hero", "I have this thing where I get older but just never wiser...");
        trackList.put("All Too Well", "I walked through the door with you...");
        trackList.put("Love Story", "We were both young when I first saw you...");
        trackList.put("Midnight Rain", "Rain, he wanted it comfortable...");

        System.out.println(trackList.get("Love Story"));

        for (String key : trackList.keySet()){
            String trackTitle = key;
            System.out.println("Title: " + key);
            System.out.println(String.format("Lyrics: %s", trackList.get(key)));
        }
    }
}