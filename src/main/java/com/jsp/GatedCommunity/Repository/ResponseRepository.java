package com.jsp.GatedCommunity.Repository;

import com.jsp.GatedCommunity.Entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
}
