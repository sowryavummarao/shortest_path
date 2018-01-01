package com.shortest_path;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sowryavummarao on 12/20/17.
 */

public class PathFinder {
    private ArrayList<Vertex> unvisitedVertices;
    private ArrayList<Edge> edges;
    private Vertex start;
    private PathTable table;

    public PathFinder(Vertex start){
        unvisitedVertices = new ArrayList<>();
        edges = new ArrayList<>();
        this.start = start;
        //unvisitedVertices.add(start);
    }

    public void find(){
        table = new PathTable();
        table.addVertex(start);
        table.setShortestDistance(table.getIndexOfVertex(start),0);
        for (Vertex v : unvisitedVertices){
            table.addVertex(v);
        }
        unvisitedVertices.add(0,start);
        //block of code above will initialize the table

        Vertex vertexToVisit;
        while (unvisitedVertices.size() > 0){
            vertexToVisit = table.findClosestUnvisitedVertex(unvisitedVertices);
            visit(vertexToVisit,table);
            unvisitedVertices.remove(vertexToVisit);
        }
        System.out.println(table);
    }

    public void visit(Vertex v, PathTable table){
        int totalDistance;
        for (Edge e : edges){
            if (e.contains(v)){
                if (unvisitedVertices.contains(e.getOtherVertex(v))) {
                    totalDistance = table.getShortestDistance(v) + e.getWeight();
                    if (totalDistance < table.getShortestDistance(e.getOtherVertex(v))){
                        table.setShortestDistance(table.getIndexOfVertex(e.getOtherVertex(v)),totalDistance);
                        table.setPreviousVertex(table.getIndexOfVertex(e.getOtherVertex(v)),v);
                    }
                }
            }
        }
    }

    public void addVertex(Vertex vertex){
        unvisitedVertices.add(vertex);
    }

    public void removeVertex(Vertex vertex){
        unvisitedVertices.remove(vertex);
    }

    public void addEdge(Edge edge){
        edges.add(edge);
    }

    public void removeEdge(Edge edge){
        edges.remove(edge);
    }
    
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Unvisited Vertices: {");
        builder.append(start.toString() + ", ");
        for (Vertex element: unvisitedVertices){
            builder.append(element.toString() + ", ");
        }
        builder.append("}\n");
        builder.append("Edges: {");
        for (Edge e : edges){
            builder.append(e.toString() + ", ");
        }
        builder.append("}");
        return builder.toString();
    }

    public static void main(String[] args) {
        Vertex vertex0 = new Vertex("0");
        PathFinder pathFinder = new PathFinder(vertex0);
        Vertex vertex1 = new Vertex("1");
        Vertex vertex2 = new Vertex("2");
        Vertex vertex3 = new Vertex("3");
        Vertex vertex4 = new Vertex("4");
        Vertex vertex5 = new Vertex("5");
        Vertex vertex6 = new Vertex("6");
        Vertex vertex7 = new Vertex("7");
        Vertex vertex8 = new Vertex("8");

        Edge zeroOne = new Edge(vertex0,vertex1,4);
        Edge zeroSeven = new Edge(vertex0,vertex7,8);
        Edge oneTwo = new Edge(vertex1,vertex2,8);
        Edge oneSeven = new Edge(vertex1,vertex7,11);
        Edge twoThree = new Edge(vertex2,vertex3,7);
        Edge twoFive = new Edge(vertex2,vertex5,4);
        Edge twoEight = new Edge(vertex2,vertex8,2);
        Edge threeFour = new Edge(vertex3,vertex4,9);
        Edge threeFive = new Edge(vertex3,vertex5,14);
        Edge fourFive = new Edge(vertex4,vertex5,10);
        Edge fiveSix = new Edge(vertex5,vertex6,2);
        Edge sixSeven = new Edge(vertex6,vertex7,1);
        Edge sevenEight = new Edge(vertex7,vertex8,7);

        pathFinder.addVertex(vertex1);
        pathFinder.addVertex(vertex2);
        pathFinder.addVertex(vertex3);
        pathFinder.addVertex(vertex4);
        pathFinder.addVertex(vertex5);
        pathFinder.addVertex(vertex6);
        pathFinder.addVertex(vertex7);
        pathFinder.addVertex(vertex8);

        pathFinder.addEdge(zeroOne);
        pathFinder.addEdge(zeroSeven);
        pathFinder.addEdge(oneTwo);
        pathFinder.addEdge(oneSeven);
        pathFinder.addEdge(twoThree);
        pathFinder.addEdge(twoFive);
        pathFinder.addEdge(twoEight);
        pathFinder.addEdge(threeFour);
        pathFinder.addEdge(threeFive);
        pathFinder.addEdge(fourFive);
        pathFinder.addEdge(fiveSix);
        pathFinder.addEdge(sixSeven);
        pathFinder.addEdge(sevenEight);

        pathFinder.find();
    }
}
