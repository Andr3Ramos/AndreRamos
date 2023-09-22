package org.codeforall.studio.exercise;

import java.util.Arrays;

public class Playground {

    public static void main(String[] args){

        Ai ai1 = new Ai("1992","Andre");


        System.out.println(ai1.getName("Joaquim"));
        System.out.println(ai1.getCreationDate(1990));


     // Double Array
        int [] myNums = {90,9,8,6};
        ai1.doubleArray(myNums);
        System.out.println(Arrays.toString(myNums));



     // Find Closest

        int[] numArray = {1,6,9,1,3,8,4,3,15,20};
        int[] find= ai1.findClosest(numArray);
        System.out.println(Arrays.toString(find));

     // Factorial Iterative


        int numArrayIterative= 5;
        int factorialIterative = ai1.factorialIterative(numArrayIterative);

        System.out.println(factorialIterative);

     // Factorial Recursive

        int numArrayRecursive= 5;
        int factorialRecursive = ai1.factorialRecursive(numArrayRecursive);

        System.out.println(factorialRecursive);
     // Palindrome
        String word= "tenetj iooi lola fred wadaw";
        System.out.println(ai1.palindrome(word));


     // Regex
        String regex = ai1.emailValidator("");
        String email="a@lol.com";
        boolean validEmail= email.matches(regex);

        System.out.println(validEmail);



    }
}