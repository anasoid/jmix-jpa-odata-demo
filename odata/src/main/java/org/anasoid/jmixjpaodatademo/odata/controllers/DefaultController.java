package org.anasoid.jmixjpaodatademo.odata.controllers;

import org.anasoid.jmixjpaodatademo.odata.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.catalog.Catalog;

@RestController
public class DefaultController {


    @Autowired
    private CatalogRepository catalogRepository;

    @GetMapping("/")
    String home() {
        return "home";
    }

    @GetMapping("/catalogs")
    Iterable<Catalog> catalogs() {
        return catalogRepository.findAll();
    }
}
