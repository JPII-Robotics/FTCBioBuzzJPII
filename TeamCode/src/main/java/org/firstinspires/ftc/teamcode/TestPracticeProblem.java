package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.PracticeProblem.strStr;

public class TestPracticeProblem {
    public static void main(String[] args) {
        String firstHaystack = "sadbutsad";
        String firstNeedle = "sad";
        boolean case1 = strStr(firstHaystack, firstNeedle) == 0;

        String secondHaystack = "fireman";
        String secondNeedle = "water";
        boolean case2 = strStr(secondHaystack, secondNeedle) == -1;

        String thirdHaystack = "marypoppins";
        String thirdNeedle = "pop";
        boolean case3 = strStr(thirdHaystack, thirdNeedle) == 4;

        if (case1 && case2 && case3) {
            System.out.println("Your function seems to work!");
        } else {
            System.out.println("Check your code or ask for help, you have messed up.");
        }
    }
}
