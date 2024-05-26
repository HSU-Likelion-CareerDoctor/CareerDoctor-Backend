package com.homepage.careerdoctor.specCertificate.repository;

import com.homepage.careerdoctor.domain.SpecCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecRepository extends JpaRepository<SpecCertificate, Long> {
<<<<<<< HEAD
    Optional<SpecCertificate> findByUserId(String userId);
=======
    Optional<SpecCertificate> findBySpecId(Long specId);
>>>>>>> c409ef801c076c8eec75cec332331871119f061d
}
