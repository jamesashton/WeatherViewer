package weather.viewer.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by james on 29/12/2016.
 */
public class HttpClientHelperTest {

    @InjectMocks
    private HttpClientHelper httpClientHelper = new HttpClientHelperImpl();

    @Mock
    private HttpClientBuilder httpClientBuilder;

    InputStream inputStream;

    String json;

    @Before
    public void setup() throws IOException {
        inputStream = getClass().getClassLoader().getResourceAsStream("data/currentweatherdata.json");
        json = new String(Files.readAllBytes(Paths.get(new File(getClass().getClassLoader().getResource("data/currentweatherdata.json").getFile()).getAbsolutePath())));
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testHttpGetResponseAsString() throws IOException {

        StatusLine statusLine = Mockito.mock(StatusLine.class);
        HttpEntity httpEntity = Mockito.mock(HttpEntity.class);
        CloseableHttpResponse response = Mockito.mock(CloseableHttpResponse.class);
        CloseableHttpClient httpClient = Mockito.mock(CloseableHttpClient.class);
        Mockito.when(httpClientBuilder.build()).thenReturn(httpClient);
        Mockito.when(httpClient.execute(Mockito.any(HttpGet.class))).thenReturn(response);
        Mockito.when(response.getStatusLine()).thenReturn(statusLine);
        Mockito.when(response.getEntity()).thenReturn(httpEntity);
        Mockito.when(httpEntity.getContent()).thenReturn(inputStream);
        Mockito.when(statusLine.getStatusCode()).thenReturn(200);

        String result = httpClientHelper.httpGetResponseAsString("www.nowhere.xom");

        Mockito.verify(httpClientBuilder, VerificationModeFactory.times(1)).build();
        Mockito.verify(httpClient,VerificationModeFactory.times(1)).execute(Mockito.any(HttpGet.class));
        Mockito.verify(response,VerificationModeFactory.times(1)).getStatusLine();
        Mockito.verify(response,VerificationModeFactory.times(1)).getEntity();
        Mockito.verify(statusLine,VerificationModeFactory.times(1)).getStatusCode();
        Mockito.verify(httpEntity,VerificationModeFactory.times(1)).getContent();

        Assert.assertTrue(result.equals(json));
    }

    @Test
    public void testHttpGetResponseAsStringWhenStatusCodeNotOk() throws IOException {
        StatusLine statusLine = Mockito.mock(StatusLine.class);

        CloseableHttpResponse response = Mockito.mock(CloseableHttpResponse.class);
        CloseableHttpClient httpClient = Mockito.mock(CloseableHttpClient.class);
        Mockito.when(httpClientBuilder.build()).thenReturn(httpClient);
        Mockito.when(httpClient.execute(Mockito.any(HttpGet.class))).thenReturn(response);
        Mockito.when(response.getStatusLine()).thenReturn(statusLine);
        Mockito.when(statusLine.getStatusCode()).thenReturn(500);

        try {
            String result = httpClientHelper.httpGetResponseAsString("www.nowhere.xom");
        } catch (Exception ex) {
            // do nothing
        }
        Mockito.verify(httpClientBuilder, VerificationModeFactory.times(1)).build();
        Mockito.verify(httpClient,VerificationModeFactory.times(1)).execute(Mockito.any(HttpGet.class));
        Mockito.verify(response,VerificationModeFactory.times(1)).getStatusLine();
        Mockito.verify(statusLine,VerificationModeFactory.atLeastOnce()).getStatusCode();
        Mockito.verify(statusLine,VerificationModeFactory.times(1)).getReasonPhrase();
    }

}