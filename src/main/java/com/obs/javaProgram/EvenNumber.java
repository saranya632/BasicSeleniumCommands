package com.obs.javaProgram;

public class EvenNumber {

    public static void main(String args[]) {
        UtilMethod utilMethod = new UtilMethod();
        for (int i = 0; i < 10; i++) {
            boolean status = utilMethod.checkEven(i);
            if (status) {
                System.out.println(i);
            }

        }

    }
}
