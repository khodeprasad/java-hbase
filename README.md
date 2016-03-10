## java-hbase

Explains how we can connect to HBase using Java and perform multiple operations on HBase tables.

**Step 1:** To connect to HBase using java we need a driver or connector to interact to HBase using Java. For that we will be using 

	<dependency>
		<groupId>org.apache.hbase</groupId>
		<artifactId>hbase-client</artifactId>
		<version>1.1.0.1</version>
	</dependency>

**Step 2:** We need to create HBase Configuration by providing the following details

	hbase.zookeeper.quorum
	hbase.zookeeper.property.clientPort
	
or we need to provide the path to the files **_hbase-site.xml_** and **_core-site.xml_** from which it load the required configuration properties.

Note: Always prefer providing path to xml files over hbase zookeeper properties.

**Step 3:** Execute

	java -cp target/java-hbase-jar-with-dependencies.jar com.khodeprasad.hbase.CreateTable
	
	java -cp target/java-hbase-jar-with-dependencies.jar com.khodeprasad.hbase.DeleteTable
	
	java -cp target/java-hbase-jar-with-dependencies.jar com.khodeprasad.hbase.ListTables
	
	java -cp target/java-hbase-jar-with-dependencies.jar com.khodeprasad.hbase.InsertIntoTable
	
	java -cp target/java-hbase-jar-with-dependencies.jar com.khodeprasad.hbase.ReadTable
	
	java -cp target/java-hbase-jar-with-dependencies.jar com.khodeprasad.hbase.ScanTable
	
	java -cp target/java-hbase-jar-with-dependencies.jar com.khodeprasad.hbase.FilterTable
	
	java -cp target/java-hbase-jar-with-dependencies.jar com.khodeprasad.hbase.DeleteRecordsFromTable

