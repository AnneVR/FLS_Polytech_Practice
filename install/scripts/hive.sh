#Script for hive

DIR=$1

TAR=$DIR/temp/distr/apache-hive-2.3.6-bin.tar.gz
if [ ! -f "$TAR" ]; then
	wget http://apache-mirror.rbc.ru/pub/apache/hive/stable-2/apache-hive-2.3.6-bin.tar.gz -P $DIR/temp/distr/
else
	echo "INFO: tar already existst."
fi

FILE=~/hive/apache-hive-2.3.6-bin
if [ ! -d "$FILE" ]; then

	mkdir ~/hive

	tar xf $DIR/temp/distr/apache-hive-2.3.6-bin.tar.gz -C ~/hive

else
	echo "INFO: file already exists."
fi

if grep -q HIVE  ~/.bashrc
then 
	echo "INFO: .bashrc already modified.";
else
	cat $DIR/temp/files/hive >> .bashrc
fi

source ~/.bashrc

cp ~/hive/apache-hive-2.3.6-bin/conf/hive-env.sh.template ~/hive/apache-hive-2.3.6-bin/conf/hive-env.sh
cat $DIR/temp/files/hive-env.sh > ~/hive/apache-hive-2.3.6-bin/conf/hive-env.sh

touch $DIR/temp/files/hive-env.sh
sed "s/USER_1/$USER/g" $DIR/temp/files/hive-env.sh.template > $DIR/temp/files/hive-env.sh
cat $DIR/temp/files/hive-env.sh > ~/hive/apache-hive-2.3.6-bin/conf/hive-env.sh
rm $DIR/temp/files/hive-env.sh

cp ~/hive/apache-hive-2.3.6-bin/conf/hive-default.xml.template ~/hive/apache-hive-2.3.6-bin/conf/hive-site.xml
cat $DIR/temp/files/hive-site.xml > ~/hive/apache-hive-2.3.6-bin/conf/hive-site.xml

touch $DIR/temp/files/hive-site.xml
sed "s/USER_1/$USER/g" $DIR/temp/files/hive-site.xml.template > $DIR/temp/files/hive-site.xml
cat $DIR/temp/files/hive-site.xml > ~/hive/apache-hive-2.3.6-bin/conf/hive-site.xml
rm $DIR/temp/files/hive-site.xml

hdfs dfs -mkdir -p /user/hive/warehouse

hdfs dfs -mkdir /tmp

hdfs dfs -chmod g+w /user/hive/warehouse

hdfs dfs -chmod g+w /tmp

schematool -initSchema -dbType derby

start-dfs.sh

start-yarn.sh

hive
