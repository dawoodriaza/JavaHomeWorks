import java.util.*;
public class MBTA {
    public static Map<String, List<String>> stations = new HashMap<>();
    static {
        stations.put("Red", Arrays.asList("south station", "park street", "keendall", "Cxntral", "harvard", "porter", "davis", "alewife"));
        stations.put("Green", Arrays.asList("goverment center", "park street", "boylston", "arlington", "copley", "Hynes", "Kenmore"));
        stations.put("Orange", Arrays.asList("north station", "haymarket", "park street", "state", "downtown crossing", "chinatown", "back bay", "forest hils"));
    }

    public static int countStation(String line1 , String station1 , String line2 , String station2){

        System.out.println("Rider boards a train "+ line1 + " Line and " + station1);
    if(station1.equalsIgnoreCase(station2)){
        return 0;
    }

    if(line1.equalsIgnoreCase(line2)){
        int i=0, j=0,count =0;
        i = stations.get(line1).indexOf(station1);
        j= stations.get(line1).indexOf(station2);
        if(i <= j){
            for(int k = i+1; k <= j; k++){
                System.out.println("Rider at " + stations.get(line1).get(k));
            }
        } else {
            for(int k = i; k >= j; k--){
                System.out.println("Rider at " + stations.get(line1).get(k));
            }}
        return Math.abs(i-j);
    } else {
        int i=0, j=0,count =0;

        int line1parkStreetStation = stations.get(line1).indexOf("park street");
        if(i <= j){
            for(int k = i+1; k <= line1parkStreetStation; k++){
                System.out.println("Rider at " + stations.get(line1).get(k));
            }
        } else {
            for(int k = i; k >= line1parkStreetStation; k--){
                System.out.println("Rider at " + stations.get(line1).get(k));
            }
        }
        i = Math.abs(stations.get(line1).indexOf(station1) - line1parkStreetStation);
        System.out.println("Rider Transfer to " + line2 + "Line");
        int line2parkStreetStation = stations.get(line2).indexOf("park street");
        j = Math.abs(stations.get(line2).indexOf(station2) - line2parkStreetStation);
        if(i <= j){
            for(int k = i+1; k <= line2parkStreetStation; k++){
                System.out.println("Rider at " + stations.get(line1).get(k));
            }
        } else {
            for(int k = i; k >= line2parkStreetStation; k--){
                System.out.println("Rider at " + stations.get(line1).get(k));
            }
        }

        System.out.println("Rider exit at "+ station2 );
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
