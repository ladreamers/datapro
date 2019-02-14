package com.fork.cash.services.xxservice;

public class Factorial {

    int fact(int n) {
    int result;
    if ( n ==1) return 1;
        result = fact (n-1) * n;
    return result;

    }
}
