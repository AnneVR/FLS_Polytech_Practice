# INSTALL

## HADOOP

1. **Adding user:**

		$ adduser hadoop

2. **Install and add to PATH jdk v8**

3. **Configure ssh**

		$ sudo apt-get install openssh-server openssh-client

		$ ssh-keygen -t rsa

		$ cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys

		$ ssh localhost

4. **Download Hadoop**

	Login as hadoop:

		$ su - hadoop 

	In /home/hadoop:

		$ wget https://archive.apache.org/dist/hadoop/common/hadoop-2.8.5/hadoop-2.8.5.tar.gz

		$ tar xf hadoop-2.8.5.tar.gz

		$ mkdir hadoop

		$ mv hadoop-2.8.5 hadoop/
		

5. **Also create 'temp/hadooptmpdata', 'hdfs/datanode' and 'hdfs/namenode' in hadoop folder**

	In /home/hadoop/hadoop:

		$ mkdir -p hdfs/namenode
		$ mkdir -p hdfs/datanode
		$ mkdir -p temp/hadooptmpdata

6. **Alter PATH**

	Add to the end of '.bashrc' file in /home/hadoop:

		export HADOOP_HOME=/home/hadoop/hadoop/hadoop-2.8.5
		export HADOOP_INSTALL=$HADOOP_HOME
		export HADOOP_MAPRED_HOME=$HADOOP_HOME
		export HADOOP_COMMON_HOME=$HADOOP_HOME
		export HADOOP_HDFS_HOME=$HADOOP_HOME
		export YARN_HOME=$HADOOP_HOME
		export HADOOP_COMMON_LIB_NATIVE_DIR=$HADOOP_HOME/lib/native
		export PATH=$PATH:$HADOOP_HOME/sbin:$HADOOP_HOME/bin
		export HADOOP_OPTS="-Djava.library.path=$HADOOP_HOME/lib/native"

7. **Configure 'hadoop/hadoop-2.8.5/etc/hadoop/hadoop-env.sh'**

	Make the following changes:

		export JAVA_HOME= path_to_jdk_8
		export HADOOP_CONF_DIR=${HADOOP_CONF_DIR:-"/home/hadoop/hadoop/hadoop-2.8.5/etc/hadoop"}

8. **Configure 'hadoop/hadoop-2.8.5/etc/hadoop/core-site.xml'**

	Make the following changes:

		<configuration>
		<property>
		<name>fs.defaultFS</name>
		<value>hdfs://localhost:9000</value>
		</property>
		<property>
		<name>hadoop.tmp.dir</name>
		<value>/home/hadoop/hadoop/temp/hadooptmpdata</value>
		</property>
		</configuration>

9. **Configure 'hadoop/etc/hadoop/hdfs-site.xml'**

	Make the following changes:

		<configuration>
		<property>
		<name>dfs.replication</name>
		<value>1</value>
		<name>dfs.name.dir</name>
		<value>file:///home/hadoop/hadoop/hdfs/namenode</value>
		<name>dfs.data.dir</name>
		<value>file:///home/hadoop/hadoop/hdfs/datanode</value>
		</property>
		</configuration>

10. **Configure 'hadoop/etc/hadoop/mapred-site.xml'**

	Create:

		$ cp mapred-site.xml.template mapred-site.xml

	Make the following changes:

		<configuration>
		<property>
		<name>mapreduce.framework.name</name>
		<value>yarn</value>
		</property>
		</configuration>

11. **Configure 'hadoop/etc/hadoop/yarn-site.xml'**

		<configuration>
		<property>
		<name>mapreduceyarn.nodemanager.aux-services</name>
		<value>mapreduce_shuffle</value>
		</property>
		</configuration>

12. **Start hadoop**
	
	Format namenode:

		$ hdfs namenode -format

	Run filesystem:

		$ start-dfs.sh

	Run yarn:

		$ start-yarn.sh

	Check if running:

		$ jps

13. **HDFS Command Line Interface**

	Create test folders

		$ hdfs dfs -mkdir /test
		$ hdfs dfs -ls /


14. **Access from browser**
	
	Open [Yarn](0.0.0.0:50070)

	Open [Hadoop](0.0.0.0:8088)
	
## HIVE

