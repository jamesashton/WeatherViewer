package weather.viewer.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by james on 29/12/2016.
 */

@Component
public class HttpClientHelperImpl implements HttpClientHelper {

    @Autowired
    HttpClientBuilder httpClientBuilder;

    public String httpGetResponseAsString(String url) {
        try {
            HttpClient httpClient = httpClientBuilder.build();
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("accept", "text/json");
            HttpResponse response = httpClient.execute(httpGet);
            StatusLine status = response.getStatusLine();
            if(status.getStatusCode() != 200) {
                throw new Exception(status.getReasonPhrase());
            }
            return IOUtils.toString(response.getEntity().getContent());
        } catch(Exception e) {
            throw new RuntimeException("Unable to get http get response.",e);
        }
    }

}