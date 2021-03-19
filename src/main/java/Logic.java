import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Logic {

    public Logic () {}

    List<List<String>> getData() throws ParseException, IOException{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        List<List<String>> data = new ArrayList<List<String>>();
        List<String> subdata = new ArrayList<String>();

        try {

            HttpGet request = new HttpGet("https://swapi.dev/api/people/");

            request.addHeader("custom-key", "mkyong");
            request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");

            CloseableHttpResponse response = httpClient.execute(request);

            try {
                System.out.println(response.getProtocolVersion());
                System.out.println(response.getStatusLine().getStatusCode()); 
                System.out.println(response.getStatusLine().getReasonPhrase());
                System.out.println(response.getStatusLine().toString()); 

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    ObjectMapper objectMapper = new ObjectMapper();
                    final JsonNode arrNode = objectMapper.readTree(result).get("results");
                    if (arrNode.isArray()) {
                        for (final JsonNode objNode : arrNode) {
                            subdata.add(objNode.get("name").asText());
                            subdata.add(objNode.get("height").asText());
                            subdata.add(objNode.get("birth_year").asText());
                            data.add(subdata);
                            subdata = new ArrayList<String>();
                        }
                    }
                }

            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }
        return data;
    }
}