1. **Make sure hadoop is installed**

		$ hadoop version

2. **Download Hive**

	In /home/hadoop/ run:

		$ wget http://apache-mirror.rbc.ru/pub/apache/hive/stable-2/apache-hive-2.3.6-bin.tar.gz

		$ tar xf apache-hive-2.3.6-bin.tar.gz

		$ mkdir hive

		$ mv apache-hive-2.3.6-bin hive/

3. **Alter PATH**

	Add to the end of .bashrc:

		export HIVE_HOME=/home/hadoop/hive/apache-hive-2.3.6-bin/
		export PATH=$PATH:$HIVE_HOME/bin
		export CLASSPATH=$CLASSPATH:/usr/local/Hadoop/lib/*:.
		export CLASSPATH=$CLASSPATH:/usr/local/hive/lib/*:.

4. **Configure 'apache-hive-2.3.6-bin/conf/hive-env.sh'**

	Create:

		$ cp hive-env.sh.template hive-env.sh

	Make the following changes:

		export HADOOP_HOME=/home/hadoop/hadoop/hadoop-2.8.5
5. **Configure 'apache-hive-2.3.6-bin/conf/hive-env.sh'**

	Create:

		$ cp hive/apache-hive-2.3.6-bin/conf/hive-default.xml.template hive/apache-hive-2.3.6-bin/conf/hive-site.xml

	Replace inside with:

		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?xml-stylesheet type="text/xsl" href="configuration.xsl"?><!--
		Licensed to the Apache Software Foundation (ASF) under one or more
		contributor license agreements. See the NOTICE file distributed with
		this work for additional information regarding copyright ownership.
		The ASF licenses this file to You under the Apache License, Version 2.0
		(the "License"); you may not use this file except in compliance with
		the License. You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

		Unless required by applicable law or agreed to in writing, software
		distributed under the License is distributed on an "AS IS" BASIS,
		WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
		See the License for the specific language governing permissions and
		limitations under the License.-->
		<configuration>
		<property>
		<name>javax.jdo.option.ConnectionURL</name>
		<value>jdbc:derby:;databaseName=/home/hadoop/hive/metastore_db;create=true</value>
		<description>
		JDBC connect string for a JDBC metastore.
		To use SSL to encrypt/authenticate the connection, provide database-specific SSL flag in the connection URL.
		For example, jdbc:postgresql://myhost/db?ssl=true for postgres database.
		</description>
		</property>
		<property>
		<name>hive.metastore.warehouse.dir</name>
		<value>/user/hive/warehouse</value>
		<description>location of default database for the warehouse</description>
		</property>
		<property>
		<name>hive.metastore.uris</name>
		<value>thrift://localhost:9083<value/>
		<description>Thrift URI for the remote metastore. Used by metastore client to connect to remote metastore.</description>
		</property>
		<property>
		<name>javax.jdo.option.ConnectionDriverName</name>
		<value>org.apache.derby.jdbc.EmbeddedDriver</value>
		<description>Driver class name for a JDBC metastore</description>
		</property>
		<property>
		<name>javax.jdo.PersistenceManagerFactoryClass</name>
		<value>org.datanucleus.api.jdo.JDOPersistenceManagerFactory</value>
		<description>class implementing the jdo persistence</description>
		</property>
		</configuration>

6. **Configure hdfs**

		$ hdfs dfs -mkdir -p /user/hive/warehouse

		$ hdfs dfs -mkdir /tmp

		$ hdfs dfs -chmod g+w /user/hive/warehouse

		$ hdfs dfs -chmod g+w /tmp

7. **Init Derby**

	Run configuration:

		schematool -initSchema -dbType derby

8. **Verify**

	Run Hadoop:

		$ start-dfs.sh

	Run Yarn:

		$ start-yarn.sh

	Run Hive:

		$ hive

	In shell:

		\> show tables; 

## SPARK

Installation is simple enough.

## BUILD 

Build with
		 
	$ gradle clean build

## RUN 

Before running make sure dfs and metastore are running.

Do it by following:

	$ start-dfs.sh

	$ hive --service metastore

Run with: 
	
	$ gradle run

## Spark-RUN

Use script:

	$ ./run.sh N

Where N is N of cores you are willing to give to spark.
