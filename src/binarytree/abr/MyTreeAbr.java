package binarytree.abr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * abr
 */
public class MyTreeAbr {
  int data;

  MyTreeAbr left;
  MyTreeAbr right;
  List<MyTreeAbr> children;

  public MyTreeAbr(int data, List<MyTreeAbr> children) {
    this.data = data;
    this.children = children;
  }

  public MyTreeAbr(int data) {
    this.data = data;
  }

//  public MyTreeAbr( int data, MyTreeAbr left, MyTreeAbr right) {
//    this.left = left;
//    this.data = data;
//    this.right = right;
//  }

  public static void accLevels (MyTreeAbr t, TreeMap<Integer, List<Integer>> levels, int cur_level){
    if (t==null){
      return;
    }
    if (!levels.containsKey(cur_level)){
      levels.put(cur_level, new ArrayList<Integer>());
    }
    List<Integer> curList = levels.get(cur_level);
    curList.add(t.data);
    if (t.children!=null){
      for (MyTreeAbr tt: t.children){
        accLevels(tt, levels, cur_level-1);
      }
    } else {
      accLevels(t.left, levels, cur_level - 1);
      accLevels(t.right, levels, cur_level - 1);
    }
  }

  public static void printLevels (MyTreeAbr t){
    TreeMap <Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
    accLevels(t, map, -1);
    int smallest = map.firstKey();
    for (int lev : map.keySet()){
      System.out.print("Level " + (Math.abs(smallest)+lev+1) + ": ");
      List<Integer> nodes = map.get(lev);
      for (int d: nodes ){
        System.out.print(d+" ");
      }
      System.out.println();
    }
  }

//  public static MyTreeAbr makeTree(int[]arr, int left, int right){
//    if (left<=right) {
//      int mid = (left + right) / 2;
//      return new MyTreeAbr(arr[mid], makeTree(arr, left, mid-1), makeTree(arr, mid+1, right));
//    }
//    return null;
//  }
}

