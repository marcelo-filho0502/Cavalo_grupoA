public class Main {
    public static void main(String[] args) {

        In in = new In("dados/entrada.txt");
        Graph G = new Graph(in);

        System.out.println("Lista de adjacência:");
        System.out.println(G);

        CC cc = new CC(G);
        int m = cc.count();
        System.out.println("Componentes conexas: " + m);

        for (int i = 0; i < m; i++) {
            System.out.print("Vértices da componente " + i + ": ");
            for (int v = 0; v < G.V(); v++) {
                if (cc.id(v) == i) System.out.print(v + " ");
            }
            System.out.println();
        }

        BreadthFirstPaths bfs = new BreadthFirstPaths(G, 0);
        if (bfs.hasPathTo(8)) {
            System.out.println("Distância mínima entre 0 e 8: " + bfs.distTo(8));
        } else {
            System.out.println("Não há caminho entre 0 e 8.");
        }

        Cycle finder = new Cycle(G);
        if (finder.hasCycle()) {
            System.out.println("O grafo possui ciclo: Sim");
            System.out.print("Um ciclo encontrado: ");
            for (int v : finder.cycle()) {
                System.out.print(v + " ");
            }
            System.out.println();
        } else {
            System.out.println("O grafo possui ciclo: Não");
        }

        System.out.println("\n--- Análise de Complexidade ---");
        System.out.println("Tempo: O(V + E) - Onde V=9 e E=16.");
        System.out.println("Espaço: O(V + E) para armazenar a lista de adjacência.");
    }
}