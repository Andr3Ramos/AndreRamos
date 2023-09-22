package org.codeforall.studio.exercise;
public class Ai {

    private String creationDate;
    private   String name;

    public int getCreationDate(int date){

        return date;
    }

    public void setCreationDate(String creationDate){

        this.creationDate= creationDate;
    }

    public String getName(String name){

        return name;
    }

    public void setName(String names){

        this.name= names;
    }

    public Ai(String firstCreationDate, String firstName)
    {
        creationDate= firstCreationDate;
        name = firstName;

    }
    //  Double Array
    public int[] doubleArray(int[] num) {
        int[] doubledNum = new int[num.length];
        for (int i= 0; i < num.length ; i++) {
            num[i] = num[i] * 2;


        }
        return doubledNum;
    }

    //Find Closest
    public int[] findClosest(int[] num) {
        int[] smallest = {num[0], num[1]};

        int[] closest = new int[2];
        int minDiff = Integer.MAX_VALUE;


        for (int i = 0; i < num.length - 1; i++) {

            int diff = num[i + 1] - num[i];
            if (diff < 0) {
                diff = -diff;
            }


            if (diff < minDiff) {
                minDiff = diff;
                closest[0] = num[i];
                closest[1] = num[i + 1];
            }
        }

        return closest;

    }


    // Factorial Iterative
    public int factorialIterative(int n){

        if(n==1){
            return 1;

        }

        return n * factorialIterative(n-1);
    }

    // Factorial Recursive
    public int factorialRecursive(int n) {

        int result= 1;
        for (int i = 1; i < n; i++) {
            result *= i+1;
        } return result;
    }

// Palindrome
    public String palindrome(String str) {

        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {

            boolean isPalindrome = true;
            int left = 0;
            int right = word.length() - 1;

            while (left < right) {

                if (Character.toLowerCase(word.charAt(left)) != Character.toLowerCase(word.charAt(right))) {

                    isPalindrome = false;

                    break;

                }
                left++;
                right--;
            }


            if (isPalindrome) {

                result.append("palindrome ");

            } else {

                result.append(word).append(" ");
            }
        }

        return result.toString().trim();
    }


    public String emailValidator(String email) {
        // Regular expression for email validation
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return regex;
    }



}



