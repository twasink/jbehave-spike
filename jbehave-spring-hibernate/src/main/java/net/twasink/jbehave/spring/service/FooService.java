package net.twasink.jbehave.spring.service;

import net.twasink.jbehave.spring.model.Foo;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FooService {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void createFoo(String name, String description) {
        Foo foo = new Foo(name);
        foo.setDescription(description);
        
        sessionFactory.getCurrentSession().save(foo);
    }

}
