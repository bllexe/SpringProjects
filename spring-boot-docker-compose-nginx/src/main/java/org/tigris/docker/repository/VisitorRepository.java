package org.tigris.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tigris.docker.entity.Visitor;

public interface VisitorRepository  extends JpaRepository<Visitor, Long> {

    Visitor findByIp(String id);

}
