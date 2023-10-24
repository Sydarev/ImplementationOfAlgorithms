package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph<T> {
    private List<Vertex<T>> vertices = new ArrayList<>();

    public Vertex<T> createVertex(T value) {
        Vertex<T> v = new Vertex<>(value);
        vertices.add(v);
        return v;
    }
    //добавление вершинам связи
    public void createEdge(Vertex<T> a, Vertex<T> b) {
        a.getAdjacent().add(b);
        b.getAdjacent().add(a);
    }

    public boolean isConnected(Vertex<T> a, Vertex<T> b) {
        return dfsFind(a, b, new HashSet<>()); // рекурсивный обход в глубину
    }

    // метод отвечает на вопрос, нашли ли мы обходом из v вершину target с
    private boolean dfsFind(Vertex<T> v, Vertex<T> target, Set<Vertex<T>> visited) {
        // если вершина в которую зашли (v) это та которую мы искали (target), то поиск закончен
        if (v.equals(target)) {
            return true; // нашли
        }
        visited.add(v); // запоминаем вершину которую посетили
        for (Vertex<T> ver : v.getAdjacent()) {
            if (!visited.contains(ver))
                if (dfsFind(ver, target, visited)) return true;
        }
        return false;
    }
}
