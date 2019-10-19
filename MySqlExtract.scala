./spark-shell

val connection="jdbc:mysql://localhost/retail_db"
#val connection="jdbc:mysql://localhost:3306/retail_db"

ip_addrs:port_num or localhost:port_num

val mysql_props = new java.util.Properties

mysql_props.setProperty("user","root")
mysql_props.setProperty("password","cloudera")
val products = sqlContext.read.jdbc(connection,"products",mysql_props)
products.show(10)
employee.registerTempTable("Products")
val check_data = sqlContext.sql("select * from Products")

products.write.mode("overwrite").saveAsTable("practice.product")


#spark-shell -i MySqlExtract.scala
