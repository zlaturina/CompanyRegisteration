/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import CompanyDao.CompanyDao;
import CompanyEntity.Company;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author mehtab
 */
@Named(value = "companyController")
@RequestScoped
public class CompanyController {

    @Inject
    private CompanyDao cDao;

    private String name;

    private List<Company> companyList;
    
    public void register(Company c){
        c = new Company(name);
        cDao.registerCompany(c);
        companyList = cDao.findAllCompanies();
    }
    
    public void delete(Integer id){
        cDao.deleteCompany(id);
    }
    
    @PostConstruct
    public void listAllCompanies(){
        this.companyList = cDao.findAllCompanies();
    }

    public CompanyController(String name) {
        this.name = name;
    }

    public CompanyController() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

}
