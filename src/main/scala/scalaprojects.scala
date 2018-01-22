import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object scalaprojects
{
  def main(args:Array[String])
  {

    val conf = new SparkConf().setAppName("scalaprojects")
    val sc = new SparkContext(conf)

    val file = sc.textFile("/user/arunvr4912/listofwords")
    val wordsrdd = file.flatMap(x=>x.split(" "))
    val wordsrddkv = wordsrdd.map(x=>(x,1))
    val reduce = wordsrddkv.reduceByKey((x,y)=>(x+y))



  }
}






