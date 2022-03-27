package com.example.demo.dao;

import com.example.demo.entities.Product;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class ProductDao {

    private final SessionFactory sessionFactory;

    public void saveProduct(Product product){
        getSession().save(product);
    }

    public List<Product> getProducts(){
        Criteria crit = getSession().createCriteria(Product.class);
        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.property("id").as("id"));
        projList.add(Projections.property("name").as("name"));
        crit.setProjection(projList);
        crit.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);


        return crit.list();
    }

    private Session getSession(){
        Session session = sessionFactory.getCurrentSession();
        if (session == null){
            session = sessionFactory.openSession();
        }
        return session;
    }

}
