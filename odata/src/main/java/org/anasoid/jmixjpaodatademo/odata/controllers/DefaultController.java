package org.anasoid.jmixjpaodatademo.odata.controllers;

import org.anasoid.jmixjpaodatademo.core.entity.catalog.Catalog;
import org.anasoid.jmixjpaodatademo.odata.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
public class DefaultController {


    @Autowired
    private CatalogRepository catalogRepository;

    @GetMapping("/")
    String home() {
        return "home";
    }

    @GetMapping("/catalogs")
    List<Catalog> catalogs() {
        return StreamSupport.stream(catalogRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
