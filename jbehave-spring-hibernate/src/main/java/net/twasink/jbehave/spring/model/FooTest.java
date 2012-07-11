package net.twasink.jbehave.spring.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testContext.xml")
@Transactional
public class FooTest {

    @Autowired
    private SessionFactory sessionFactory;
    private Session currentSession;

    @Before
    public void openSession() {
        currentSession = sessionFactory.getCurrentSession();
    }

    @Test
    public void shouldHaveASessionFactory() {
        assertNotNull(sessionFactory);
    }

    @Test
    public void shouldHaveNoObjectsAtStart() {
        List<?> results = currentSession.createQuery("from Foo").list();
        assertTrue(results.isEmpty());
    }

    @Test
    public void shouldBeAbleToPersistAnObject() {
        assertEquals(0, currentSession.createQuery("from Foo").list().size());
        Foo jobUser = new Foo("Bar");
        currentSession.persist(jobUser);
        currentSession.flush();
        assertEquals(1, currentSession.createQuery("from Foo").list().size());
    }

    @Test
    public void shouldBeABleToQueryForObjects() {
        shouldBeAbleToPersistAnObject();

        assertEquals(1, currentSession.createQuery("from Foo where name = 'Bar'").list().size());
        assertEquals(0, currentSession.createQuery("from Foo where name = 'Baz'").list().size());
    }
}