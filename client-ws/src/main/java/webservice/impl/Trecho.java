
package webservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for trecho complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trecho">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="destino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distancia" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="origem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proximo" type="{http://impl.webservice/}trecho" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trecho", propOrder = {
    "destino",
    "distancia",
    "id",
    "origem",
    "proximo"
})
public class Trecho {

    protected String destino;
    protected Double distancia;
    protected Long id;
    protected String origem;
    protected Trecho proximo;

    public Trecho() {
        super();
    }

    public Trecho(String origem, String destino, Double distancia) {
        super();
        this.destino = destino;
        this.distancia = distancia;
        this.origem = origem;
    }

    /**
     * Gets the value of the destino property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Sets the value of the destino property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestino(String value) {
        this.destino = value;
    }

    /**
     * Gets the value of the distancia property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDistancia() {
        return distancia;
    }

    /**
     * Sets the value of the distancia property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDistancia(Double value) {
        this.distancia = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the origem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigem() {
        return origem;
    }

    /**
     * Sets the value of the origem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigem(String value) {
        this.origem = value;
    }

    /**
     * Gets the value of the proximo property.
     * 
     * @return
     *     possible object is
     *     {@link Trecho }
     *     
     */
    public Trecho getProximo() {
        return proximo;
    }

    /**
     * Sets the value of the proximo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Trecho }
     *     
     */
    public void setProximo(Trecho value) {
        this.proximo = value;
    }

}
