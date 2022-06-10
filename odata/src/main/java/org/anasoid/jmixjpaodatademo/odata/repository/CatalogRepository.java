package org.anasoid.jmixjpaodatademo.odata.repository;

import org.springframework.data.repository.CrudRepository;


import org.anasoid.jmixjpaodatademo.core.entity.catalog.Catalog;
public interface CatalogRepository extends CrudRepository<Catalog, Long> {
}
