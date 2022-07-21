package com.obs.javaProgram;

public class UtilMethod {
    public boolean checkEven(int num) {
        boolean flag = false;
        int r = (num % 2);
        if (r == 0) {
            flag = true;
        }
        return flag;
    }
}
