import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);
		        int N = sc.nextInt();  //vertex
		        int M = sc.nextInt();  //edges

		        Graph graph = new Graph(N);

		        for (int i = 0; i < M; i++) {
		            char a = sc.next().charAt(0);
		            char b = sc.next().charAt(0);
		            graph.addEdge(a - 'a', b - 'a'); 
		        }

		        char X = sc.next().charAt(0);
		        char Y = sc.next().charAt(0);

		        List<String> validEdges = graph.findValidNewEdges(X - 'a', Y - 'a');

		        if (validEdges.isEmpty()) {
		            System.out.println("-1");
		        } else {
		            System.out.println(validEdges.size());
		            for (String edge : validEdges) {
		                System.out.println(edge);
		            }
		       
		}


	}

}
