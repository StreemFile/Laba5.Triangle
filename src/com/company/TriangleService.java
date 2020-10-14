

package com.company;

/**
 * Created by IntelliJ IDEA.
 * Laba 5.TriangleService
 *
 * @Autor: vovamv
 * @DateTime: 10/14/20|11:20 дп
 * @Version TriangleService: 1.0
 */

public class TriangleService {
    public static Double getAlphaAngle(Triangle thisTriangle) {
        try {
            return Math.acos((thisTriangle.getSideB() * thisTriangle.getSideB() + thisTriangle.getSideC() * thisTriangle.getSideC() -
                    thisTriangle.getSideA() * thisTriangle.getSideA()) / (2 * thisTriangle.getSideB() * thisTriangle.getSideC()));
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
            return null;
        }
    }

    public static Double getBetaAngle(Triangle thisTriangle) {
        try {
            return Math.acos((thisTriangle.getSideA() * thisTriangle.getSideA() + thisTriangle.getSideC() * thisTriangle.getSideC() -
                    thisTriangle.getSideB() * thisTriangle.getSideB()) / (2 * thisTriangle.getSideA() * thisTriangle.getSideC()));
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
            return null;
        }
    }

    public static Double getGammaAngle(Triangle thisTriangle) {
        try {
            return Math.acos((thisTriangle.getSideB() * thisTriangle.getSideB() + thisTriangle.getSideA() * thisTriangle.getSideA() -
                    thisTriangle.getSideC() * thisTriangle.getSideC()) / (2 * thisTriangle.getSideB() * thisTriangle.getSideA()));
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
            return null;
        }
    }

    private static Boolean isRight(Triangle thisTriangle) {
        try {
            return Math.round(Math.toDegrees(getAlphaAngle(thisTriangle))) == 90 ||
                    Math.round(Math.toDegrees(getBetaAngle(thisTriangle))) == 90 ||
                    Math.round(Math.toDegrees(getGammaAngle(thisTriangle))) == 90;
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
            return null;
        }
    }

    public static Boolean isEquilateral(Triangle thisTriangle) {
        try {
            return getAlphaAngle(thisTriangle) == getBetaAngle(thisTriangle) && getBetaAngle(thisTriangle) == getGammaAngle(thisTriangle);
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
            return null;
        }
    }

    public static Boolean isIsosceles(Triangle thisTriangle) {
        try {
            return getAlphaAngle(thisTriangle) == getBetaAngle(thisTriangle) || getBetaAngle(thisTriangle) == getGammaAngle(thisTriangle) || getAlphaAngle(thisTriangle) == getGammaAngle(thisTriangle);
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
            return null;
        }
    }

    public static Boolean isScalene(Triangle thisTriangle) {
        try {
            return getAlphaAngle(thisTriangle) != getBetaAngle(thisTriangle) && getBetaAngle(thisTriangle) != getGammaAngle(thisTriangle) && getAlphaAngle(thisTriangle) != getGammaAngle(thisTriangle);
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
            return null;
        }
    }

    public static Boolean isAcute(Triangle thisTriangle) {
        try {
            return Math.toDegrees(getAlphaAngle(thisTriangle)) < 90 &&
                    Math.toDegrees(getBetaAngle(thisTriangle)) < 90 &&
                    Math.toDegrees(getGammaAngle(thisTriangle)) < 90;
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
            return null;
        }
    }

    public static Boolean isObtuse(Triangle thisTriangle) {
        try {
            return Math.toDegrees(getAlphaAngle(thisTriangle)) > 90 ||
                    Math.toDegrees(getBetaAngle(thisTriangle)) > 90 ||
                    Math.toDegrees(getGammaAngle(thisTriangle)) > 90;
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
            return null;
        }
    }

    public static void getTriangleType(Triangle thisTriangle) {
        try {
            System.out.print("Цей трикутник є ");
            if (isRight(thisTriangle)) {
                System.out.print("прямокутним ");
            }
            if (isEquilateral(thisTriangle)) {
                System.out.print("рівностороннім ");
            } else if (isIsosceles(thisTriangle)) {
                System.out.print("рівнобедреним ");
            } else if (isScalene(thisTriangle)) {
                System.out.print("різностороннім ");
            }
            if (isObtuse(thisTriangle)) {
                System.out.print("тупокутним трикутником.");
            } else if (isAcute(thisTriangle)) {
                System.out.print("гострокутним трикутником.");
            }
            System.out.println();
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
        }
    }

    public static Double getPerimeter(Triangle thisTriangle) {
        try {
            double perimeter;
            perimeter = thisTriangle.getSideA() + thisTriangle.getSideB() + thisTriangle.getSideC();
            return perimeter;
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
            return null;
        }
    }

