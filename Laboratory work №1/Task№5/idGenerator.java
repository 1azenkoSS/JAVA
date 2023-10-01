package org.example;

class IdGenerator {
    private static Long orderIdGenerator = 0L;

    public static Long getId(){
        ++orderIdGenerator;
        return orderIdGenerator;
    }
}