package detail_tracker.util;

import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import detail_tracker.entities.ElectricalDeviceLkp;
import detail_tracker.entities.PlumbingFixtureLkp;
import  jakarta.annotation.PostConstruct;

@Singleton
@Startup
public class DatabasePrePop {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void populateDatabase() {
        PlumbingFixtureLkp sink = new PlumbingFixtureLkp();
        //sink.setDescription("Sink");
        em.persist(sink);

        PlumbingFixtureLkp toilet = new PlumbingFixtureLkp();
        //toilet.setDescription("Toilet");
        em.persist(toilet);

        ElectricalDeviceLkp light = new ElectricalDeviceLkp();
        //light.setDescription("Light");
        em.persist(light);

        // Add more...
    }
}