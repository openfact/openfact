package org.openfact.models;

import java.util.List;

import javax.inject.Inject;

import org.hamcrest.CoreMatchers;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openfact.models.jpa.AbstractHibernateStorage;
import org.openfact.models.jpa.JpaEmisorProvider;
import org.openfact.models.jpa.entities.EmisorEntity;
import org.openfact.models.jpa.search.SearchCriteriaJoinAliasModel;
import org.openfact.models.jpa.search.SearchCriteriaJoinModel;
import org.openfact.models.search.OrderByModel;
import org.openfact.models.search.PagingModel;
import org.openfact.models.search.SearchCriteriaFilterModel;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

@RunWith(Arquillian.class)
public class EmisorProviderIT {

    @Inject
    private EmisorProvider emisores;

    @SuppressWarnings("rawtypes")
    @Deployment
    public static Archive createDeployment() {
        JavaArchive archive = ShrinkWrap.create(JavaArchive.class);

        archive.addClass(Model.class);
        archive.addClass(EmisorModel.class);

        archive.addClass(Provider.class);
        archive.addClass(EmisorProvider.class);
        archive.addClass(JpaEmisorProvider.class);
        archive.addClass(EmisorEntity.class);

        archive.addClass(AbstractHibernateStorage.class);
        archive.addClass(SearchCriteriaJoinAliasModel.class);
        archive.addClass(SearchCriteriaJoinModel.class);
        archive.addClass(OrderByModel.class);
        archive.addClass(PagingModel.class);
        archive.addClass(SearchCriteriaFilterModel.class);
        archive.addClass(SearchCriteriaModel.class);
        archive.addClass(SearchResultsModel.class);

        archive.addPackages(true, "org.openfact");

        archive.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        archive.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml");

        return archive;
    }

    @Before
    public void before() {
        removeAllEmisores();
    }

    @After
    public void after() {
        removeAllEmisores();
    }

    public void removeAllEmisores() {
        List<EmisorModel> models = emisores.getAll();
        for (EmisorModel model : models) {
            emisores.remove(model);
        }
    }

    @Test
    public void create() {
        EmisorModel model = emisores.create("PE", "10467793549", "Sistcoop S.A.C.");

        Assert.assertThat(model, CoreMatchers.notNullValue());
        Assert.assertThat(model.getId(), CoreMatchers.notNullValue());
        Assert.assertThat(model.getPais(), CoreMatchers.equalTo("PE"));
        Assert.assertThat(model.getRuc(), CoreMatchers.equalTo("10467793549"));
        Assert.assertThat(model.getRazonSocial(), CoreMatchers.equalTo("Sistcoop S.A.C."));
        Assert.assertThat(model.getEstado(), CoreMatchers.is(true));
    }

    @Test
    public void findById() {
        EmisorModel model1 = emisores.create("PE", "10467793549", "Sistcoop S.A.C.");

        String id = model1.getId();
        EmisorModel model2 = emisores.findById(id);

        Assert.assertThat(model1, CoreMatchers.notNullValue());
        Assert.assertThat(model2, CoreMatchers.notNullValue());
        Assert.assertThat(model1, CoreMatchers.equalTo(model2));
    }

    @Test
    public void findByRuc() {
        EmisorModel model1 = emisores.create("PE", "10467793549", "Sistcoop S.A.C.");

        String pais = model1.getPais();
        String ruc = model1.getRuc();
        EmisorModel model2 = emisores.findByRuc(pais, ruc);

        Assert.assertThat(model1, CoreMatchers.notNullValue());
        Assert.assertThat(model2, CoreMatchers.notNullValue());
        Assert.assertThat(model1, CoreMatchers.equalTo(model2));
    }

    @Test
    public void findByRazonSocial() {
        EmisorModel model1 = emisores.create("PE", "10467793549", "Sistcoop S.A.C.");

        String pais = model1.getPais();
        String razonSocial = model1.getRazonSocial();
        EmisorModel model2 = emisores.findByRazonSocial(pais, razonSocial);

        Assert.assertThat(model1, CoreMatchers.notNullValue());
        Assert.assertThat(model2, CoreMatchers.notNullValue());
        Assert.assertThat(model1, CoreMatchers.equalTo(model2));
    }

    @Test
    public void remove() {
        EmisorModel model1 = emisores.create("PE", "10467793549", "Sistcoop S.A.C.");

        String id = model1.getId();
        boolean result = emisores.remove(model1);
        EmisorModel model2 = emisores.findById(id);

        Assert.assertThat(result, CoreMatchers.is(true));
        Assert.assertThat(model2, CoreMatchers.nullValue());
    }

    @Test
    public void getAll() {
        emisores.create("PE", "10467793549", "Sistcoop S.A.C.");
        emisores.create("PE", "45263512585", "Softgreen S.A.C.");

        List<EmisorModel> models = emisores.getAll();

        Assert.assertThat(models, CoreMatchers.notNullValue());
        Assert.assertThat(models.size(), CoreMatchers.is(2));
    }
 
    /*@Test
    public void searchCriteria() {
        EmisorModel model1 = emisores.create("PE", "10467793549", "Sistcoop S.A.C.");
        emisores.create("PE", "45263512585", "Softgreen S.A.C.");
        emisores.create("PE", "85362412574", "Ahren S.A.C.");

        model1.setEstado(false);
        model1.commit();

        // add filters
        SearchCriteriaModel criteria = new SearchCriteriaModel();
        criteria.addFilter("estado", true, SearchCriteriaFilterOperator.bool_eq);

        SearchResultsModel<EmisorModel> searched = emisores.search(criteria);

        Assert.assertThat(searched, CoreMatchers.nullValue());
        Assert.assertThat(searched.getTotalSize(), CoreMatchers.is(1));
        Assert.assertThat(searched.getModels().size(), CoreMatchers.is(1));
    }
   
    @Test
    public void searchCriteriaFiltertext() {
        EmisorModel model1 = emisores.create("PE", "10467793549", "Sistcoop S.A.C.");
        emisores.create("PE", "45263512585", "Softgreen S.A.C.");
        emisores.create("PE", "85362412574", "Ahren S.A.C.");

        model1.setEstado(false);
        model1.commit();

        // add filters
        SearchCriteriaModel criteria = new SearchCriteriaModel();
        criteria.addFilter("estado", false, SearchCriteriaFilterOperator.bool_eq);

        SearchResultsModel<EmisorModel> searched = emisores.search(criteria, "S.A.C.");

        Assert.assertThat(searched, CoreMatchers.notNullValue());
        Assert.assertThat(searched.getTotalSize(), CoreMatchers.is(2));
        Assert.assertThat(searched.getModels().size(), CoreMatchers.is(2));
    }*/

}
