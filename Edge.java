package com.shortest_path;

/**
 * Created by sowryavummarao on 12/19/17.
 */
public class Edge {
    private Vertex vertex1;
    private Vertex vertex2;

    private int weight;

    public Edge(){

    }

    public Edge(Vertex vertex1, Vertex vertex2, int weight ){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    public Vertex getVertex1(){
        return vertex1;
    }
    public Vertex getVertex2(){
        return vertex2;
    }
    public int getWeight(){
        return weight;
    }

    public void setVertex1(Vertex vertex1){
        this.vertex1 = vertex1;
    }

    public void setVertex2(Vertex vertex2){
        this.vertex2 = vertex2;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public String toString(){
        return (vertex1.toString() + "<---->" + vertex2.toString());
    }

    public boolean contains(Vertex v){
        return (v == vertex1 || v == vertex2);
    }

    public Vertex getOtherVertex(Vertex v){
        if (v == vertex1){
            return vertex2;
        }else if (v == vertex2){
            return vertex1;
        }
        else {
            return null;
        }
    }
}
