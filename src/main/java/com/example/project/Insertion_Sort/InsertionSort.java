package com.example.project.Insertion_Sort;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {

    // PART A. implementing insertion sort
    public static int[] insertionSort(int[] elements) {
        for (int i = 1; i < elements.length; i++) {
            int current = elements[i];
            int j = i - 1;
            while (j >= 0 && elements[j] > current) {
                elements[j + 1] = elements[j]; 
                j--; 
            }
            elements[j + 1] = current;
        }
        return elements;
    }

   
    public static void selectionSort(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int min = i;
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[j] < elements[min]) {
                    int temp = elements[j];
                    elements[j] = elements[min];
                    elements[min] = temp;
                }
            }
        }

    }

    // PART B. sorting a 1000-word list
    public static ArrayList<String> insertionSortWordList(ArrayList<String> words) {
        for (int i = 0; i < words.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(j).compareTo(words.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            String temp = words.get(i);
            words.set(i, words.get(minIndex));
            words.set(minIndex, temp);
        }
        return words;
    }

    public static void selectionSortWordList(ArrayList<String> words) {
        int loopCounter = 0;
        for (int i = 1; i < words.size(); i++) {
            String current = words.get(i);
            int j = i - 1;
            while (j >= 0 && words.get(j).compareTo(current) > 0) {
                words.set(j + 1, words.get(j));
                j--;
                loopCounter++;
            }
            words.set(j + 1, current);
            loopCounter++;
        }
        System.out.println("Loop Iterations: " + loopCounter);
    }

    public static ArrayList<String> loadWordsInto(ArrayList<String> wordList) {
        try {
            Scanner input = new Scanner(new File("src/main/java/com/example/project/Selection_Sort/words.txt"));
            while (input.hasNext()) {
                String word = input.next();
                wordList.add(word);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wordList;
    }

    public static void main(String[] args) {
    
    }
   
}