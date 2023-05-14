/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Karthik M
 */
public class NewClass extends JFrame{
    
    private int[][] maze = {{1,1,1,1,1,1,1,1,1,1,1,1,1},
                             {1,0,1,0,1,0,1,0,0,0,0,0,1},
                             {1,0,1,0,0,0,1,0,1,1,1,0,1},
                             {1,0,1,1,1,1,1,0,0,0,0,0,1},
                             {1,0,0,1,0,0,0,0,1,1,1,0,1},
                             {1,0,1,0,1,1,1,0,1,0,0,0,1},
                             {1,0,1,0,1,0,0,0,1,1,1,0,1},
                             {1,0,1,0,1,1,1,0,1,0,1,0,1},
                             {1,0,0,0,0,0,0,0,0,0,1,9,1},
                             {1,1,1,1,1,1,1,1,1,1,1,1,1}
                           };
    
    public List<Integer> path = new ArrayList<>();
    
    NewClass(){
        setTitle("Maze Solver");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchPath(maze, 1, 1, path);
        System.out.print(path);
        
    }
    
    @Override
    public void paint(Graphics g){
        g.translate(200, 120);
        
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length; j++){
                Color color;
                switch(maze[i][j]){
                    case 1: color = Color.BLACK; break;
                    case 9: color = Color.red; break;
                    default : color = Color.white; 
                    
                }
                g.setColor(color);
                g.fillRect(30*j, 30*i, 30, 30);
                g.setColor(Color.red);
                g.drawRect(30*j, 30*i, 30, 30);
            }
        }
        
        for(int i=0; i<path.size(); i+=2){
            int pathx= path.get(i);
            int pathY = path.get(i+1);
            System.out.println("X coordinates " + pathx);
            System.out.println("Y coordinates " + pathY);
            
            g.setColor(Color.green);
            g.fillRect(30*pathx, 30*pathY, 20, 20);
        }
        
    }
    
    public static void main(String args[]){
        NewClass view = new NewClass();
        view.setVisible(true);
    }
}
