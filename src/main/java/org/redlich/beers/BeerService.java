package org.redlich.beers;

import jakarta.nosql.document.DocumentQuery;
import jakarta.nosql.mapping.document.DocumentTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
/*
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
 */

import java.util.stream.Stream;

import static jakarta.nosql.document.DocumentQuery.select;

@ApplicationScoped
public class BeerService {

    @Inject
    @ConfigProperty(name = "db1")
    private DocumentTemplate template;

    public Beer insert(Beer beer) {
        return template.insert(beer);
        }

    public Stream<Beer> findByName(String name) {
        DocumentQuery query = select()
                .from("Beer")
                .where("name")
                .eq(name)
                .build();
        return template.select(query);
        }
    }