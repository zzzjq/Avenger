package avenger.service.util.hbase;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import avenger.service.util.PropUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Component
@Slf4j
public class HconnectionFactory implements InitializingBean {

	static Connection connection;

	@Override
	public void afterPropertiesSet() {
		try {
			String zkQuorum = PropUtils.getProperty("hbase.zookeeper.quorum");
			if (StringUtils.isNotBlank(zkQuorum) && connection == null) {
				Configuration conf = HBaseConfiguration.create();
				conf.set("hbase.zookeeper.quorum", zkQuorum);
				connection = ConnectionFactory.createConnection(conf);
				// 程序退出时断开hbase连接
				Runtime.getRuntime().addShutdownHook(new Thread(() -> {
					try {
						connection.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}, "HbaseExitThread"));
				log.info("hbases客户端初始化成功");
			}
		} catch (Exception e) {
			log.error("hbase客户端初始化失败", e);
		}
	}
}
