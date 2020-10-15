
package com.company;


public class Main {
    public static void main(String[] args){
        Triangle myTriangle = TriangleFactory.createTriangleThroughThreeSides(6,4,4);
        TriangleService.getTriangleInfo(myTriangle);
        Triangle myTriangle2 = TriangleFactory.createTriangleThroughThreeSides(9,6,6);
        TriangleService.getTriangleInfo(myTriangle2);
        TriangleService.isSimilar(myTriangle2,myTriangle);
    }
}
