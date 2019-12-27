package week_3.functional;

public class interopRunnable {

    static void postponeComputation(int delay, Runnable computation){
        //count to delay
        computation.run();
    }

    public static void main(String[] args){
        //done in Kotlin in FunctionTypesMoreLambdas.kt
        //postponeComputation(15){}
    }
}