    public static Double getArea(Triangle thisTriangle) {
        try {
            double area;
            double halfPerimeter = getPerimeter(thisTriangle) / 2;
            area = Math.sqrt(halfPerimeter * (halfPerimeter - thisTriangle.getSideA()) *
                    (halfPerimeter - thisTriangle.getSideB()) * (halfPerimeter - thisTriangle.getSideC()));
            return area;
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
            return null;
        }
    }

    public static Double getInscribedCircle(Triangle thisTriangle) {
        try {
            double inscribedCircle;
            inscribedCircle = getArea(thisTriangle) / (getPerimeter(thisTriangle) / 2);
            return inscribedCircle;
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
            return null;
        }
    }

    public static Double getDescribedCircle(Triangle thisTriangle) {
        try {
            double describedCircle;
            describedCircle = (thisTriangle.getSideA() * thisTriangle.getSideB() * thisTriangle.getSideC()) / (4 * getArea(thisTriangle));
            return describedCircle;
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
            return null;
        }
    }

    public static Double getMiddleLine(double neededSide, Triangle thisTriangle) {
        try {
            double middleLine;
            middleLine = neededSide / 2;
            return middleLine;
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
            return null;
        }
    }

    public static Double getHeight(double neededSide, Triangle thisTriangle) {
        try {
            double height;
            height = (2 * getArea(thisTriangle)) / neededSide;
            return height;
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
            return null;
        }
    }

    public static Double getMedian(double neededSide, Triangle thisTriangle) {
        try {
            double median;

            if (neededSide == thisTriangle.getSideA()) {
                median = Math.sqrt(2 * thisTriangle.getSideB() * thisTriangle.getSideB() +
                        2 * thisTriangle.getSideC() * thisTriangle.getSideC() - thisTriangle.getSideA() * thisTriangle.getSideA()) / 2;
            } else if (neededSide == thisTriangle.getSideB()) {
                median = Math.sqrt(2 * thisTriangle.getSideA() * thisTriangle.getSideA() +
                        2 * thisTriangle.getSideC() * thisTriangle.getSideC() - thisTriangle.getSideB() * thisTriangle.getSideB()) / 2;
            } else {
                median = Math.sqrt(2 * thisTriangle.getSideB() * thisTriangle.getSideB() +
                        2 * thisTriangle.getSideA() * thisTriangle.getSideA() - thisTriangle.getSideC() * thisTriangle.getSideC()) / 2;
            }
            return median;
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
            return null;
        }
    }

    public static Double getBisector(double neededSide, Triangle thisTriangle) {
        try {
            double bisector;

            double halfPerimeter = getPerimeter(thisTriangle) / 2;
            if (neededSide == thisTriangle.getSideA()) {
                bisector = (2 * Math.sqrt(thisTriangle.getSideB() * thisTriangle.getSideC() * halfPerimeter *
                        (halfPerimeter - thisTriangle.getSideA()))) / (thisTriangle.getSideB() + thisTriangle.getSideC());
            } else if (neededSide == thisTriangle.getSideB()) {
                bisector = (2 * Math.sqrt(thisTriangle.getSideA() * thisTriangle.getSideC() * halfPerimeter *
                        (halfPerimeter - thisTriangle.getSideB()))) / (thisTriangle.getSideA() + thisTriangle.getSideC());
            } else {
                bisector = (2 * Math.sqrt(thisTriangle.getSideA() * thisTriangle.getSideB() * halfPerimeter *
                        (halfPerimeter - thisTriangle.getSideC()))) / (thisTriangle.getSideA() + thisTriangle.getSideB());
            }
            return bisector;
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
            return null;
        }
    }

    public static void getTriangleInfo(Triangle thisTriangle) {
        try {
            String sidesAndAnglesInfo = thisTriangle.toString();
            System.out.println(sidesAndAnglesInfo);
            getTriangleType(thisTriangle);
            System.out.println(String.format("Периметр трикутника: %.2f", getPerimeter(thisTriangle)) +
                    String.format("\nПлоща трикутника: %.2f", getArea(thisTriangle)) +
                    String.format("\nРадіус вписаного кола в трикутник: %.2f", getInscribedCircle(thisTriangle)) +
                    String.format("\nРадіус описаного кола в трикутник: %.2f", getDescribedCircle(thisTriangle)) +
                    String.format("\nСередня лінія навпроти сторони a: %.2f", getMiddleLine(thisTriangle.getSideA(), thisTriangle)) +
                    String.format("\nСередня лінія навпроти сторони b: %.2f", getMiddleLine(thisTriangle.getSideB(), thisTriangle)) +
                    String.format("\nСередня лінія навпроти сторони c: %.2f", getMiddleLine(thisTriangle.getSideC(), thisTriangle)) +
                    String.format("\nВисота опущена з вершини а: %.2f", getHeight(thisTriangle.getSideA(), thisTriangle)) +
                    String.format("\nВисота опущена з вершини b: %.2f", getHeight(thisTriangle.getSideB(), thisTriangle)) +
                    String.format("\nВисота опущена з вершини а: %.2f", getHeight(thisTriangle.getSideC(), thisTriangle)) +
                    String.format("\nМедіана опущена з вершини а: %.2f", getMedian(thisTriangle.getSideA(), thisTriangle)) +
                    String.format("\nМедіана опущена з вершини b: %.2f", getMedian(thisTriangle.getSideB(), thisTriangle)) +
                    String.format("\nМедіана опущена з вершини c: %.2f", getMedian(thisTriangle.getSideC(), thisTriangle)) +
                    String.format("\nБісектриса опущена з вершини а: %.2f", getBisector(thisTriangle.getSideA(), thisTriangle)) +
                    String.format("\nБісектриса опущена з вершини b: %.2f", getBisector(thisTriangle.getSideB(), thisTriangle)) +
                    String.format("\nБісектриса опущена з вершини c: %.2f", getBisector(thisTriangle.getSideC(), thisTriangle)));
            System.out.println();
        } catch (NullPointerException e) {
            System.out.println("Трикутник не існує");
        }
    }

