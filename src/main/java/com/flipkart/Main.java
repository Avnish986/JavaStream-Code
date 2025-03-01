package com.flipkart;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static class Tree {
        int val;
        Tree left;
        Tree right;
        public Tree(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
        public Tree() {
            this.left = null;
            this.right = null;
        }
        public Tree insert(int val, Tree root) {
            if(root == null) {
                return new Tree(val);
            }

            if(val < root.val) {
                root.left = insert(val, root.left);
            } else {
                root.right = insert(val, root.right);
            }
            return root;
        }

        void inorder(Tree root) {
            if(root == null) {
                return;
            }

            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
        void levelOrder(Tree root) {
            if(root == null) {
                return;
            }

            Queue<Tree> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                Tree node = queue.poll();

                System.out.print(node.val + " ");
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        void leftView(Tree root) {
            if(root == null) {
                return;
            }

            Queue<Tree> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                int sz = queue.size();
                for(int i  = 0; i < sz; i++) {
                    Tree node = queue.poll();
                    if(i == 0) {
                        System.out.print(node.val + " ");
                    }
                    if(node.left != null) {
                        queue.add(node.left);
                    }
                    if(node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String s = "asdfaghjklkjhgfdsa";

        // Create a set to track seen characters
        HashSet<Character> seen = new HashSet<>();

        // Find the first repeating character
        Optional<Character> firstRepeating = s.chars()  // Stream of int
                .mapToObj(c -> (char) c)  // Convert to Stream<Character>
                .filter(c -> !seen.add(c))  // If not added to the set, it's a duplicate
                .findFirst();  // Get the first repeating character

        // Print the result if present
        firstRepeating.ifPresent(System.out::println);

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] evenNumbers = Arrays.stream(arr).filter(n -> n % 2 == 0).toArray();
        System.out.println(Arrays.toString(evenNumbers));

        int[] arr1 = {5, 3, 9, 1, 10, 7};
        OptionalInt mx = Arrays.stream(arr1).max();
        mx.ifPresent(System.out::println);

        Integer[] arr3 = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(arr3).mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum);

        int[] arr4 = {1, 2, 3, 4, 5};
        int[] newArr = Arrays.stream(arr4).map(n -> n * n).toArray();
        System.out.println(Arrays.toString(newArr));

        int[] arr5 = {1, 5, 7, 10, 15};
        long count  = Arrays.stream(arr5).filter(n -> n > 5).count();

        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<String> filteredWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(filteredWords);

        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e", "f")
        );

        List<String> flattenedList = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flattenedList);

        List<String> words1 = Arrays.asList("hello", "world", "java", "streams");
        String filteredWords1 = words1.stream().reduce("", (str1, str2) -> str1 + str2);
        System.out.println(filteredWords1);

        Integer[] arr6 = {1, 2, 2, 3, 4, 4, 5};
        Set<Integer> filteredArr = Arrays.stream(arr6).collect(Collectors.toSet());
        System.out.println(filteredArr);

        int[] arr7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] newArr7 = Arrays.stream(arr7).limit(5).toArray();
        System.out.println(Arrays.toString(newArr7));

        Tree root = new Tree(5);

        root = root.insert(3, root);
        root = root.insert(4, root);
        root = root.insert(7, root);
        root = root.insert(11, root);
        root = root.insert(12, root);
        //root.inorder(root);
        //root.levelOrder(root);
        root.leftView(root);

        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        Map<String, List<String>> groupAnagrams = groupAnagrams(strs);
        List<List<String>> result = new ArrayList<>(groupAnagrams.values());
        System.out.println(result);

    }

    private static Map<String, List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for(String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if(!result.containsKey(sortedStr)) {
                result.put(sortedStr, new ArrayList<>());
            }
            result.get(sortedStr).add(str);
        }

        return result;
    }
}