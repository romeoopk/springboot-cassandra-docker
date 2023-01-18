package com.azamakram.github.BookStore.config;

//import org.springframework.context.annotation.Bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.cassandra.config.*;
//import org.springframework.data.cassandra.core.convert.CassandraConverter;
//import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
//import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
public class BookStoreCassandraConfig extends AbstractCassandraConfiguration {

    @Value("${spring.data.cassandra.port}")
    private int port;

    @Value("${spring.cassandra.contact-points}")
    private String contactPoints;

    @Value("${spring.cassandra.keyspace-name}")
    private String keySpace;

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getContactPoints() {
        return contactPoints;
    }

    @Override
    protected String getKeyspaceName() {
        return keySpace;
    }  

    /*@Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }*/

   /* @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.azamakram.github.BookStore.model.entity"};
    }*/


    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        return Collections.singletonList(CreateKeyspaceSpecification
                .createKeyspace(getKeyspaceName())
                .ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true)
                .withSimpleReplication());
    }
}
