package com.demo.pruebatecnicamc.be;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends ObjectMapper {
    private static final long serialVersionUID = 1L;
    public HibernateAwareObjectMapper() {
        Hibernate4Module hm = new Hibernate4Module();
        hm.disable(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION);
        registerModule(hm);
    }
}
