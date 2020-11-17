package io.hackages.learning.entity;
// Generated Nov 17, 2020 1:42:45 PM by Hibernate Tools 3.2.2.GA


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Products generated by hbm2java
 */
@Entity
@Table(name="products"
    ,catalog="classicmodels"
)
public class Products  implements java.io.Serializable {


     private String productCode;
     private Productlines productlines;
     private String productName;
     private String productScale;
     private String productVendor;
     private String productDescription;
     private short quantityInStock;
     private BigDecimal buyPrice;
     private BigDecimal msrp;
     private Set orderdetailses = new HashSet(0);

    public Products() {
    }

	
    public Products(String productCode, Productlines productlines, String productName, String productScale, String productVendor, String productDescription, short quantityInStock, BigDecimal buyPrice, BigDecimal msrp) {
        this.productCode = productCode;
        this.productlines = productlines;
        this.productName = productName;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.msrp = msrp;
    }
    public Products(String productCode, Productlines productlines, String productName, String productScale, String productVendor, String productDescription, short quantityInStock, BigDecimal buyPrice, BigDecimal msrp, Set orderdetailses) {
       this.productCode = productCode;
       this.productlines = productlines;
       this.productName = productName;
       this.productScale = productScale;
       this.productVendor = productVendor;
       this.productDescription = productDescription;
       this.quantityInStock = quantityInStock;
       this.buyPrice = buyPrice;
       this.msrp = msrp;
       this.orderdetailses = orderdetailses;
    }
   
     @Id 
    
    @Column(name="productCode", unique=true, nullable=false, length=15)
    public String getProductCode() {
        return this.productCode;
    }
    
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="productLine", nullable=false)
    public Productlines getProductlines() {
        return this.productlines;
    }
    
    public void setProductlines(Productlines productlines) {
        this.productlines = productlines;
    }
    
    @Column(name="productName", nullable=false, length=70)
    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    @Column(name="productScale", nullable=false, length=10)
    public String getProductScale() {
        return this.productScale;
    }
    
    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }
    
    @Column(name="productVendor", nullable=false, length=50)
    public String getProductVendor() {
        return this.productVendor;
    }
    
    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }
    
    @Column(name="productDescription", nullable=false, length=65535)
    public String getProductDescription() {
        return this.productDescription;
    }
    
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    
    @Column(name="quantityInStock", nullable=false)
    public short getQuantityInStock() {
        return this.quantityInStock;
    }
    
    public void setQuantityInStock(short quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
    
    @Column(name="buyPrice", nullable=false, precision=10)
    public BigDecimal getBuyPrice() {
        return this.buyPrice;
    }
    
    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }
    
    @Column(name="MSRP", nullable=false, precision=10)
    public BigDecimal getMsrp() {
        return this.msrp;
    }
    
    public void setMsrp(BigDecimal msrp) {
        this.msrp = msrp;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="products")
    public Set getOrderdetailses() {
        return this.orderdetailses;
    }
    
    public void setOrderdetailses(Set orderdetailses) {
        this.orderdetailses = orderdetailses;
    }




}


