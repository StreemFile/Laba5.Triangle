
package com.company;


public class Main {
    public static void main(String[] args){
        Triangle myTriangle = TriangleFactory.createTriangleThoughSideAndTwoAngles(28,140,60);
        TriangleService.getTriangleInfo(myTriangle);
        Triangle myTriangle2 = TriangleFactory.createTriangleThoughSideAndTwoAngles(50,14,60);
        TriangleService.getTriangleInfo(myTriangle2);
        TriangleService.getIsSimilar(myTriangle2,myTriangle);
    }
}
