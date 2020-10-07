
package com.company;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * Laba 5.Triangle
 *
 * @Autor: vovamv
 * @DateTime: 9/29/20|3:38 пп
 * @Version Triangle: 1.0
 */

public class Triangle {
    private double aSide;
    private double bSide;
    private double cSide;

    private double alphaCorner;
    private double betaCorner;
    private double gammaCorner;

    public Triangle() {
    }

    public Triangle(double aSide, double bSide, double cSide) {

        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
        this.checkSides();
        this.alphaCorner = this.countAlphaCorner();
        this.betaCorner = this.countBetaCorner();
        this.gammaCorner = this.countGammaCorner();
    }

    public Triangle(double bSide, double cSide, int alphaCorner) {
        this.bSide = bSide;
        this.cSide = cSide;
        this.alphaCorner = Math.toRadians(alphaCorner);
        this.aSide = this.getThirdSide();
        this.betaCorner = this.countBetaCorner();
        this.gammaCorner = this.countGammaCorner();
    }

    public Triangle(double cSide, int alphaCorner, int betaCorner) {
        this.cSide = cSide;
        this.alphaCorner = Math.toRadians(alphaCorner);
        this.betaCorner = Math.toRadians(betaCorner);
        this.gammaCorner = Math.toRadians(180 - betaCorner - alphaCorner);
        this.checkCorners();
        this.bSide = getSecondSide();
        this.aSide = getThirdSide();
    }

    public double countAlphaCorner(){
        return Math.acos((this.getBSide()*this.getBSide()+this.getCSide()*this.getCSide()-
                this.getASide()*this.getASide())/(2*this.getBSide()*this.getCSide()));
    }
    public double countBetaCorner(){
        return Math.acos((this.getASide()*this.getASide()+this.getCSide()*this.getCSide()-
                this.getBSide()*this.getBSide())/(2*this.getASide()*this.getCSide()));
    }
    public double countGammaCorner(){
        return Math.acos((this.getBSide()*this.getBSide()+this.getASide()*this.getASide()-
                this.getCSide()*this.getCSide())/(2*this.getBSide()*this.getASide()));
    }


    public double getASide() {
        return aSide;
    }

    public void setASide(double aSide) {
        this.aSide = aSide;
    }

    public double getBSide() {
        return bSide;
    }

    public void setBSide(double bSide) {
        this.bSide = bSide;
    }

    public double getCSide() {
        return cSide;
    }

    public void setCSide(double cSide) {
        this.cSide = cSide;
    }

    public double getAlphaCorner() {
        return Math.toDegrees(alphaCorner);
    }

    public void setAlphaCorner(double alphaCorner) {
        this.alphaCorner = Math.toRadians(alphaCorner);
    }

    public double getBetaCorner() {
        return Math.toDegrees(betaCorner);
    }

    public void setBetaCorner(double betaCorner) {
        this.betaCorner = Math.toRadians(betaCorner);
    }

    public double getGammaCorner() {
        return Math.toDegrees(gammaCorner);
    }

    public void setGammaCorner(double gammaCorner) {
        this.gammaCorner = Math.toRadians(gammaCorner);
    }


    public double getThirdSide(){
        return Math.sqrt(Math.pow(this.bSide,2) + Math.pow(this.cSide,2) - 2 * this.bSide *
                this.cSide * Math.cos(this.alphaCorner));
    }

    public double getSecondSide(){
        return this.cSide*Math.sin(this.betaCorner)/Math.sin(this.gammaCorner);
    }
    public void getTriangleType(){

        System.out.print("Цей трикутник є ");
        if(this.isRight()) { System.out.print("прямокутним трикутником."); }
        else if(this.isEquilateral()) { System.out.print("рівностороннім "); }
        else if(this.isIsosceles()) { System.out.print("рівнобедреним "); }
        else if(this.isScalene()) { System.out.print("різностороннім "); }
        if(this.isAcute()){ System.out.print("гострокутним трикутником."); }
        else if(this.isObtuse()){ System.out.print("тупокутним трикутником."); }
        System.out.println();
    }


    public void checkSides(){
        Scanner in = new Scanner(System.in);
        if (this.getASide() + this.getBSide() < this.getCSide() ||
                this.getBSide() + this.getCSide() < this.getASide() ||
                this.getASide() + this.getCSide() < this.getBSide()) {
            System.out.println("Невірно задані сторони трикутника. Задайте нові данні: ");
            System.out.println("Сторона а: ");
            this.setASide(in.nextDouble());
            System.out.println("Сторона b: ");
            this.setBSide(in.nextDouble());
            System.out.println("Сторона c: ");
            this.setCSide(in.nextDouble());
            this.checkSides();
        }
    }
    public void checkCorners(){
        Scanner in = new Scanner(System.in);
        if(this.getAlphaCorner() + this.getBetaCorner() >= 180 ||
        this.getAlphaCorner() == 0 || this.getBetaCorner() == 0) {
            System.out.println("Невірно задані кути. Введіть нові данні:");
            System.out.println("Введіть кут альфа: ");
            this.setAlphaCorner(in.nextDouble());
            System.out.println("Введіть кут бетта: ");
            this.setBetaCorner(in.nextDouble());
            this.checkCorners();
        }
    }

