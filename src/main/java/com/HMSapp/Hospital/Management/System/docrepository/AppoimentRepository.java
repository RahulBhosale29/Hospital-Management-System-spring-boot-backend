package com.HMSapp.Hospital.Management.System.docrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HMSapp.Hospital.Management.System.docappoiment.Appoiment;

@Repository
public interface AppoimentRepository extends JpaRepository<Appoiment, Long>{

}
