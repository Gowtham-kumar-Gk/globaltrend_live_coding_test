import java.util.*;
public class Q2
{
    public static void main(String args[])
    {
        Map<Integer, Map<Integer,Integer>> graph = new HashMap<>();
        graph.put(0,Map.of(1,4,2,1));
        graph.put(1,Map.of(3,1));
        graph.put(2,Map.of(1,2,3,5));
        graph.put(3,new HashMap<>());

        int source = 0;
        Map<Integer, Integer> shortestPaths = dijkstra(graph, source);
        System.out.println(shortestPaths);
    }
    public static Map<Integer,Integer> dijkstra(Map<Integer, Map<Integer, Integer>> graph,int source)
    {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(arr -> arr[1]));
        Set<Integer> visited = new HashSet<>();

        for(int vertex : graph.keySet())
        {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(source,0);
        pq.add(new int[]{source,0});

        while(!pq.isEmpty())
        {
            int[] current  = pq.poll();
            int u = current[0];

            if(visited.contains(u))
                continue;
            visited.add(u);

            for(Map.Entry<Integer,Integer> neighbor : graph.get(u).entrySet())
            {
                int v = neighbor.getKey();
                int weight = neighbor.getValue();
                int newDistt = distances.get(u)+weight;

                if(newDistt < distances.get(v))
                {
                    distances.put(v,newDistt);
                    pq.add(new int[]{v,newDistt});
                }
            }
        }
        return distances;
    }

}
