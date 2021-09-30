import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@SuppressWarnings("unchecked")
public class HashGraph extends Graph{
    
    int p; // Big Prime (for PolyHash())
    int x; // Small number (for PolyHash())
    
    // This is complete, no need to edit
    public HashGraph(int cap, int p, int x){
        super(cap); // Forward the parameter to Graph's constructor
        this.p = p;
        this.x = x;
    }
    
    
    public static int polyHash(String s, int p, int x){
        // Pls use code from the previous problem
        return 0; // Fix this
    }
    
    public int getListIndex(String s){
        // Pls use code from the previous problem
        return 0; // Fix this
    }
    
    
    public void addVertex(String key){
        if (size==cap){
            System.out.println("Vertex list is full. You need to recreate the Graph");
            return;
        }
        
        // Map the String key to the array index (use getListIndex())
        // Pls use code from the previous problem as the starter
        
    }
    
    public void addEdge(String source, String destination){
        // Map String's source and destination (city name) to Integer's u, v (array index)
        // You may call super.addEdge(u, v); for simpler implementation
    }
    

    public void BFS(Vertex s){
        // Set all Vertex.dist to Infinity (Use Integer.MAX_VALUE to represent Infinity)
        
        // Set dist of the start vertex (s) to 0
        // Push the start vertex to an empty queue
        
        // [*] Check if the queue is not empty
        // Pop queue and get the current vertex
        // Extract the list of all vertices that are connected to current vertex
        
        // Traverse all the list check if the dist value of anyone are still infinity or not
        // If yes,  set push that vertex into the queue
        //          increase the dist variable of that vertex by one
        //          set the prev variable of that vertex to the current vertex
        
        // Repeat [*]
    }

    
    public Stack<Vertex> getShortestPathList(Vertex S, Vertex U){
        
        // Create a stack
        
        // Start from city U
        // [*] push the current city into the stack
        // Go back one city using U.prev
        // Repeat [*] until you reach the city S
        
        // return the stack
        return null; // Fix this
    }
    
    public void printShortestPath(String s_str, String u_str){
        
        // Map city names to index numbers
        // Get vertices from the vertexList
        // Run BFS() at the starting city
        // Get shortestPartList(starting city, ending city)
        // Traverse all the stack and print the city name
        
    }
    
    // This function is complete, no need to edit
    public void showVertexList(){
        for (int i=0; i<vertexList.length; i++){
            if (vertexList[i]!=null)
                System.out.println("vertexList["+i+"] contains "+vertexList[i].strKey);
            else
                System.out.println("vertexList["+i+"] null");
        }
    }


    // This is editable test case, but no need to edit
    public static HashGraph constructGraph(){
        
        int p = 101111; // Big Prime (Hash key1)
        int x = 101;    // Small number (Hash key2)
        HashGraph graph = new HashGraph(32, p, x); 
        
        String[] cities = new String[]{"Dublin", "Edinburgh", "Manchester", 
            "Copenhagen", "Lisbon", "London", "Berlin", "Prague", "Madrid", 
            "Paris", "Vienna", "Budapest", "Geneva", "Milan", "Zurich", "Rome"};
        for (int i=0; i<16; i++){
            graph.addVertex(cities[i]);
        }
        
        return graph;
    }
    
    // This is editable test case, but no need to edit
    public static HashGraph connectEdges(HashGraph graph){
        graph.addEdge("Dublin", "Edinburgh");
        graph.addEdge("Dublin", "London");                
        graph.addEdge("Dublin", "Lisbon");
        graph.addEdge("Edinburgh", "Manchester");
        graph.addEdge("Manchester", "London");
        graph.addEdge("Manchester", "Copenhagen");
        graph.addEdge("Copenhagen", "Berlin");
        graph.addEdge("Lisbon", "Madrid");
        graph.addEdge("London", "Paris");
        graph.addEdge("Berlin", "Prague");
        graph.addEdge("Berlin", "Vienna");
        graph.addEdge("Berlin", "Paris");
        graph.addEdge("Prague", "Zurich");
        graph.addEdge("Madrid", "Paris");
        graph.addEdge("Madrid", "Milan");
        graph.addEdge("Madrid", "Geneva");
        graph.addEdge("Vienna", "Zurich");
        graph.addEdge("Budapest", "Rome");
        graph.addEdge("Milan", "Zurich");
        graph.addEdge("Zurich", "Rome");
        return graph;
    }
}
