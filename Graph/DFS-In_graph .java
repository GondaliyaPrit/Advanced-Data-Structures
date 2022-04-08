package com.prit.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class graph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjlist = getadjlist();
     

        perfromDFSusingReciorson(adjlist);
    }

    public static ArrayList getadjlist() {
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        adjlist.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        adjlist.add(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        adjlist.add(list3);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(2);
        list4.add(4);
        adjlist.add(list4);

        ArrayList<Integer> list5 = new ArrayList<>();
        adjlist.add(list5);

        return adjlist;
    }

  

    public static void perfromDFSusingReciorson(ArrayList<ArrayList<Integer>> adjlist) {
        boolean[] visited = new boolean[adjlist.size()];
        perfromDFSusingReciorson(adjlist, 0, visited);
    }
    public static void perfromDFSusingReciorson(ArrayList<ArrayList<Integer>> adjlist, Integer start, boolean[] visited) {
        System.out.print(start + " ");
        visited[start] = true;
        ArrayList<Integer> list = adjlist.get(start);

        for (int i = list.size()-1; i >= 0; i--) {
            Integer  integer = list.get(i);
            if (!visited[integer]) {
                perfromDFSusingReciorson(adjlist, integer, visited);
            }
        }
    }
}


