package challenge.yourself;

import java.util.*;

public class NumberOfProvinces {

    static int res = 0;
    static Set<Integer> visited;

    public static void main(String[] args) {
        System.out.println(findConnectedCities(new int[][]{
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        }));
    }

    public static int findConnectedCities(int[][] isConnected) {
        visited = new HashSet<>();

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                res++;
                dfs(i, isConnected);
            }
        }
        return res;

    }

    private static void dfs(int city, int[][] isCityConnected) {
        visited.add(city);

        for (int i = 0; i < isCityConnected.length; i++) {
            if (isCityConnected[city][i] == 1 && !visited.contains(i)) {
                dfs(i, isCityConnected);
            }
        }
    }
}
