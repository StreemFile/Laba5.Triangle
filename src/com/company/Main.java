
package com.company;

import java.util.Scanner;

public class Main {

    public static Triangle createTriangleThroughThreeSides(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть сторону а: ");
        double aSide = in.nextDouble();
        System.out.println("Введіть сторону b: ");
        double bSide = in.nextDouble();
        System.out.println("Введіть сторону c: ");
        double cSide = in.nextDouble();
        return new Triangle(aSide,bSide,cSide);
    }
    public static Triangle createTriangleThoughTwoSidesAndCorner(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть сторону b: ");
        double bSide = in.nextDouble();
        System.out.println("Введіть сторону c: ");
        double cSide = in.nextDouble();
        System.out.println("Введіть кут альфа: ");
        int alphaCorner = in.nextInt();
        return new Triangle(bSide,cSide,alphaCorner);
    }
    public static Triangle createTriangleThoughSideAndTwoCorner(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть сторону c: ");
        double cSide = in.nextDouble();
        System.out.println("Введіть кут альфа: ");
        int alphaCorner = in.nextInt();
        System.out.println("Введіть кут бетта: ");
        int bettaCorner = in.nextInt();
        return new Triangle(cSide,alphaCorner,bettaCorner);
    }
    public static void menu(){
        System.out.println("_____________________________________" +
                "\nЩоб задати трикутник за допомогою 3 сторін введіть 1." +
                "\nЩоб задати трикутник за допомогою 2 сторін та 1 кута введіть 2." +
                "\nЩоб задати трикутник за допомогою 1 сторіни та 2 кутів введіть 3." +
                "\nЩоб вийти з програми введіть будь-яке інше число." +
                "\n_____________________________________");
        Scanner in = new Scanner(System.in);
        int menu = in.nextInt();
        switch (menu) {
            case 1:
               Triangle triangleThroughThreeSides = createTriangleThroughThreeSides();
               triangleThroughThreeSides.getTriangleInfo();
                menu();
                break;
            case 2:
                Triangle triangleThoughTwoSidesAndCorner = createTriangleThoughTwoSidesAndCorner();
                triangleThoughTwoSidesAndCorner.getTriangleInfo();
                menu();
                break;
            case 3:
                Triangle triangleThoughSideAndTwoCorner = createTriangleThoughSideAndTwoCorner();
                triangleThoughSideAndTwoCorner.getTriangleInfo();
                menu();
                break;
            default:
                break;
        }

    }
    public static void main(String[] args) {
        menu();
    }
}
