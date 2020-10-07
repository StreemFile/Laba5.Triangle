
package com.company;

import java.util.Scanner;

public class Main {

    public static Triangle createTriangleThroughThreeSides(double sideA, double sideB, double sideC){
        return new Triangle(sideA,sideB,sideC);
    }
    public static Triangle createTriangleThoughTwoSidesAndCorner(double sideB, double sideC,float alphaCorner){
        return new Triangle(sideB,sideC,alphaCorner);
    }
    public static Triangle createTriangleThoughSideAndTwoCorners(double sideC,float alphaCorner,float betaCorner){
        return new Triangle(sideC,alphaCorner,betaCorner);
    }

    public static void main(String[] args) {
        Triangle myTriangle = createTriangleThoughSideAndTwoCorners(10,70,30);
        myTriangle.getTriangleInfo();
        Triangle myTriangle2 = createTriangleThoughSideAndTwoCorners(5,30,70);
        myTriangle2.getTriangleInfo();
        myTriangle2.getIsSimilar(myTriangle);
    }
}
