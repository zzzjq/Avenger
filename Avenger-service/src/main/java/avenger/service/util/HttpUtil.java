package avenger.service.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjq
 * @version May 23, 2019 5:55:18 PM
 */
@Slf4j
public class HttpUtil {

	public static boolean get(String url) {
		CloseableHttpClient client = null;
		HttpGet httpGet = null;
		HttpResponse response = null;
		try {
			client = HttpClients.createDefault();
			httpGet = new HttpGet(url);
			response = client.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if (HttpStatus.SC_OK == statusCode) {
				return true;
			}
		} catch (Exception e) {
			log.error("http get error : {}", e);
		} finally {
			if (client != null) {
				try {
					client.close();
				} catch (IOException e) {
					log.error("httpClient close error : {}", e);
				}
			}
		}
		return false;
	}

}