    public static void getIsSimilar(Triangle thisTriangle, Triangle otherTriangle) {
        try {
            if (isSimilar(thisTriangle, otherTriangle)) {
                System.out.println("Трикутники подібні з відношенням " + getRatio(thisTriangle, otherTriangle));
            } else {
                System.out.println("Трикутники не подібні.");
            }
        } catch (NullPointerException e) {
            System.out.println("Один з трикутників не існує");
        }
    }

    public static String getRatio(Triangle thisTriangle, Triangle otherTriangle) {
        try {
            double firstTriangleSide = thisTriangle.getSideC();
            double secondTriangleSide = otherTriangle.getSideC();
            while ((firstTriangleSide % 2 == 0 && secondTriangleSide % 2 == 0) ||
                    (firstTriangleSide % 3 == 0 && secondTriangleSide % 3 == 0) ||
                    (firstTriangleSide % 5 == 0 && secondTriangleSide % 5 == 0) ||
                    (firstTriangleSide % 7 == 0 && secondTriangleSide % 7 == 0)) {
                if (firstTriangleSide % 2 == 0 && secondTriangleSide % 2 == 0) {
                    firstTriangleSide /= 2;
                    secondTriangleSide /= 2;
                } else if (firstTriangleSide % 3 == 0 && secondTriangleSide % 3 == 0) {
                    firstTriangleSide /= 3;
                    secondTriangleSide /= 3;
                } else if (firstTriangleSide % 5 == 0 && secondTriangleSide % 5 == 0) {
                    firstTriangleSide /= 5;
                    secondTriangleSide /= 5;
                } else {
                    firstTriangleSide /= 7;
                    secondTriangleSide /= 7;
                }
            }
            return (int) firstTriangleSide + ":" + (int) secondTriangleSide;
        } catch (NullPointerException e) {
            System.out.println("Один з трикутників не існує");
            return null;
        }
    }


    public static Boolean isSimilar(Triangle thisTriangle, Triangle otherTriangle) {
        try {
            boolean isSimilar = false;
            if (Math.round(Math.toDegrees(getAlphaAngle(thisTriangle)) * 1000.0) / 1000.0 == Math.round(Math.toDegrees(getAlphaAngle(otherTriangle)) * 1000.0) / 1000.0 &&
                    Math.round(Math.toDegrees(getBetaAngle(thisTriangle)) * 1000.0) / 1000.0 == Math.round(Math.toDegrees(getBetaAngle(otherTriangle)) * 1000.0) / 1000.0 &&
                    Math.round(Math.toDegrees(getGammaAngle(thisTriangle)) * 1000.0) / 1000.0 == Math.round(Math.toDegrees(getGammaAngle(otherTriangle)) * 1000.0) / 1000.0) {
                isSimilar = true;
            }

            if (Math.round(Math.toDegrees(getBetaAngle(thisTriangle)) * 1000.0) / 1000.0 == Math.round(Math.toDegrees(getAlphaAngle(otherTriangle)) * 1000.0) / 1000.0 &&
                    Math.round(Math.toDegrees(getAlphaAngle(thisTriangle)) * 1000.0) / 1000.0 == Math.round(Math.toDegrees(getBetaAngle(otherTriangle)) * 1000.0) / 1000.0 &&
                    Math.round(Math.toDegrees(getGammaAngle(thisTriangle)) * 1000.0) / 1000.0 == Math.round(Math.toDegrees(getGammaAngle(otherTriangle)) * 1000.0) / 1000.0) {
                isSimilar = true;
            }

            return isSimilar;
        } catch (NullPointerException e) {
            System.out.println("Один з трикутників не існує");
            return null;
        }
    }
}
