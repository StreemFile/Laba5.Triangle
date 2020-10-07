
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
    private double sideA;
    private double sideB;
    private double sideC;
    private boolean isValid;
    public Triangle() {
    }

    public Triangle(double sideA, double sideB, double sideC) {

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.isValid = this.isValidSide();

    }

    public Triangle(double sideB, double sideC, float alphaCorner) {
        this.sideB = sideB;
        this.sideC = sideC;
        this.sideA = this.getThirdSide((float) Math.toRadians(alphaCorner));
        this.isValid = this.isValidCorner(alphaCorner);
    }

    public Triangle(double sideC, float alphaCorner, float betaCorner) {
        this.sideC = sideC;
        this.sideB = getSecondSide((float) Math.toRadians(betaCorner), (float) Math.toRadians(180 - alphaCorner - betaCorner));
        this.sideA = getThirdSide((float) Math.toRadians(alphaCorner));
        this.isValid = this.isValidCorner(alphaCorner,betaCorner);
    }

    public double getAlphaCorner(){
        return Math.acos((this.getSideB()*this.getSideB()+this.getSideC()*this.getSideC()-
                this.getSideA()*this.getSideA())/(2*this.getSideB()*this.getSideC()));
    }
    public double getBetaCorner(){
        return Math.acos((this.getSideA()*this.getSideA()+this.getSideC()*this.getSideC()-
                this.getSideB()*this.getSideB())/(2*this.getSideA()*this.getSideC()));
    }
    public double getGammaCorner(){
        return Math.acos((this.getSideB()*this.getSideB()+this.getSideA()*this.getSideA()-
                this.getSideC()*this.getSideC())/(2*this.getSideB()*this.getSideA()));
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
        if(!this.isValidSide()) this.setValid(false);
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
        if(!this.isValidSide()) this.setValid(false);
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
        if(!this.isValidSide()) this.setValid(false);
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public double getThirdSide(float alphaCorner){
        return Math.sqrt(Math.pow(this.sideB,2) + Math.pow(this.sideC,2) - 2 * this.sideB *
                this.sideC * Math.cos(alphaCorner));
    }

    public double getSecondSide(float betaCorner, float gammaCorner){
        return this.sideC*Math.sin(betaCorner)/Math.sin(gammaCorner);
    }

    public boolean isValidCorner(float cornerAlpha){
        boolean isValid = true;
        if(cornerAlpha>= 180 || cornerAlpha <= 0) {
            System.out.println("Трикутник з заданим кутом не існує");
            isValid = false;
        }
        return isValid;
    }

    public boolean isValidCorner(float cornerAlpha, float cornerBeta){
        boolean isValid = true;
        if(cornerAlpha + cornerBeta >= 180 ||
                cornerAlpha <= 0 || cornerBeta <= 0 ) {
            System.out.println("Трикутник з заданими кутами не існує.");
            isValid = false;
        }
        return isValid;
    }

    public boolean isValidSide(){
    boolean isValid = true;
        if (this.getSideA() + this.getSideB() < this.getSideC() ||
                this.getSideB() + this.getSideC() < this.getSideA() ||
                this.getSideA() + this.getSideC() < this.getSideB()) {
            System.out.println("Трикутник з заданими сторонами не існує.");
            isValid = false;
        }

        return isValid;
    }

    public boolean isRight(){
        return Math.round(Math.toDegrees(this.getAlphaCorner())) == 90 ||
                Math.round(Math.toDegrees(this.getBetaCorner())) == 90 ||
                Math.round(Math.toDegrees(this.getGammaCorner())) == 90;
    }
    public boolean isEquilateral(){return this.getAlphaCorner() == this.getBetaCorner() && this.getBetaCorner() == this.getGammaCorner();}
    public boolean isIsosceles(){return this.getAlphaCorner() == this.getBetaCorner() || this.getBetaCorner() == this.getGammaCorner() || this.getAlphaCorner() == this.getGammaCorner();}
    public boolean isScalene(){return this.getAlphaCorner() != this.getBetaCorner() && this.getBetaCorner() != this.getGammaCorner() && this.getAlphaCorner() != this.getGammaCorner();}
    public boolean isAcute(){return Math.toDegrees(this.getAlphaCorner()) < 90 &&
            Math.toDegrees(this.getBetaCorner()) < 90 &&
            Math.toDegrees(this.getGammaCorner()) < 90;}
    public boolean isObtuse(){return Math.toDegrees(this.getAlphaCorner()) > 90 ||
            Math.toDegrees(this.getBetaCorner()) > 90 ||
            Math.toDegrees(this.getGammaCorner()) > 90;}

    public void getTriangleType(){
        System.out.print("Цей трикутник є ");
        if(this.isRight()) { System.out.print("прямокутним "); }
        if(this.isEquilateral()) { System.out.print("рівностороннім "); }
        else if(this.isIsosceles()) { System.out.print("рівнобедреним "); }
        else if(this.isScalene()) { System.out.print("різностороннім "); }
        if(this.isObtuse()){ System.out.print("тупокутним трикутником."); }
        else if(this.isAcute()){ System.out.print("гострокутним трикутником."); }
        System.out.println();
    }

    public double getPerimeter(){
        double perimeter = 0;
        if(this.isValid()) {
            perimeter = this.getSideA() + this.getSideB() + this.getSideC();
        }
        else{
            System.out.println("Неможливо розрахувати периметр оскільки трикутник не існує.");
        }
        return perimeter;
    }
    public double getArea(){
        double area = 0;
        double halfPerimeter = this.getPerimeter()/2;
        if(this.isValid()) {
            area = Math.sqrt(halfPerimeter * (halfPerimeter - this.getSideA()) *
                    (halfPerimeter - this.getSideB()) * (halfPerimeter - this.getSideC()));
        }
        else{
            System.out.println("Неможливо розрахувати площу оскільки трикутник не існує.");
        }
        return area;
    }
    public double getInscribedCircle(){
        double inscribedCircle = 0;
        if(this.isValid()) {
            inscribedCircle = getArea()/(getPerimeter()/2);
        }
        else{
            System.out.println("Неможливо розрахувати радіус вписаного кола оскільки трикутник не існує.");
        }
        return inscribedCircle;
    }
    public double getDescribedCircle(){
        double describedCircle = 0;
        if(this.isValid()) {
            describedCircle = (this.getSideA()*this.getSideB()*this.getSideC())/(4*getArea());
        }
        else{
            System.out.println("Неможливо розрахувати радіус описаного кола оскільки трикутник не існує.");
        }
        return describedCircle;
    }
    public double getMiddleLine(double side){
        double middleLine = 0;
        if(this.isValid()) {
            middleLine = side/2;
        }
        else{
            System.out.println("Неможливо розрахувати середню лінію оскільки трикутник не існує.");
        }
        return middleLine;
    }
    public double getHeight(double side){
        double height = 0;
        if(this.isValid()) {
            height = (2*this.getArea())/side;
        }
        else{
            System.out.println("Неможливо розрахувати висоту оскільки трикутник не існує.");
        }
        return height;
    }
    public double getMedian(double side){
        double median = 0;
        if(this.isValid()) {
            if (side == this.getSideA()) {
                median = Math.sqrt(2 * this.getSideB() * this.getSideB() +
                        2 * this.getSideC() * this.getSideC() - this.getSideA() * this.getSideA()) / 2;
            } else if (side == this.getSideB()) {
                median = Math.sqrt(2 * this.getSideA() * this.getSideA() +
                        2 * this.getSideC() * this.getSideC() - this.getSideB() * this.getSideB()) / 2;
            } else {
                median = Math.sqrt(2 * this.getSideB() * this.getSideB() +
                        2 * this.getSideA() * this.getSideA() - this.getSideC() * this.getSideC()) / 2;
            }
        }
        else{
            System.out.println("Неможливо розрахувати медіану оскільки трикутник не існує.");
        }
        return median;
    }
    public double getBisector(double side){
        double bisector = 0;

        double halfPerimeter = this.getPerimeter()/2;
        if(this.isValid()) {
            if (side == this.getSideA()) {
                bisector = (2 * Math.sqrt(this.getSideB() * this.getSideC() * halfPerimeter *
                        (halfPerimeter - this.getSideA()))) / (this.getSideB() + this.getSideC());
            } else if (side == this.getSideB()) {
                bisector = (2 * Math.sqrt(this.getSideA() * this.getSideC() * halfPerimeter *
                        (halfPerimeter - this.getSideB()))) / (this.getSideA() + this.getSideC());
            } else {
                bisector = (2 * Math.sqrt(this.getSideA() * this.getSideB() * halfPerimeter *
                        (halfPerimeter - this.getSideC()))) / (this.getSideA() + this.getSideB());
            }
        }
        else{
            System.out.println("Неможливо розрахувати бісектрису оскільки трикутник не існує.");
        }
        return bisector;
    }

    public void getTriangleInfo(){
        if(this.isValid()) {
            String sidesAndCornersInfo = this.toString();
            System.out.println(sidesAndCornersInfo);
            this.getTriangleType();
            System.out.println(String.format("Периметр трикутника: %.2f", this.getPerimeter()) +
                    String.format("\nПлоща трикутника: %.2f", this.getArea()) +
                    String.format("\nРадіус вписаного кола в трикутник: %.2f", this.getInscribedCircle()) +
                    String.format("\nРадіус описаного кола в трикутник: %.2f", this.getDescribedCircle()) +
                    String.format("\nСередня лінія навпроти сторони a: %.2f", this.getMiddleLine(this.getSideA())) +
                    String.format("\nСередня лінія навпроти сторони b: %.2f", this.getMiddleLine(this.getSideB())) +
                    String.format("\nСередня лінія навпроти сторони c: %.2f", this.getMiddleLine(this.getSideC())) +
                    String.format("\nВисота опущена з вершини а: %.2f", this.getHeight(this.getSideA())) +
                    String.format("\nВисота опущена з вершини b: %.2f", this.getHeight(this.getSideB())) +
                    String.format("\nВисота опущена з вершини а: %.2f", this.getHeight(this.getSideC())) +
                    String.format("\nМедіана опущена з вершини а: %.2f", this.getMedian(this.getSideA())) +
                    String.format("\nМедіана опущена з вершини b: %.2f", this.getMedian(this.getSideB())) +
                    String.format("\nМедіана опущена з вершини c: %.2f", this.getMedian(this.getSideC())) +
                    String.format("\nБісектриса опущена з вершини а: %.2f", this.getBisector(this.getSideA())) +
                    String.format("\nБісектриса опущена з вершини b: %.2f", this.getBisector(this.getSideB())) +
                    String.format("\nБісектриса опущена з вершини c: %.2f", this.getBisector(this.getSideC())));
        }
        else{
            System.out.println("Неможливо вивести інформацію оскільки трикутник не існує.");
        }
        System.out.println();
    }
    public void getIsSimilar(Triangle otherTriangle){
    if(this.isValid() && otherTriangle.isValid()) {
        if (this.isSimilar(otherTriangle)) {
            System.out.println("Трикутники подібні з відношенням " + getRatio(otherTriangle));
        } else {
            System.out.println("Трикутники не подібні.");
        }
    }
    else System.out.println("Неможливо порівняти оскільки один з трикутникіи не існує.");
    }
    public String getRatio(Triangle otherTriangle){
        double firstTriangleSide = this.getSideC();
        double secondTriangleSide = otherTriangle.getSideC();
        while ((firstTriangleSide % 2 == 0  && secondTriangleSide % 2 == 0) ||
                (firstTriangleSide % 3 == 0  && secondTriangleSide % 3 == 0) ||
                (firstTriangleSide % 5 == 0  && secondTriangleSide % 5 == 0) ||
                (firstTriangleSide % 7 == 0  && secondTriangleSide % 7 == 0)){
            if(firstTriangleSide % 2 == 0  && secondTriangleSide % 2 == 0){
                firstTriangleSide /= 2;
                secondTriangleSide /=2;
            }
            else if(firstTriangleSide % 3 == 0  && secondTriangleSide % 3 == 0){
                firstTriangleSide /= 3;
                secondTriangleSide /=3;
            }
            else if(firstTriangleSide % 5 == 0  && secondTriangleSide % 5 == 0){
                firstTriangleSide /= 5;
                secondTriangleSide /=5;
            }
            else{
                firstTriangleSide /= 7;
                secondTriangleSide /=7;
            }
        }
       return (int)firstTriangleSide + ":" + (int)secondTriangleSide;
    }
//public boolean isSimilar(Triangle otherTriangle){
//    boolean isSimilar = false;
//    if(this.isValid && otherTriangle.isValid) {
//        if (this.getPerimeter() > otherTriangle.getPerimeter()) {
//            System.out.println((Math.round((this.getPerimeter() / otherTriangle.getPerimeter()) * 1000.0) / 1000.0));
//            if ((Math.round((this.getPerimeter() / otherTriangle.getPerimeter()) * 1000.0) / 1000.0) % 1 == 0)
//                isSimilar = true;
//        } else {
//            if ((Math.round((otherTriangle.getPerimeter() % this.getPerimeter()) * 1000.0) / 1000.0)  % 1 == 0)
//                isSimilar = true;
//        }
//    } else {
//        System.out.println("Один з трикутників не існує.");
//    }
//    return isSimilar;
//}

    public boolean isSimilar(Triangle otherTriangle){
        boolean isSimilar = false;
        if (Math.round(Math.toDegrees(this.getAlphaCorner())*100000.0)/100000.0 == Math.round(Math.toDegrees(otherTriangle.getAlphaCorner())*100000.0)/100000.0 &&
                Math.round(Math.toDegrees(this.getBetaCorner())*100000.0)/100000.0 == Math.round(Math.toDegrees(otherTriangle.getBetaCorner())*100000.0)/100000.0 &&
                Math.round(Math.toDegrees(this.getGammaCorner())*100000.0)/100000.0 == Math.round(Math.toDegrees(otherTriangle.getGammaCorner())*100000.0)/100000.0 ){
            isSimilar = true;
        }

        if (Math.round(Math.toDegrees(this.getBetaCorner())*100000.0)/100000.0 == Math.round(Math.toDegrees(otherTriangle.getAlphaCorner())*100000.0)/100000.0 &&
                Math.round(Math.toDegrees(this.getAlphaCorner())*100000.0)/100000.0 == Math.round(Math.toDegrees(otherTriangle.getBetaCorner())*100000.0)/100000.0 &&
                Math.round(Math.toDegrees(this.getGammaCorner())*100000.0)/100000.0 == Math.round(Math.toDegrees(otherTriangle.getGammaCorner())*100000.0)/100000.0 ){
            isSimilar = true;
        }

        return isSimilar;
    }


    @Override
    public String toString() {
        String info = "";
        if(this.isValid) {
            info = "Triangle{" +
                    String.format("sideA= %.2f", this.sideA) +
                    String.format(", sideB= %.2f", this.sideB) +
                    String.format(", sideC= %.2f", this.sideC) +
                    String.format(", alphaCorner= %.2f", Math.toDegrees(this.getAlphaCorner())) +
                    String.format(", betaCorner= %.2f", Math.toDegrees(this.getBetaCorner())) +
                    String.format(", gammaCorner= %.2f", Math.toDegrees(this.getGammaCorner())) +
                    '}';
        }
        else{
            System.out.println("Неможливо вивести інформацію оскільки трикутник не існує.");
        }
        return info;
    }
}
