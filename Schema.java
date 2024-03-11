QUESTION 3. Create schema in any Database script or any ORM (Object Relational Mapping).

  ANS:   Creating schema(product and customer)  in java using hibernate ORM tool .....Bellow are the codes.

  ----hibernate.cfg.xml

<!-- Hibernate file-based configuration document.

<!DOCTYPE hibernate-configuration PUBLIC
	"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
	"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">   -->


<hibernate-configuration>
   <session-factory>
   
   
      <property name = "hibernate.dialect">
         org.hibernate.dialect.MySQL8Dialect  </property>
      
      <property name = "hibernate.connection.url">  jdbc:mysql://localhost/kodnest </property>
      
      <property name = "hibernate.connection.username"> root  </property>
      
      <property name = "hibernate.connection.password"> S##48k@qirt  </property>
      
  	  <property name = "hbm2ddl.auto"> create </property>
  	  
  	   <property name = "show_sql"> true </property>
  	   
  	     <mapping class = "com.kodnest.entity.Customer"></mapping>  
  	     <mapping class = "com.kodnest.entity.Product"></mapping>   
      
   </session-factory>
</hibernate-configuration>







  ----pom.xml


  <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.kodnest.hibernate </groupId>
  <artifactId>Hibernate-Project</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>Hibernate-Project</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <dependencies>
	  
	  
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
    
    
    <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>5.6.15.Final</version>
</dependency>


<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>

    
  </dependencies>
</project>






  

  ------Schema.java

  package com.demo;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg. Configuration;

import com.kodnest.entity.Customer;
import com.kodnest.entity.Product;


public class Schema
	{
		public static void main( String[] args )
			{
				Configuration cfg = new Configuration();
				cfg.configure();
				SessionFactory factory = cfg.buildSessionFactory();
				Session session = factory.openSession();
			//	System.out.println(session + "success");
				
				
				try {
				
				Transaction tr = session.beginTransaction();
				
				Product p1 = new Product();
				p1.setPid(1);
				p1.setPname("prod-1");
				session.save(p1);
				
				
				Product p2 = new Product();
				p2.setPid(2);
				p2.setPname("prod-2");
				session.save(p2);
					
				ArrayList<Product> al = new ArrayList<Product>();
				al.add(p1);
				al.add(p2);
				
				Customer c1 =  new Customer(1,"john" , al);
				session.save(c1);
				
				Customer c2 =  new Customer(2,"jack", al );
		      	session.save(c2);
				
				tr.commit();
			}
				
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}





---Entity classes of product and customer

---Product.java


  package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Product {
	@Id
	int pid;
	String pname;
	
	@ManyToMany
	Customer c;

	public Product() {
		super();
	}

	public Product(int pid, String pname, Customer c) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.c = c;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Customer getC() {
		return c;
	}

	public void setC(Customer c) {
		this.c = c;
	}
}





----Customer.java

  package com.demo.entity;


import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Customer {
	
	
	
	@Id
	int cid;
	String cname;
	
	@ManyToMany
	Product p;
	
	public Customer(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public Customer() {
		super();
	}
	public Customer(int i, String string, ArrayList<Product> al) {
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
}
