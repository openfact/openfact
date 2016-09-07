package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe a declaration by an economic operator of certain
 * characteristics or capabilities in fulfilment of requirements specified in a
 * call for tenders.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:20 a. m.
 */
public class Declaration {

    /**
     * A code signifying the type of this declaration.
     */
    private Code.Type DeclarationTypeCode;
    /**
     * Text describing this declaration.
     */
    private Text.Type Description;
    /**
     * The name of this declaration.
     */
    private Name.Type Name;
    private Evidence Supplied
    m_Evidence Supplied;

    public Declaration() {

    }

    public void finalize() throws Throwable {

    }

    public Code.Type getDeclarationTypeCode() {
        return DeclarationTypeCode;
    }

    public Text.Type getDescription() {
        return Description;
    }

    public Evidence Supplied

    getEvidence Supplied(){
		return m_Evidence Supplied;
	}

    public Name.Type getName() {
        return Name;
    }

    /**
     * 
     * @param newVal
     */
    public void setDeclarationTypeCode(Code.Type newVal) {
        DeclarationTypeCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDescription(Text.Type newVal) {
        Description = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setEvidence

    Supplied(Evidence Supplied newVal){
		m_Evidence Supplied = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setName(Name.Type newVal) {
        Name = newVal;
    }
}// end Declaration