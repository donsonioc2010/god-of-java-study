package e.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


/* 참고자료
* https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=websearch&logNo=221930525766
* 지립니다 선생님
* */
public class FileInputTest {
    public static void Open( String strInputFileName ) throws Exception
    {
        InputStream in = null;

        try
        {
            in = new FileInputStream( new File( strInputFileName ) );
        }
        finally
        {
            // file handle leak 이 발생하는지 확인하기 위해서 주석 처리함
            // if( in != null ) in.close();
        }
    }

    public static void main( String [] args ) {
        for( int i = 0; i < 10; ++i )
        {
            try
            {
                System.out.println( i );
                Open( "/Users/kimjongwon/project/testCode/src/e/io/FileInputTest.java" );
                //Open( "./FileInputTest.java" );

                // Open 에서는 close 하지 않고 가비지 컬렉션을 실행하면 어떻게 되는지 확인하려면 아래의 주석을 해제하세요.
                // System.gc();

                Thread.sleep( 10000 );
            }
            catch( Exception e )
            {
                System.out.println( e );
            }
        }
    }
}
