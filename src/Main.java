
public class Main {
    public static void main(String[] args) {
        // 1. Carregar o Grafo do arquivo
        In in = new In("dados/entrada.txt");
        Graph G = new Graph(in);

        // 2. Imprimir Lista de Adjacência
        System.out.println("Lista de adjacência:");
        System.out.println(G);

        // 3. Componentes Conexas
        CC cc = new CC(G);
        int m = cc.count();
        System.out.println("Componentes conexas: " + m);

        // Listar vértices de cada componente
        for (int i = 0; i < m; i++) {
            System.out.print("Vértices da componente " + i + ": ");
            for (int v = 0; v < G.V(); v++) {
                if (cc.id(v) == i) System.out.print(v + " ");
            }
            System.out.println();
        }

        // 4. Distância Mínima entre (0,0) -> vértice 0 e (2,2) -> vértice 8
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, 0);
        if (bfs.hasPathTo(8)) {
            System.out.println("Distância mínima entre 0 e 8: " + bfs.distTo(8));
        } else {
            System.out.println("Não há caminho entre 0 e 8.");
        }

        // 5. Ciclo
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

    }
}