/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlo;

/**
 *
 * @author jameswilliams
 */
import java.util.stream.IntStream;
import java.util.stream.DoubleStream;

import static java.lang.Math.random;
import static java.lang.Math.hypot;
import static java.lang.System.out;

public interface MonteCarlo {

    public static void main(String[] args) {
        IntStream.of(
                10000,
                100000,
                1000000,
                10000000,
                100000000
        )
                .mapToDouble(MonteCarlo::pi)
                .forEach(out::println);
    }

    public static double range() {
        //a square with a side of length 2 centered at 0 has 
        //x and y range of -1 to 1
        return (random() * 2) - 1;
    }

    public static double pi(int numThrows) {
        long inCircle = DoubleStream.generate(
                //distance from (0,0) = hypot(x, y)
                () -> hypot(range(), range())
        )
                .limit(numThrows)
                .unordered()
                .parallel()
                //circle with diameter of 2 has radius of 1
                .filter(d -> d < 1)
                .count();
        return (4.0 * inCircle) / numThrows;
    }
}
