#Script for spark

DIR=$1

TAR=$DIR/temp/distr/spark-3.0.0-preview2-bin-hadoop2.7.tgz
if [ ! -f "$TAR" ]; then
    wget  http://mirror.linux-ia64.org/apache/spark/spark-3.0.0-preview2/spark-3.0.0-preview2-bin-hadoop2.7.tgz -P $DIR/temp/distr/
else
    echo "INFO: tar already existst."
fi

FILE=~/spark/spark-3.0.0-preview2-bin-hadoop2.7
if [ ! -d "$FILE" ]; then

	mkdir ~/spark

    tar xf $DIR/temp/distr/spark-3.0.0-preview2-bin-hadoop2.7.tgz -C ~/spark

else
    echo "INFO: file already exists."
fi

if grep -q SPARK  ~/.bashrc
then 
    echo "INFO: .bashrc already modified.";
else
    cat $DIR/temp/files/spark >> .bashrc
fi

source ~/.bashrc
