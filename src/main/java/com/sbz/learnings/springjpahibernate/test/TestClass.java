package com.sbz.learnings.springjpahibernate.test;


interface i1 {
    static void s1() {
        System.out.println("si1");
    }
    default void m1() {
        System.out.println("i1");
    }
}

interface i2 {
    default void m1() {
        System.out.println("i2");
    }
    static void s1() {
        System.out.println("si1");
    }
}

public class TestClass implements i1{

    @Override
    public void m1() {
        i1.super.m1();
//        i2.super.m1();
    }

    public static void main(String[] args) {
        TestClass t = new TestClass();
        t.m1();
        i1.s1();i2.s1();
    }


    //        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//
//        Integer reduce = list.stream().reduce(0, Integer::sum);
//        int sum = list.stream().mapToInt(integer -> integer).sum();
//        int sum1 = list.stream().mapToInt(Integer::intValue).sum();
//
//        List<Integer> integers = list.subList(0, 5);
//
//        Predicate<Integer> predicate = i -> i % 2 == 0;
//        Function<Integer, Integer> integerIntegerFunction = (a) -> a + a;
//        BiFunction<Integer, Integer, Integer> integerBiFunction = Integer::sum;
//        Supplier<String> stringSupplier = () -> "Hello";
//        Map<Boolean, List<Integer>> collect = list.stream().collect(Collectors.partitioningBy(predicate));
//
//        System.out.println(integerIntegerFunction.apply(10));
//        System.out.println(integerBiFunction.apply(10, 10));
//        System.out.println(stringSupplier.get());
//        System.out.println(collect);
}
