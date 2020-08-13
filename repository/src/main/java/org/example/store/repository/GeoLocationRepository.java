package org.example.store.repository;


import org.example.store.model.GeoLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeoLocationRepository extends JpaRepository<GeoLocation, Long> {

    Optional<GeoLocation> findByLatitude(Double latitude);

    Optional<GeoLocation> findByLongitude(Double longitude);

    Optional<GeoLocation> findByLatitudeAndLongitude(Double latitude, Double longitude);

}
