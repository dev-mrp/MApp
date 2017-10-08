package com.gladiator.code.merchant.activity;

/**
 * Created by Mukesh on 6/8/2017.
 */

public class JavaTest {

    enum Checks {
        INSTANCE;

        Checks() {
            System.out.println("checks");
        }

        public void dowork() {
            System.out.println(" do work please ");
        }
    }


    public static void main(String[] args) {
        /*Checks.INSTANCE.dowork();
        Checks.INSTANCE.*/

       /* Base mBase = new Base();
        mBase.display();

        Child mChild = new Child();
        mChild.display();
*/

        Base mBase = new Base();
        mBase.display();

       /* Child2 mChild2 = new Child2();
        mChild2.display();
        mChild2.display1();*/


        Child mChild = new Child();
        mChild.display();
       // mChild.
    }


}


  class Base {

    public void display() {
        System.out.println("Base");
    }

    public void display1() {
        System.out.println("Base1");
    }

}

  class Child extends Base {

    public void display() {
       // super.display();
        System.out.println("Child");
    }

}
  class Child2 extends Child {

    public void display() {
        super.display();
        System.out.println("Child2");
    }

}
