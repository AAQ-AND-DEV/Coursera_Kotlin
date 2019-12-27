package week_2.extensions;

import static java.lang.System.out;
import static week_2.extensions.ExtensionsKt.*;

public class PracticeInterop {

    //static char c = ExtensionsKt.lastChar("abc");
    public static void main(String[] args){
        char c = lastChar("abc");
        out.println(c);
        out.println(repeat("ha", 5));

    }
}
