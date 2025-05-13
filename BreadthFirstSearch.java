import java.util.*;
class BreadthFirstSearch{
   
    public static void main(String[] args){
        ArrayDeque<String> Ashgabat = new ArrayDeque<>(Arrays.asList("London", "Sydney"));
        ArrayDeque<String> London = new ArrayDeque<>(Arrays.asList("Houston", "New York"));
        ArrayDeque<String> Sydney = new ArrayDeque<>(Arrays.asList("Honolulu"));
        ArrayDeque<String> Houston = new ArrayDeque<>(Arrays.asList("Nashville"));
        ArrayDeque<String> SanFrancisco = new ArrayDeque<>();
        ArrayDeque<String> Wellington = new ArrayDeque<>(Arrays.asList("San Francisco"));
        ArrayDeque<String> Nashville = new ArrayDeque<>(Arrays.asList("San Francisco"));
        ArrayDeque<String> NewYork = new ArrayDeque<>(Arrays.asList("San Francisco"));
        ArrayDeque<String> Honolulu = new ArrayDeque<>(Arrays.asList("Wellington"));

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
    public static Set<String> breadthFirstSearch(HashMap<String, ArrayDeque<String>> graph, String start, String destination){
        HashMap<String, String> path = new HashMap<>();
        Set<String> shortestRoute = new LinkedHashSet<>();
        List<String> visited = new ArrayList<>();
        String currentCity = start;
        System.out.println(start);
        path.put("", currentCity);
        ArrayDeque<String> queue = graph.get(start);

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
            }
        }

        return shortestRoute;

    }
}