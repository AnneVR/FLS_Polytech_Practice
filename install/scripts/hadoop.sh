#Script for hadoop

DIR=$1

TAR=$DIR/temp/distr/hadoop-2.8.5.tar.gz
if [ ! -f "$TAR" ]; then
	wget https://archive.apache.org/dist/hadoop/common/hadoop-2.8.5/hadoop-2.8.5.tar.gz -P $DIR/temp/distr/
else
	echo "INFO: tar already existst."
fi

FILE=~/hadoop/hadoop-2.8.5
if [ ! -d "$FILE" ]; then
	mkdir -p ~/hadoop/hdfs/namenode

	mkdir -p ~/hadoop/hdfs/datanode

	mkdir -p ~/hadoop/temp/hadooptmpdata

	tar xf $DIR/temp/distr/hadoop-2.8.5.tar.gz -C ~/hadoop
else
	echo "INFO: file already exists."
fi

if grep -q HADOOP  ~/.bashrc
then 
	echo "INFO: .bashrc already modified.";
else
	cat $DIR/temp/files/hadoop >> ~/.bashrc
fi

source ~/.bashrc

touch $DIR/temp/files/core-site.xml
sed "s/USER_1/$USER/g" $DIR/temp/files/core-site.xml.template > $DIR/temp/files/core-site.xml
cat $DIR/temp/files/core-site.xml > ~/hadoop/hadoop-2.8.5/etc/hadoop/core-site.xml
rm $DIR/temp/files/core-site.xml


touch $DIR/temp/files/hdfs-site.xml
sed "s/USER_1/$USER/g" $DIR/temp/files/hdfs-site.xml.template > $DIR/temp/files/hdfs-site.xml
cat $DIR/temp/files/hdfs-site.xml > ~/hadoop/hadoop-2.8.5/etc/hadoop/hdfs-site.xml
rm $DIR/temp/files/hdfs-site.xml


cp  ~/hadoop/hadoop-2.8.5/etc/hadoop/mapred-site.xml.template ~/hadoop/hadoop-2.8.5/etc/hadoop/mapred-site.xml
cat $DIR/temp/files/mapred-site.xml > ~/hadoop/hadoop-2.8.5/etc/hadoop/mapred-site.xml

cat $DIR/temp/files/yarn-site.xml > ~/hadoop/hadoop-2.8.5/etc/hadoop/yarn-site.xml



read -p "Modify hadoop-env.sh and press any key..."

hdfs namenode -format

start-dfs.sh

start-yarn.sh

jps

hdfs dfs -mkdir /test

hdfs dfs -ls /

stop-yarn.sh

stop-dfs.sh

echo Done...