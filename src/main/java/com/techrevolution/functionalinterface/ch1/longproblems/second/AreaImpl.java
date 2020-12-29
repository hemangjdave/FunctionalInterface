package com.techrevolution.functionalinterface.ch1.longproblems.second;

public class AreaImpl {
    public static void main(String[] args) {

        Integer integer1 = Integer.valueOf(10);
        Integer integer2 = Integer.valueOf(10);

        System.out.println(integer1 == integer2);

        Area circleArea = () -> Math.PI * 4 * 4;
        Area rectangle = () -> 5 * 4;
        System.out.println("Area of a circle with radius of 4 is:-" + circleArea.compute());
        System.out.println("Area of a rectangle with width and height of 4 is:-" + rectangle.compute());
    }
}
