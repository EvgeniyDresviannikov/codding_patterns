package topological.sort;

import java.util.*;

class CompilationOrder {

    public static void main(String[] args) {
        System.out.println(findCompilationOrder(List.of(
                List.of('B', 'A'),
                List.of('C', 'A'),
                List.of('D', 'C'),
                List.of('E', 'D'),
                List.of('E', 'B')
        )));
    }

    public static List<Character> findCompilationOrder(List<List<Character>> dependencies){

        Map<Character, Integer> inEdges = new HashMap<>();
        Map<Character, Set<Character>> graph = new HashMap<>();

        for (int i = 0; i < dependencies.size(); i++) {
            char child = dependencies.get(i).get(0);
            char parent = dependencies.get(i).get(1);

            inEdges.put(child, 0);
            inEdges.put(parent, 0);

            graph.put(parent, new HashSet<>());
            graph.put(child, new HashSet<>());
        }

        for (int i = 0; i < dependencies.size(); i++) {
            char child = dependencies.get(i).get(0);
            char parent = dependencies.get(i).get(1);

            inEdges.put(child, inEdges.get(child)+1);

            graph.get(parent).add(child);

        }


        List<Character> queue = new LinkedList<>();

        inEdges.entrySet().forEach(entry -> {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        });

        List<Character> result = new ArrayList<>();

        while (!queue.isEmpty()) {

            char val = queue.remove(0);
            result.add(val);

            graph.get(val).forEach(item -> {
                inEdges.put(item, inEdges.get(item)-1);
                if (inEdges.get(item) == 0) {
                    queue.add(item);
                }
            });
        }

        if(result.size() != graph.size()){
            return new ArrayList<>();
        }

        return result;
    }
}