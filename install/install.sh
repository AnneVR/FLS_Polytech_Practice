DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

if [ "$1" == "hadoop" ]; then
	echo "exec hadoop..."
	bash $DIR/scripts/hadoop.sh $DIR
elif [ "$1" == "spark" ]; then
	echo "exec spark..."
	bash $DIR/scripts/spark.sh $DIR
elif [ "$1" == "hive" ]; then
	echo "exec hive..."
	bash $DIR/scripts/hive.sh $DIR
elif [ "$1" == "help" ]; then
	echo -e "hadoop - install hadoop\nspark - install spark\nhive - install hive\nhelp - for help\n"
elif [ "$1" == "clean" ]; then
	rm -rf $DIR/temp/distr/*
else
	echo "type help for help"
fi
