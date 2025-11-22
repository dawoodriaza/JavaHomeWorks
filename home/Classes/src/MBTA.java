import java.util.*;
public class MBTA {
    public static Map<String, List<String>> stations = new HashMap<>();
    static {
        stations.put("Red", Arrays.asList("south station", "park street", "keendall", "Cxntral", "harvard", "porter", "davis", "alewife"));
        stations.put("Green", Arrays.asList("goverment center", "park street", "boylston", "arlington", "copley", "Hynes", "Kenmore"));
        stations.put("Orange", Arrays.asList("north station", "haymarket", "park street", "state", "downtown crossing", "chinatown", "back bay", "forest hils"));
    }
    public static int countStation(String line1 , String station1 , String line2 , String station2){
        int i=0, j=0,count =0;
    if(station1.equalsIgnoreCase(station2)){
        return 0;
    }

    if(line1.equalsIgnoreCase(line2)){
        i = stations.get(line1).indexOf(station1);
        j= stations.get(line1).indexOf(station2);
        return Math.abs(i-j);
    } else {

        int line1parkStreetStation = stations.get(line1).indexOf("park street");
        i = Math.abs(stations.get(line1).indexOf(station1) - line1parkStreetStation);

        int line2parkStreetStation = stations.get(line2).indexOf("park street");
        j = Math.abs(stations.get(line2).indexOf(station2) - line2parkStreetStation);
        return Math.abs(i+j);
    }
    }

    public static void main(String[] args) {
        System.out.println(countStation("Red", "alewife", "Red", "alewife"));
        System.out.println(countStation("Red", "alewife", "Red", "south station"));
        System.out.println(countStation("Red", "south station", "Green", "Kenmore"));
        System.out.println(countStation("Orange", "chinatown", "Green", "arlington"));
    }
}
