package c.string;

public class aboutStringSeries {
    public static void main(String[] args) {
        aboutStringSeries sample = new aboutStringSeries();

        sample.testString();
        sample.testStringBuilder();
    }

    void testString() {
        long startTime = System.currentTimeMillis();
        String result = "";
        for(int i=0; i<5; i++){
            result += "abcd";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("걸린 시간 : " + (float)(endTime-startTime)/1000 + "초");
    }

    void testStringBuilder() {
        long startTime = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder(4 * 100000);
        for(int i=0; i<5; i++){
            builder.append("abcd");
        }
        String result = builder.toString();
        long endTime = System.currentTimeMillis();
        System.out.println("걸린 시간 : " + (float)(endTime-startTime)/1000 + "초");
    }

}
