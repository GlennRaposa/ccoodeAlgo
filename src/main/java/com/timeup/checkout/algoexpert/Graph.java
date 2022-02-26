package com.timeup.checkout.algoexpert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {

    private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

    public static class Node{
        private int id;
        LinkedList<Node> adjacent = new LinkedList<Node>();
        public Node(int id){
            this.id = id;
        }
    }

    public void addNode(int id) {
        nodeLookup.put(id, new Node(id));
    }

    private Node getNode(int id){
        return nodeLookup.get(id);
    }

    public void addEdge(int source, int destination){
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }

    /*
    *** DFS - Algorithm:
    Create a recursive function that takes the index of the node and a visited array.
    Mark the current node as visited and print the node.
    Traverse all the adjacent and unmarked nodes and call the recursive function with the index of the adjacent node.
    */
    public boolean hasPathDFS(int source, int destination){
        Node s = getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathDFS(s,d,visited);
    }

    private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited){
        if(visited.contains(source.id)){
            System.out.print(source.id + " ");
            return false;
        }
        visited.add(source.id);
        if(source == destination){
            return true;
        }
        for(Node child : source.adjacent){
            if(hasPathDFS(child, destination, visited)){
                return true;
            }
        }
        return false;
    }

    public boolean hasPathBFS(int source, int destination){
        return hasPathBFS(getNode(source), getNode(destination));
    }

    public boolean hasPathBFS(Node source, Node destination){
        LinkedList<Node> nextToVisit = new LinkedList<Node>();
        HashSet<Integer> visited = new HashSet<Integer>();
        nextToVisit.add(source);
        while(!nextToVisit.isEmpty()){
            Node node = nextToVisit.remove();
            if(node == destination){
                return true;
            }
            if(visited.contains(node.id)){
                continue;
            }
            visited.add(node.id);

            for(Node child : node.adjacent){
                nextToVisit.add(child);
            }
        }
        return false;

    }
    public static void main(String args[])
    {
        Graph g = new Graph();

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.hasPathDFS(0,3);
    }
}
