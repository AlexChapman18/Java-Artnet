package com.mycompany.any;

public class Sleep {
    public Sleep(int millie){
        try {
            Thread.sleep(millie);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }
    }
}
