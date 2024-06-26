import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.Scanner;

public class TestClient {
    @Test
    public void testGet() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查询的ip");
        String ip = scanner.next();
//        发起get请求
        String url="https://restapi.amap.com/v3/ip?key=0113a13c88697dcea6a445584d535837&ip="+ip;
//        创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                //获取数据
//                response.getEntity().getContent(); 数据
                String json = EntityUtils.toString(response.getEntity());
                System.out.println(json);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //关闭资源
            client.close();

        }
    }
}
