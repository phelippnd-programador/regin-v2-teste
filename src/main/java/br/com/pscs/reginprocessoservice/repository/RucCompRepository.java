package br.com.pscs.reginprocessoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pscs.reginprocessoservice.model.entity.RucComp;
@Repository
public interface RucCompRepository extends JpaRepository<RucComp, String>{

}
