package com.graph.intro.traversal;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Integer[][] matrix = {{0, 0, 0, 0, 1},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0}};

        System.out.printf(iscycle(matrix) + " ");
    }

    public static boolean iscycle(Integer[][] matrix) {
        boolean[] visited = new boolean[matrix.length];
        boolean[] rec = new boolean[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            if (iscyclefound(matrix, i, visited, rec)) {
                return true;
            }
        }
        return false;   
    }


    public static boolean iscyclefound(Integer[][] matrix, Integer i, boolean[] visited, boolean[] rec) {

        if (rec[i] == true) {
            return true;
        }
        if (visited[i] == true) {
            return false;
        }

        visited[i] = true;
        rec[i] = true ;
        ArrayList<Integer> list = getvertax(matrix, i);
        for (Integer getlist : list) {
           if (iscyclefound(matrix,getlist,visited,rec))
           {
               return  true;
           }
        }
        rec[i]  = false;
        return  false ;
    }


    public static ArrayList<Integer> getvertax(Integer[][] matrix, Integer i) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][i] == 1) {
                list.add(j);
            }
        }
        return list;
    }
}


