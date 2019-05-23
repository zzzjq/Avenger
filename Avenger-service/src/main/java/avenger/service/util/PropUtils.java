package avenger.service.util;

import org.apache.commons.lang.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author zhangjq
 * @version May 23, 2019 5:55:16 PM
 */
@Slf4j
public class PropUtils {

	private static Properties prop;

	static {
		prop = new Properties();
		Properties envProp = loadPropertyFromFile("configs/config.properties");
		prop.putAll(envProp);
	}

	private static Properties loadPropertyFromFile(String filePath) {
		Properties properties = new Properties();
		InputStreamReader in = getPath(filePath);
		if (in == null) {
			log.info("config.properties does not exists");
		}
		try {
			properties.load(in);
		} catch (IOException e) {
			log.error("load config.properties error:{}", e);
		} finally {
			try {
				in.close();
			} catch (Exception e) {
				log.error("unable to close input stream for file config.properties:{}", e);
			}
		}

		return properties;
	}

	public static String getProperty(String key) {
		String value = "";
		if (StringUtils.isBlank(key)) {
			log.info("ConfigProperties:key is null");
		} else {
			value = prop.getProperty(key);
			if (value != null) {
				value = value.trim();
			} else {
				value = "";
			}
		}
		return value;
	}

	private static InputStreamReader getPath(String path) {
		String absPath = PropUtils.class.getClassLoader().getResource(path).getPath();
		log.info("config.properties resourcePath:{}", absPath);
		try {
			InputStreamReader is = new FileReader(absPath);
			return is;
		} catch (FileNotFoundException e) {
			log.error("unable to find file:{} , error:{}", absPath, e);
		}

		return null;
	}

}
