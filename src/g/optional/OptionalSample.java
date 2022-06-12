package g.optional;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalSample {
    public static void main(String[] args) {
        OptionalSample sample = new OptionalSample();
        sample.checkOptionalData();;
    }

    private void createOptionalObjects() {
        Optional<String> emptyString = Optional.empty(); // 데이터가 없는 Optional 객체 생성시 empty()사용
        String common = null;
        Optional<String> nullableString = Optional.ofNullable(common);  //null이 추가될 수 있는 상황일 때 Nullable메소드 사용
        common = "common";
        Optional<String> commonString = Optional.of(common); //반드시 데이터가 들어가야 할 때 of사용
    }

    private void checkOptionalData() {
        System.out.println(Optional.of("present").isPresent());
        System.out.println(Optional.ofNullable(null).isPresent());
    }

    private void getOptionalData(Optional<String> data) throws Exception {
        String defaultValue = "default";
        String result1 = data.get();
        String result2 = data.orElse(defaultValue);
        Supplier<String> stringSupplier = new Supplier<String>() {
            @Override
            public String get() {
                return "GodOfJava";
            }
        };

        String result3 = data.orElseGet(stringSupplier);


        Supplier<Exception> exceptionSupplier = new Supplier<Exception>() {
            @Override
            public Exception get() {
                return new Exception();
            }
        };

        String result4 = data.orElseThrow(exceptionSupplier);
    }
}
