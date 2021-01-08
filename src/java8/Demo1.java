package java8;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author shengyun
 * @date 2020/12/10
 */
public class Demo1 {

    public static void main(String[] args) {
        Stream<Double> generate = Stream.generate(Math::random).limit(2);
        System.out.println(Arrays.toString(generate.toArray()));

        Stream<Integer> iterate = Stream.iterate(1, s -> s * 2);
        System.out.println(Arrays.toString(iterate.peek(s -> System.out.println("test what? " + s)).limit(10).toArray()));

        List<String> strings = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaaaaaaa", "aaaaaa");
        Stream<String> sorted = strings.stream().sorted((o1, o2) -> o2.length() - o1.length());
        System.out.println(sorted.max(Comparator.comparingInt(String::length)).get());

        Optional<List<String>> optionalList = Optional.of(strings);
    }
}
