//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.21 at 07:17:48 AM MSK 
//


package entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ColorDto.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ColorDto">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BLACK"/>
 *     &lt;enumeration value="BLUE"/>
 *     &lt;enumeration value="ORANGE"/>
 *     &lt;enumeration value="BROWN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ColorDto")
@XmlEnum
public enum ColorDto {

    BLACK,
    BLUE,
    ORANGE,
    BROWN;

    public String value() {
        return name();
    }

    public static ColorDto fromValue(String v) {
        return valueOf(v);
    }

}
