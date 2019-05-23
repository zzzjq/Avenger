package avenger.service.util.hbase;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Slf4j
public class HBaseUtil {
	public static HTable getTable(String tableName) throws IOException {
		return (HTable) HconnectionFactory.connection.getTable(TableName.valueOf(tableName));
	}

	/**
	 * 创建表
	 *
	 * @param tableName
	 * @param familyColumn
	 */
	public static void createTable(String tableName, Set<String> familyColumn) {
		TableName tn = TableName.valueOf(tableName);
		try (Admin admin = HconnectionFactory.connection.getAdmin()) {
			HTableDescriptor htd = new HTableDescriptor(tn);
			for (String fc : familyColumn) {
				HColumnDescriptor hcd = new HColumnDescriptor(fc);
				htd.addFamily(hcd);
			}
			admin.createTable(htd);
		} catch (IOException e) {
			e.printStackTrace();
			log.info("创建" + tableName + "表失败！", e);
		}
	}

	/**
	 * 创建表
	 *
	 * @param tableName
	 * @param familyColumn
	 */
	public static void createTable(String tableName, String familyColumn) {
		TableName tn = TableName.valueOf(tableName);
		try (Admin admin = HconnectionFactory.connection.getAdmin()) {
			HTableDescriptor htd = new HTableDescriptor(tn);
			HColumnDescriptor hcd = new HColumnDescriptor(familyColumn);
			htd.addFamily(hcd);
			admin.createTable(htd);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("创建" + tableName + "表失败！", e);
		}
	}

	/**
	 * 删除表
	 *
	 * @param tableName
	 */
	public void dropTable(String tableName) {
		TableName tn = TableName.valueOf(tableName);
		try (Admin admin = HconnectionFactory.connection.getAdmin();) {
			admin.disableTable(tn);
			admin.deleteTable(tn);
		} catch (IOException e) {
			e.printStackTrace();
			log.info("删除" + tableName + "表失败！");
		}
	}

	/**
	 * @param tableName 表名
	 * @param put
	 * @return
	 */
	public static boolean put(String tableName, Put put) {
		try {
			Table table = HconnectionFactory.connection.getTable(TableName.valueOf(tableName));
			table.put(put);
			return true;
		} catch (Exception e) {
			log.error("数据插入表名" + tableName + "失败！数据为:", e);
			return false;
		}
	}

	public static boolean put(String tableName, List<Put> puts) {
		if (StringUtils.isBlank(tableName)) {
			return false;
		}
		try (Table table = HconnectionFactory.connection.getTable(TableName.valueOf(tableName));
				Admin admin = HconnectionFactory.connection.getAdmin();) {
			table.put(puts);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void getTable() throws IOException {
		Table table = HconnectionFactory.connection.getTable(TableName.valueOf("t_test"));
		System.out.println("===========" + table);
	}

	public static List<Result> get(String tableName, String... rowkeys) {
		List<Result> resultList = new ArrayList<Result>();
		List<Get> gets = new ArrayList<Get>();
		log.info("Hbase查询开始，tablename:{}, rowkeys:{}", tableName, rowkeys);
		for (String rowkey : rowkeys) {
			if (StringUtils.isBlank(rowkey)) {
				continue;
			}
			Get get = new Get(Bytes.toBytes(rowkey));
			gets.add(get);
		}
		try (Table table = HconnectionFactory.connection.getTable(TableName.valueOf(tableName));) {
			log.info("Hbase查询，tablename:{}", tableName);
			Result[] results = table.get(gets);
			log.info("Hbase查询结果，tablename:{}, results:{}", tableName, JSON.toJSONString(results));
			/** 处理下空指针 **/
			if (null != results) {
				Collections.addAll(resultList, results);
			}
			return resultList;
		} catch (Exception e) {
			log.info("Hbase查询异常", e);
			return resultList;
		}
	}

	public static boolean isTableAvailable(String tableName) throws IOException {
		return HconnectionFactory.connection.getAdmin().isTableAvailable(TableName.valueOf(tableName));
	}

	public static boolean isTableExist(String tableName) throws IOException {
		try {
			return HconnectionFactory.connection.getAdmin().tableExists(TableName.valueOf(tableName));
		} catch (Exception e) {
			log.error("Hbase Exception", e);
		}
		return false;
	}

}
