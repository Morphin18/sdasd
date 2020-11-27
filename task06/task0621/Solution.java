package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandFatherName = reader.readLine();
        Cat catGrandFather = new Cat(grandFatherName);

        String grandMotherName = reader.readLine();
        Cat catGrandMother = new Cat(grandMotherName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, null,catGrandFather);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, catGrandMother, null);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMother, catFather);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catFather);

        System.out.println(catGrandFather);
        System.out.println(catGrandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parent_one;
        private Cat parent_two;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parent_one, Cat parent_two) {
            this.name = name;
            this.parent_one = parent_one;
            this.parent_two = parent_two;

        }

        @Override
        public String toString() {
            if (parent_one == null && parent_two == null) {
                return "The cat's name is " + name + ", no mother, no father ";
            }
            else
                if (parent_one == null && parent_two != null) {
                    return "The cat's name is " + name + ", no mother, father is " + parent_two.name;
                }
                else
                    if (parent_one != null && parent_two == null)
                        return "The cat's name is " + name + ", mother is " + parent_one.name + ", no father";
                    else
                        return "The cat's name is " + name + ", mother is " + parent_one.name + ", father is " + parent_two.name;

        }
    }

}
