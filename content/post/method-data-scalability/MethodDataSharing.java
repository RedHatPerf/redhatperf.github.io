package redhat.app.services.benchmark;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.CompilerControl;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/**
 * This benchmark should be used with the following JVM options to tune the tier compilation level:
 * -XX:TieredStopAtLevel=
 *
 */
@State(Scope.Benchmark)
@Fork(2)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
public class MethodDataSharing {

    @Benchmark
    public void doFoo() {
        foo(1000, true);
    }


    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    private static int foo(int count, boolean countAll) {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (countAll) {
                total++;
            }
        }
        return total;
    }
}