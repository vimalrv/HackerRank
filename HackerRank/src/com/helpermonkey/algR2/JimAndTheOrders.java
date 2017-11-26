package com.helpermonkey.algR2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/* Hacker Rank - Jim And The Orders */
public class JimAndTheOrders {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i=0;i<n;i++){
            int t= in.nextInt();
            int d= in.nextInt();
            int f = t+d;//finish time
            if(map.containsKey(f)){
                List<Integer> list = map.get(f);
                list.add(i+1);
                map.put(f,list);
            }else{
                List<Integer> list = new ArrayList<>(Arrays.asList(i+1));
                map.put(f,list);//f_time, i-th
            }
        }
        List<Map.Entry<Integer, List<Integer>>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, List<Integer>>>(){
            public int compare(Map.Entry<Integer, List<Integer>> e1, Map.Entry<Integer, List<Integer>> e2){
                //return (int)e1.getKey() - (int)e2.getKey();
                return e1.getKey().compareTo(e2.getKey());
            }
        });
        for(Map.Entry e: list){
            for(Integer i: (List<Integer>)e.getValue()){
                System.out.print(i+" ");
            }
        }
    }
}
