package Orgraph;

import java.util.*;

public class DAG<T> {
    private List<Vertex<T>> vertices = new ArrayList<>();

    public Vertex<T> createVertex(T value) {
        Vertex<T> v = new Vertex<>(value);
        vertices.add(v);
        return v;
    }

    public void createEdge(Vertex<T> from, Vertex<T> to) {
        // добавляем в список смежности только в одном направлении
        from.getAdjacent().add(to);
    }

    public int path(Vertex<T> from, Vertex<T> to) {
        Map<Vertex<T>, Integer> paths = new HashMap<>(); // по городу даёт количество полётов чтобы до него добраться из from
        paths.put(from, 0);

        Queue<Vertex<T>> queue = new ArrayDeque<>(); // очередь обхода вершин
        Set<Vertex<T>> added = new HashSet<>(); // запоминаем все когда-либо побывавшие в очереди вершины
        queue.add(from);

        int count = 0;
        while (!queue.isEmpty()) {
            Vertex<T> v = queue.poll();
            added.add(v);
            if (v == to) return paths.get(v);
            for (Vertex<T> ver : v.getAdjacent()) {
                if (!added.contains(ver) && !paths.containsKey(ver)) {
                    queue.add(ver);
                    paths.put(ver, paths.get(v) + 1);
                }

            }
        }
        return -1;
    }

}