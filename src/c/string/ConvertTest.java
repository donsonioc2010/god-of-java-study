package c.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertTest {
    public static void main(String[] args) {
        String str = "테스트12abc";
        List<String> charSet = new ArrayList<>(Arrays.asList("utf-8", "utf-16", "euc-kr", "ksc5601", "iso-8859-1", "x-windows-949"));

        charSet.forEach(v -> {
            charSet.forEach(e -> {
                try {
                    System.out.println(v + "," + e + " => Encording Result:"+ new String(str.getBytes(v), e));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
        });
    }
}
//utf-8,utf-8 => Encording Result:테스트12abc
//utf-8,utf-16 => Encording Result:賬誤렱㉡扣
//utf-8,euc-kr => Encording Result:���ㅽ��12abc
//utf-8,ksc5601 => Encording Result:���ㅽ��12abc
//utf-8,iso-8859-1 => Encording Result:íì¤í¸12abc
//utf-8,x-windows-949 => Encording Result:�뀒�뒪�듃12abc
//utf-16,utf-8 => Encording Result:���L¤Ҹ 1 2 a b c
//utf-16,utf-16 => Encording Result:테스트12abc
//utf-16,euc-kr => Encording Result:���L짚恬 1 2 a b c
//utf-16,ksc5601 => Encording Result:���L짚恬 1 2 a b c
//utf-16,iso-8859-1 => Encording Result:þÿÑLÂ¤Ò¸ 1 2 a b c
//utf-16,x-windows-949 => Encording Result:��L짚恬 1 2 a b c
//euc-kr,utf-8 => Encording Result:�׽�Ʈ12abc
//euc-kr,utf-16 => Encording Result:엗붺욮ㄲ慢�
//euc-kr,euc-kr => Encording Result:테스트12abc
//euc-kr,ksc5601 => Encording Result:테스트12abc
//euc-kr,iso-8859-1 => Encording Result:Å×½ºÆ®12abc
//euc-kr,x-windows-949 => Encording Result:테스트12abc
//ksc5601,utf-8 => Encording Result:�׽�Ʈ12abc
//ksc5601,utf-16 => Encording Result:엗붺욮ㄲ慢�
//ksc5601,euc-kr => Encording Result:테스트12abc
//ksc5601,ksc5601 => Encording Result:테스트12abc
//ksc5601,iso-8859-1 => Encording Result:Å×½ºÆ®12abc
//ksc5601,x-windows-949 => Encording Result:테스트12abc
//iso-8859-1,utf-8 => Encording Result:???12abc
//iso-8859-1,utf-16 => Encording Result:㼿㼱㉡扣
//iso-8859-1,euc-kr => Encording Result:???12abc
//iso-8859-1,ksc5601 => Encording Result:???12abc
//iso-8859-1,iso-8859-1 => Encording Result:???12abc
//iso-8859-1,x-windows-949 => Encording Result:???12abc
//x-windows-949,utf-8 => Encording Result:�׽�Ʈ12abc
//x-windows-949,utf-16 => Encording Result:엗붺욮ㄲ慢�
//x-windows-949,euc-kr => Encording Result:테스트12abc
//x-windows-949,ksc5601 => Encording Result:테스트12abc
//x-windows-949,iso-8859-1 => Encording Result:Å×½ºÆ®12abc
//x-windows-949,x-windows-949 => Encording Result:테스트12abc