    public boolean isRight(){return this.getAlphaCorner() == 90 || this.getBetaCorner() == 90 || this.getGammaCorner() == 90;}
    public boolean isEquilateral(){return this.getAlphaCorner() == this.getBetaCorner() && this.getBetaCorner() == this.getGammaCorner();}
    public boolean isIsosceles(){return this.getAlphaCorner() == this.getBetaCorner() || this.getBetaCorner() == this.getGammaCorner() || this.getAlphaCorner() == this.getGammaCorner();}
    public boolean isScalene(){return this.getAlphaCorner() != this.getBetaCorner() && this.getBetaCorner() != this.getGammaCorner() && this.getAlphaCorner() != this.getGammaCorner();}
    public boolean isAcute(){return this.getAlphaCorner() < 90 && this.getBetaCorner() < 90 && this.getGammaCorner() < 90;}
    public boolean isObtuse(){return this.getAlphaCorner() > 90 || this.getBetaCorner() > 90 || this.getGammaCorner() > 90;}

    public double getPerimeter(){ return this.getASide() + this.getBSide() + this.getCSide(); }
    public double getArea(){
        double halfPerimeter = this.getPerimeter()/2;
        return Math.sqrt(halfPerimeter*(halfPerimeter-this.getASide())*
                (halfPerimeter-this.getBSide())*(halfPerimeter-this.getCSide()));
    }
    public double getInscribedCircle(){ return getArea()/(getPerimeter()/2); }
    public double getDescribedCircle(){ return (this.getASide()*this.getBSide()*this.getCSide())/(4*getArea()); }
    public double getMiddleLine(double side){ return side/2; }
    public double getHeight(double side){ return (2*this.getArea())/side; }
    public double getMedian(double side){
        double median = 0;
        if(side == this.getASide()) {
            median = Math.sqrt(2*this.getBSide()*this.getBSide() +
                    2*this.getCSide()*this.getCSide() - this.getASide()*this.getASide())/2;
        }
        else if(side == this.getBSide()){
            median = Math.sqrt(2*this.getASide()*this.getASide() +
                    2*this.getCSide()*this.getCSide() - this.getBSide()*this.getBSide())/2;
        }
        else{
           median = Math.sqrt(2*this.getBSide()*this.getBSide() +
                   2*this.getASide()*this.getASide() - this.getCSide()*this.getCSide())/2;
        }
        return median;
    }
    public double getBisector(double side){
        double bisector = 0;

        double halfPerimeter = this.getPerimeter()/2;
        if(side == this.getASide()) {
            bisector = (2*Math.sqrt(this.getBSide()*this.getCSide()*halfPerimeter*
                    (halfPerimeter-this.getASide()))) / (this.getBSide() + this.getCSide());
        }
        else if(side == this.getBSide()){
            bisector = (2*Math.sqrt(this.getASide()*this.getCSide()*halfPerimeter*
                    (halfPerimeter-this.getBSide()))) / (this.getASide() + this.getCSide());
        }
        else{
            bisector = (2*Math.sqrt(this.getASide()*this.getBSide()*halfPerimeter*
                    (halfPerimeter-this.getCSide()))) / (this.getASide() + this.getBSide());
        }
        return bisector;
    }

    public void getTriangleInfo(){
        String SidesAndCornersInfo = this.toString();
        System.out.println(SidesAndCornersInfo);
        this.getTriangleType();
        System.out.println(String.format("Периметр трикутника: %.2f", this.getPerimeter()) +
                String.format("\nПлоща трикутника: %.2f", this.getArea()) +
                String.format("\nРадіус вписаного кола в трикутник: %.2f", this.getInscribedCircle()) +
                String.format("\nРадіус описаного кола в трикутник: %.2f", this.getDescribedCircle()) +
                String.format("\nСередня лінія навпроти сторони a: %.2f", this.getMiddleLine(this.getASide())) +
                String.format("\nСередня лінія навпроти сторони b: %.2f", this.getMiddleLine(this.getBSide())) +
                String.format("\nСередня лінія навпроти сторони c: %.2f", this.getMiddleLine(this.getCSide())) +
                String.format("\nВисота опущена з вершини а: %.2f", this.getHeight(this.getASide())) +
                String.format("\nВисота опущена з вершини b: %.2f", this.getHeight(this.getBSide())) +
                String.format("\nВисота опущена з вершини а: %.2f", this.getHeight(this.getCSide())) +
                String.format("\nМедіана опущена з вершини а: %.2f", this.getMedian(this.getASide())) +
                String.format("\nМедіана опущена з вершини b: %.2f", this.getMedian(this.getBSide())) +
                String.format("\nМедіана опущена з вершини c: %.2f", this.getMedian(this.getCSide())) +
                String.format("\nБісектриса опущена з вершини а: %.2f", this.getBisector(this.getASide())) +
                String.format("\nБісектриса опущена з вершини b: %.2f", this.getBisector(this.getBSide())) +
                String.format("\nБісектриса опущена з вершини c: %.2f", this.getBisector(this.getCSide())));
    }
    @Override
    public String toString() {
        return "Triangle{" +
                String.format("aSide= %.2f", this.aSide) +
                String.format(", bSide= %.2f", this.bSide) +
                String.format(", cSide= %.2f", this.cSide) +
                String.format(", alphaCorner= %.2f", Math.toDegrees(this.alphaCorner))+
                String.format(", betaCorner= %.2f", Math.toDegrees(this.betaCorner)) +
                String.format(", gammaCorner= %.2f" , Math.toDegrees(this.gammaCorner)) +
                '}';
    }
}
