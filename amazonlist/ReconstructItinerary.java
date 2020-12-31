import java.util.*;

public class ReconstructItinerary {

    // Use a hashmap<Stirng, PriorityQueue<String>> to store flghts information
    // the key is departure airport while the value is arrival airport
    // here priority queue ensures the lexical order when two itineraries depart from the same airport
    // use dfs method to find the final arrival airport, then go back and find the final second arrival airport and etc
    // use addFirst method to add arrival airports to the path list(avoid reversal process)

    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;

    public List<String> findItinerary(List<List<String>> tickets) {
        // initialize variables
        flights = new HashMap<String, PriorityQueue<String>>();
        path = new LinkedList<String>();

        // add tickets to fights map
        for (List<String> ticket: tickets) {
            // parse from and to airports
            String from = ticket.get(0);
            String to = ticket.get(1);
            // use putIfAbsent method to avoid duplicate keys
            flights.putIfAbsent(from, new PriorityQueue<String>());
            flights.get(from).add(to);
        }

        // use dfs method to find arrival airports recursively
        dfs("JFK");
        return path;
    }

    public void dfs(String departure) {
        // get arrival airports 
        PriorityQueue<String> arrivals = flights.get(departure);
        // find the final arrival airport and go back recursively
        // when key not exist, hashmap returns null
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll());
        }
        // add the arrival airport to path list
        path.addFirst(departure);

    }
}