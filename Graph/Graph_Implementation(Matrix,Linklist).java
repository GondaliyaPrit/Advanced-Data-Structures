package com.graph;

import java.util.ArrayList;

public class Main {
    //todo Graph implimanation
    public static void main(String[] args) {
	// write your code here
        int v = 5 ;
        int e = 10;

        int[][] arr = new int[v+1][v+1];
        ad(5,10,arr);

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i <=v ; i++) {
            arrayList.add(new ArrayList<Integer>());
        }



    }

     static  void ad(int source , int des, int[][] arr)
    {
        arr[source][des] = 1 ;
        arr[des][source] = 1 ;
    }

    static  void add(int source , int des, ArrayList<ArrayList<Integer>> arrayList )
    {
        arrayList.get(source).add(des);
        arrayList.get(des).add(source);
    }


}
