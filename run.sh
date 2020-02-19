spark-submit \
  --class spark.App \
  --master local[$1] \
  ./build/libs/spark.jar \