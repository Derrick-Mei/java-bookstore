package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Sectionrepository extends JpaRepository<Section, Long>
{
}
