
package to_dl_raw

import org.apache.spark.sql.SparkSession

object App {
  def main(args: Array[String]) = {

    val session = SparkSession.builder
      .appName("to_dl_raw")
      .enableHiveSupport()
      .getOrCreate()

    session.sparkContext.setLogLevel("Warn")

    val data = session.read.option("header", "true")
                            .csv("hdfs://" + args(0) +  "/sba/application_data.csv")

    data.write.mode("Overwrite").saveAsTable("dl_raw_full")

    data.select(
      "SK_ID_CURR",
      "TARGET",
      "NAME_CONTRACT_TYPE",
      "CODE_GENDER",
      "FLAG_OWN_CAR",
      "FLAG_OWN_REALTY",
      "CNT_CHILDREN",
      "AMT_INCOME_TOTAL",
      "AMT_CREDIT",
      "AMT_ANNUITY",
      "AMT_GOODS_PRICE",
      "NAME_TYPE_SUITE",
      "NAME_INCOME_TYPE",
      "NAME_EDUCATION_TYPE",
      "NAME_FAMILY_STATUS",
      "NAME_HOUSING_TYPE",
      "REGION_POPULATION_RELATIVE",
      "DAYS_BIRTH",
      "DAYS_EMPLOYED",
      "DAYS_REGISTRATION",
      "DAYS_ID_PUBLISH",
      "OWN_CAR_AGE",
      "FLAG_MOBIL",
      "FLAG_CONT_MOBILE",
      "FLAG_EMAIL",
      "OCCUPATION_TYPE",
      "CNT_FAM_MEMBERS",
      "REGION_RATING_CLIENT",
      "REGION_RATING_CLIENT_W_CITY",
      "WEEKDAY_APPR_PROCESS_START",
      "HOUR_APPR_PROCESS_START",
      "REG_REGION_NOT_LIVE_REGION",
      "REG_REGION_NOT_WORK_REGION"
    ).write
      .option("timestampFormat", "yyyy/MM/dd HH:mm:ss ZZ")
      .mode("Overwrite")
      .saveAsTable("dl_raw_filtered")
  }
}
