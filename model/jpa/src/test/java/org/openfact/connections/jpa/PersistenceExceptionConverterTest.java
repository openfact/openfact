package org.openfact.connections.jpa;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.transaction.*;
import javax.validation.constraints.Size;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(Arquillian.class)
@UsingDataSet("empty.xml")
public class PersistenceExceptionConverterTest {

    @Inject
    EntityManager em;

    @Deployment
    public static Archive createDeployment() {
        Archive[] libs = Maven.resolver()
                .loadPomFromFile("pom.xml")
                .resolve("org.mockito:mockito-core")
                .withTransitivity()
                .as(JavaArchive.class);

        WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("persistence.xml", "META-INF/persistence.xml")

                .addClass(PersistenceEntityProducer.class)
                .addClass(PersistenceExceptionConverter.class)
                .addClass(ModelException.class)
                .addClass(ModelDuplicateException.class);

        archive.addAsLibraries(libs);
        return archive;
    }

    @Test
    public void test_generate_success() {
        assertThat("Entity Manager was not generated", em, is(notNullValue()));
    }

    @Test(expected = ModelException.class)
    public void test_modelException() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        EntityObject entity1 = new EntityObject("id", "Carlos Esteban Feria Vila");

        em.persist(entity1);
        em.flush();
    }

    @Test(expected = ModelDuplicateException.class)
    public void test_duplicationExeption() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        EntityObject entity1 = new EntityObject("id", "Carlos");
        EntityObject entity2 = new EntityObject("id", "Carlos Feria");

        em.persist(entity1);
        em.persist(entity2);
        em.flush();
    }

    @Entity
    class EntityObject {

        @Id
        private String id;

        @Column
        @Size(max = 10)
        private String fullName;

        public EntityObject(String id, String fullName) {
            this.id = id;
            this.fullName = fullName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }
    }

}