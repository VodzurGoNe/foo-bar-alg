package org.gruzdov;

import java.util.Map;
import java.util.Optional;

public class Main {

    public static final String FOO_VALUE = "Foo";
    public static final String BAR_VALUE = "Bar";

    public static void main(String[] args) {
        try {
            int num = Integer.parseInt(args[0]);

            calculateHashTable(num);

        } catch (NumberFormatException e) {
            System.out.println("Error - NumberFormatException");
        }

    }

    private static void calculateBranching(int num) {
        boolean isMultipleFive = num % 5 == 0;

        if (num % 3 == 0) {
            if (isMultipleFive) {
                System.out.println(FOO_VALUE + BAR_VALUE);
            } else {
                System.out.println(FOO_VALUE);
            }

        } else if (isMultipleFive) {
            System.out.println(BAR_VALUE);
        } else {
            System.out.println(num);
        }

    }

    private static void calculateHashTable(final int num) {
        var sb = new StringBuilder();
        var map = Map.of(
                3, FOO_VALUE,
                5, BAR_VALUE
        );

        map.forEach((k, v) -> {
            if (num % k == 0) {
                sb.append(v);
            }
        });

        String result = sb.toString();
        System.out.println(result.isBlank() ? String.valueOf(num) : result);
    }

    private static void calculateOptionalVar(final int num) {
        String result = Optional.of(num)
                .filter(n -> (num % 3 == 0) && (num % 5 == 0))
                .map(n -> FOO_VALUE + BAR_VALUE)
                .orElseGet(() -> Optional.ofNullable(num % 3 == 0 ? FOO_VALUE : null)
                        .orElseGet(() -> Optional.ofNullable(num % 5 == 0 ? BAR_VALUE : null)
                                .orElseGet(() -> String.valueOf(num)))
                );

        System.out.println(result);
    }

}
