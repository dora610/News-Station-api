/**
 * 
 */
package com.karuriSuro.newsStation.dao;

import org.springframework.data.repository.ListCrudRepository;

import com.karuriSuro.newsStation.entity.News;

/**
 * @author surajitkaruri
 *
 */
// TODO: also add PagingAndSortingRepository
public interface NewsRepository extends ListCrudRepository<News, Long> {

}
