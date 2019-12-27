package week_2;

import static week_2.FunFunctionsKt.sum;
import static java.lang.System.out;

public class UsingSumOverloads {
    public static void main(String[] args){
        //without @JvmOverloads overload not accessible,
        //must provide all arguments w/out @JvmOverloads
        System.out.println(sum(1));
        out.println(sum());
        out.println(sum(1,2,3));

    }

}
