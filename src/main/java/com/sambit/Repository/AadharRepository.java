package com.sambit.Repository;

import com.sambit.Model.Aadhar;
import javafx.scene.control.IndexRange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AadharRepository extends JpaRepository<Aadhar, Integer> {
}
