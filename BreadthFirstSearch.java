/**
 * Title: Breadth First Search Algorithm
 * @author Halmuhammet Muhamedorazov
 * @since 15.05.2025
 * @version 1.0
 * Requirements: Java 8 or later needed for ArrayDeque, HashMap, and Set.
 * Summary: Algorithm starts with adding the start node to the queue,
 *          then, adds its direct neighbors to the back of the queue.
 *          If none of the nodes is the destination, then it adds the second degree neighbors
 *          to the back of the queue. Same logic applies until it finds destination at any node.
 *          If the destination is found, the program terminates and traces the path taken
 *          to form the route. Since the edges has no weight, the resulting route is shortest.
 */

// import the needed libraries
import java.util.*;
class BreadthFirstSearch{
    public static void main(String[] args){
        
        // Initialize the the nodes and their neighbors; Neighbors represented as ArrayDeque
        // Using ArrayDeque is better choice than String array since we need to resize dynamically (pop())
        ArrayDeque<String> Ashgabat = new ArrayDeque<>(Arrays.asList("London", "Sydney"));
        ArrayDeque<String> London = new ArrayDeque<>(Arrays.asList("Houston", "New York"));
        ArrayDeque<String> Sydney = new ArrayDeque<>(Arrays.asList("Honolulu"));
        ArrayDeque<String> Houston = new ArrayDeque<>(Arrays.asList("Nashville"));
        ArrayDeque<String> SanFrancisco = new ArrayDeque<>();
        ArrayDeque<String> Wellington = new ArrayDeque<>(Arrays.asList("San Francisco"));
        ArrayDeque<String> Nashville = new ArrayDeque<>(Arrays.asList("San Francisco"));
        ArrayDeque<String> NewYork = new ArrayDeque<>(Arrays.asList("San Francisco"));
        ArrayDeque<String> Honolulu = new ArrayDeque<>(Arrays.asList("Wellington"));

        // Represent the directed graph as HashMap with Key-Value pairs
        HashMap<String, ArrayDeque<String>> graph = new HashMap<>();
        graph.put("Ashgabat", Ashgabat);
        graph.put("London", London);
        graph.put("Sydney", Sydney);
        graph.put("Houston", Houston);
        graph.put("San Francisco", SanFrancisco);
        graph.put("Wellington", Wellington);
        graph.put("Nashville", Nashville);
        graph.put("New York", NewYork);
        graph.put("Honolulu", Honolulu);
            
        Set<String> path = breadthFirstSearch(graph, "Ashgabat", "San Francisco");
        System.out.println(path);
    }

    /**
     * This function implements Breadth First Search Algorithm
     * @param graph Graph representing nodes and edges
     * @param start Starting city/node
     * @param destination Target city/node
     * @return shortestRoute The traced shortest route from start to destination
     */

    public static Set<String> breadthFirstSearch(HashMap<String, ArrayDeque<String>> graph, String start, String destination){
        // Initialize the shortestRoute set
        Set<String> shortestRoute = new LinkedHashSet<>();
        HashMap<String, String> path = new HashMap<>();
        String currentCity = start;
        // Initialize the path with starting node/city
        path.put("", currentCity);
        System.out.println(start);
        
        // Declare and initialize the queue with starting node/city
        ArrayDeque<String> queue = graph.get(start);
        // Make a visited list to keep track of cities visited to avoid infinite loop problem
        List<String> visited = new ArrayList<>();

        while(!queue.isEmpty()){
            if(!visited.contains(currentCity)){
                String nextCity = queue.pop();
                path.put(nextCity, currentCity);
                if(currentCity.equals(destination)){
                    break;
                }
                for(String neighbor : graph.get(nextCity)){
                    queue.add(neighbor);
                }
                System.out.println(nextCity + " ");
                visited.add(currentCity);
                currentCity = nextCity;
            }else{
                queue.pop();
            }
        }
        System.out.println(path.values());

        return shortestRoute;

    }
}