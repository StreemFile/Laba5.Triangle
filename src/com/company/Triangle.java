
package com.company;


/**
 * Created by IntelliJ IDEA.
 * Laba 5.Triangle
 *
 * @Autor: vovamv
 * @DateTime: 9/29/20|3:38 пп
 * @Version Triangle: 1.0
 */

public class Triangle {
    private Float sideA;
    private Float sideB;
    private Float sideC;

    public Triangle() {
    }

    public Triangle(float sideA, float sideB, float sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;

    }

    public float getSideA() {
        return sideA;
    }

    public float getSideB() {
        return sideB;
    }

    public float getSideC() {
        return sideC;
    }

    @Override
    public String toString() {
        String info = "Triangle{" +
                    String.format("sideA= %.2f", this.sideA) +
                    String.format(", sideB= %.2f", this.sideB) +
                    String.format(", sideC= %.2f", this.sideC) +
                    String.format(", alphaAngle= %.2f", Math.toDegrees(TriangleService.getAlphaAngle(this))) +
                    String.format(", betaAngle= %.2f", Math.toDegrees(TriangleService.getBetaAngle(this))) +
                    String.format(", gammaAngle= %.2f", Math.toDegrees(TriangleService.getGammaAngle(this))) +
                    '}';
        return info;
    }
}
