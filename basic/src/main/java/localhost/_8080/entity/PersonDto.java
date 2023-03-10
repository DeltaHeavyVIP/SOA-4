//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.22 at 07:53:14 PM MSK 
//


package localhost._8080.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="passportID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="eyeColor" type="{http://localhost:8080/Entity}ColorDto"/>
 *         &lt;element name="hairColor" type="{http://localhost:8080/Entity}ColorDto"/>
 *         &lt;element name="nationality" type="{http://localhost:8080/Entity}CountryDto"/>
 *         &lt;element name="location" type="{http://localhost:8080/Entity}LocationDto"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonDto", propOrder = {
    "name",
    "passportID",
    "eyeColor",
    "hairColor",
    "nationality",
    "location"
})
public class PersonDto {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String passportID;
    @XmlElement(required = true)
    protected ColorDto eyeColor;
    @XmlElement(required = true)
    protected ColorDto hairColor;
    @XmlElement(required = true)
    protected CountryDto nationality;
    @XmlElement(required = true)
    protected LocationDto location;

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
     * Gets the value of the passportID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassportID() {
        return passportID;
    }

    /**
     * Sets the value of the passportID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassportID(String value) {
        this.passportID = value;
    }

    /**
     * Gets the value of the eyeColor property.
     * 
     * @return
     *     possible object is
     *     {@link ColorDto }
     *     
     */
    public ColorDto getEyeColor() {
        return eyeColor;
    }

    /**
     * Sets the value of the eyeColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColorDto }
     *     
     */
    public void setEyeColor(ColorDto value) {
        this.eyeColor = value;
    }

    /**
     * Gets the value of the hairColor property.
     * 
     * @return
     *     possible object is
     *     {@link ColorDto }
     *     
     */
    public ColorDto getHairColor() {
        return hairColor;
    }

    /**
     * Sets the value of the hairColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColorDto }
     *     
     */
    public void setHairColor(ColorDto value) {
        this.hairColor = value;
    }

    /**
     * Gets the value of the nationality property.
     * 
     * @return
     *     possible object is
     *     {@link CountryDto }
     *     
     */
    public CountryDto getNationality() {
        return nationality;
    }

    /**
     * Sets the value of the nationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryDto }
     *     
     */
    public void setNationality(CountryDto value) {
        this.nationality = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link LocationDto }
     *     
     */
    public LocationDto getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationDto }
     *     
     */
    public void setLocation(LocationDto value) {
        this.location = value;
    }

}
