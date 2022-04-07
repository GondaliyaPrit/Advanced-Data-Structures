Graph img :--> https://prnt.sc/xKxgpCPV3Wvv
Arraylist-MAtrix img :--> https://prnt.sc/eBsgv5RZfaqP


package com.graph.intro.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // write your code here

        ArrayList<ArrayList<Integer>> Getlist = Getlist();
        parfromBFS(Getlist);

    }

    public static ArrayList Getlist() {
        ArrayList<ArrayList<Integer>> Getlist = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        Getlist.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        Getlist.add(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        Getlist.add(list3);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(2);
        list4.add(4);
        Getlist.add(list4);

        ArrayList<Integer> list5 = new ArrayList<>();
        Getlist.add(list5);

        return Getlist;
    }

    public static void parfromBFS(ArrayList<ArrayList<Integer>> Getlist) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visit = new boolean[Getlist.size()];

        while (!queue.isEmpty()) {
            Integer vertex = queue.remove();
            System.out.print(vertex + " ");
            visit[vertex] = true;

            ArrayList<Integer> list = Getlist.get(vertex);
            for (Integer ver : list) {
                if (!visit[ver]) {
                    queue.add(ver);
                }

            }
        }
    }
}
