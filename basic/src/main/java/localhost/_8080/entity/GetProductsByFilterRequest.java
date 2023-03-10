//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.22 at 07:53:14 PM MSK 
//


package localhost._8080.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="page" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pageSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coordinateX" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="coordinateY" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="partNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="manufactureCost" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="unitOfMeasure" type="{http://localhost:8080/Entity}UnitOfMeasureDto"/>
 *         &lt;element name="ownerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ownerPassportId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ownerEyeColor" type="{http://localhost:8080/Entity}ColorDto"/>
 *         &lt;element name="ownerHairColor" type="{http://localhost:8080/Entity}ColorDto"/>
 *         &lt;element name="ownerNationality" type="{http://localhost:8080/Entity}CountryDto"/>
 *         &lt;element name="ownerLocationX" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ownerLocationY" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ownerLocationZ" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="orderBy" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="field" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="sortType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "page",
    "pageSize",
    "id",
    "name",
    "coordinateX",
    "coordinateY",
    "price",
    "partNumber",
    "manufactureCost",
    "unitOfMeasure",
    "ownerName",
    "ownerPassportId",
    "ownerEyeColor",
    "ownerHairColor",
    "ownerNationality",
    "ownerLocationX",
    "ownerLocationY",
    "ownerLocationZ",
    "orderBy"
})
@XmlRootElement(name = "getProductsByFilterRequest")
public class GetProductsByFilterRequest {

    protected int page;
    protected int pageSize;
    protected int id;
    @XmlElement(required = true)
    protected String name;
    protected float coordinateX;
    protected float coordinateY;
    protected long price;
    @XmlElement(required = true)
    protected String partNumber;
    protected int manufactureCost;
    @XmlElement(required = true)
    protected UnitOfMeasureDto unitOfMeasure;
    @XmlElement(required = true)
    protected String ownerName;
    @XmlElement(required = true)
    protected String ownerPassportId;
    @XmlElement(required = true)
    protected ColorDto ownerEyeColor;
    @XmlElement(required = true)
    protected ColorDto ownerHairColor;
    @XmlElement(required = true)
    protected CountryDto ownerNationality;
    protected int ownerLocationX;
    protected double ownerLocationY;
    protected double ownerLocationZ;
    protected List<GetProductsByFilterRequest.OrderBy> orderBy;

    /**
     * Gets the value of the page property.
     * 
     */
    public int getPage() {
        return page;
    }

    /**
     * Sets the value of the page property.
     * 
     */
    public void setPage(int value) {
        this.page = value;
    }

    /**
     * Gets the value of the pageSize property.
     * 
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Sets the value of the pageSize property.
     * 
     */
    public void setPageSize(int value) {
        this.pageSize = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the coordinateX property.
     * 
     */
    public float getCoordinateX() {
        return coordinateX;
    }

    /**
     * Sets the value of the coordinateX property.
     * 
     */
    public void setCoordinateX(float value) {
        this.coordinateX = value;
    }

    /**
     * Gets the value of the coordinateY property.
     * 
     */
    public float getCoordinateY() {
        return coordinateY;
    }

    /**
     * Sets the value of the coordinateY property.
     * 
     */
    public void setCoordinateY(float value) {
        this.coordinateY = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public long getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(long value) {
        this.price = value;
    }

    /**
     * Gets the value of the partNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartNumber() {
        return partNumber;
    }

    /**
     * Sets the value of the partNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartNumber(String value) {
        this.partNumber = value;
    }

    /**
     * Gets the value of the manufactureCost property.
     * 
     */
    public int getManufactureCost() {
        return manufactureCost;
    }

    /**
     * Sets the value of the manufactureCost property.
     * 
     */
    public void setManufactureCost(int value) {
        this.manufactureCost = value;
    }

    /**
     * Gets the value of the unitOfMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link UnitOfMeasureDto }
     *     
     */
    public UnitOfMeasureDto getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * Sets the value of the unitOfMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitOfMeasureDto }
     *     
     */
    public void setUnitOfMeasure(UnitOfMeasureDto value) {
        this.unitOfMeasure = value;
    }

    /**
     * Gets the value of the ownerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Sets the value of the ownerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerName(String value) {
        this.ownerName = value;
    }

    /**
     * Gets the value of the ownerPassportId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerPassportId() {
        return ownerPassportId;
    }

    /**
     * Sets the value of the ownerPassportId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerPassportId(String value) {
        this.ownerPassportId = value;
    }

    /**
     * Gets the value of the ownerEyeColor property.
     * 
     * @return
     *     possible object is
     *     {@link ColorDto }
     *     
     */
    public ColorDto getOwnerEyeColor() {
        return ownerEyeColor;
    }

    /**
     * Sets the value of the ownerEyeColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColorDto }
     *     
     */
    public void setOwnerEyeColor(ColorDto value) {
        this.ownerEyeColor = value;
    }

    /**
     * Gets the value of the ownerHairColor property.
     * 
     * @return
     *     possible object is
     *     {@link ColorDto }
     *     
     */
    public ColorDto getOwnerHairColor() {
        return ownerHairColor;
    }

    /**
     * Sets the value of the ownerHairColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColorDto }
     *     
     */
    public void setOwnerHairColor(ColorDto value) {
        this.ownerHairColor = value;
    }

    /**
     * Gets the value of the ownerNationality property.
     * 
     * @return
     *     possible object is
     *     {@link CountryDto }
     *     
     */
    public CountryDto getOwnerNationality() {
        return ownerNationality;
    }

    /**
     * Sets the value of the ownerNationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryDto }
     *     
     */
    public void setOwnerNationality(CountryDto value) {
        this.ownerNationality = value;
    }

    /**
     * Gets the value of the ownerLocationX property.
     * 
     */
    public int getOwnerLocationX() {
        return ownerLocationX;
    }

    /**
     * Sets the value of the ownerLocationX property.
     * 
     */
    public void setOwnerLocationX(int value) {
        this.ownerLocationX = value;
    }

    /**
     * Gets the value of the ownerLocationY property.
     * 
     */
    public double getOwnerLocationY() {
        return ownerLocationY;
    }

    /**
     * Sets the value of the ownerLocationY property.
     * 
     */
    public void setOwnerLocationY(double value) {
        this.ownerLocationY = value;
    }

    /**
     * Gets the value of the ownerLocationZ property.
     * 
     */
    public double getOwnerLocationZ() {
        return ownerLocationZ;
    }

    /**
     * Sets the value of the ownerLocationZ property.
     * 
     */
    public void setOwnerLocationZ(double value) {
        this.ownerLocationZ = value;
    }

    /**
     * Gets the value of the orderBy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderBy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderBy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetProductsByFilterRequest.OrderBy }
     * 
     * 
     */
    public List<GetProductsByFilterRequest.OrderBy> getOrderBy() {
        if (orderBy == null) {
            orderBy = new ArrayList<GetProductsByFilterRequest.OrderBy>();
        }
        return this.orderBy;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="field" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="sortType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "field",
        "sortType"
    })
    public static class OrderBy {

        protected String field;
        protected String sortType;

        /**
         * Gets the value of the field property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getField() {
            return field;
        }

        /**
         * Sets the value of the field property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setField(String value) {
            this.field = value;
        }

        /**
         * Gets the value of the sortType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSortType() {
            return sortType;
        }

        /**
         * Sets the value of the sortType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSortType(String value) {
            this.sortType = value;
        }

    }

}
