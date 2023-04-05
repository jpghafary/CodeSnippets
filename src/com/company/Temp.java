package com.company;

interface BaseI {
    void method();
}

class BaseC {
    public void method(){
        System.out.println("123");
    }
}

class Temp extends BaseC implements BaseI {

    public static void main(String args[]){
        (new Temp()).method();
    }
}
