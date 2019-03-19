package cylong.lambda;

public class LambdaTest {

    private static int calc(int a, int b, Operation operation) {
        return operation.calc(a, b);
    }

    private static void say(String msg, Greeting greeting) {
        greeting.say(msg);
    }

    public static void main(String[] args) {
        // 类型声明
        Operation addition = (int a, int b) -> a + b;

        // 不用类型声明
        Operation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句。
        // 一般只有存在多行语句的时候才会使用，单行语句不需要使用，部分IDE会提示去掉大括号。
        Operation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        Operation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + LambdaTest.calc(10, 5, addition));
        System.out.println("10 - 5 = " + LambdaTest.calc(10, 5, subtraction));
        System.out.println("10 x 5 = " + LambdaTest.calc(10, 5, multiplication));
        System.out.println("10 / 5 = " + LambdaTest.calc(10, 5, division));

        // 不用括号
        Greeting sayHello = message -> System.out.println("Hello " + message);

        // 用括号
        Greeting sayBye = (message) -> System.out.println("Bye " + message);

        LambdaTest.say("cylong", sayHello);
        LambdaTest.say("cylong", sayBye);
        LambdaTest.say("cylong", message -> System.out.println("Hello " + message));

        // 以前的匿名方法
        LambdaTest.say("cylong", new Greeting() {
            @Override
            public void say(String msg) {
                System.out.println("Hello " + msg);
            }
        });
    }
}
