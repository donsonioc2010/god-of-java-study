package c.string;

public class StringCheck {
    public static void main(String[] args) {
        StringCheck sample = new StringCheck();
        //length 0, 혹은 마지막이여야 메소드가 정상실행됨
        String addresses[] =new String[]{
            "서울시 구로구 신도림동",
            "경기도 성남시 분당구 정자동 개발 공장",
            "서울시 구로구 개봉동"
        };
        /*
        sample.checkAddress(addresses);
        sample.containsAddress(addresses);
        System.out.println("==========");
        sample.checkMatch();
        System.out.println("=====index====");
        sample.checkIndexOf();
        System.out.println("=====lastIndex====");
        sample.checkLastIndexOf();
        */
        //sample.checkSubstring();
        //sample.checkSplit();
        //sample.checkTrim();
        //sample.checkReplace();
        sample.checkFormat();
    }

    public void checkFormat() {
        String text = "제 이름은 %s입니다. 지금까지 %d 권의 책을 썼고,"
                + "하루에 %f %%의 시간을 책을 쓰는데 할애하고 있습니다.";

        String realText = String.format(text, "이상민", 7,10.5);
        //형식에 맞추지 않으면 exception
        //String realText = String.format(text, "이상민", 7);
        System.out.println(realText);

    }

    public void checkReplace() {
        String text ="The String class represents character strings.";
        System.out.println(text.replace('s', 'z'));
        System.out.println(text);
        System.out.println(text.replace("tring", "trike"));
        System.out.println(text.replaceAll(" ", "|"));
        System.out.println(text.replaceFirst(" ","|"));
    }

    public void checkTrim() {
        String strings[] = new String[] {
            " a", "b ","     c","d      ","e    f", "     "
        };
        for (String string : strings) {
            System.out.println("[" + string+ "] → " + "[" + string.trim()+ "]");
        }
        String text ="    a";
        if(text != null && text.trim().length() > 0) {
            System.out.println("OK");
        }
    }

    public void checkSplit() {
        String text = "Java technology is both a programming language and a platform.";
        //split에 정규식 넣을 수 있음...
        String[] splitArray = text.split(" ");
        for(String temp:splitArray) {
            System.out.println(temp);
        }
    }

    public void checkSubstring() {
        String text = "Java technology";
        String technology = text.substring(5);
        System.out.println(technology);

        String tech = text.substring(5,9);
        System.out.println(tech);
    }

    public void checkIndexOf() {
        String text = "Java technology is both a programming language and a platform.";
        System.out.println(text.indexOf('a'));
        System.out.println(text.indexOf("a "));
        System.out.println(text.indexOf('a', 20));
        System.out.println(text.indexOf("a ", 20));
        System.out.println(text.indexOf('z'));
    }

    public void checkLastIndexOf() {
        String text = "Java technology is both a programming language and a platform.";
        System.out.println(text.lastIndexOf('a'));
        System.out.println(text.lastIndexOf("a "));
        System.out.println(text.lastIndexOf('a', 20));
        System.out.println(text.lastIndexOf("a ", 20));
        System.out.println(text.lastIndexOf('z'));
    }

    public void checkMatch() {
        String text = "This is a text";
        String compare1 = "is";
        String compare2 = "this";

        //ignoreCase 없는 메소드
        System.out.println(text.regionMatches(2, compare1, 0, 1));
        System.out.println(text.regionMatches(5, compare1, 0, 2));

        //ignoreCase 사용한 메소드 true일 경우 대소문자 구분 X
        System.out.println(text.regionMatches(true, 0 , compare2, 0, 4));
        //toffset = text변수의 시작위치, 2번째(other) 매개변수는 text변수랑 비교할 문자열
        //ooffset은 other 문자열의 시작할 위치, len은 other에서 넘어준 문자열에서 몇개를 비교할지 1은 한개니까 is에서 i만 비교하는거임
    }

    public void containsAddress(String[] addresses) {
        int containCount = 0;
        String containText = "구로";
        for(String address : addresses) {
            if(address.contains(containText)) {
                containCount++;
            }
        }
        System.out.println("Contains " + containText + " conunt is " + containCount );
    }

    public void checkAddress(String[] addresses) {
        int startCount = 0, endCount = 0;
        String startText = "서울시";
        String endText = "동";

        for(String address : addresses) {
            if(address.startsWith(startText)) {
                startCount++;
            }
            if(address.endsWith(endText)) {
                endCount++;
            }
        }
        System.out.println("Starts With " + startText + " count is "+ startCount);
        System.out.println("Ends width " + endText + " count is " + endCount);
    }
}
