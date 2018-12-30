package com.dil8654.convertLinkedHashSetToArrayList;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class ConvertLinkedHashSetToArrayList
{

  public static void main(String[] args)
  {
    Set<String> testStrings = new LinkedHashSet<>();
    testStrings.add("String 1");
    testStrings.add("String 2");
    testStrings.add("String 3");
    testStrings.add("String 4");
    testStrings.add("String 5");

    System.out.println("** Printing LinkedHashSet: " + testStrings);
    ArrayList<String> linkedHashSetToArrayList1 = new ArrayList<>(testStrings);
    System.out.println("** Printing linkedHashSetToArrayList1:" + linkedHashSetToArrayList1);
    
    ArrayList<String> linkedHashSetToArrayList2 = new ArrayList<>();
    linkedHashSetToArrayList2.addAll(testStrings);
    System.out.println("** Printing linkedHashSetToArrayList2:" + linkedHashSetToArrayList2);
  }
}
