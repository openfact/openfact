package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.ubl.type.IdentifierType;

/**
 * A class for assigning identifying information to an item.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:42 a. m.
 */
@Entity
@Table(name = "ITEM_IDENTIFICATION")
public class ItemIdentificationEntity {
	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * An identifier for a system of barcodes.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "BARCODESYMBOLOGYID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "BARCODESYMBOLOGYID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "BARCODESYMBOLOGYID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "BARCODESYMBOLOGYID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "BARCODESYMBOLOGYID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "BARCODESYMBOLOGYID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "BARCODESYMBOLOGYID_SCHEMEDATAURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "BARCODESYMBOLOGYID_SCHEMEURI")) })
	private IdentifierType barcodeSymbologyID;
	/**
	 * An extended identifier for the item that identifies the item with
	 * specific properties, e.g., ItemEntity 123 = Chair / ItemEntity 123 Ext 45
	 * = brown chair. Two chairs can have the same item number, but one is
	 * brown. The other is white.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "EXTENDEDID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "EXTENDEDID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "EXTENDEDID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "EXTENDEDID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "EXTENDEDID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "EXTENDEDID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "EXTENDEDID_SCHEMEDATAURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "EXTENDEDID_SCHEMEURI")) })
	private IdentifierType extendedID;
	/**
	 * An identifier for the item.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "ID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "ID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "ID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "ID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "ID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "ID_SCHEMEDATAURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "ID_SCHEMEURI")) })
	private IdentifierType ID;
	@Transient
	private DimensionEntity measurementDimension;
	@Transient
	private PartyEntity issuerParty;
	@Transient
	private List<PhysicalAttributeEntity> physicalAttributes = new ArrayList<>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public IdentifierType getBarcodeSymbologyID() {
		return barcodeSymbologyID;
	}
	public void setBarcodeSymbologyID(IdentifierType barcodeSymbologyID) {
		this.barcodeSymbologyID = barcodeSymbologyID;
	}
	public IdentifierType getExtendedID() {
		return extendedID;
	}
	public void setExtendedID(IdentifierType extendedID) {
		this.extendedID = extendedID;
	}
	public IdentifierType getID() {
		return ID;
	}
	public void setID(IdentifierType iD) {
		ID = iD;
	}
	public DimensionEntity getMeasurementDimension() {
		return measurementDimension;
	}
	public void setMeasurementDimension(DimensionEntity measurementDimension) {
		this.measurementDimension = measurementDimension;
	}
	public PartyEntity getIssuerParty() {
		return issuerParty;
	}
	public void setIssuerParty(PartyEntity issuerParty) {
		this.issuerParty = issuerParty;
	}
	public List<PhysicalAttributeEntity> getPhysicalAttributes() {
		return physicalAttributes;
	}
	public void setPhysicalAttributes(List<PhysicalAttributeEntity> physicalAttributes) {
		this.physicalAttributes = physicalAttributes;
	}

	
	

}
