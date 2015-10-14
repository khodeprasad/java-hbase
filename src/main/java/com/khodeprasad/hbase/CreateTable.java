package com.khodeprasad.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import com.khodeprasad.hbase.util.HBaseConfigUtil;

/**
 * @author Prasad Khode
 *
 */
public class CreateTable {

	public static void main(String[] args) {
		Configuration config = HBaseConfigUtil.getHBaseConfiguration();

		Connection connection = null;
		Admin admin = null;

		try {
			connection = ConnectionFactory.createConnection(config);
			admin = connection.getAdmin();

			String tableName = "peoples";

			if (!admin.isTableAvailable(TableName.valueOf(tableName))) {
				HTableDescriptor hbaseTable = new HTableDescriptor(TableName.valueOf(tableName));
				hbaseTable.addFamily(new HColumnDescriptor("name"));
				hbaseTable.addFamily(new HColumnDescriptor("contact_info"));
				hbaseTable.addFamily(new HColumnDescriptor("personal_info"));
				admin.createTable(hbaseTable);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (admin != null) {
					admin.close();
				}

				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
