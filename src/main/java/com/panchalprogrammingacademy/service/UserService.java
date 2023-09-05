package com.panchalprogrammingacademy.service;

import com.panchalprogrammingacademy.Model.User;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@NoArgsConstructor
public class UserService {

    @Autowired
    private HibernateTemplate hibernateTemplate;

//    public UserService(HibernateTemplate hibernateTemplate)
//    {
//        this.hibernateTemplate = hibernateTemplate;
//    }

    public User createUser(User data) {
        hibernateTemplate.save(data);
        return data;
    }

    public User getUserById(int id)
    {
        return hibernateTemplate.get(User.class, id);
    }

    @Transactional
    public User updateUser(User user)
    {
        User user1 = hibernateTemplate.get(User.class, user.getId());
        if(user1 == null)
            return new User();

        user1.setName(user.getName());

        try
        {
            //Transaction transaction = hibernateTemplate.getSessionFactory().getCurrentSession().beginTransaction();
//            if (!hibernateTemplate.contains(user1)) {
//                hibernateTemplate.saveOrUpdate(user1); // Attach the object to the session
//            }

            hibernateTemplate.saveOrUpdate(user1);
            //transaction.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return user1;
    }

    @Transactional
    public void deleteUser(int id)
    {
        User user = hibernateTemplate.get(User.class, id);
        if(user != null)
        {
//            Transaction transaction = hibernateTemplate.getSessionFactory().getCurrentSession().beginTransaction();
//            hibernateTemplate.delete(user);
//            transaction.commit();

//            Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
//            hibernateTemplate.delete(user);

            hibernateTemplate.delete(user);
        }
    }
}
