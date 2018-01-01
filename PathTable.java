package com.shortest_path;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 * Created by sowryavummarao on 12/19/17.
 */
public class PathTable {
    private ArrayList<Vertex> vertices;
    private ArrayList<Integer> shortestDistances;
    private ArrayList<Vertex> previousVertices;

    public PathTable(){
        this.vertices = new ArrayList<>();
        shortestDistances = new ArrayList<>();
        previousVertices = new ArrayList<>();
    }

    public void addVertex(Vertex vertex){
        vertices.add(vertex);
        shortestDistances.add(Integer.MAX_VALUE);
        previousVertices.add(null);
    }

    public void setShortestDistance(int index,int shortestDistance){
        shortestDistances.set(index,shortestDistance);
    }

    public void setPreviousVertex(int index, Vertex previousVertex){
        previousVertices.set(index,previousVertex);
    }

    public int getIndexOfVertex(Vertex vertex){
        return vertices.indexOf(vertex);
    }

    public Vertex findClosestUnvisitedVertex(ArrayList<Vertex> unvisitedVertices){
        if (unvisitedVertices.size() > 0) {
            Vertex closestVertex = unvisitedVertices.get(0);
            for (Vertex v : unvisitedVertices) {
                if (getShortestDistance(v) < getShortestDistance(closestVertex)) {
                    closestVertex = v;
                }
            }
            return closestVertex;
        }else{
            return null;
        }
    }

    public int getShortestDistance(Vertex vertex){
        return shortestDistances.get(vertices.indexOf(vertex));
    }
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Vertex | Shortest Distance | Prev Vertex\n");
        for (int i = 0; i < vertices.size();i++){
            builder.append(vertices.get(i) + " | ");
            builder.append(shortestDistances.get(i) + " | ");
            builder.append(previousVertices.get(i) + "\n");
        }
        return builder.toString();
    }
}
