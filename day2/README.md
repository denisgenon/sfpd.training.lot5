# Day 2 : Hibernate

## Workshop: Reverse Engineering 

1. Run a local instance of Mysql server 
    * If already installed 
    * via [Docker](https://hub.docker.com/_/mysql) 

1. Import some sample dbs and run the script 
    * [employees.sql](https://dev.mysql.com/doc/employee/en/employees-installation.html)
    * [mysqlsampledatabase.sql](https://www.mysqltutorial.org/mysql-sample-database.aspx)

1. Sample project `00.hibernate4.reveng.sample`
    1. Check the configuration 
    1. Run the using command for POJO generation : `mvn clean hibernate3:hbm2java`  
    1. Check the generated classes, is the result expected ?
    1. Use the property `match-catalog` to filter the cause of the problem 

1. Retry with the new version of [Hibernate Tools](https://github.com/hibernate/hibernate-tools/blob/master/maven/docs/5-minute-tutorial.md)
    * Are the results different ? 

### Online resources 
* [Documentation](https://docs.jboss.org/tools/latest/en/hibernatetools/html_single/index.html)
* Maven Plugin for Hibernate Tools [old repo](https://github.com/stadler/hibernate-tools-maven-plugin)

## Workshop: Experiment with Hibernate Search

https://www.baeldung.com/hibernate-search

## Workshop: Experiment with MultiTenancy using 2 instances of DB

https://www.baeldung.com/hibernate-5-multitenancy  
 
## Online Resources 

* [Sample DBs](https://www3.ntu.edu.sg/home/ehchua/programming/sql/SampleDatabases.html)
* [Performance Practices for Hibernate 5 and Spring Boot 2 Part 1](https://dzone.com/articles/50-best-performance-practices-for-hibernate-5-amp)
* [Performance Practices for Hibernate 5 and Spring Boot 2 Part 2](https://dzone.com/articles/best-performance-practices-for-hibernate-5-and-spr)
* [Performance tips](https://vladmihalcea.com/hibernate-performance-tuning-tips/)

## Books 
* [Pro JPA 2 in Java EE 8: An In-Depth Guide to Java Persistence APIs](https://www.amazon.com/dp/1484234197/ref=sm_n_se_dkp_FR_pr_sea_0_0?adId=1484234197&creativeASIN=1484234197&linkId=ec98fbe3322cb32dce01764a9c07c107&tag=logicbig-20&linkCode=w42&ref-refURL=https%3A%2F%2Fwww.logicbig.com%2Ftutorials%2Fjava-ee-tutorial%2Fjpa%2Fembeddable-classes.html&slotNum=0&imprToken=sc0cTNRL5GNiSrIo1WM0AQ&adType=smart&adMode=search&adFormat=grid&impressionTimestamp=1605495600379)
* [Java Persistence with Hibernate 2nd Edition](https://www.amazon.com/dp/1617290459/ref=sm_n_se_dkp_FR_pr_sea_1_1?adId=1617290459&creativeASIN=1617290459&linkId=ec98fbe3322cb32dce01764a9c07c107&tag=logicbig-20&linkCode=w42&ref-refURL=https%3A%2F%2Fwww.logicbig.com%2Ftutorials%2Fjava-ee-tutorial%2Fjpa%2Fone-to-one.html&slotNum=0&imprToken=Sr7zFVywB.CgPlkacf9-JA&adType=smart&adMode=search&adFormat=grid&impressionTimestamp=1605495993932)
