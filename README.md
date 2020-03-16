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
