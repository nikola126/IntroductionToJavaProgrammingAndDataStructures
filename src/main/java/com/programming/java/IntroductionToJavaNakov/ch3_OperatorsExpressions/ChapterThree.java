package com.programming.java.IntroductionToJavaNakov.ch3_OperatorsExpressions;

public class ChapterThree {
    public static void taskOne() {
        int N = 1024;
        System.out.println(N + " even: " + (1024 % 2 == 0));
    }

    public static void taskTwo() {
        int N = 1035;
        System.out.print(N + " divisible by 3 and 5: ");
        System.out.println(1035 % 3 == 0 && 1035 % 5 == 0);
    }

    public static void taskThree() {
        int N = 10352;

        int thirdDigit = (N / 100) % 10;

        System.out.println(N + " Third digit is 7: " + (thirdDigit == 7));
    }

    public static void taskFour() {
        int N = 1035;

        int thirdBit = N & (1 << 3);
        thirdBit = (thirdBit != 0) ? 1 : 0;

        System.out.println("Third bit of " + N + " is: " + thirdBit);
    }

    public static void taskFive() {
        int width = 10;
        int length = 5;

        int perimeter = 2 * (width + length);
        int area = width * length;

        System.out.println("Width: " + width + " Length: " + length);
        System.out.println("Perimeter: " + perimeter);
        System.out.println("Area: " + area);
    }

    public static void taskSix() {
        int a = 5;
        int b = 3;
        int h = 4;

        int area = h * (a + b) / 2;

        System.out.println("A: " + a + " B: " + b + " H: " + h);
        System.out.println("Area of trapezoid: " + area);
    }

    public static void taskSeven() {
        float mass = 70.0f;
        float moonGravityPercentage = 100 - 17;

        float massOnMoon = (mass * moonGravityPercentage) / 100;

        System.out.println("Mass on Earth: " + mass);
        System.out.println("Mass on Moon: " + massOnMoon);
    }

    public static void taskEight() {
        float radius = 5;
        float centerX = 0;
        float centerY = 0;

        float pointX = 3;
        float pointY = 3;
        System.out.println("Point (" + pointX + "," + pointY + ")");

        // c^2 = a^2 + b^2 - 2*a*b*cos(c)
        double distanceToCenter = Math.sqrt(Math.pow(pointX, 2) + Math.pow(pointY, 2)
                - 2 * pointX * pointY * Math.cos(90));

        boolean inside = Math.abs(distanceToCenter - radius) < 0.001;
        System.out.println("Point inside circle: " + inside);
    }

    public static float area(float x1, float y1, float x2,
                             float y2, float x3, float y3) {
        return (float) Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }

    public static void taskNine() {
        // https://www.geeksforgeeks.org/check-whether-given-point-lies-inside-rectangle-not/

        float radius = 5;
        float centerCircleX = 0;
        float centerCircleY = 0;

        float botLeftX = -1;
        float botLeftY = 1;

        float topRightX = 5;
        float topRightY = 5;

        // derived

        float topLeftX = -1;
        float topLeftY = 5;

        float botRightX = 5;
        float botRightY = 1;

        float pointX = 3;
        float pointY = 3;
        System.out.println("Point (" + pointX + "," + pointY + ")");

        // c^2 = a^2 + b^2 - 2*a*b*cos(c)
        double distanceToCircleCenter = Math.sqrt(Math.pow(pointX, 2) + Math.pow(pointY, 2)
                - 2 * pointX * pointY * Math.cos(90));

        float ABCD = area(botLeftX, botLeftY, botRightX, botRightY, topRightX, topRightY) +
                area(botLeftX, botLeftY, topLeftX, topLeftY, topRightX, topRightY);

        float PAB = area(botLeftX, botLeftY, topRightX, topRightY, pointX, pointY);
        float PBC = area(topLeftX, topRightY, pointX, pointY, topRightX, topRightY);
        float PCD = area(topLeftX, topLeftY, pointX, pointY, botRightX, botRightY);
        float PAD = area(botLeftX, botRightY, pointX, pointY, botRightX, botRightY);


        boolean insideRectangle = (ABCD == PAB + PBC + PCD + PAD);

        boolean insideCircle = Math.abs(distanceToCircleCenter - radius) < 0.001;
        System.out.println("Point inside circle: " + insideCircle);
        System.out.println("Point inside rectangle: " + insideRectangle);
    }

    public static void taskTen() {
        int N = 1234;
        System.out.println("N = " + N);

        int digitFour = N % 10;
        N /= 10;
        int digitThree = N % 10;
        N /= 10;
        int digitTwo = N % 10;
        N /= 10;
        int digitOne = N;

        int sumOfDigits = digitOne + digitTwo + digitThree + digitFour;

        System.out.println("Sum of digits: " + sumOfDigits);
        System.out.println("" + digitFour + digitThree + digitTwo + digitOne);
        System.out.println("" + digitFour + digitTwo + digitThree + digitOne);
        System.out.println("" + digitOne + digitThree + digitTwo + digitFour);
    }

    public static void taskEleven() {
        int n = 35;
        int p = 5;
        int mask = 1 << p;

        int bitAtP = n & mask;

        System.out.println("N = " + n);
        System.out.print("Bit at position " + p + " is: ");
        System.out.println(bitAtP > 0 ? 1 : 0);
    }

    public static void taskTwelve() {
        int n = 35;
        int p = 2;
        int v = 1;

        System.out.println("n = " + n + " p = " + p + " v = " + v);

        int bitAtP = (n & (1 << p)) > 0 ? 1 : 0;
        System.out.println("Bit at p is: " + bitAtP);

        if (bitAtP > v) {
            n -= Math.pow(2, p);
        } else {
            n += Math.pow(2, p);
        }

        System.out.println("n = " + n);
    }

    public static void taskThirteen() {
        int N = 17;
        boolean isPrime = true;

        for (int i = N / 2; i >= 2; i--) {
            if (N % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(N + " is prime? " + isPrime);
    }

    public static void printAll() {
        taskOne();
        taskTwo();
        taskThree();
        taskFour();
        taskFive();
        taskSix();
        taskSeven();
        taskEight();
        taskNine();
        taskTen();
        taskEleven();
        taskTwelve();
        taskThirteen();
    }

    public static void main(String[] args) {
        printAll();
    }

}
