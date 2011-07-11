package test;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * @author tbaum
 * @since 11.07.11
 */
@Path("/")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class Endpoint {
// ------------------------------ FIELDS ------------------------------

    private Provider<EntityManager> em;

// --------------------------- CONSTRUCTORS ---------------------------

    @Inject
    public Endpoint(Provider<EntityManager> em) {
        this.em = em;
    }

// -------------------------- OTHER METHODS --------------------------

    @GET
    @Path("create/{id}")
    @Transactional
    public DataClass create(@PathParam("id") String data) {
        EntityManager entityManager = em.get();
        DataClass entity = new DataClass(data);
        entityManager.persist(entity);
        return entity;
    }

    @GET
    @Transactional
    @Path("list")
    public DataClass[] getClichedMessage() {
        EntityManager entityManager = em.get();
        TypedQuery<DataClass> query = entityManager.createQuery("FROM DataClass", DataClass.class);
        List<DataClass> resultList = query.getResultList();
        return resultList.toArray(new DataClass[resultList.size()]);
    }
}
