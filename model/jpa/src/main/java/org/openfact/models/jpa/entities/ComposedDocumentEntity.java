package org.openfact.models.jpa.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Entity
@DiscriminatorValue(value = "COMPOSED")
public class ComposedDocumentEntity extends CatalogEntity {

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<CatalogEntity> childrens = new ArrayList<>();

	@Override
	public void add(CatalogEntity catalog) {
		//catalog.setType(this);
		childrens.add(catalog);
	}

	@Override
	public boolean remove(CatalogEntity catalog) {
		if (catalog == null) {
			return false;
		}

		CatalogEntity catalogEntity = null;
		Iterator<CatalogEntity> it = childrens.iterator();
		while (it.hasNext()) {
			CatalogEntity ae = it.next();
			if (ae.equals(catalog)) {
				catalogEntity = ae;
				it.remove();
				break;
			}
		}
		if (catalogEntity == null) {
			return false;
		}

		return true;
	}

	@Override
	public boolean removeByCatalogId(String catalogId) {
		if (catalogId == null) {
			return false;
		}

		CatalogEntity catalogEntity = null;
		Iterator<CatalogEntity> it = childrens.iterator();
		while (it.hasNext()) {
			CatalogEntity ae = it.next();
			if (ae.getDocumentId().equals(documentId)) {
				catalogEntity = ae;
				it.remove();
				break;
			}
		}
		if (catalogEntity == null) {
			return false;
		}

		return true;
	}

	@Override
	public boolean removeByname(String catalogname) {
		if (catalogname == null) {
			return false;
		}

		CatalogEntity catalogEntity = null;
		Iterator<CatalogEntity> it = childrens.iterator();
		while (it.hasNext()) {
			CatalogEntity ae = it.next();
			if (ae.getName().equals(catalogname)) {
				catalogEntity = ae;
				it.remove();
				break;
			}
		}
		if (catalogEntity == null) {
			return false;
		}

		return true;
	}

	@Override
	public CatalogEntity getChildByCatalogId(String catalogId) {
		return childrens.stream().filter(f -> f.getCatalog().equals(catalogId)).findAny().orElse(null);
	}

	@Override
	public CatalogEntity getChildByName(String catalogName) {
		return childrens.stream().filter(f -> f.getName().equals(catalogName)).findAny().orElse(null);
	}

	@Override
	public List<CatalogEntity> getChildrens() {
		return childrens;
	}

}
