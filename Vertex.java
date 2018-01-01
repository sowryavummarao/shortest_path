package com.shortest_path;

/**
 * Created by sowryavummarao on 12/19/17.
 */
public class Vertex {
    private String name;

    public Vertex(){
        this("No Name");
    }

    public Vertex(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return String.format("Vertex(%s)",name);
    }
}
