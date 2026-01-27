/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThread extends Thread{

    private int first;
    private int second;

    public CountThread(int first, int second){
        this.first = first;
        this.second = second;
    }

    public void run(){
        for(int i=first; i<=second; i++){
            System.out.println(i);
        }
    }
}
