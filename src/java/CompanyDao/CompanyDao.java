/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompanyDao;

import CompanyEntity.Company;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mehtab
 */
@Stateless
public class CompanyDao {
    
    @PersistenceContext(name="CompanyPU")
    EntityManager em;
    
    public Company registerCompany(Company company){
        em.persist(company);
        return company;
    }
    
    public void deleteCompany(Integer id){
       em.remove(em.find(Company.class, id));
    }
    
    public Company findCompanyById(Integer id){
        return em.find(Company.class, id);
    }
    
    public List<Company> findAllCompanies(){
        return em.createQuery("Select c From Company c",Company.class).getResultList();
    }
    
    
    
}
